import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
	private static BufferedReader br;
	private static int sumItemPriority;

	public static void main(String[] args)
	{
		sumItemPriority = 0;
		readFilePart1();

		System.out.println("Part 1 solution: " + sumItemPriority);

		sumItemPriority = 0;
		readFilePart2();

		System.out.println("Part 2 solution: " + sumItemPriority);
	}

	private static void readFilePart1()
	{
		try
		{
			br = new BufferedReader(new FileReader(new File("Day 3.txt"), StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			String line;
			char[] compartment1;
			char[] compartment2;
			int mid;
			while ((line = br.readLine()) != null)
			{
				mid = line.length() / 2;
				compartment1 = (line.substring(0, mid)).toCharArray();
				compartment2 = (line.substring(mid)).toCharArray();


				sumItemPriority += calculateSumItemPriority(getRedundantItem(compartment1, compartment2));
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	private static void readFilePart2()
	{
		try
		{
			br = new BufferedReader(new FileReader(new File("Day 3.txt"), StandardCharsets.UTF_8));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			String[] lines = new String[3];
			String line;
			int mid;
			int i = 0;
			while ((line = br.readLine()) != null)
			{

				lines[i] = line;
				i++;
				if (i == 3)
				{
					sumItemPriority += calculateSumItemPriority(getBadge(lines));
					i = 0;
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	private static char getBadge(String[] lines)
	{
		Arrays.sort(lines, Comparator.comparingInt(String :: length));

		for (char itemElf1 : lines[0].toCharArray())
		{
			for (char itemElf2 : lines[1].toCharArray())
			{
				if (itemElf1 == itemElf2)
				{
					for (char itemElf3 : lines[2].toCharArray())
					{
						if (itemElf2 == itemElf3 && itemElf1 == itemElf3)
						{
							return itemElf1;
						}
					}
				}
			}
		}
		return 0;
	}

	private static char getRedundantItem(char[] compartment1, char[] compartment2)
	{

		for (char itemCompartment1 : compartment1)
		{
			for (char itemCompartment2 : compartment2)
			{
				if (itemCompartment1 == itemCompartment2)
				{
					return itemCompartment1;
				}
			}
		}

		return 0;
	}

	private static int calculateSumItemPriority(char redundantItem)
	{
		if (redundantItem >= 65 && redundantItem <= 90)
		{
			return redundantItem - 38;
		}
		else if (redundantItem >= 97 && redundantItem <= 122)
		{
			return redundantItem - 96;
		}
		return 0;
	}
}