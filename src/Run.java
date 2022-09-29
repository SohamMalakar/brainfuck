import java.util.ArrayList;

public class Run
{
    static void run(String text, int memorySize) throws Exception
    {
        Lexer lexer = new Lexer(text);
        ArrayList<Token> tokens = lexer.tokenize();

        Parser parser = new Parser(tokens);
        ArrayList<Node> parseTree = parser.parse();

        Interpreter interpreter = new Interpreter(memorySize);
        interpreter.visit(parseTree);
    }
}
