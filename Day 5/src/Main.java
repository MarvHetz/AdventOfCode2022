import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
	private static BufferedReader br;

	private static ArrayList<String>[] ship;

	public static void main(String[] args)
	{
		ship = new ArrayList[9];
		createStacks();
	}

	private static void createStacks()
	{
		List<String> list = Arrays.asList("[F]", "[T]", "[C]", "[L]", "[R]", "[P]", "[G]", "[Q]");
		ship[0].addAll(list);

		list = Arrays.asList("[N]", "[Q]", "[H]", "[W]", "[R]", "[F]", "[S]", "[J]");
		ship[1].addAll(list);

		list = Arrays.asList("[F]", "[B]", "[H]", "[E]", "[P]", "[M]", "[Q]");
		ship[2].addAll(list);

		list = Arrays.asList("[V]", "[S]", "[T]", "[D]", "[F]");
		ship[3].addAll(list);

		list = Arrays.asList("[Q]", "[L]", "[D]", "[W]", "[V]", "[F]", "[Z]");
		ship[4].addAll(list);

		list = Arrays.asList("[Z]", "[C]", "[L]", "[S]");
		ship[5].addAll(list);

		list = Arrays.asList("[Z]", "[B]", "[M]", "[V]", "[D]", "[F]");
		ship[6].addAll(list);

		list = Arrays.asList("[T]", "[J]", "[B]");
		ship[7].addAll(list);

		list = Arrays.asList("[Q]", "[N]", "[B]", "[G]", "[L]", "[S]", "[P]", "[H]");
		ship[8].addAll(list);
	}
}
