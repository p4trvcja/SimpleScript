import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import visitor.InterpretVisitor;
import visitor.SimpleScriptLexer;
import visitor.SimpleScriptParser;
import visitor.InterpretListener;

public class Main{
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java SimpleScriptInterpreter <input_file>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String code = readFile(inputFilePath);

        CodePointCharStream input = CharStreams.fromString(code);
        SimpleScriptLexer lexer = new SimpleScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleScriptParser parser = new SimpleScriptParser(tokens);
        ParseTree tree = parser.script();

        InterpretListener listener = new InterpretListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);

        InterpretVisitor interpreter = new InterpretVisitor();
        interpreter.setVariables(listener.getVariables());
        interpreter.visit(tree);
    }

    private static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}