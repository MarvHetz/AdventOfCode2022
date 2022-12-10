import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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


		for (int i = 0; i < 2; i++)
		{
			createStacks();
			readFile(i);
			System.out.print("Part " + (i + 1) + " solution: ");
			for (int j = 0; j < 9; j++)
			{
				System.out.print(ship[j].get(ship[j].size() - 1));
			}
			System.out.println();
		}


	}

	private static void createStacks()
	{
		List<String> list = Arrays.asList("[F]", "[T]", "[C]", "[L]", "[R]", "[P]", "[G]", "[Q]");
		ship[0] = new ArrayList<String>();
		ship[0].addAll(list);

		list = Arrays.asList("[N]", "[Q]", "[H]", "[W]", "[R]", "[F]", "[S]", "[J]");
		ship[1] = new ArrayList<String>();
		ship[1].addAll(list);

		list = Arrays.asList("[F]", "[B]", "[H]", "[E]", "[P]", "[M]", "[Q]");
		ship[2] = new ArrayList<String>();
		ship[2].addAll(list);

		list = Arrays.asList("[V]", "[S]", "[T]", "[D]", "[F]");
		ship[3] = new ArrayList<String>();
		ship[3].addAll(list);

		list = Arrays.asList("[Q]", "[L]", "[D]", "[W]", "[V]", "[F]", "[Z]");
		ship[4] = new ArrayList<String>();
		ship[4].addAll(list);

		list = Arrays.asList("[Z]", "[C]", "[L]", "[S]");
		ship[5] = new ArrayList<String>();
		ship[5].addAll(list);

		list = Arrays.asList("[Z]", "[B]", "[M]", "[V]", "[D]", "[F]");
		ship[6] = new ArrayList<String>();
		ship[6].addAll(list);

		list = Arrays.asList("[T]", "[J]", "[B]");
		ship[7] = new ArrayList<String>();
		ship[7].addAll(list);

		list = Arrays.asList("[Q]", "[N]", "[B]", "[G]", "[L]", "[S]", "[P]", "[H]");
		ship[8] = new ArrayList<String>();
		ship[8].addAll(list);
	}

	private static void readFile(int part)
	{
		try
		{
			try
			{
				br = new BufferedReader(new FileReader("Day 5.txt"));

				try
				{
					String line;
					int[] moves = new int[3];
					while ((line = br.readLine()) != null)
					{
						line = line.replace("move ", "");
						line = line.replace("from ", "");
						line = line.replace("to ", "");

						for (int i = 0; i < 3; i++)
						{
							moves[i] = Integer.parseInt(line.split(" ")[i]);
						}

						if (part == 0)
						{
							movePart1(moves[0], moves[1], moves[2]);
						}
						else
						{
							movePart2(moves[0], moves[1], moves[2]);
						}
					}
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				finally
				{
					br.close();
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not found");
			}

		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void movePart1(int quantity, int from, int to)
	{
		for (int i = 0; i < quantity; i++)
		{
			ship[to - 1].add(ship[from - 1].get(ship[from - 1].size() - 1));
			ship[from - 1].remove(ship[from - 1].size() - 1);
		}
	}

	private static void movePart2(int quantity, int from, int to)
	{
		quantity--;
		for (quantity = quantity; 0 <= quantity; quantity--)
		{
			ship[to - 1].add(ship[from - 1].get(ship[from - 1].size() - 1 - quantity));
			ship[from - 1].remove(ship[from - 1].size() - 1 - quantity);
		}
	}
}
