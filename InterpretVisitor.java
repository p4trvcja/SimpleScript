public class InterpretVisitor extends SimpleScriptBaseVisitor<Object> {
    // Override visit methods here to interpret SimpleScript code
    @Override
    public Object visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx) {
        Object value = visit(ctx.expr()); // Visit the expression inside the print statement
        System.out.println(value); // Print the value
        return null; // Return null since print statement doesn't return a value
    }

    @Override
    public Object visitExpr(SimpleScriptParser.ExprContext ctx) {
        // Since expr can be a value, visit the value context if present
        if (ctx.value() != null) {
            return visitValue(ctx.value());
        }
        // Otherwise, handle other cases based on your grammar rules
        // For now, let's just return null
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