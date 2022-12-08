import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    private static BufferedReader br;
    private static int sumRedundantAssignments;


    public static void main(String[] args)
    {
        sumRedundantAssignments = 0;
        readFile();

        System.out.println("Part 1 solution: " + sumRedundantAssignments);
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
            while((line = br.readLine()) != null)
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

    private static void checkRedundant(String assignments[][])
    {
        int assignmentsInt[][] = new int[2][2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; i < 2; i++)
            {
                assignmentsInt[i][j] = Integer.valueOf(assignments[i][j]);
            }
        }

        if (assignmentsInt[0][0] < assignmentsInt[1][0] && assignmentsInt[0][1] > assignmentsInt[1][1])
        {
            sumRedundantAssignments++;
        }
        else if (assignmentsInt[0][0] < assignmentsInt[1][0] && assignmentsInt[0][1] == assignmentsInt[1][1])
        {
            sumRedundantAssignments++;
        }
        else if (assignmentsInt[0][0] == assignmentsInt[1][0] && assignmentsInt[0][1] > assignmentsInt[1][1])
        {
            sumRedundantAssignments++;
        } else if (assignmentsInt[0][0] == assignmentsInt[1][0] && assignmentsInt[0][1] == assignmentsInt[1][1])
        {
            sumRedundantAssignments++;
        }
    }
}