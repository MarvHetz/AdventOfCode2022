import java.io.BufferedReader;
import java.util.ArrayList;

public class Main
{
    private static BufferedReader br;
    private static ArrayList<String[]> ship;
    private static String[] stack;
    public static void main(String[] args)
    {
        createStacks();
    }

    private static void createStacks()
    {
        stack = new String[]{"[F]","[T]","[C]","[L]","[R]","[P]","[G]","[Q]"};
        ship.add(stack);
        stack = new String[]{"[N]","[Q]","[H]","[W]","[R]","[F]","[S]","[J]"};
        ship.add(stack);
    }
}
