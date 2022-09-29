public class Token
{
    TokenType type;
    String value;

    Token(TokenType type)
    {
        this(type, null);
    }

    Token(TokenType type, String value)
    {
        this.type = type;
        this.value = value;
    }

    String getStr()
    {
        return type + (value != null ? value : "");
    }
}
