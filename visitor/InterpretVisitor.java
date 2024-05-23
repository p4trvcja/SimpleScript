package visitor;
import java.util.*;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    private int currentInstruction = 0;
    private final Map<String, FunctionInfo> functions = new HashMap<>();
    private final Map<Integer, Map<String, Variable>> variables = new HashMap<>();

    public InterpretVisitor() {
        super();
        variables.put(0, new HashMap<>());
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
        private final List<SimpleScriptParser.StatementContext> block;
        private SimpleScriptParser.ReturnStatementContext returnStatementContext;
        private final int functionID = ID++;

        public FunctionInfo(String returnType, List<SimpleScriptParser.StatementContext> block, int parametersCount) {
            this.returnType = returnType;
            this.block = block;
            this.parametersCount = parametersCount;
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

        public void setReturnStatementContext(SimpleScriptParser.ReturnStatementContext returnStatementContext) {
            this.returnStatementContext = returnStatementContext;
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

            if (value instanceof String)
                value = sourceVariable((String) value);
            
            if (type.equals("int") && value instanceof Float) {
                value = ((Float) value).intValue();
            }
     
            if(variables.get(currentInstruction).containsKey(name)) {
                System.err.println("Duplicate Error: Variable '" + name + "' has been declared");
                return null;
            }

            Variable variable = new Variable(type, value);
            variables.get(currentInstruction).put(name, variable);
        }

        return null;
    }

    @Override
    public Void visitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();

        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Variable variable = new Variable(type, null);
            variables.get(currentInstruction).put(name, variable);
        }

        return null;
    }

    @Override
    public Void visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Object value = visit(ctx.expr());

        if (value instanceof String)
             value = sourceVariable((String) value);

        Map<String, Variable> localVariables = variables.get(currentInstruction);

        if (Objects.nonNull(ctx.ASSIGN())) {
            if (Objects.nonNull(localVariables) && Objects.nonNull(localVariables.get(name))) {
                Variable variable = new Variable(localVariables.get(name).getType(), value);
                variables.get(currentInstruction).put(name, variable);
            } else {
                System.err.println("Error: Variable '" + name + "' has not been declared");
                System.exit(1);
            }
        }

        if (Objects.nonNull(ctx.ASSIGNMENT())) {

            Object baseVariable = sourceVariable(name);

            if (baseVariable instanceof String)
                baseVariable = parseValue((String) baseVariable);

            if (value instanceof String)
                value = parseValue((String) value);

            switch (ctx.ASSIGNMENT().getText()) {
                case "+=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (int) baseVariable + (int) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (float) baseVariable + (float) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "-=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (int) baseVariable - (int) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (float) baseVariable - (float) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "*=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (int) baseVariable * (int) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        Variable variable = new Variable(localVariables.get(name).getType(), (float) baseVariable * (float) value);
                        variables.get(currentInstruction).put(name, variable);
                    } else {
                        System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                        System.exit(1);
                    }
                    break;
                case "/=":
                    try {
                        if (baseVariable instanceof Integer && value instanceof Integer) {
                            Variable variable = new Variable(localVariables.get(name).getType(), (int) baseVariable / (int) value);
                            variables.get(currentInstruction).put(name, variable);
                        } else if (baseVariable instanceof Float && value instanceof Float) {
                            Variable variable = new Variable(localVariables.get(name).getType(), (float) baseVariable / (float) value);
                            variables.get(currentInstruction).put(name, variable);
                        } else {
                            System.err.println("Error: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.");
                            System.exit(1);
                        }
                    } catch (ArithmeticException e) {
                        System.err.println("Error: Division by 0.");
                        System.exit(1);
                    }
                    break;
            }
        }

        if (localVariables.get(name).getType() == "int"){
            Variable variable = new Variable(localVariables.get(name).getType(), (int) value);
            variables.get(currentInstruction).put(name, variable);
        }else if (localVariables.get(name).getType() == "float"){
            Variable variable = new Variable(localVariables.get(name).getType(), (float) value);
            variables.get(currentInstruction).put(name, variable);
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
        } else if(ctx.arrayAccess() != null){
            return visitArrayAccess(ctx.arrayAccess());
        }else {
            return null;
        }
    }

    @Override
    public Object visitTerm(SimpleScriptParser.TermContext ctx) {
        Object result = visit(ctx.factor());

        if (result instanceof String)
            result = sourceVariable((String) result);

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
            System.err.println("Error: Incorrect factor context");
            System.exit(1);
        }

        return null;
    }

    private Object multiply(Object a, Object b) {
        try {
            a = Integer.parseInt(String.valueOf(a));
            b = Integer.parseInt(String.valueOf(b));

        } catch (NumberFormatException e) {
            try {
                a = Float.parseFloat(String.valueOf(a));
                b = Float.parseFloat(String.valueOf(b));
            } catch (NumberFormatException ex) {
                System.err.println("Error: Operands are not valid numbers");
                System.exit(1);
            }
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (int) b * (int) a;
        } else if (a instanceof Float && b instanceof Float){
            return (float) b * (float) a;
        } else {
            System.err.println("Error: Incorrect arguments for multiplication");
            System.exit(1);
        }

        return null;
    }


    private Object divide(Object a, Object b) {
        try {
            a = Integer.parseInt(String.valueOf(a));
            b = Integer.parseInt(String.valueOf(b));

        } catch (NumberFormatException e) {
            try {
                a = Float.parseFloat(String.valueOf(a));
                b = Float.parseFloat(String.valueOf(b));
            } catch (NumberFormatException ex) {
                System.err.println("Error: Operands are not valid numbers");
                System.exit(1);
            }
        }
        if (a instanceof Integer && b instanceof Integer) {
            if ((int) b == 0) {
                System.err.println("Error: Division by zero");
                System.exit(1);
            }
            return (int) b / (int) a;
        } else if(a instanceof Float && b instanceof Float) {
            if ((float) b == 0.0) {
                System.err.println("Error: Division by zero");
                System.exit(1);
            }
            return (float) b / (float) a;
        } else {
            System.err.println("Error: Incorrect arguments for division");
            System.exit(1);
        }

        return null;
    }

    @Override
    public Object visitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx) {
        Object right = visit(ctx.term());
        Object left = null;
        String op = null;

        if (right instanceof String)
            right = sourceVariable((String) right);
    
        if (ctx.getChildCount() > 1) {
            op = ctx.getChild(1).getText();
            left = visit(ctx.arithmeticOperation());

            if (left instanceof String)
                left = sourceVariable((String) left);
        }

        try {
            right = Integer.parseInt(String.valueOf(right));
            if (left != null)
                left = Integer.parseInt(String.valueOf(left));

        } catch (NumberFormatException e) {
            try {
                right = Float.parseFloat(String.valueOf(right));
                if (left != null)
                    left = Float.parseFloat(String.valueOf(left));
            } catch (NumberFormatException ex) {
                System.err.println("Error: Operands are not valid numbers");
                System.exit(1);
            }
        }

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
        }

        return null;
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

        if (left instanceof String)
            left = sourceVariable((String) left);

        if (right instanceof String)
            right = sourceVariable((String) right);

        if (left instanceof String) {
            try {
                left = parseValue((String) left);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        if (right instanceof String) {
            try {
                right = parseValue((String) right);
            } catch (NumberFormatException e) {
                return null;
            }
        }


        if (op == null) {
            return right;
        }

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
        }

        return null;
    }

    @Override
    public Object visitLogicalTerm(SimpleScriptParser.LogicalTermContext ctx) {
        Object result = visit(ctx.logicalFactor());

        if (result instanceof String) {
            result = sourceVariable((String) result);
        }

        if (ctx.logicalTerm() != null) {
            Object nextFactorResult = visit(ctx.logicalTerm());

            if (ctx.OR() != null) {

                try {
                    boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                    boolean nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;
                    result = boolResult || nextBoolResult;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid boolean value");
                    System.exit(1);
                }
            }
        }

        return result;
    }

    @Override
    public Object visitLogicalFactor(SimpleScriptParser.LogicalFactorContext ctx) {
        Object result = visit(ctx.logicalPrimary());

        if (result instanceof String)
            result = sourceVariable((String) result);

        if (ctx.logicalFactor() != null) {
            Object nextFactorResult = visit(ctx.logicalFactor());

            if (ctx.AND() != null) {
                try {
                    boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                    boolean nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;
                    result = boolResult && nextBoolResult;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid boolean value");
                    System.exit(1);
                }
            }
        }

        return result;
    }

    @Override
    public Object visitLogicalPrimary(SimpleScriptParser.LogicalPrimaryContext ctx) {
        if (ctx.value() != null) {
            return visit(ctx.value());

        } else if (ctx.logicalPrimary() != null) {
            Object result = visit(ctx.logicalPrimary());

            try {
                boolean boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
                return !boolResult;
            } catch (NumberFormatException e) {
                System.out.println("Invalid boolean value");
            }

        } else if (ctx.conditionalOperation() != null) {
            return visit(ctx.conditionalOperation());
        }

        return null;
    }
    
    @Override
    public Object visitValue(SimpleScriptParser.ValueContext ctx) {

        if (ctx.NAME() != null) {
            String variableName = ctx.NAME().getText();

            if (!variables.get(currentInstruction).containsKey(variableName) && !variables.get(0).containsKey(variableName)) {
                System.err.println("Error: Variable '" + variableName + "' is not defined.");
                System.exit(1);
            }
        }

        if (ctx.NAME() != null) {
            return ctx.NAME().getText();
        } else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        } else if (ctx.NUMBER() != null) {
            return ctx.NUMBER().getText();
        } else if (ctx.BOOLEAN() != null) {
            return ctx.BOOLEAN().getText();
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
        Map<String, Variable> localVariables = variables.get(currentInstruction);
        if (localVariables.containsKey(variableName)) {
            Variable variable = new Variable(localVariables.get(variableName).getType(), value);
            variables.get(currentInstruction).put(variableName, variable);
        } else {
            System.err.println("Error: Variable '" + variableName + "' has not been declared");
            System.exit(1);
        }
    
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

        try {
            for (Map.Entry<String, FunctionInfo> function : functions.entrySet()) {
                FunctionInfo functionInfo = function.getValue();
                if (functionInfo.functionID == currentInstruction) {
                    Object returnValue = visit(ctx.expr());

                    if (returnValue instanceof String) {
                        returnValue = sourceVariable((String) returnValue);
                    }

                    currentInstruction = 0;

                    return switch (functionInfo.returnType) {
                        case "int" -> (int) returnValue;
                        case "float" -> (float) returnValue;
                        case "bool" -> Boolean.parseBoolean((String) returnValue);
                        case "string" -> returnValue;
                        default -> throw new IllegalStateException("Error: Unexpected value: " + functionInfo.returnType);
                    };
                }
            }

            exitProgram("Error: Function is not defined.");
        } catch (Exception e) {
            exitProgram("Error: Return type and value type don't match");
        }

        currentInstruction = 0;

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

        if (ctx.returnStatement() != null && returnType.equals("void")) {
            exitProgram("Error: Void functions cannot contain a return statement.");
        }

        if (ctx.returnStatement() == null && !returnType.equals("void")) {
            exitProgram("Error: Function of the return type " + returnType + " should return a value.");
        }

        Map<String, Variable> parameters = new LinkedHashMap<>();

        if (ctx.NAME().size() > 1) {
            for (int i = 1; i < ctx.NAME().size(); i++) {
                String type = ctx.TYPE(i).getText();
                String name = ctx.NAME(i).getText();
                parameters.put(name, new Variable(type, null));
            }
        }

        List<SimpleScriptParser.StatementContext> blockContext = ctx.statement();

        if (blockContext.isEmpty() && returnType.equals("void")) {
            System.err.println("Error: Block context not found.");
            System.exit(1);
        }

        FunctionInfo functionInfo = new FunctionInfo(returnType, blockContext, parameters.size());
        functionInfo.setReturnStatementContext(ctx.returnStatement());
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

        if (Objects.isNull(functionInfo)) {
            System.out.println("Function '" + functionName + "' is not defined.");
            System.exit(0);
        }

        currentInstruction = functionInfo.getFunctionID();

        Iterator<Map.Entry<String, Variable>> iterator = variables.get(currentInstruction).entrySet().iterator();
        int count = 0;

        while (iterator.hasNext()) {
            Map.Entry<String, Variable> entry = iterator.next();
            if (count >= functionInfo.parametersCount) {
                iterator.remove();
            }
            count++;
        }

        int idx = 0;

        for (var argument : variables.get(currentInstruction).entrySet()) {
            argument.getValue().setValue(visit(ctx.expr(idx++)));
        }

        return executeFunction(functionName);
    }

    @Override
    public Object visitIfCondition(SimpleScriptParser.IfConditionContext ctx) {
       boolean result = (boolean) visit(ctx.conditionalOperation(0));

       if (result) {
           visit(ctx.block(0));
           return null;
       } else if (!ctx.ELIF().isEmpty()){
           for (int i = 1; i <= ctx.ELIF().size(); i++) {
               result = (boolean) visit(ctx.conditionalOperation(i));

               if (result) {
                   visit(ctx.block(i));
                   return null;
               }
           }
       }

        if (Objects.nonNull(ctx.ELSE())) {
            visit(ctx.block(ctx.conditionalOperation().size()));
            return null;
        }

        return null;
    }

    @Override
    public Object visitWhileLoop(SimpleScriptParser.WhileLoopContext ctx) {
        boolean condition = (boolean) visit(ctx.conditionalOperation());

        while (condition) {
            visit(ctx.block());
            condition = (boolean) visit(ctx.conditionalOperation());
        }

        return null;
    }

    @Override
    public Object visitForLoop(SimpleScriptParser.ForLoopContext ctx) {
        SimpleScriptParser.VariableDefinitionContext variableDefinitionContext = ctx.variableDefinition();
        SimpleScriptParser.ConditionalOperationContext conditionalOperationContext = ctx.conditionalOperation();
        SimpleScriptParser.SingleValueOperationContext singleValueOperationContext = ctx.singleValueOperation();
        SimpleScriptParser.VariableAssignmentContext variableAssignmentContext = ctx.variableAssignment();

        visitVariableDefinition(variableDefinitionContext); 
        while ((boolean) visit(conditionalOperationContext)) { 
            visit(ctx.block());
            if (singleValueOperationContext != null) {
                visitSingleValueOperation(singleValueOperationContext);
            } else if (variableAssignmentContext != null) {
                visitVariableAssignment(variableAssignmentContext);
            }
        }

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

        if (ctx.arguments() != null) {
            arguments = visit(ctx.arguments());
        }

        Variable variable = new Variable(type, arguments);

        variables.get(currentInstruction).put(name, variable);

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
            Map<String, Variable> localVariables = variables.get(currentInstruction);
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

    private Object executeFunction(String functionName) {
        FunctionInfo functionInfo = functions.get(functionName);

        if (functionInfo == null) {
            System.out.println("Error: Function '" + functionName + "' is not defined.");
            System.exit(0);
        }

        for (var statement : functionInfo.block) {
            visit(statement);
        }

        if (functionInfo.returnStatementContext != null) {
            return visit(functionInfo.returnStatementContext);
        }

        currentInstruction = 0;
        return null;
    }

    private Object sourceVariable(String variable) {

        if (variables.get(currentInstruction).containsKey(variable)) {
             return variables.get(currentInstruction).get(variable).getValue();
        } else if (variables.get(0).containsKey(variable)) {
             return variables.get(0).get(variable).getValue();
        }

        return variable;
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

        throw new NullPointerException();
    }
}
