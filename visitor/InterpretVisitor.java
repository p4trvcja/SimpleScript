package visitor;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    private int currentInstruction = 0;
    private final Map<String, FunctionInfo> functions = new HashMap<>();
    private final Map<Integer, Map<String, Variable>> variables = new HashMap<>();

    public InterpretVisitor() {
        super();
        variables.put(0, new HashMap<>());
    }
    
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

        public void setType(String type) {
            this.type = type;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Variable{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public class FunctionInfo {
        private static int ID = 1;
        private final String returnType;
        private final List<SimpleScriptParser.StatementContext> block;
        private final int functionID = ID++;

        public FunctionInfo(String returnType, List<SimpleScriptParser.StatementContext> block) {
            this.returnType = returnType;
            this.block = block;
        }

        public List<SimpleScriptParser.StatementContext> getBlock() {
            return block;
        }

        public String getReturnType() {
            return returnType;
        }

        public int getFunctionID() {
            return functionID;
        }

        @Override
        public String toString() {
            return "FunctionInfo{" +
                    "returnType='" + returnType + '\'' +
                    ", block=" + block +
                    '}';
        }
    }

    public Map<Integer, Map<String, Variable>> getVariables() {
        return variables;
    }

    @Override
    public Void visitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx) {
        String type = ctx.TYPE().getText();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Object value = visit(ctx.expr(i));

            if (variables.get(currentInstruction).containsKey(value)) {
                value = variables.get(currentInstruction).get(value).getValue();
            } else if (variables.get(0).containsKey(value)) {
                value = variables.get(0).get(value).getValue();
            }

            Variable variable = new Variable(type, value);
            variables.get(currentInstruction).put(name, variable);
            // System.out.println("Variable '" + name + "' of type '" + type + "' defined with value: " + value);
        }
        return null;
    }

    @Override
    public Void visitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Variable variable = new Variable(type, null); // Initialize with null value
            variables.get(currentInstruction).put(name, variable);
            // System.out.println("Variable '" + name + "' of type '" + type + "' declared");
        }
        return null;
    }

    @Override
    public Void visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Object value = visit(ctx.expr());

        if (variables.get(currentInstruction).containsKey(value)) {
            value = variables.get(currentInstruction).get(value).getValue();
        } else if (variables.get(0).containsKey(value)) {
            value = variables.get(0).get(value).getValue();
        }

        Map<String, Variable> localVariables = variables.get(currentInstruction);

        if (Objects.nonNull(localVariables) && Objects.nonNull(localVariables.get(name))) {
            Variable variable = new Variable(localVariables.get(name).getType(), value);
            variables.get(currentInstruction).put(name, variable);
            // System.out.println("Variable '" + name + "' assigned value: " + value);
        } else {
            System.err.println("Error: Variable '" + name + "' has not been declared");
        }
        return null;
    }

    @Override
    public Object visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx) {
        Object value = visit(ctx.expr());
        Map<String, Variable> localVariables = variables.get(currentInstruction);

        if (value instanceof String && localVariables.containsKey(value)) {
            System.out.println(localVariables.get(value).value);
        } else {
            System.out.println(value);
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
    public Object visitTerm(SimpleScriptParser.TermContext ctx) {
        Object result = visit(ctx.factor()); // Odwiedź pierwszy czynnik

        if (variables.get(currentInstruction).containsKey(result)) {
            result = variables.get(currentInstruction).get(result).getValue();
        } else if (variables.get(0).containsKey(result)) {
            result = variables.get(0).get(result).getValue();
        }

        if (ctx.term() != null) {
            Object nextFactorResult = visit(ctx.term());
            if (ctx.MUL() != null) {
                result = multiply(result, nextFactorResult);
            } else if (ctx.DIV() != null) {
                result = divide(result, nextFactorResult);
            }
        }

        return result;
    }

    @Override
    public Object visitFactor(SimpleScriptParser.FactorContext ctx) {
        if (ctx.value() != null) {
            return visit(ctx.value());
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else {
            throw new IllegalArgumentException("Incorrect factor context");
        }
    }

    private Object multiply(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a * (Integer) b;
        } else {
            throw new IllegalArgumentException("Incorrect arguments for multiplication");
        }
    }

    private Object divide(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            if ((Integer) b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return (Integer) a / (Integer) b;
        } else {
            throw new IllegalArgumentException("Incorrect arguments for division");
        }
    }

    @Override
    public Object visitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx) {
        Object right = visit(ctx.term());
        Object left = null;
        String op = null;
    
        if (ctx.getChildCount() > 1) {
            op = ctx.getChild(1).getText();
            left = visit(ctx.arithmeticOperation());
        }

        try {
            right = Integer.parseInt(String.valueOf(right));
            if (left != null)
                left = Integer.parseInt(String.valueOf(left));

        } catch (NumberFormatException e) {
            System.out.println("Left: " + left);
            System.out.println("Right: " + right);
            try {
                left = Float.parseFloat(String.valueOf(left));
                if (right != null)
                    right = Float.parseFloat(String.valueOf(right));
            } catch (NumberFormatException ex) {
                throw new RuntimeException("Operands are not valid numbers");
            }
        }

        // Perform the arithmetic operation based on the operator
        if (op == null) {
            return right;
        }
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

        for (SimpleScriptParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }

        return null;
    }

    @Override
    public Object visitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx) {
        String returnType = ctx.TYPE(0).getText();
        String functionName = ctx.NAME(0).getText();

        Map<String, Variable> parameters = new LinkedHashMap<>();

        if (ctx.NAME().size() > 1) {
            for (int i = 1; i < ctx.NAME().size(); i++) {
                String type = ctx.TYPE(i).getText();
                String name = ctx.NAME(i).getText();
                parameters.put(name, new Variable(type, null));
            }
        }

        List<SimpleScriptParser.StatementContext> blockContext = ctx.statement();

        if (blockContext.isEmpty()) {
            throw new RuntimeException("Block context not found within FunctionDeclarationContext.");
        }

        FunctionInfo functionInfo = new FunctionInfo(returnType, blockContext);

        currentInstruction = functionInfo.functionID;

        variables.put(functionInfo.functionID, parameters);
        functions.put(functionName, functionInfo);

        currentInstruction = 0;

        return null;
    }

    @Override
    public Object visitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx) {
        String functionName = ctx.NAME().getText();
        FunctionInfo functionInfo = functions.get(functionName);

        currentInstruction = functionInfo.getFunctionID();

        int idx = 0;

        for (var argument : variables.get(currentInstruction).entrySet()) {
            argument.getValue().setValue(visit(ctx.expr(idx++)));
        }

        return executeFunction(functionName);
    }


    private Object executeFunction(String functionName) {
        FunctionInfo functionInfo = functions.get(functionName);

        if (functionInfo == null) {
            throw new RuntimeException("Function '" + functionName + "' is not defined.");
        }

        for (var statement : functionInfo.block) {
            visit(statement);
        }

        currentInstruction = 0;

        for (var m : variables.entrySet()) {
            System.out.println(m.getKey() + ": ");
            System.out.println(m.getValue());
        }

        return null;
    }
}