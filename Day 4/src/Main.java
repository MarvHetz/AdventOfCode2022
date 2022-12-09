import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	private static BufferedReader br;
	private static int sumRedundantAssignments;
	private static int sumOverlapingAssignments;


	public static void main(String[] args)
	{
		sumRedundantAssignments = 0;
		sumOverlapingAssignments = 0;
		readFile();

		System.out.println("Part 1 solution: " + sumRedundantAssignments);
		System.out.println("Part 2 solution: " + sumOverlapingAssignments);
	}

	private static void readFile()
	{
		try
		{
			br = new BufferedReader(new FileReader("Day 4.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			String line;
			String[] sections;
			String[][] assignments = new String[2][];
			while ((line = br.readLine()) != null)
			{
				sections = line.split(",");
				assignments[0] = sections[0].split("-");
				assignments[1] = sections[1].split("-");

				checkRedundant(assignments);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void checkRedundant(String[][] assignments)
	{
		int[][] assignmentsInt = new int[2][2];
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				assignmentsInt[i][j] = Integer.valueOf(assignments[i][j]);
			}
		}

		if (assignmentsInt[0][0] >= assignmentsInt[1][0] && assignmentsInt[0][1] <= assignmentsInt[1][1])
		{
			sumRedundantAssignments++;
		}
		else if (assignmentsInt[0][0] <= assignmentsInt[1][0] && assignmentsInt[0][1] >= assignmentsInt[1][1])
		{
			sumRedundantAssignments++;
		}

		if (assignmentsInt[0][0] >= assignmentsInt[1][0] && assignmentsInt[0][0] <= assignmentsInt[1][1])
		{
			sumOverlapingAssignments++;
		}
		else if (assignmentsInt[0][1] >= assignmentsInt[1][0] && assignmentsInt[0][1] <= assignmentsInt[1][1])
		{
			sumOverlapingAssignments++;
		}
		else if (assignmentsInt[1][0] >= assignmentsInt[0][0] && assignmentsInt[1][0] <= assignmentsInt[0][1])
		{
			sumOverlapingAssignments++;
		}
		else if (assignmentsInt[1][1] >= assignmentsInt[0][0] && assignmentsInt[1][1] <= assignmentsInt[0][1])
		{
			sumOverlapingAssignments++;
		}
	}
}
