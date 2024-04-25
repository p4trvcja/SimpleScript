package visitor;
import java.util.*;
import visitor.InterpretVisitor.Variable;

// import org.antlr.v4.runtime.tree.ParseTree;

public class InterpretListener extends SimpleScriptBaseListener{
    private int currentInstruction = 0;
    private final Map<Integer, Map<String, Variable>> variables = new HashMap<>();

    @Override
    public void enterScript(SimpleScriptParser.ScriptContext ctx) {
        variables.put(currentInstruction, new HashMap<>());
    }

    @Override
    public void enterVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        for (int i = 0; i < ctx.NAME().size(); i++) {
            String name = ctx.NAME(i).getText();
            Variable variable = new Variable(type, null); // Initialize with null value
            variables.get(currentInstruction).put(name, variable);
            System.out.println("Variable '" + name + "' of type '" + type + "' declared");
        }
    }

    public Map<Integer, Map<String, Variable>>  getVariables() {
        return variables;
    }
}