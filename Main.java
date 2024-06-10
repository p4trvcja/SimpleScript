import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import visitor.CustomErrorListener;
import visitor.InterpretVisitor;
import visitor.SimpleScriptLexer;
import visitor.SimpleScriptParser;

public class Main{
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java SimpleScriptInterpreter <input_file>");
            System.exit(1);
        }

        String inputFilePath = args[0];
//        String inputFilePath = "script_if_else.ss";
        String code = readFile(inputFilePath);

        CodePointCharStream input = CharStreams.fromString(code);
        SimpleScriptLexer lexer = new SimpleScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleScriptParser parser = new SimpleScriptParser(tokens);

        lexer.removeErrorListeners();
        parser.removeErrorListeners();

        CustomErrorListener errorListener = new CustomErrorListener(inputFilePath);
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);


        ParseTree tree = parser.script();

        InterpretVisitor interpreter = new InterpretVisitor();
        interpreter.visit(tree);
    }

    private static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}