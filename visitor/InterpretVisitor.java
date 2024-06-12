package visitor;
import java.util.*;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    private int currentInstruction = 0;
    private int id = 0;
    private Map<String, Map<List<Object>, Object>> memoizedResults = new HashMap<>();
    private final Map<String, FunctionInfo> functions = new HashMap<>();
    //private final Map<Integer, Map<String, Variable>> variables = new HashMap<>();
    private final Deque<Map<String, Variable>> scopeStack = new ArrayDeque<>();
    private final Stack<FunctionInfo> functionStack = new Stack<>();
    private final Deque<Map<String, FunctionInfo>> functionDeque = new ArrayDeque<>();
    private static final int MAX_RECURSION_DEPTH = 1000; 
    private int currentRecursionDepth = 0;
    private Map<String, Variable> globalScope = new HashMap<>();
    private String filePath = "script.ss";

    public InterpretVisitor(String filePath) {
        super();
        this.filePath = filePath;
        scopeStack.push(new HashMap<>());
        functionDeque.push(new HashMap<>());
        functionStack.push(null);
    }

    public InterpretVisitor() {
        super();
        this.filePath = filePath;
        scopeStack.push(new HashMap<>());
        functionDeque.push(new HashMap<>());
        functionStack.push(null);
    }

    public static class Variable {
        private String type;
        private Object value;
        private int scopeLevel;
    
        public Variable(String type, Object value, int scopeLevel) {
            this.type = type;
            this.value = value;
            this.scopeLevel = scopeLevel;
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
        private int ID;
        private final String returnType;
        private final int parametersCount;
        private final SimpleScriptParser.BlockContext block;
        private FunctionInfo parentFunction;
        private Map<String, Variable> lexicalEnvironment = new HashMap<>();
        private int parentId; 
        private final int functionID = ID++;
        public Map<String, Variable> parameters; // Add this line

        public FunctionInfo(String returnType, SimpleScriptParser.BlockContext block, int parametersCount, int ID, int parentId, FunctionInfo parentFunction) {
            this.returnType = returnType;
            this.block = block;
            this.parametersCount = parametersCount;
            this.parameters = new LinkedHashMap<>();
            this.ID = ID;
            this.parentFunction = parentFunction;
            this.parentId = parentId;
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

    private void printError(ParserRuleContext ctx, String message, int errorIndex) {
        int line = ctx.getStart().getLine();
        int charPositionInLine = ctx.getStart().getCharPositionInLine();
        String errorLine = ctx.getStart().getInputStream().getText(new org.antlr.v4.runtime.misc.Interval(
                ctx.getStart().getStartIndex(),
                ctx.getStop().getStopIndex()
        ));
        if(errorLine.split("\n").length > 1){
            errorLine = errorLine.split("\n")[0];
        }
        String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine+errorIndex);
        String middle = message;
        String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
        customizedMsg += "\t" + errorLine + "\n";
        customizedMsg += "\t" + " ".repeat(errorIndex-charPositionInLine) + "^";
        // Print the customized error message
        System.err.println(customizedMsg);
        System.exit(1);

    }


    @Override
    public Void visitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx) {
        String type = ctx.TYPE().getText();
        Map<String, Variable> currentScope = scopeStack.peek();

        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Object value = visit(ctx.expr(i));

//            if (value instanceof String) {
//                // Check if the string is a variable name
//                String strValue = (String) value;
//                if (currentScope.containsKey(strValue) || isVariableName(strValue)) {
//                    value = sourceVariable(strValue);
//                }
//            }

//            if (type.equals("int") && value instanceof Float) {
//                value = ((Float) value).intValue();
//            }

            if (ctx.expr().get(i).value() != null){
                if ((ctx.expr().get(i).value().STRING() == null && Objects.equals(type, "string")) && !Objects.equals(type, checkType(value))) {
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.expr(i).getStart().getCharPositionInLine();
                    printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                    System.exit(1);
                } else if ((ctx.expr().get(i).value().STRING() != null)) {
                    if (!Objects.equals(type, "string")) {
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.expr(i).getStart().getCharPositionInLine();
                        printError(context, "TypeError: Variable '" + name + "' can't be assigned type: string", errorIndex);
                        System.exit(1);
                    }
                } else if (ctx.expr().get(i).value() != null && ctx.expr().get(i).value().NAME() != null) {
                    Object var = ctx.expr().get(i).value().NAME().getText();

                    for (Map<String, Variable> scope : scopeStack) {
                        if (scope.containsKey(var)) {
                            Variable variable = scope.get(var);
                            if (variable.type.equals("string") && !Objects.equals(type, "string")) {
                                int errorIndex = ctx.expr().get(i).getStart().getCharPositionInLine();
                                printError(ctx, "TypeError: Variable '" + name + "' can't be assigned type: string", errorIndex);
                                System.exit(1);
                            }
                        }
                    }
                } else if (!Objects.equals(type, checkType(value))) {
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.expr(i).getStart().getCharPositionInLine();
                    printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                    System.exit(1);
                }
            } else if (ctx.expr().get(i).functionInvocation() != null) {
                String val = ctx.expr().get(i).functionInvocation().NAME().getText();
                for (var function : functionDeque) {
                    if (function.containsKey(val)) {
                        FunctionInfo functionInfo = function.get(val);
                        if (!Objects.equals(functionInfo.returnType, type)) {
                            ParserRuleContext context =  findParent(ctx);
                            int errorIndex = ctx.expr(i).getStart().getCharPositionInLine();
                            printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                            System.exit(1);
                        }
                    }

                }
            } else if (ctx.expr().get(i).arithmeticOperation() != null || ctx.expr().get(i).conditionalOperation() != null || ctx.expr().get(i).singleValueOperation() != null) {
                if (Objects.equals("string", type)) {
                    int errorIndex = ctx.getStart().getCharPositionInLine();
                    printError(ctx, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                    System.exit(1);
                }
            }

            if (currentScope.containsKey(name)) {
                if (currentScope.containsKey(name)) {
                    if(currentScope.get(name).scopeLevel == functionDeque.size()){
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.NAME(i).getSymbol().getCharPositionInLine();
                        printError(context, "DuplicateError: Variable '" + name + "' has been declared", errorIndex);
                        System.exit(1);
                    }
                }
            }

            Variable variable = new Variable(type, value, functionDeque.size());
            currentScope.put(name, variable);
        }

        return null;
    }

    private String checkType (Object value) {
        if(value instanceof Integer){
            return "int";
        }else if(value instanceof Float){
            return "float";
        }else if(value instanceof Boolean){
            return "bool";
        }

        if(parseValue((String)value) instanceof Integer){
            return "int";
        }else if(parseValue((String)value) instanceof String){
            return "string";
        }else if(parseValue((String)value) instanceof Float){
            return "float";
        }else if(parseValue((String)value) instanceof Boolean){
            return "bool";
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
            if (currentScope.containsKey(name)) {
                if(currentScope.get(name).scopeLevel == functionDeque.size()){
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.NAME(i).getSymbol().getCharPositionInLine();
                    printError(context, "DuplicateError: Variable '" + name + "' has been declared", errorIndex);
                    System.exit(1);
                }
            }
            Variable variable = new Variable(type, null, functionDeque.size());
            currentScope.put(name, variable);
        }

        return null;
    }

    @Override
    public Void visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Object value = visit(ctx.expr());

//        if (value instanceof String) {
//            String strValue = (String) value;
//            if (isVariableName(strValue)) {
//                value = sourceVariable(strValue);
//            }
//        }

        Map<String, Variable> currentScope = scopeStack.peek();

        // if (currentScope.containsKey(name)) {
        //     int errorIndex = ctx.NAME(i).getSymbol().getCharPositionInLine();
        //     printError(ctx, "Duplicate Error: Variable '" + name + "' has been declared", errorIndex);
        //     System.exit(1);
        // }



        if (ctx.ASSIGN() != null) {
            if (currentScope.containsKey(name)) {

                if (ctx.expr().value() != null && ctx.expr().value().STRING() != null) {
                    if (!Objects.equals(currentScope.get(name).type, "string")) {
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.ASSIGN().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                        System.exit(1);
                    }
                } else if (ctx.expr().value() != null && ctx.expr().value().NAME() != null) {
                    Object var = ctx.expr().value().NAME().getText();

                    for (Map<String, Variable> scope : scopeStack) {
                        if (scope.containsKey(var)) {
                            Variable variable = scope.get(var);
                            if (variable.type.equals("string") && !Objects.equals(currentScope.get(name).type, "string")) {
                                int errorIndex = ctx.expr().getStart().getCharPositionInLine();
                                printError(ctx, "TypeError: Variable '" + name + "' can't be assigned type: string", errorIndex);
                                System.exit(1);
                            }
                        }
                    }
                } else if (ctx.expr().functionInvocation() != null) {
                    String val = ctx.expr().functionInvocation().NAME().getText();
                    for (var function : functionDeque) {
                        if (function.containsKey(val)) {
                            FunctionInfo functionInfo = function.get(val);
                            if (!Objects.equals(functionInfo.returnType, currentScope.get(name).type)) {
                                ParserRuleContext context =  findParent(ctx);
                                int errorIndex = ctx.getStart().getCharPositionInLine();
                                printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                                System.exit(1);
                            }
                        }

                    }
                } else if (ctx.expr().arithmeticOperation() != null || ctx.expr().conditionalOperation() != null || ctx.expr().singleValueOperation() != null) {
                    if (Objects.equals("string", currentScope.get(name).type)) {
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.getStart().getCharPositionInLine();
                        printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                        System.exit(1);
                    }
                } else if (!Objects.equals(currentScope.get(name).type, checkType(value))) {
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.ASSIGN().getSymbol().getCharPositionInLine();
                    printError(context, "TypeError: Variable '" + name + "' can't be assigned type: " + checkType(value), errorIndex);
                    System.exit(1);
                }
                Variable variable = currentScope.get(name);
                variable.setValue(value);
            } else {
                ParserRuleContext context =  findParent(ctx);
                int errorIndex = ctx.ASSIGN().getSymbol().getCharPositionInLine();
                printError(context, "NameError: Variable '" + name + "' has not been declared", errorIndex);
                System.exit(1);
            }
        }



        if (ctx.ASSIGNMENT() != null) {
            if(currentScope.get(name) == null || currentScope.get(name).value == null){
                int errorIndex = ctx.ASSIGNMENT().getSymbol().getCharPositionInLine();
                ParserRuleContext context =  findParent(ctx);
                printError(context, "NameError: Variable '" + name + "' might not have been initialized", errorIndex);
                System.exit(1);
            }
            Object baseVariable = sourceVariable(name);

            if (baseVariable instanceof String)
                baseVariable = parseValue((String) baseVariable);

            if (value instanceof String)
                value = parseValue((String) value);

            Variable variable = currentScope.get(name);

            int errorIndex = ctx.ASSIGNMENT().getSymbol().getCharPositionInLine();

            switch (ctx.ASSIGNMENT().getText()) {
                case "+=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable + (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable + (float) value);
                    } else {
                        ParserRuleContext context =  findParent(ctx);
                        printError(context, "TypeError: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.", errorIndex);
                        System.exit(1);
                    }
                    break;
                case "-=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable - (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable - (float) value);
                    } else {
                        ParserRuleContext context =  findParent(ctx);
                        printError(context, "TypeError: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.", errorIndex);
                        System.exit(1);
                    }
                    break;
                case "*=":
                    if (baseVariable instanceof Integer && value instanceof Integer) {
                        variable.setValue((int) baseVariable * (int) value);
                    } else if (baseVariable instanceof Float && value instanceof Float) {
                        variable.setValue((float) baseVariable * (float) value);
                    } else {
                        ParserRuleContext context =  findParent(ctx);
                        printError(context, "TypeError: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.", errorIndex);
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
                            ParserRuleContext context =  findParent(ctx);
                            printError(context, "TypeError: The types of " + baseVariable + " and " + value + " vary. Cannot perform the assignment.", errorIndex);
                            System.exit(1);
                        }
                    } catch (ArithmeticException e) {
                        ParserRuleContext context =  findParent(ctx);
                        printError(context, "ZeroDivisionError: Dividing by zero is not allowed.", errorIndex);
                        System.exit(1);
                    }
                    break;
            }
        }

        return null;
    }


    @Override
    public Object visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx) {
        if(ctx.expr() == null){
            System.out.println();
            return null;
        }
        Object value = visit(ctx.expr());

        Map<String, Variable> localVariables = currentScope();


        System.out.println(value);

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
        // if (result instanceof String) {
        //     String strResult = (String) result;
        //     if (isNumeric(strResult)) {
        //         result = parseValue(strResult); // Return the parsed numeric value
        //     } else {
        //         // Otherwise, treat it as a variable name
        //         result = sourceVariable(strResult);
        //     }
        // }

        if (ctx.term() != null) {
            Object nextFactorResult = visit(ctx.term());
            if (ctx.MUL() != null) {
                if(!Objects.equals(checkType(result), checkType(nextFactorResult))){
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.MUL().getSymbol().getCharPositionInLine();
                    printError(context, "TypeError: Operands are of different types: " + checkType(result) + ", " + checkType(nextFactorResult), errorIndex);
                    System.exit(1);
                }
                result = multiply(result, nextFactorResult);
            } else if (ctx.DIV() != null) {
                try{
                    if(!Objects.equals(checkType(result), checkType(nextFactorResult))){
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.DIV().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Operands are of different types: " + checkType(result) + ", " + checkType(nextFactorResult), errorIndex);
                        System.exit(1);
                    }
                    result = divide(result, nextFactorResult);
                }catch(Exception e){
                    ParserRuleContext context =  findParent(ctx);
                    int errorIndex = ctx.DIV().getSymbol().getCharPositionInLine();
                    printError(context, "ZeroDivisionError: Division by zero", errorIndex);
                    System.exit(1);
                }

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
        if (ctx.factor() != null){
            Object n = visit(ctx.factor());
            return "-" + n;
        }
        else if (ctx.value() != null) {
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
        try {
            if (a != null)
                a = convertToNumber(a);
            b = convertToNumber(b);
        } catch (NumberFormatException e) {
            System.err.println("Error: Operands are not valid numbers");
            System.exit(1);
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (int) a * (int) b;
        } else if (a instanceof Float || b instanceof Float) {
            return ((Number) a).floatValue() * ((Number) b).floatValue();
        } else {
            System.err.println("Error: Incorrect arguments for multiplication");
            return null;
        }
    }

    private Object divide(Object a, Object b) {
        try {
            if (a != null)
                a = convertToNumber(a);
            b = convertToNumber(b);
        } catch (NumberFormatException e) {
            System.err.println("Error: Operands are not valid numbers");
            System.exit(1);
        }
        // Perform division
        if (a instanceof Integer && b instanceof Integer) {
            if (((Integer) a).intValue() == 0) {
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
    public Object visitConditionalArithmeticOperation(SimpleScriptParser.ConditionalArithmeticOperationContext ctx) {
        Object right = visit(ctx.arithmeticOperation());
        Object left = null;
        String op = null;

        if (ctx.getChildCount() > 1) {
            op = ctx.getChild(1).getText();
            left = visit(ctx.conditionalArithmeticOperation());
        }

        // Convert right operand to a literal value if it's a variable
        // if (right instanceof String) {
        //     String rightVarName = (String) right;
        //     if (currentScope().containsKey(rightVarName)) {
        //         right = sourceVariable(rightVarName);
        //     } else {
        //         // If it's not a variable, treat it as a literal value
        //         try {
        //             right = parseValue(rightVarName);
        //         } catch (NumberFormatException e) {
        //             System.err.println("Error: Invalid value for right operand");
        //             System.exit(1);
        //         }
        //     }
        // }

        // // Convert left operand to a literal value if it's a variable
        // if (left instanceof String) {
        //     String leftVarName = (String) left;
        //     if (currentScope().containsKey(leftVarName)) {
        //         left = sourceVariable(leftVarName);
        //     } else {
        //         // If it's not a variable, treat it as a literal value
        //         try {
        //             left = parseValue(leftVarName);
        //         } catch (NumberFormatException e) {
        //             System.err.println("Error: Invalid value for left operand");
        //             System.exit(1);
        //         }
        //     }
        // }

        // Now, both left and right operands should be literal values
        // Perform type conversion if necessary
        try {
            if (left != null)
                left = convertToNumber(left);
            right = convertToNumber(right);
            if(left != null && right != null){
                if (!Objects.equals(checkType(left), checkType(right))) {
                    try{
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.CONDITION_OP().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Operands are of different types: " + checkType(left) + ", " + checkType(right), errorIndex);
                        System.exit(1);
                    }catch(Exception e){
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.CONDITION_OP().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Operands are of different types: " + checkType(left) + ", " + checkType(right), errorIndex);
                        System.exit(1); 
                    }
                    
                }
            }

        } catch (NumberFormatException e) {
            if(checkType(right) != "int" || checkType(right) != "float"){
                ParserRuleContext context =  findParent(ctx);
                int errorIndex = ctx.arithmeticOperation().getStart().getCharPositionInLine();
                printError(context, "TypeError: Operands are not valid numbers", errorIndex);
                System.exit(1);
            }
            if(ctx.CONDITION_OP() == null){
                ParserRuleContext context =  findParent(ctx);
                int errorIndex = ctx.arithmeticOperation().getStart().getCharPositionInLine();
                printError(context, "MissingOperatorError: Missing operator in logical operation", errorIndex);
                System.exit(1);
            }
            
            
        }

        if (op == null) {
            return right;
        }

        // Perform arithmetic operation
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

    @Override
    public Object visitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx) {
        Object right = visit(ctx.term());
        if(ctx.term().factor().value() != null && ctx.term().factor().value().STRING() != null){
            ParserRuleContext context =  findParent(ctx);
            int errorIndex = ctx.term().factor().value().STRING().getSymbol().getCharPositionInLine();
            printError(ctx.term(), "TypeError: String value detected in arithmetic operation: '" + right + "'", errorIndex);
            System.exit(1);
        }else if(ctx.term().factor().value() != null && ctx.term().factor().value().NAME() != null && Objects.equals(currentScope().get(ctx.term().factor().value().NAME().getText()).type, "string")){
            ParserRuleContext context =  findParent(ctx);
            int errorIndex = ctx.term().factor().value().NAME().getSymbol().getCharPositionInLine();
            printError(ctx.term(), "TypeError: String value detected in arithmetic operation: '" + right + "'", errorIndex);
            System.exit(1);
        }
        Object left = null;
        String op = null;

        if (ctx.getChildCount() > 1) {
            op = ctx.getChild(1).getText();
            left = visit(ctx.arithmeticOperation());
        }

        // Convert right operand to a literal value if it's a variable
        // if (right instanceof String) {
        //     String rightVarName = (String) right;
        //     if (currentScope().containsKey(rightVarName)) {
        //         right = sourceVariable(rightVarName);
        //     } else {
        //         // If it's not a variable, treat it as a literal value
        //         try {
        //             right = parseValue(rightVarName);
        //         } catch (NumberFormatException e) {
        //             System.err.println("Error: Invalid value for right operand");
        //             System.exit(1);
        //         }
        //     }
        // }

        // Convert left operand to a literal value if it's a variable
        // if (left instanceof String) {
        //     String leftVarName = (String) left;
        //     if (currentScope().containsKey(leftVarName)) {
        //         left = sourceVariable(leftVarName);
        //     } else {
        //         // If it's not a variable, treat it as a literal value
        //         try {
        //             left = parseValue(leftVarName);
        //         } catch (NumberFormatException e) {
        //             System.err.println("Error: Invalid value for left operand");
        //             System.exit(1);
        //         }
        //     }
        // }

        // Now, both left and right operands should be literal values
        // Perform type conversion if necessary
        try {
            if (left != null)
                left = convertToNumber(left);
            right = convertToNumber(right);
            if(left != null && right != null){
                if (!Objects.equals(checkType(left), checkType(right))) {
                    try{
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.CONCAT().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Operands are of different types: " + checkType(left) + ", " + checkType(right), errorIndex);
                        System.exit(1);
                    }catch(Exception e){
                        ParserRuleContext context =  findParent(ctx);
                        int errorIndex = ctx.SUB().getSymbol().getCharPositionInLine();
                        printError(context, "TypeError: Operands are of different types: " + checkType(left) + ", " + checkType(right), errorIndex);
                        System.exit(1); 
                    }
                    
                }
            }

        } catch (NumberFormatException e) {
            try{
                if((((Boolean) right).booleanValue() == true || ((Boolean) right).booleanValue() == false) && left == null){
                    return right;
                }
            }catch(Exception b){
                ParserRuleContext context =  findParent(ctx);
                int errorIndex = ctx.arithmeticOperation().getStart().getCharPositionInLine();
                printError(context, "TypeError: Operands are not valid numbers.", errorIndex);
                System.exit(1);
            }
            
            
        }

        if (op == null) {
            return right;
        }

        // Perform arithmetic operation
        switch (op) {
            case "+":
                var val = add(left, right);
                return val;
            case "-":
                return subtract(left, right);
            default:
                int errorIndex = ctx.arithmeticOperation().getStart().getCharPositionInLine();
                ParserRuleContext statementCtx = findParent(ctx);
                printError(statementCtx, "TypeError: Invalid operand", errorIndex);
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
            return ((Integer) left).intValue()+((Integer) right).intValue();
        } else if (left instanceof Float && right instanceof Float) {
            return ((Float) left).floatValue()+((Float) right).floatValue();
        } else {
            System.err.println("Error: Unsupported operand types for addition");
            System.exit(1);
            return null;
        }
    }

    // Helper method to perform subtraction
    private Object subtract(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return ((Integer) left).intValue()-((Integer) right).intValue();
        } else if (left instanceof Float && right instanceof Float) {
            return ((Float) left).floatValue()-((Float) right).floatValue();
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

        // if (ctx.getChildCount() > 1) {
        //     op = ctx.getChild(1).getText();
        //     left = visit(ctx.conditionalOperation());
        // }

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
                    int errorIndex = ctx.logicalTerm().getStart().getCharPositionInLine();
                    ParserRuleContext statementCtx = findParent(ctx);
                    printError(statementCtx, "TypeError: Invalid value for left operand", errorIndex);
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
                    int errorIndex = ctx.logicalTerm().getStart().getCharPositionInLine();
                    ParserRuleContext statementCtx = findParent(ctx);
                    printError(statementCtx, "TypeError: Invalid value for right operand", errorIndex);
                    System.exit(1);
                }
            }
        }

        if (op == null) {
            return right;
        }

        // Perform comparison based on the operator

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

            boolean boolResult = false;
            boolean nextBoolResult = false;

            try {
                boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
            } catch (ClassCastException e) {
                int errorIndex = ctx.logicalFactor().getStart().getCharPositionInLine();
//                ParserRuleContext statementCtx = findParent(ctx);
                printError(ctx.logicalFactor(), "Error: Invalid boolean value", errorIndex);
                System.exit(1);
            }

            try {
                nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;

            } catch (ClassCastException e) {
                int errorIndex = ctx.logicalTerm().getStart().getCharPositionInLine();
//                ParserRuleContext statementCtx = findParent(ctx);
                printError(ctx.logicalFactor(), "Error: Invalid boolean value", errorIndex);
                System.exit(1);
            }

            return boolResult || nextBoolResult;
        }

        return result;
    }

    @Override
    public Object visitLogicalFactor(SimpleScriptParser.LogicalFactorContext ctx) {
        Object result = visit(ctx.logicalPrimary());

        // Check if the result is a variable name
        // if (result instanceof String) {
        //     String varName = (String) result;
        //     if (currentScope().containsKey(varName)) {
        //         result = sourceVariable(varName);
        //     } else {
        //         // If it's not a variable, treat it as a literal value
        //         return result;
        //     }
        // }

        if (ctx.AND() != null && ctx.logicalFactor() != null) {
            Object nextFactorResult = visit(ctx.logicalFactor());

            boolean boolResult = false;
            boolean nextBoolResult = false;

            try {
                 boolResult = result instanceof String ? (boolean) parseValue((String) result) : (boolean) result;
            } catch (ClassCastException e) {
                int errorIndex = ctx.logicalPrimary().getStart().getCharPositionInLine();
//                ParserRuleContext statementCtx = findParent(ctx);
                printError(ctx.logicalPrimary(), "Error: Invalid boolean value", errorIndex);
                System.exit(1);
            }

            try {
                 nextBoolResult = nextFactorResult instanceof String ? (boolean) parseValue((String) nextFactorResult) : (boolean) nextFactorResult;
            } catch (ClassCastException e) {
                int errorIndex = ctx.logicalFactor().getStart().getCharPositionInLine();
//                ParserRuleContext statementCtx = findParent(ctx);
                printError(ctx.logicalPrimary(), "Error: Invalid boolean value", errorIndex);
                System.exit(1);
            }

            return boolResult && nextBoolResult;
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
            } catch (ClassCastException e) {
                int errorIndex = ctx.logicalPrimary().getStart().getCharPositionInLine();
                ParserRuleContext statementCtx = findParent(ctx);
                printError(statementCtx, "Error: Invalid boolean value", errorIndex);
                System.exit(1);
            }
        } else if (ctx.conditionalOperation() != null) {
            return visit(ctx.conditionalOperation());
        } else if (ctx.functionInvocation() != null) {
            return visit(ctx.functionInvocation());
        } else if (ctx.conditionalArithmeticOperation() != null) {
            return visit(ctx.conditionalArithmeticOperation());
        }

        return null;
    }

    private ParserRuleContext findParent(ParserRuleContext ctx){
        ParserRuleContext statementCtx = ctx;
        while(!(statementCtx instanceof SimpleScriptParser.StatementContext)){
            statementCtx = statementCtx.getParent();
        }
        return statementCtx;
    }

    @Override
    public Object visitValue(SimpleScriptParser.ValueContext ctx) {
        if (ctx.NAME() != null) {
            String variableName = ctx.NAME().getText();
            // Check if the variable exists in the current scope
            if (currentScope() != null && !currentScope().containsKey(variableName)) {
                int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
                ParserRuleContext statementCtx = findParent(ctx);
                printError(statementCtx, "NameError: Variable '" + variableName + "' is not defined.", errorIndex);
                System.exit(1);
            }
            Object value = sourceVariable(variableName);
            if(value == null){
                int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
                ParserRuleContext statementCtx = findParent(ctx);
                printError(statementCtx, "NameError: Variable '" + ctx.NAME() + "' might not have been initialized", errorIndex);
                System.exit(1);
            }
            
            return value; // Return variable name
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

        Map<String, Variable> localVariables = currentScope();

        if(!localVariables.containsKey(variableName)){
            ParserRuleContext context =  findParent(ctx);
            int errorIndex = ctx.SINGLE_VAL_OP().getSymbol().getCharPositionInLine();
            printError(context, "NameError: Variable '" + variableName + "' has not been declared", errorIndex);
            System.exit(1);
        }

        // Get the current value of the variable
        Object value = sourceVariable(variableName);

        if(value == null){
            int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
            printError(ctx, "Error: Variable '" + variableName + "' might not have been initialized", errorIndex);
            System.exit(1);
        }

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

        Map<String, Variable> currentScope = currentScope();
        Variable variable = currentScope.get(variableName);
        variable.setValue(value);
    
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

        // if (ctx.returnStatement() != null) {

        //     return visit(ctx.returnStatement());
        // }

        // Pop the block scope from the stack after visiting all statements
        scopeStack.pop();

        return null;
    }

    @Override
    public Object visitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx) {
        FunctionInfo functionInfo = functionStack.peek();
        Object returnValue = new Object();

        try {
            if(ctx.expr() == null && Objects.equals(functionInfo.returnType, "void")){
                return new Exception();
            }

            if(functionStack.size() < 2){
                int errorIndex = ctx.RETURN().getSymbol().getCharPositionInLine();
                printError(ctx, ": Return statement not inside a function", errorIndex);
                System.exit(1);
            }

            returnValue = visit(ctx.expr());

            if (ctx.expr().value() != null && ctx.expr().value().STRING() != null) {
                if (!Objects.equals(functionInfo.returnType, "string")) {
                    int errorIndex = ctx.expr().getStart().getCharPositionInLine();
                    printError(ctx, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: \"" + returnValue + "\"", errorIndex);
                    System.exit(1);
                }
            } else if (ctx.expr().value() != null && ctx.expr().value().NAME() != null) {
                Object name = ctx.expr().value().NAME().getText();

                for (Map<String, Variable> scope : scopeStack) {
                    if (scope.containsKey(name)) {
                        Variable variable = scope.get(name);
                        if (variable.type.equals("string") && !Objects.equals(functionInfo.returnType, "string")) {
                            int errorIndex = ctx.expr().getStart().getCharPositionInLine();
                            printError(ctx, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: \"" + returnValue + "\"", errorIndex);
                            System.exit(1);
                        }
                    }
                }
            } else if (ctx.expr().functionInvocation() != null) {
                String val = ctx.expr().functionInvocation().NAME().getText();
                for (var function : functionDeque) {
                    if (function.containsKey(val)) {
                        if (!Objects.equals(functionInfo.returnType, "string")) {
                            ParserRuleContext context = findParent(ctx);
                            int errorIndex = ctx.getStart().getCharPositionInLine();
                            printError(context, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: " + returnValue, errorIndex);
                            System.exit(1);
                        }
                    }
                }
            } else if (ctx.expr().arithmeticOperation() != null || ctx.expr().conditionalOperation() != null || ctx.expr().singleValueOperation() != null) {
                if (Objects.equals(functionInfo.returnType, "string")) {
                    ParserRuleContext context = findParent(ctx);
                    int errorIndex = ctx.getStart().getCharPositionInLine();
                    printError(context, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: " + returnValue, errorIndex);
                    System.exit(1);
                }
            } else if (!Objects.equals(functionInfo.returnType, checkType(returnValue))) {
                int errorIndex = ctx.expr().getStart().getCharPositionInLine();
                printError(ctx, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: " + returnValue, errorIndex);
                System.exit(1);
            }

            return switch (functionInfo.returnType) {
                        case "int" -> Integer.valueOf((String) returnValue);
                        case "float" -> Float.valueOf((String) returnValue);
                        case "bool" -> Boolean.valueOf((String) returnValue);
                        case "string" -> returnValue;
                        default -> throw new RuntimeException();
                    };

        } catch (Exception e1) {

            if (returnValue instanceof String) {
                returnValue = sourceVariable((String) returnValue);
            }

            try {
                return switch (functionInfo.returnType) {
                    case "int" -> returnValue;
                    case "float" -> returnValue;
                    case "bool" ->  returnValue;
                    default -> throw new RuntimeException();
                };
            } catch (Exception e2) {
                int errorIndex = ctx.expr().getStart().getCharPositionInLine();
                printError(ctx, "TypeError: Function of return type '" + functionInfo.returnType + "' can't return: " + returnValue, errorIndex);
                System.exit(1);
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

        if (ctx.block() == null) {
            exitProgram("Error: Incomplete function definition.");
        }

        // if (ctx.block().returnStatement() != null && returnType.equals("void")) {
        //     int errorIndex = ctx.block().getStart().getCharPositionInLine();
        //     printError(ctx, "Error: Void functions cannot contain a return statement.", errorIndex);
        //     System.exit(1);
        // }

        Map<String, Variable> parameters = new LinkedHashMap<>();
        for (int i = 1; i < ctx.NAME().size(); i++) {
            String type = ctx.TYPE(i).getText();
            String name = ctx.NAME(i).getText();
            parameters.put(name, new Variable(type, null, scopeStack.size()));
        }

        SimpleScriptParser.BlockContext block = ctx.block();

//        if (block.returnStatement() == null && !returnType.equals("void")) {
//            System.err.println("Error: Non-void function should return a value.");
//            System.exit(1);
//        }

        var currentFunction = functionStack.peek();
        
        if(currentFunction == null){
            FunctionInfo functionInfo = new FunctionInfo(returnType, block, parameters.size(), id, -1, null);
            id+=1;
            functionInfo.parameters = parameters;

            var currentFunctionStack = functionDeque.peek();
            currentFunctionStack.put(functionName, functionInfo);

            return null;
        }else{
            FunctionInfo functionInfo = new FunctionInfo(returnType, block, parameters.size(), id, currentFunction.parentId, currentFunction);
            id+=1;
            functionInfo.parameters = parameters;

            var currentFunctionStack = functionDeque.peek();
            currentFunctionStack.put(functionName, functionInfo);

            return null;
        }
    }


    public Variable resolveVariable(String name) {
        // Check the current local scope (top of the stack)
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            Map<String, Variable> currentScope = currentScope();
            if (currentScope.containsKey(name)) {
                return currentScope.get(name);
            }
        }
        // Check the global scope
        if (globalScope.containsKey(name)) {
            return globalScope.get(name);
        }
        return null; // Variable not found
    }


    public Object visitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx) {
        String functionName = ctx.NAME().getText();
        try {
            if (!functionDeque.peek().containsKey(functionName)) {
                ParserRuleContext context = findParent(ctx);
                int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
                printError(context, "NameError: Function '" + functionName + "' is not defined.", errorIndex);
                System.exit(1);
            }
        } catch(Exception e){
            ParserRuleContext context = findParent(ctx);
            int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
            printError(context, "NameError: Function '" + functionName + "' is not defined.", errorIndex);
            System.exit(1);
        }

        FunctionInfo functionInfo = functionDeque.peek().get(functionName);
        FunctionInfo parentFunction = functionInfo.parentFunction;
        Map<String, Variable> parentVariables = new HashMap<>();
        
        if(parentFunction != null){
            parentVariables = parentFunction.lexicalEnvironment;
        }else{
            parentVariables = scopeStack.getLast();
        }



        int originalRecursionDepth = currentRecursionDepth;
        currentRecursionDepth++;

        if (currentRecursionDepth > MAX_RECURSION_DEPTH) {
            exitProgram("StackOverflowError: Stack overflow detected in function '" + functionName + "'. Recursion depth limit exceeded.");
        }

        
        if (Objects.equals(functionInfo.returnType, "void") && !(ctx.getParent() instanceof SimpleScriptParser.StatementContext)) {
            ParserRuleContext context = findParent(ctx);
            int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
            printError(context, "TypeError: 'void' type not expected here", errorIndex);
            System.exit(1);
        }
        List<SimpleScriptParser.ExprContext> arguments = ctx.expr();

        if (arguments.size() != functionInfo.parametersCount) {
            int errorIndex = ctx.LPAREN().getSymbol().getCharPositionInLine();
            printError(ctx, "ArgumentsCountError: Function '" + functionName + "' expects " + functionInfo.parametersCount + " arguments, but got " + arguments.size(), errorIndex);
            System.exit(1);
        }

        // Create a key for memoization based on the function name and arguments
        List<Object> argumentValues = arguments.stream().map(this::visit).collect(Collectors.toList());
        // if (memoizedResults.containsKey(functionName) && memoizedResults.get(functionName).containsKey(argumentValues)) {
        //     currentRecursionDepth--;
        //     return memoizedResults.get(functionName).get(argumentValues);
        // }

        // Create a new scope for the function call
        int originalScopeSize = scopeStack.size();
        int originalFunScopeSize = functionDeque.size();
        Map<String, Variable> localVariables = new HashMap<>();
        functionDeque.peek().get(functionName).lexicalEnvironment = localVariables;
        localVariables.putAll(parentVariables);

        // Assign the arguments to the parameters
        List<String> parameterNames = new ArrayList<>(functionInfo.parameters.keySet());
        for (int i = 0; i < arguments.size(); i++) {
            String parameterName = parameterNames.get(i);
            if (arguments.get(i).value() != null && arguments.get(i).value().STRING() != null) {
                if (!Objects.equals(functionInfo.parameters.get(parameterName).getType(), "string")){
                    int errorIndex = ctx.LPAREN().getSymbol().getCharPositionInLine();
                    printError(ctx, "Error: Type mismatch in argument: " + parameterName, errorIndex);
                    System.exit(1);
                }
            } else if (!Objects.equals(functionInfo.parameters.get(parameterName).getType(), checkType(argumentValues.get(i)))){
                int errorIndex = ctx.LPAREN().getSymbol().getCharPositionInLine();
                printError(ctx, "Error: Type mismatch in argument: " + parameterName, errorIndex);
                System.exit(1);
            }

            Variable parameter = functionInfo.parameters.get(parameterName);
            localVariables.put(parameterName, new Variable(parameter.getType(), argumentValues.get(i), scopeStack.size()+1));
        }

        scopeStack.push(localVariables);
        functionStack.push(functionInfo);
        functionDeque.push(new HashMap<>(functionDeque.peek()));

        SimpleScriptParser.BlockContext ctx_f = functionInfo.getBlock();
        Object result = null;

        for (SimpleScriptParser.StatementContext statementContext : ctx_f.statement()) {
            var value = visit(statementContext);
            if (value != null){
                result = value;
                break;
            }
            if(value instanceof Exception){
                while (scopeStack.size() > originalScopeSize) {
                    scopeStack.pop();
                }
                while(functionDeque.size() > originalFunScopeSize){
                    functionDeque.pop();
                }
                functionStack.pop();
                // functionDeque.pop();
        
                currentRecursionDepth--;
        
                // Store the result in the memoization cache
                memoizedResults.computeIfAbsent(functionName, k -> new HashMap<>()).put(argumentValues, result);
                return null;
            }
            // homeScope = scopeStack.peek();
        }

        if(result == null && Objects.equals(functionInfo.returnType, "void")){
            while (scopeStack.size() > originalScopeSize) {
                scopeStack.pop();
            }
            while(functionDeque.size() > originalFunScopeSize){
                functionDeque.pop();
            }
            functionStack.pop();
            // functionDeque.pop();
    
            currentRecursionDepth--;
    
            // Store the result in the memoization cache
            memoizedResults.computeIfAbsent(functionName, k -> new HashMap<>()).put(argumentValues, result);
            return null;
        }
        // else if (result == null && ctx_f.returnStatement() != null) {
        //     result = visit(ctx_f.returnStatement());
        // }
        else if (result == null && !Objects.equals(functionInfo.returnType, "void")) {
            int errorIndex = ctx.NAME().getSymbol().getCharPositionInLine();
            printError(ctx, "Error: function: '" + functionName + "' should return a value", errorIndex);
            System.exit(1);
        }

        // Reset the scope stack to its original size efficiently
        while (scopeStack.size() > originalScopeSize) {
            scopeStack.pop();
            // functionDeque.pop();
        }
        while(functionDeque.size() > originalFunScopeSize){
            functionDeque.pop();
        }
        functionStack.pop();
        // functionDeque.pop();

        currentRecursionDepth--;

        // Store the result in the memoization cache
        // memoizedResults.computeIfAbsent(functionName, k -> new HashMap<>()).put(argumentValues, result);

        return result;
    }


    @Override
    public Object visitIfCondition(SimpleScriptParser.IfConditionContext ctx) {
        boolean result;
        try{
            if(!(visit(ctx.conditionalOperation(0)) instanceof  Boolean)) {
                result = (boolean) visit(ctx.conditionalOperation(0));
            }
            if(ctx.conditionalOperation(0).logicalTerm() != null && ctx.conditionalOperation(0).logicalTerm().logicalFactor() != null && ctx.conditionalOperation(0).logicalTerm().logicalFactor().logicalPrimary() != null && ctx.conditionalOperation(0).logicalTerm().logicalFactor().logicalPrimary().value() != null && ctx.conditionalOperation(0).logicalTerm().logicalFactor().logicalPrimary().value().STRING() != null){
                throw new RuntimeException("Variab is not defined.");
            }
        }catch(Exception e){
            int errorIndex = ctx.getStart().getCharPositionInLine();
            printError(ctx, "IfConditionError: Invalid if condition", errorIndex);
            System.exit(1);
        }
        if(!(visit(ctx.conditionalOperation(0)) instanceof  Boolean)) {
            result = (boolean) visit(ctx.conditionalOperation(0));
        }else{
            result = ((Boolean) visit(ctx.conditionalOperation(0))).booleanValue();
        }
       if (result) {
           return visit(ctx.block(0));
       } else if (!ctx.ELIF().isEmpty()){
           for (int i = 1; i <= ctx.ELIF().size(); i++) {
               try{
                   if(!(visit(ctx.conditionalOperation(i)) instanceof  Boolean)) {
                       result = (boolean) visit(ctx.conditionalOperation(i));
                   }
                   if(ctx.conditionalOperation(i).logicalTerm() != null && ctx.conditionalOperation(i).logicalTerm().logicalFactor() != null && ctx.conditionalOperation(i).logicalTerm().logicalFactor().logicalPrimary() != null && ctx.conditionalOperation(i).logicalTerm().logicalFactor().logicalPrimary().value() != null && ctx.conditionalOperation(i).logicalTerm().logicalFactor().logicalPrimary().value().STRING() != null){
                       throw new RuntimeException("Variab is not defined.");
                   }
               }catch(Exception e){
                   int errorIndex = ctx.conditionalOperation(i).getStart().getCharPositionInLine();
                   printError(ctx.conditionalOperation(i), "IfConditionError: Invalid if condition", errorIndex);
                   System.exit(1);
               }
               if(!(visit(ctx.conditionalOperation(i)) instanceof  Boolean)) {
                   result = (boolean) visit(ctx.conditionalOperation(i));
               }else{
                   result = ((Boolean) visit(ctx.conditionalOperation(i))).booleanValue();
               }

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
            var value = visit(ctx.block());

            if (value != null) {
                scopeStack.pop();
                return value;
            }

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
            currentScope().put(paramName, new Variable("var", element, scopeStack.size()));

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
        String type = ctx.arrayType().TYPE().getText();
        int dimensions = ctx.arrayType().LBRACK().size();
        String name = ctx.NAME().getText();
        Object array = visit(ctx.nestedArray());

        if (!validateArrayDimensions(array, dimensions)) {
            System.err.println("Error: Array '" + name + "' dimensions do not match the declared type");
            System.exit(1);
        }

        Variable variable = new Variable(type + "[]".repeat(dimensions), array, scopeStack.size());
        Map<String, Variable> localVariables = currentScope();
        localVariables.put(name, variable);

        return null;
    }

    private boolean validateArrayDimensions(Object array, int expectedDimensions) {
        if (expectedDimensions == 0) {
            return !(array instanceof List);
        }

        if (!(array instanceof List)) {
            return false;
        }

        List<?> list = (List<?>) array;
        for (Object element : list) {
            if (!validateArrayDimensions(element, expectedDimensions - 1)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object visitNestedArray(SimpleScriptParser.NestedArrayContext ctx) {
        List<Object> array = new ArrayList<>();

        for (ParseTree child : ctx.children) {
            if (child instanceof SimpleScriptParser.NestedArrayContext) {
                array.add(visit(child));
            } else if (child instanceof SimpleScriptParser.ExprContext) {
                array.add(visit(child));
            }
        }

        return array;
    }

    @Override
    public Object visitArrayAccess(SimpleScriptParser.ArrayAccessContext ctx) {
        String arrayName = ctx.NAME().getText();
        List<Object> indices = new ArrayList<>();

        for (SimpleScriptParser.ExprContext exprCtx : ctx.expr()) {
            Object index = visit(exprCtx);
            if (index instanceof String) {
                index = parseValue((String) index);
            }
            indices.add(index);
        }

        if (indices.stream().anyMatch(index -> !(index instanceof Integer))) {
            System.err.println("Error: Array indices must be integers");
            System.exit(1);
        }

        Map<String, Variable> localVariables = currentScope();
        if (!localVariables.containsKey(arrayName)) {
            System.err.println("Error: Array '" + arrayName + "' has not been declared");
            System.exit(1);
        }

        Variable arrayVariable = localVariables.get(arrayName);
        Object value = arrayVariable.getValue();

        for (Object index : indices) {
            int intIndex = (int) index;
            if (!(value instanceof List)) {
                System.err.println("Error: Variable '" + arrayName + "' is not an array");
                System.exit(1);
            }

            List<?> array = (List<?>) value;
            if (intIndex < 0 || intIndex >= array.size()) {
                System.err.println("Error: Array index out of bounds");
                System.exit(1);
            }

            value = array.get(intIndex);
        }

        return value;
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
        if(ctx.expr() == null){
            ParserRuleContext context = findParent(ctx);
            int errorIndex = ctx.getStart().getCharPositionInLine();
            printError(context, "TypeError: Switch expects an expression", errorIndex);
            System.exit(1);
        }
        Object value = visit(ctx.expr());

//        Variable switchVariable = currentScope().get(switchVariableName);

//        if (switchVariable == null) {
//            throw new RuntimeException("Variable " + switchVariableName + " is not defined.");
//        }

//        Object switchValue = switchVariable.getValue();
        boolean caseMatched = false;

        // Iterate through all case clauses
        for (SimpleScriptParser.CaseClauseContext caseCtx : ctx.caseClause()) {
            if(caseCtx.value() != null && caseCtx.value().NAME() != null){
//                ParserRuleContext context = findParent(ctx);
                int errorIndex = caseCtx.value().getStart().getCharPositionInLine();
                printError(caseCtx, "TypeError: Constant value expected", errorIndex);
                System.exit(1);
            }
            Object caseValue = visit(caseCtx.value());

            if (caseMatched || value.equals(caseValue)) {
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
        return value;
    }
}
