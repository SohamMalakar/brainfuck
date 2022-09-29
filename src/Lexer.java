import java.util.ArrayList;

public class Lexer
{
    String text;
    int position;
    Character currentChar;

    Lexer(String text)
    {
        this.text = text;
        position = -1;
        currentChar = null;
        advance();
    }

    private void advance()
    {
        position++;
        currentChar = position < text.length() ? text.charAt(position) : null;
    }

    ArrayList<Token> tokenize()
    {
        ArrayList<Token> tokens = new ArrayList<>();

        while (currentChar != null)
        {
            if (currentChar == '+')
            {
                advance();
                tokens.add(new Token(TokenType.PLUS));
            }
            else if (currentChar == '-')
            {
                advance();
                tokens.add(new Token(TokenType.MINUS));
            }
            else if (currentChar == '<')
            {
                advance();
                tokens.add(new Token(TokenType.LT));
            }
            else if (currentChar == '>')
            {
                advance();
                tokens.add(new Token(TokenType.GT));
            }
            else if (currentChar == '.')
            {
                advance();
                tokens.add(new Token(TokenType.DOT));
            }
            else if (currentChar == ',')
            {
                advance();
                tokens.add(new Token(TokenType.COMMA));
            }
            else if (currentChar == '[')
            {
                advance();
                tokens.add(new Token(TokenType.LBRAC));
            }
            else if (currentChar == ']')
            {
                advance();
                tokens.add(new Token(TokenType.RBRAC));
            }
            else
            {
                advance();
            }
        }

        return tokens;
    }
}
