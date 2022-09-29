import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        int memorySize = 1024;

        if (args.length != 1 && args.length != 2)
        {
            System.err.println("Usage: brainfuck <file> [memory-size]");
            System.exit(1);
        }

        if (args.length == 2)
        {
            memorySize = Integer.parseInt(args[1]);
        }

        File file = new File(args[0]);
        StringBuilder buffer = new StringBuilder();

        if (file.exists() && file.canRead())
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                buffer.append(line);
            }

            bufferedReader.close();
        }

        Run.run(String.valueOf(buffer), memorySize);
    }
}