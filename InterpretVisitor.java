import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    private Scope globalScope = new Scope();
    private Scope currentScope = globalScope;
    
    public class Variable {
        private String type;
        private Object value;
    
        public Variable(String type, Object value) {
            this.type = type;
            this.value = value;
        }
    
        public String getType() {
            return type;
        }
    
        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Variable{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public class Scope {
        private final Scope parentScope;
        private final Map<String, Object> variables;

        public Scope() {
            this(null);
        }

        public Scope(Scope parentScope) {
            this.parentScope = parentScope;
            this.variables = new HashMap<>();
        }

        public void setVariable(String name, Object value) {
            variables.put(name, value);
        }

        public Object getVariable(String name) {
            Object value = variables.get(name);
            if (value == null && parentScope != null) {
                return parentScope.getVariable(name);
            }
            return value;
        }

        public boolean variableExists(String name) {
            return variables.containsKey(name) || (parentScope != null && parentScope.variableExists(name));
        }

        public Scope getParentScope() {
            return parentScope;
        }
    }

    public class FunctionInfo {
        private final List<SimpleScriptParser.ParameterContext> parameters;
        private final SimpleScriptParser.BlockContext block;
        private final Scope parentScope;

        public FunctionInfo(List<SimpleScriptParser.ParameterContext> parameters, SimpleScriptParser.BlockContext block, Scope parentScope) {
            this.parameters = parameters;
            this.block = block;
            this.parentScope = parentScope;
        }

        public List<SimpleScriptParser.ParameterContext> getParameters() {
            return parameters;
        }

        public SimpleScriptParser.BlockContext getBlock() {
            return block;
        }

        public Scope getParentScope() {
            return parentScope;
        }
    }

    HashMap<String, Variable> variables = new HashMap<>();
    Map<String, FunctionInfo> functions = new HashMap<>();
    

    @Override
    public Void visitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx) {
        String type = ctx.TYPE().getText();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Object value = visit(ctx.expr(i));
            Variable variable = new Variable(type, value);
            variables.put(name, variable);
            System.out.println("Variable '" + name + "' of type '" + type + "' defined with value: " + value);
        }
        return null;
    }
    
    @Override
    public Void visitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Variable variable = new Variable(type, null); // Initialize with null value
            variables.put(name, variable);
            System.out.println("Variable '" + name + "' of type '" + type + "' declared");
        }
        return null;
    }

    @Override
    public Void visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Object value = visit(ctx.expr());
        if (variables.containsKey(name)) {
            Variable variable = new Variable(variables.get(name).getType(), value);
            variables.put(name, variable);
            System.out.println("Variable '" + name + "' assigned value: " + value);
        } else {
            System.err.println("Error: Variable '" + name + "' has not been declared");
        }
        return null;
    }

    @Override
    public Object visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx) {
        Object value = visit(ctx.expr()); // Visit the expression inside the print statement
        if (value instanceof String && variables.containsKey(value)) {
            // If the value is a variable name and it exists in the variables map
            System.out.println(variables.get(value).value); // Print the value of the variable
        } else {
            System.out.println(value); // Otherwise, print the value as is
        }
        return null;
    }

    @Override
    public Object visitExpr(SimpleScriptParser.ExprContext ctx) {
        if (ctx.arithmeticOperation() != null) {
            return visitArithmeticOperation(ctx.arithmeticOperation());
        } else if (ctx.conditionalOperation() != null) {
            return visitConditionalOperation(ctx.conditionalOperation());
        } else if (ctx.singleValueOperation() != null) {
            return visitSingleValueOperation(ctx.singleValueOperation());
        } else if (ctx.value() != null) {
            return visitValue(ctx.value());
        } else if (ctx.functionInvocation() != null) {
            return visitFunctionInvocation(ctx.functionInvocation());
        } else if (ctx.stringOperation() != null) {
            return visitStringOperation(ctx.stringOperation());
        } else {
            // Handle other cases as needed
            return null;
        }
    }

    @Override
    public Object visitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx) {
        Object left = visit(ctx.value());
        Object right = visit(ctx.expr());
        String op = ctx.ARITHMETIC_OP().getText();

        try {
            left = Integer.parseInt(String.valueOf(left));
            right = Integer.parseInt(String.valueOf(right));
        } catch (NumberFormatException e) {
            try {
                left = Float.parseFloat(String.valueOf(left));
                right = Float.parseFloat(String.valueOf(right));
            } catch (NumberFormatException ex) {
                throw new RuntimeException("Operands are not a valid numbers: " + left);
            }
        }

        // Perform the arithmetic operation based on the operator
        switch (op) {
            case "+":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left + (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left + (float) right;
                }
                break;
            case "-":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left - (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left - (float) right;
                }
                break;
            // Add other arithmetic operations as needed
            // Handle multiplication, division, etc.
        }

        // If none of the cases match, return null or throw an error
        return null;
    }

    @Override
    public Object visitConditionalOperation(SimpleScriptParser.ConditionalOperationContext ctx) {
        Object left = visit(ctx.value());
        Object right = visit(ctx.expr());
        String op = ctx.CONDITION_OP().getText();

        // Perform the conditional operation based on the operator
        switch (op) {
            case ">":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left > (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left > (float) right;
                }
                break;
            case ">=":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left >= (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left >= (float) right;
                }
                break;
            case "<":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left < (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left < (float) right;
                }
                break;
            case "<=":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left <= (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left <= (float) right;
                }
                break;
            case "==":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left == (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left == (float) right;
                }
                break;
            case "!=":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left != (int) right;
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left != (float) right;
                }
                break;
            // Add other conditional operations as needed
        }

        // If none of the cases match, return null or throw an error
        return null;
    }
    
    @Override
    public Object visitValue(SimpleScriptParser.ValueContext ctx) {
        // Depending on the type of value, handle it accordingly
        if (ctx.NAME() != null) {
            // If it's a variable, you need to fetch its value from somewhere
            // For now, let's just return its name
            return ctx.NAME().getText();
        } else if (ctx.STRING() != null) {
            // If it's a string, return its text (without quotes)
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        } else if (ctx.NUMBER() != null) {
            // If it's a number, return its text
            return ctx.NUMBER().getText();
        } else if (ctx.BOOLEAN() != null) {
            // If it's a boolean, return its text
            return ctx.BOOLEAN().getText();
        }
        // Return null if none of the above cases match
        return null;
    }

     @Override
    public Object visitBlock(SimpleScriptParser.BlockContext ctx) {
        Scope blockScope = new Scope(currentScope);
        currentScope = blockScope;

        for (SimpleScriptParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }

        currentScope = currentScope.getParentScope();

        return null;
    }

    @Override
    public Object visitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.NAME().getText();
        List<SimpleScriptParser.ParameterContext> parameters = ctx.parameters().parameter();

        SimpleScriptParser.BlockContext blockContext = null;
        for (ParseTree child : ctx.children) {
            if (child instanceof SimpleScriptParser.BlockContext) {
                blockContext = (SimpleScriptParser.BlockContext) child;
                break;
            }
        }

        if (blockContext == null) {
            throw new RuntimeException("Block context not found within FunctionDeclarationContext.");
        }

        Scope functionScope = new Scope(currentScope);
        currentScope = functionScope;

        visitBlock(blockContext);

        FunctionInfo functionInfo = new FunctionInfo(parameters, blockContext, currentScope);
        functions.put(functionName, functionInfo);
        currentScope = currentScope.getParentScope();

        return null;
    }

    @Override
    public Object visitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx) {
        String functionName = ctx.NAME().getText();

        visit(ctx.arguments());

        return executeFunction(functionName);
    }

    @Override
    public Object visitParameter(SimpleScriptParser.ParameterContext ctx) {
        String parameterName = ctx.NAME().getText();
        currentScope.setVariable(parameterName, null); // Parameters are initially set to null
        return null;
    }

    @Override
    public Object visitParameters(SimpleScriptParser.ParametersContext ctx) {
        for (SimpleScriptParser.ParameterContext parameterContext : ctx.parameter()) {
            visit(parameterContext);
        }
        return null;
    }

    @Override
    public Object visitArguments(SimpleScriptParser.ArgumentsContext ctx) {
        for (SimpleScriptParser.ExprContext exprContext : ctx.expr()) {
            visit(exprContext);
        }
        return null;
    }


    private Object executeFunction(String functionName) {
        FunctionInfo functionInfo = (FunctionInfo) globalScope.getVariable(functionName);
        if (functionInfo == null) {
            throw new RuntimeException("Function '" + functionName + "' is not defined.");
        }

        Scope functionScope = new Scope(functionInfo.getParentScope());
        List<SimpleScriptParser.ParameterContext> parameters = functionInfo.getParameters();
        for (SimpleScriptParser.ParameterContext parameter : parameters) {
            String paramName = parameter.NAME().getText();
            functionScope.setVariable(paramName, null);
        }

        currentScope = functionScope;

        visit(functionInfo.getBlock());

        currentScope = currentScope.getParentScope();

        return null;
    }
}
