import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main
{
	private static ArrayList<Elf> elves;
	private static BufferedReader br;

	public static void main(String[] args)
	{
		elves = new ArrayList<>();
		try
		{
			br = new BufferedReader(new FileReader(new File("calories.csv")));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		readFile();

		elves.sort(Comparator.comparing(Elf :: getCalories));
		Collections.reverse(elves);

		System.out.println("Part 1 solution: " + elves.get(0));

		int totalCaloriesTopThree = elves.get(0).getCalories() + elves.get(1).getCalories() + elves.get(2).getCalories();
		System.out.println("Part 2 solution: " + totalCaloriesTopThree);
	}

	private static void readFile()
	{
		String line;
		int calories;
		Elf addingElf;

		try
		{
			addingElf = new Elf();
			while ((line = br.readLine()) != null)
			{
				if (line.isEmpty())
				{
					elves.add(addingElf);
					addingElf = new Elf();
				}
				else
				{
					calories = Integer.valueOf(line);
					addingElf.addCalories(calories);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}

	}
}