package visitor;

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {

        // Retrieve the CharStream from the recognizer's token source
        CharStream charStream = ((TokenStream) recognizer.getInputStream()).getTokenSource().getInputStream();

        // Extract the specific line of the source code where the error occurred
        String errorLine = getErrorLine(charStream, line);

        // Adjust the position and line if it's a common missing semicolon error
        if (msg.contains("missing ';'")) {
            if (charPositionInLine == 0) {
                // Move the error indication to the end of the previous line
                line--;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
        }
        if(charPositionInLine-1<0){
            line -= 1;
            errorLine = getErrorLine(charStream, line);
            charPositionInLine = errorLine.length();
        }

        // Construct the customized error message
        String customizedMsg = "error: line " + line + ":" + (charPositionInLine - 1) + " " + msg + "\n";
        customizedMsg += errorLine + "\n";
        customizedMsg += " ".repeat(charPositionInLine - 1) + "^";
        // Print the customized error message
        System.err.println(customizedMsg);
        System.exit(1);
    }

    // Helper method to extract the specific line of the source code
    private String getErrorLine(CharStream charStream, int line) {
        String text = charStream.toString();
        String[] lines = text.split("\n");
        return lines[line - 1]; // line is 1-based, array index is 0-based
    }
}