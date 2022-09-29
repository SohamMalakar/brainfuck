import java.util.ArrayList;

public class Parser
{
    ArrayList<Token> tokens;
    int position;
    Token currentToken;

    Parser(ArrayList<Token> tokens)
    {
        this.tokens = tokens;
        position = -1;
        currentToken = null;
        advance();
    }

    private void advance()
    {
        position++;
        currentToken = position < tokens.size() ? tokens.get(position) : null;
    }

    ArrayList<Node> parse() throws Exception
    {
        return expr(false);
    }

    ArrayList<Node> expr(boolean parent) throws Exception
    {
        ArrayList<Node> nodes = new ArrayList<>();

        while (currentToken != null)
        {
            if (currentToken.type == TokenType.PLUS || currentToken.type == TokenType.MINUS ||
                currentToken.type == TokenType.LT || currentToken.type == TokenType.GT ||
                currentToken.type == TokenType.DOT || currentToken.type == TokenType.COMMA)
            {
                nodes.add(new Node(currentToken));
                advance();
            }
            else if (currentToken.type == TokenType.LBRAC)
            {
                advance();
                nodes.add(new Node(new Token(TokenType.LBRAC), expr(true)));
            }
            else
            {
                if (!parent)
                    throw new Exception("SyntaxError: unmatched ']'");

                nodes.add(new Node(currentToken));
                advance();
                return nodes;
            }
        }

        if (parent)
            throw new Exception("SyntaxError: unmatched '['");

        return nodes;
    }
}
