package visitor;
import java.util.*;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    private int currentInstruction = 0;
    private final Map<String, FunctionInfo> functions = new HashMap<>();
    //private final Map<Integer, Map<String, Variable>> variables = new HashMap<>();
    private final Deque<Map<String, Variable>> scopeStack = new ArrayDeque<>();
    private final Stack<FunctionInfo> functionStack = new Stack<>();

    public InterpretVisitor() {
        super();
        scopeStack.push(new HashMap<>());
    }
    
    public static class Variable {
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

    public static class FunctionInfo {
        private static int ID = 1;
        private final String returnType;
        private final int parametersCount;
        private final SimpleScriptParser.BlockContext block;
        private final int functionID = ID++;
        public Map<String, Variable> parameters; // Add this line

        public FunctionInfo(String returnType, SimpleScriptParser.BlockContext block, int parametersCount) {
            this.returnType = returnType;
            this.block = block;
            this.parametersCount = parametersCount;
            this.parameters = new LinkedHashMap<>();
        }

        public SimpleScriptParser.BlockContext getBlock() {
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
                    ", parameters=" + parameters + // Add this line
                    '}';
        }
    }

    private Map<String, Variable> currentScope() {
        return scopeStack.peek();
    }

    @Override
    public Void visitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx) {
        String type = ctx.TYPE().getText();
        Map<String, Variable> currentScope = scopeStack.peek();

        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Object value = visit(ctx.expr(i));

            if (value instanceof String) {
                // Check if the string is a variable name
                String strValue = (String) value;
                if (currentScope.containsKey(strValue) || isVariableName(strValue)) {
                    value = sourceVariable(strValue);
                }
            }

            if (type.equals("int") && value instanceof Float) {
                value = ((Float) value).intValue();
            }

            if (currentScope.containsKey(name)) {
                System.err.println("Duplicate Error: Variable '" + name + "' has been declared");
                System.exit(1);
            }

            Variable variable = new Variable(type, value);
            currentScope.put(name, variable);
        }

        return null;
    }

    private boolean isVariableName(String name) {
        for (Map<String, Variable> scope : scopeStack) {
            if (scope.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Void visitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        Map<String, Variable> currentScope = scopeStack.peek();

        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Variable variable = new Variable(type, null);
            currentScope.put(name, variable);
        }

        return null;
    }

    @Override
    public Void visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Object value = visit(ctx.expr());

        if (value instanceof String) {
            String strValue = (String) value;
            if (isVariableName(strValue)) {
                value = sourceVariable(strValue);
            }
        }

        Map<String, Variable> currentScope = scopeStack.peek();

        if (ctx.ASSIGN() != null) {
            if (currentScope.containsKey(name)) {
                Variable variable = currentScope.get(name);
                variable.setValue(value);
            } else {
                System.err.println("Error: Variable '" + name + "' has not been declared");
                System.exit(1);
            }
        }

        if (ctx.ASSIGNMENT() != null) {
            Object baseVariable = sourceVariable(name);

            if (baseVariable instanceof String)
                baseVariable = parseValue((String) baseVariable);

            if (value instanceof String)
                value = parseValue((String) value);

            Variable variable = currentScope.get(name);

            switch (ctx.ASSIGNMENT().getText()) {
                case "+=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable + (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable + (float) value);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "-=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable - (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable - (float) value);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "*=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable * (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable * (float) value);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "/=":
                    try {
                        if (baseVariable instanceof Integer && value instanceof Integer) {
                            variable.setValue((int) baseVariable / (int) value);
                        } else if (baseVariable instanceof Float && value instanceof Float) {
                            variable.setValue((float) baseVariable / (float) value);
                        } else {
                            System.err.println("Error: The types of " + baseVariable + " and " + value + "vary. Cannot perform the assignment.");
                                    System.exit(1);
                        }
                    } catch (ArithmeticException e) {
                        System.err.println("Error: Division by 0.");
                        System.exit(1);
                    }
                    break;
            }
        }

        return null;
    }


    @Override
    public Object visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx) {
        Object value = visit(ctx.expr());

        Map<String, Variable> localVariables = currentScope();

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
        } else if(ctx.arrayAccess() != null){
            return visitArrayAccess(ctx.arrayAccess());
        } else if (ctx.arrayOperation() != null) {
            return visitArrayOperation(ctx.arrayOperation());
        } else {
            return null;
        }
    }

    @Override
    public Object visitTerm(SimpleScriptParser.TermContext ctx) {
        Object result = visit(ctx.factor());

        // Check if the result is a numeric literal
        if (result instanceof String) {
            String strResult = (String) result;
            if (isNumeric(strResult)) {
                result = parseValue(strResult); // Return the parsed numeric value
            } else {
                // Otherwise, treat it as a variable name
                result = sourceVariable(strResult);
            }
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

    // Helper method to check if a string represents a numeric value
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public Object visitFactor(SimpleScriptParser.FactorContext ctx) {
        if (ctx.value() != null) {
            return visit(ctx.value());
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        }else if (ctx.functionInvocation() != null){
            return visitFunctionInvocation(ctx.functionInvocation());
        } else {
            System.err.println("Error: Incorrect factor context");
            System.exit(1);
        }

        return null;
    }

    private Object multiply(Object a, Object b) {
        // Perform multiplication
        if (a instanceof Integer && b instanceof Integer) {
            return (int) a * (int) b;
        } else if (a instanceof Float || b instanceof Float) {
            // Cast to float if any operand is float to preserve precision
            return ((Number) a).floatValue() * ((Number) b).floatValue();
        } else {
            System.err.println("Error: Incorrect arguments for multiplication");
            return null;
        }
    }

    private Object divide(Object a, Object b) {
        // Perform division
        if (a instanceof Integer && b instanceof Integer) {
            if ((int) a == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return (int) b / (int) a;
        } else if (a instanceof Float || b instanceof Float) {
            if (((Number) a).floatValue() == 0.0) {
                throw new ArithmeticException("Division by zero");
            }
            return ((Number) b).floatValue() / ((Number) a).floatValue();
        } else {
            System.err.println("Error: Incorrect arguments for division");
            return null;
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

        // Convert right operand to a literal value if it's a variable
        if (right instanceof String) {
            String rightVarName = (String) right;
            if (currentScope().containsKey(rightVarName)) {
                right = sourceVariable(rightVarName);
            } else {
                // If it's not a variable, treat it as a literal value
                try {
                    right = parseValue(rightVarName);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid value for right operand");
                    System.exit(1);
                }
            }
        }

        // Convert left operand to a literal value if it's a variable
        if (left instanceof String) {
            String leftVarName = (String) left;
            if (currentScope().containsKey(leftVarName)) {
                left = sourceVariable(leftVarName);
            } else {
                // If it's not a variable, treat it as a literal value
                try {
                    left = parseValue(leftVarName);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid value for left operand");
                    System.exit(1);
                }
            }
        }

        // Now, both left and right operands should be literal values
        // Perform type conversion if necessary
        try {
            if (left != null)
                left = convertToNumber(left);
            right = convertToNumber(right);
        } catch (NumberFormatException e) {
            System.err.println("Error: Operands are not valid numbers");
            System.exit(1);
        }

        if (op == null) {
            return right;
        }

        // Perform arithmetic operation
        switch (op) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            default:
                System.err.println("Error: Unsupported operator: " + op);
                System.exit(1);
                return null;
        }
    }

    // Helper method to convert operand to a number
    private Object convertToNumber(Object operand) {
        if (operand instanceof Integer || operand instanceof Float) {
            return operand; // Already a number
        } else if (operand instanceof String) {
            return parseValue((String) operand);
        } else {
            throw new NumberFormatException();
        }
    }

    // Helper method to perform addition
    private Object add(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left + (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left + (float) right;
        } else {
            System.err.println("Error: Unsupported operand types for addition");
            System.exit(1);
            return null;
        }
    }

    // Helper method to perform subtraction
    private Object subtract(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left - (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left - (float) right;
        } else {
            System.err.println("Error: Unsupported operand types for subtraction");
            System.exit(1);
            return null;
        }
    }


    @Override
    public Object visitConditionalOperation(SimpleScriptParser.ConditionalOperationContext ctx) {
        Object right = visit(ctx.logicalTerm());
        Object left = null;
        String op = null;

        if (ctx.getChildCount() > 1) {
            op = ctx.getChild(1).getText();
            left = visit(ctx.conditionalOperation());
        }

        // Check if left operand is a variable name
        if (left instanceof String) {
            String leftVarName = (String) left;
            if (currentScope().containsKey(leftVarName)) {
                left = sourceVariable(leftVarName);
            } else {
                // If it's not a variable, treat it as a literal value
                try {
                    left = parseValue(leftVarName);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid value for left operand");
                    System.exit(1);
                }
            }
        }

        // Check if right operand is a variable name
        if (right instanceof String) {
            String rightVarName = (String) right;
            if (currentScope().containsKey(rightVarName)) {
                right = sourceVariable(rightVarName);
            } else {
                // If it's not a variable, treat it as a literal value
                try {
                    right = parseValue(rightVarName);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid value for right operand");
                    System.exit(1);
                }
            }
        }

        if (op == null) {
            return right;
        }

        // Perform comparison based on the operator
        switch (op) {
            case ">":
                return compareGreaterThan(left, right);
            case ">=":
                return compareGreaterThanOrEqual(left, right);
            case "<":
                return compareLessThan(left, right);
            case "<=":
                return compareLessThanOrEqual(left, right);
            case "==":
                return compareEqual(left, right);
            case "!=":
                return compareNotEqual(left, right);
        }

        return null;
    }

    // Helper methods for comparison
    private boolean compareGreaterThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left > (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left > (float) right;
        }
        return false;
    }

    private boolean compareGreaterThanOrEqual(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left >= (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left >= (float) right;
        }
        return false;
    }

    private boolean compareLessThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left < (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left < (float) right;
        }
        return false;
    }

    private boolean compareLessThanOrEqual(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left <= (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left <= (float) right;
        }
        return false;
    }

    private boolean compareEqual(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left == (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left == (float) right;
        }
        return false;
    }

    private boolean compareNotEqual(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (int) left != (int) right;
        } else if (left instanceof Float && right instanceof Float) {
            return (float) left != (float) right;
        }
        return false;
    }

    @Override
    public Object visitLogicalTerm(SimpleScriptParser.LogicalTermContext ctx) {
        Object result = visit(ctx.logicalFactor());

        // Check if the result is a variable name
        if (result instanceof String) {
            String varName = (String) result;
            if (currentScope().containsKey(varName)) {
                result = sourceVariable(varName);
            }
        }

        if (ctx.OR() != null && ctx.logicalTerm() != null) {
            Object nextFactorResult = visit(ctx.logicalTerm());

            try {
                boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                boolean nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;
                return boolResult || nextBoolResult;
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid boolean value");
                System.exit(1);
            }
        }

        return result;
    }

    @Override
    public Object visitLogicalFactor(SimpleScriptParser.LogicalFactorContext ctx) {
        Object result = visit(ctx.logicalPrimary());

        // Check if the result is a variable name
        if (result instanceof String) {
            String varName = (String) result;
            if (currentScope().containsKey(varName)) {
                result = sourceVariable(varName);
            } else {
                // If it's not a variable, treat it as a literal value
                return result;
            }
        }

        if (ctx.AND() != null && ctx.logicalFactor() != null) {
            Object nextFactorResult = visit(ctx.logicalFactor());

            try {
                boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                boolean nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;
                return boolResult && nextBoolResult;
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid boolean value");
                System.exit(1);
            }
        }

        return result;
    }

    @Override
    public Object visitLogicalPrimary(SimpleScriptParser.LogicalPrimaryContext ctx) {
        if (ctx.value() != null) {
            Object result = visit(ctx.value());

            // Check if the result is a variable name
            if (result instanceof String) {
                String varName = (String) result;
                if (currentScope().containsKey(varName)) {
                    result = sourceVariable(varName);
                } else {
                    // If it's not a variable, treat it as a literal value
                    return result;
                }
            }

            return result;
        } else if (ctx.logicalPrimary() != null) {
            Object result = visit(ctx.logicalPrimary());

            try {
                boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                return !boolResult;
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid boolean value");
                System.exit(1);
            }
        } else if (ctx.conditionalOperation() != null) {
            return visit(ctx.conditionalOperation());
        } else if (ctx.functionInvocation() != null) {
            return visit(ctx.functionInvocation());
        }

        return null;
    }

    @Override
    public Object visitValue(SimpleScriptParser.ValueContext ctx) {
        if (ctx.NAME() != null) {
            String variableName = ctx.NAME().getText();
            // Check if the variable exists in the current scope
            if (!currentScope().containsKey(variableName)) {
                System.err.println("Error: Variable '" + variableName + "' is not defined.");
                System.exit(1);
            }
            return sourceVariable(variableName); // Return variable name
        } else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1); // Return string value without quotes
        } else if (ctx.NUMBER() != null) {
            return ctx.NUMBER().getText(); // Return number value
        } else if (ctx.BOOLEAN() != null) {
            return ctx.BOOLEAN().getText(); // Return boolean value
        }

        return null;
    }

    @Override
    public Object visitSingleValueOperation(SimpleScriptParser.SingleValueOperationContext ctx) {
        String variableName = ctx.NAME().getText();
        String operation = ctx.SINGLE_VAL_OP().getText();
    
        // Get the current value of the variable
        Object value = sourceVariable(variableName);

        if (value instanceof String){
            value = parseValue((String) value);
        }
    
        // Apply the operation
        if (value instanceof Integer) {
            if (operation.equals("++")) {
                value = (int) value + 1;
            } else if (operation.equals("--")) {
                value = (int) value - 1;
            }
        } else if (value instanceof Float) {
            if (operation.equals("++")) {
                value = (float) value + 1;
            } else if (operation.equals("--")) {
                value = (float) value - 1;
            }
        }
    
        // Update the variable value
        Map<String, Variable> localVariables = currentScope();
        if (localVariables.containsKey(variableName)) {
            Variable variable = new Variable(localVariables.get(variableName).getType(), value);
            localVariables.put(variableName, variable);
        } else {
            System.err.println("Error: Variable '" + variableName + "' has not been declared");
            System.exit(1);
        }
    
        return null;
    }

    @Override
    public Object visitBlock(SimpleScriptParser.BlockContext ctx) {
        // Create a new scope that inherits from the parent scope
        Map<String, Variable> blockScope = new HashMap<>(currentScope());
        scopeStack.push(blockScope);

        // Visit each statement in the block
        for (SimpleScriptParser.StatementContext statementContext : ctx.statement()) {
            var value = visit(statementContext);
            if (value != null)
                return value;
        }

        if (ctx.returnStatement() != null) {

            return visit(ctx.returnStatement());
        }

        // Pop the block scope from the stack after visiting all statements
        scopeStack.pop();

        return null;
    }

    @Override
    public Object visitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx) {
        FunctionInfo functionInfo = functionStack.pop();

        try {
            Object returnValue = visit(ctx.expr());

            return switch (functionInfo.returnType) {
                        case "int" -> Integer.valueOf((String) returnValue);
                        case "float" -> Float.valueOf((String) returnValue);
                        case "bool" -> Boolean.valueOf((String) returnValue);
                        default -> throw new RuntimeException();
                    };

        } catch (Exception e1) {

            Object returnValue = visit(ctx.expr());

            if (returnValue instanceof String) {
                returnValue = sourceVariable((String) returnValue);
            }

            try {
                return switch (functionInfo.returnType) {
                    case "int" -> Integer.valueOf((String) returnValue);
                    case "float" -> Float.valueOf((String) returnValue);
                    case "bool" -> Boolean.valueOf((String) returnValue);
                    default -> throw new RuntimeException();
                };
            } catch (Exception e2) {
                System.out.println(e2);
                exitProgram("Error: Return type and value type don't match");
            }
        }

        return null;
    }

    private void exitProgram(String message) {
        System.out.println(message);
        System.exit(0);
    }

    @Override
    public Object visitFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx) {
        String returnType = ctx.TYPE(0).getText();
        String functionName = ctx.NAME(0).getText();

        if (ctx.block().returnStatement() != null && returnType.equals("void")) {
            exitProgram("Error: Void functions cannot contain a return statement.");
        }

        Map<String, Variable> parameters = new LinkedHashMap<>();
        for (int i = 1; i < ctx.NAME().size(); i++) {
            String type = ctx.TYPE(i).getText();
            String name = ctx.NAME(i).getText();
            parameters.put(name, new Variable(type, null));
        }

        SimpleScriptParser.BlockContext block = ctx.block();

        if (block.statement().isEmpty() && returnType.equals("void")) {
            System.err.println("Error: Block context not found.");
            System.exit(1);
        }

        FunctionInfo functionInfo = new FunctionInfo(returnType, block, parameters.size());
        functionInfo.parameters = parameters;

        functions.put(functionName, functionInfo);

        return null;
    }

    @Override
    public Object visitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx) {
        String functionName = ctx.NAME().getText();

        if (!functions.containsKey(functionName)) {
            exitProgram("Error: Function '" + functionName + "' is not defined.");
        }

        FunctionInfo functionInfo = functions.get(functionName);
        List<SimpleScriptParser.ExprContext> arguments = ctx.expr();

        functionStack.push(functionInfo);

        if (arguments.size() != functionInfo.parametersCount) {
            exitProgram("Error: Function '" + functionName + "' expects " + functionInfo.parametersCount + " arguments, but got " + arguments.size());
        }

        // Create a new scope for the function call

        scopeStack.push(new HashMap<>(currentScope()));

        Map<String, Variable> localVariables = scopeStack.peek();


        // Assign the arguments to the parameters
        List<String> parameterNames = new ArrayList<>(functionInfo.parameters.keySet());
        for (int i = 0; i < arguments.size(); i++) {
            Object value = visit(arguments.get(i));
            String parameterName = parameterNames.get(i);
            Variable parameter = functionInfo.parameters.get(parameterName);
            parameter.setValue(value);
            localVariables.put(parameterName, parameter);
        }

        var result = visit(functionInfo.getBlock());

        scopeStack.pop(); // Remove the function scope

        return result;
    }

    @Override
    public Object visitIfCondition(SimpleScriptParser.IfConditionContext ctx) {
       boolean result = (boolean) visit(ctx.conditionalOperation(0));

       if (result) {
           return visit(ctx.block(0));
       } else if (!ctx.ELIF().isEmpty()){
           for (int i = 1; i <= ctx.ELIF().size(); i++) {
               result = (boolean) visit(ctx.conditionalOperation(i));

               if (result) {
                   return visit(ctx.block(i));
               }
           }
       }

        if (Objects.nonNull(ctx.ELSE())) {
            return visit(ctx.block(ctx.conditionalOperation().size()));
        }

        return null;
    }

    @Override
    public Object visitWhileLoop(SimpleScriptParser.WhileLoopContext ctx) {


        // Evaluate the initial condition
        boolean condition = (boolean) visit(ctx.conditionalOperation());

        while (condition) {
            // Enter the loop block
            scopeStack.push(new HashMap<>(currentScope()));
            visit(ctx.block());

            // After executing the loop block, pop its scope
            scopeStack.pop();

            // Re-evaluate the loop condition
            condition = (boolean) visit(ctx.conditionalOperation());
        }

        // Pop the scope for the while loop
//        scopeStack.pop();

        return null;
    }

    @Override
    public Object visitForLoop(SimpleScriptParser.ForLoopContext ctx) {
        scopeStack.push(new HashMap<>(currentScope()));
        boolean isList = false;
        if(ctx.variableDefinition() != null) {
            SimpleScriptParser.VariableDefinitionContext variableDefinitionContext = ctx.variableDefinition();
            visitVariableDefinition(variableDefinitionContext);
        } else {
            SimpleScriptParser.VariableAssignmentContext variableAssignmentContext1 = ctx.variableAssignment(0);
            visitVariableAssignment(variableAssignmentContext1);
            isList = true;
        }
        SimpleScriptParser.ConditionalOperationContext conditionalOperationContext = ctx.conditionalOperation();
        SimpleScriptParser.SingleValueOperationContext singleValueOperationContext = ctx.singleValueOperation();
        SimpleScriptParser.VariableAssignmentContext variableAssignmentContext;
        if(isList) {
            variableAssignmentContext = ctx.variableAssignment(1);
        } else {
            variableAssignmentContext = ctx.variableAssignment(0);
        }

        // Visit and add loop variable to the current scope

        while ((boolean) visit(conditionalOperationContext)) {
            scopeStack.push(new HashMap<>(currentScope()));
            visit(ctx.block());
            scopeStack.pop();
            if (singleValueOperationContext != null) {
                visitSingleValueOperation(singleValueOperationContext);
            } else if (variableAssignmentContext != null) {
                visitVariableAssignment(variableAssignmentContext);
            }

        }
        // Pop the loop scope from the stack after the loop completes
        scopeStack.pop();

        return null;
    }

    @Override
    public Object visitForLoopArray(SimpleScriptParser.ForLoopArrayContext ctx) {
        // Create a new scope for the loop
        scopeStack.push(new HashMap<>(currentScope()));

        // Get the parameter and array name
        SimpleScriptParser.ParameterContext parameterCtx = ctx.parameter();
        String paramName = parameterCtx.NAME().getText();
        if(scopeStack.peek().containsKey(paramName)) {
            System.err.println("Duplicate Error: Variable '" + paramName + "' has been declared");
            System.exit(1);
        }
        String arrayName = ctx.NAME().getText();

        // Get the array variable
        Variable arrayVariable = currentScope().get(arrayName);
        if (arrayVariable == null || !(arrayVariable.getValue() instanceof List<?>)) {
            System.err.println("Variable " + arrayName + " is not an array or is not defined.");
            System.exit(1);
        }

        List<?> array = (List<?>) arrayVariable.getValue();

        for (Object element : array) {
            // Create a new scope for each iteration
            scopeStack.push(new HashMap<>(currentScope()));
            // Define the loop variable with the current element
            currentScope().put(paramName, new Variable("var", element));

            // Execute the block
            visit(ctx.block());

            // Pop the inner loop scope
            scopeStack.pop();
        }

        // Pop the loop scope
        scopeStack.pop();

        return null;
    }

    @Override
    public Object visitArguments(SimpleScriptParser.ArgumentsContext ctx) {
        List<Object> values = new ArrayList<>();
        String type;

        Object firstExpr = visit(ctx.expr(0));

        try {
            Integer.parseInt((String) firstExpr);
            type = "int";
        } catch (NumberFormatException e1) {
            try {
                Float.parseFloat((String) firstExpr);
                type = "float";
            } catch (NumberFormatException e2) {
                try {
                    Boolean.parseBoolean((String) firstExpr);
                    type = "boolean";
                } catch (NumberFormatException e3) {
                    System.out.println("Unknown type");
                    return null;
                }
            }
        }

        values.add(firstExpr);

        for (int i = 1; i < ctx.expr().size(); i++) {
            Object expr = visit(ctx.expr(i));

            try {
                switch (type) {
                    case "int":
                        Integer.parseInt((String) expr);
                        break;
                    case "float":
                        Float.parseFloat((String) expr);
                        break;
                    case "boolean":
                        Boolean.parseBoolean((String) expr);
                        break;
                    default:
                        System.out.println("Unknown type");
                        return null;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Inhomogeneous values provided as the array arguments");
                System.exit(1);
            }

            values.add(expr);
        }

        return values;
    }


    @Override
    public Object visitArrayDefinition(SimpleScriptParser.ArrayDefinitionContext ctx) {
        String type = ctx.arrayType().TYPE().getText() + "[" + "]";
        String name = ctx.NAME().getText();
        Object arguments = new ArrayList<>();
        Map<String, Variable> localVariables = currentScope();

        if (ctx.arguments() != null) {
            arguments = visit(ctx.arguments());
        }

        Variable variable = new Variable(type, arguments);

        localVariables.put(name, variable);

        return null;
    }

    @Override
    public Object visitArrayAccess(SimpleScriptParser.ArrayAccessContext ctx) {
        String arrayName = ctx.NAME().getText();
        Object index = visit(ctx.expr());

        if (index instanceof String)
                index = parseValue((String) index);

        if (index instanceof Integer && index instanceof Integer) {
            int intIndex = (int) index;
            Map<String, Variable> localVariables = currentScope();
            if (!localVariables.containsKey(arrayName)) {
                System.err.println("Error: Array '" + arrayName + "' has not been declared");
                System.exit(1);
            }

            Variable arrayVariable = localVariables.get(arrayName);
            if (!(arrayVariable.getValue() instanceof List)) {
                System.err.println("Error: Variable '" + arrayName + "' is not an array");
                System.exit(1);
            }

            List<?> array = (List<?>) arrayVariable.getValue();
            if (intIndex < 0 || intIndex >= array.size()) {
                System.err.println("Error: Array index out of bounds");
                System.exit(1);
            }

            return array.get(intIndex);
        }

        return null;
    }

    @Override
    public Object visitArrayOperation(SimpleScriptParser.ArrayOperationContext ctx) {
        if (ctx.reverseOperation() != null) {
            return visitReverseOperation(ctx.reverseOperation());
        } else if (ctx.addOperation() != null) {
            return visitAddOperation(ctx.addOperation());
        }
        return null;
    }

    @Override
    public Object visitReverseOperation(SimpleScriptParser.ReverseOperationContext ctx) {
        String arrayName = ctx.NAME().getText();
        Variable arrayVar = currentScope().get(arrayName);

        if (arrayVar == null || !(arrayVar.getValue() instanceof List)) {
            System.err.println("Variable " + arrayName + " is not an array or is not defined.");
            System.exit(1);
        }

        List<Object> array = (List<Object>) arrayVar.getValue();
        Collections.reverse(array);
        return array;
    }

    @Override
    public Object visitAddOperation(SimpleScriptParser.AddOperationContext ctx) {
        String arrayName = ctx.NAME().getText();
        Variable arrayVar = currentScope().get(arrayName);
        String arrType = arrayVar.getType().substring(0, arrayVar.getType().length() - 2);

        if (arrayVar == null || !(arrayVar.getValue() instanceof List)) {
            System.err.println("Variable " + arrayName + " is not an array or is not defined.");
            System.exit(1);
        }

        List<Object> array = (List<Object>) arrayVar.getValue();
        
        Object valueToAdd = visit(ctx.expr());
        if(arrType.equals("int")) {
            try {
                int value = Integer.parseInt(valueToAdd.toString());
                array.add(value);
            } catch(Exception e) {
                System.err.println("Type of variable: " + valueToAdd.getClass() + " does not match with array type: " + arrType);
                System.exit(1);
            }
        } else if(arrType.equals("double")) {
            try {
                double value = Double.parseDouble(valueToAdd.toString());
                array.add(value);
            } catch(Exception e) {
                System.err.println("Type of variable: " + valueToAdd.getClass() + " does not match with array type: " + arrType);
                System.exit(1);
            }
        } else if(arrType.equals("string")) {
            array.add(valueToAdd);
        }
        // array.add(valueToAdd);
        return null;
    }

    @Override
    public Object visitSwitchCondition(SimpleScriptParser.SwitchConditionContext ctx) {
        String switchVariableName = ctx.NAME().getText();
        Variable switchVariable = currentScope().get(switchVariableName);

        if (switchVariable == null) {
            throw new RuntimeException("Variable " + switchVariableName + " is not defined.");
        }

        Object switchValue = switchVariable.getValue();
        boolean caseMatched = false;

        // Iterate through all case clauses
        for (SimpleScriptParser.CaseClauseContext caseCtx : ctx.caseClause()) {
            Object caseValue = visit(caseCtx.value());

            if (caseMatched || switchValue.equals(caseValue)) {
                caseMatched = true;
                for (SimpleScriptParser.StatementContext stmtCtx : caseCtx.statement()) {
                    visit(stmtCtx);
                }
            }

            if (caseMatched && caseCtx.BREAK() != null) {
                return null;
            }
        }

        // If no case matched or fall-through occurs, execute the default clause if it exists
        if (caseMatched && ctx.defaultClause() != null) {
            for (SimpleScriptParser.StatementContext stmtCtx : ctx.defaultClause().statement()) {
                visit(stmtCtx);
            }
        } else if (!caseMatched && ctx.defaultClause() != null) {
            for (SimpleScriptParser.StatementContext stmtCtx : ctx.defaultClause().statement()) {
                visit(stmtCtx);
            }
        }

        return null;
    }


    @Override
    public Object visitStringOperation(SimpleScriptParser.StringOperationContext ctx) {
        if (ctx.concatenationOperation() != null) {
            return visitConcatenationOperation(ctx.concatenationOperation());
        } else if (ctx.findOperation() != null) {
            return visitFindOperation(ctx.findOperation());
        }
        return null;
    }

    @Override
    public Object visitConcatenationOperation(SimpleScriptParser.ConcatenationOperationContext ctx) {
        String left = ctx.children.get(0).getText();
        left = findVar(left);
        
        String right = ctx.children.get(2).getText();
        right = findVar(right);

        return left + right;
    }

    @Override
    public Object visitFindOperation(SimpleScriptParser.FindOperationContext ctx) {
        String needle = ctx.children.get(2).getText();
        needle = findVar(needle);

        String haystack = ctx.children.get(4).getText();
        haystack = findVar(haystack);

        return haystack.indexOf(needle);
    }

    private String findVar(String str) {
        if(currentScope().containsKey(str)) {
            Variable var = currentScope().get(str);
            if (var == null || !(var.getValue() instanceof String)) {
                System.err.println("Variable " + str + " is not a string or is not defined.");
                System.exit(1);
            }
            str = var.getValue().toString();
        } else {
            str = str.substring(1, str.length()-1);
        }
        return str;
    }

    private Object sourceVariable(String name) {
        for (Map<String, Variable> scope : scopeStack) {
            if (scope.containsKey(name)) {
                return scope.get(name).getValue();
            }
        }
        System.err.println("Error: Variable '" + name + "' has not been declared");
        System.exit(1);
        return null;  // Unreachable but required for compilation
    }

    private Object parseValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e1) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e2) {
                if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
                    return Boolean.parseBoolean(value);
                }
            }
        }
        // System.err.println("Cannot cast" + value + "to a specific type.");
        // System.exit(1);
        // return null;
        throw new NullPointerException();
    }
}
