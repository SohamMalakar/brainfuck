import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter
{
    int[] tape;
    int pos;
    int memorySize;

    Interpreter(int memorySize)
    {
        this.memorySize = memorySize;
        tape = new int[memorySize];
        Arrays.fill(tape, 0);
        pos = 0;
    }

    void visit(ArrayList<Node> nodes) throws IOException
    {
        for (int i = 0; i < nodes.size(); i++)
        {
            Node node = nodes.get(i);

            if (node.token.type == TokenType.PLUS)
            {
                tape[pos] = (tape[pos] + 1) % 256;
            }
            else if (node.token.type == TokenType.MINUS)
            {
                tape[pos] = tape[pos] == 0 ? 256 - 1 : tape[pos] - 1;
            }
            else if (node.token.type == TokenType.LT)
            {
                pos = pos == 0 ? memorySize - 1 : pos - 1;
            }
            else if (node.token.type == TokenType.GT)
            {
                pos = (pos + 1) % memorySize;
            }
            else if (node.token.type == TokenType.DOT)
            {
                System.out.print((char)tape[pos]);
            }
            else if (node.token.type == TokenType.COMMA)
            {
                tape[pos] = System.in.read();
            }
            else if (node.token.type == TokenType.LBRAC)
            {
                if (tape[pos] != 0)
                {
                    visit(node.children);
                    i--;
                }
            }
            else
            {
                if (tape[pos] != 0)
                {
                    return;
                }
            }
        }
    }
}
