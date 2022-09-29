import java.util.ArrayList;

public class Node
{
    Token token;
    ArrayList<Node> children;

    Node(Token token)
    {
        this(token, null);
    }

    Node(Token token, ArrayList<Node> children)
    {
        this.token = token;
        this.children = children;
    }

    String getStr()
    {
        StringBuilder str = new StringBuilder(token.getStr());

        if (children == null)
            return String.valueOf(str);

        for (Node child : children)
        {
            str.append(", ").append(child.getStr());
        }

        return "(" + str + ")";
    }
}
