import java.util.HashMap;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
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

    HashMap<String, Variable> variables = new HashMap<>();
    

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
            // Add other conditional operations as needed
            // Handle <, <=, ==, !=
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
}