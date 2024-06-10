package visitor;

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {

    private final String filePath;

    public CustomErrorListener(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {

        // Retrieve the CharStream from the recognizer's token source
        CharStream charStream = ((TokenStream) recognizer.getInputStream()).getTokenSource().getInputStream();

        // Extract the specific line of the source code where the error occurred
        String errorLine = getErrorLine(charStream, line);

        // Adjust the position and line if it's a common missing semicolon error
        if (msg.contains("missing \';\'")) {
            if (charPositionInLine == 0) {
                // Move the error indication to the end of the previous line
                line--;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: " + "missing " + msg.split(" ")[1];
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine - 1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input") && msg.contains("expecting") && charPositionInLine == 0 && msg.contains("\')\'")){
            errorLine = getErrorLine(charStream, line-1);
            while(!errorLine.contains("(")){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
            }
            charPositionInLine = errorLine.length()-1;
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: missing \')\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input \'=\' expecting {\'and\', \'or\', \')\'}")){
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: missing \'=\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input") && msg.contains("expecting") && msg.contains("\')\'")){
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: missing \')\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("no viable alternative at input") && msg.endsWith("}\'") && msg.matches(".*\\(.*")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: Missing \')\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("no viable alternative at input") && msg.endsWith("}\'")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine-1);
            String middle = "SyntaxError: Missing \';\' before \'}\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine-1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("no viable alternative at input")){
            if(errorLine.length()-charPositionInLine == errorLine.strip().length()){
                errorLine = getErrorLine(charStream, line-1);
                charPositionInLine = errorLine.length();
                String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
                String middle = "SyntaxError: Missing ';'";
                String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
                customizedMsg += "\t" + errorLine + "\n";
                customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
                // Print the customized error message
                System.err.println(customizedMsg);
                System.exit(1);
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: Invalid syntax";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input") && msg.contains("expecting") && msg.split("\\{")[1].contains("\';\'")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine-1);
            String middle = "SyntaxError: missing \';\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine-1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input") && msg.contains("expecting") && msg.split("\\{")[1].contains("\';\'")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine-1);
            String middle = "SyntaxError: missing \';\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine-1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("mismatched input") && msg.contains("expecting") && msg.split("\\{")[1].contains("\'=\'")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine-1);
            String middle = "SyntaxError: Expecting variable assignment";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine-1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("extraneous input \';\'") && msg.contains("expecting") && msg.contains("<EOF>")){
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: expecting statement or end of file, got \';\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("extraneous input") && msg.contains("expecting") && msg.contains("\'}\'")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine-1);
            String middle = "SyntaxError: missing \'}\'";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine-1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
        }else if(msg.contains("extraneous input") && msg.contains("expecting")){
            if(charPositionInLine-1<0){
                line -= 1;
                errorLine = getErrorLine(charStream, line);
                charPositionInLine = errorLine.length();
            }
            String beginning = "File '" + filePath + "', line "+ line + ":" + (charPositionInLine);
            String middle = "SyntaxError: " + msg.split(" ")[4] + " expected";
            String customizedMsg =  "\n"+ beginning + "\n" + middle + "\n\n";
            customizedMsg += "\t" + errorLine + "\n";
            customizedMsg += "\t" + " ".repeat(charPositionInLine - 1) + "^";
            // Print the customized error message
            System.err.println(customizedMsg);
            System.exit(1);
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
        if(line > lines.length) return "";
        return lines[line - 1]; // line is 1-based, array index is 0-based
    }
}