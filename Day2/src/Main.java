import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    private static BufferedReader br;
    private static int points;

    public static void main(String[] args)
    {
        points = 0;
        readFilePart1();
        System.out.println("Part 1 solution: " + points);

        points = 0;

        readFilePart2();
        System.out.println("Part 2 solution: " + points);
    }

    private static void readFilePart1()
    {
        try
        {
            br = new BufferedReader(new FileReader("EncryptedStrategyGuide.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            String line;
            String[] shapes;
            char shapeElf;
            char shapeMe;
            while ((line = br.readLine()) != null)
            {
                shapes = line.split(" ");
                shapeElf = shapes[0].charAt(0);
                shapeMe = shapes[1].charAt(0);

                calculatePoints(shapeElf, shapeMe);
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
            br = new BufferedReader(new FileReader("EncryptedStrategyGuide.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            String line;
            String[] shapes;
            char shapeElf;
            char shapeMe;
            while ((line = br.readLine()) != null)
            {
                shapes = line.split(" ");
                shapeElf = shapes[0].charAt(0);
                shapeMe = shapes[1].charAt(0);

                if ((shapeElf == 'A') && (shapeMe == 'X'))
                {
                    calculatePoints(shapeElf, 'Z');
                }
                else if ((shapeElf == 'A') && (shapeMe == 'Y'))
                {
                    calculatePoints(shapeElf, 'X');
                }
                else if ((shapeElf == 'A') && (shapeMe == 'Z'))
                {
                    calculatePoints(shapeElf, 'Y');
                }
                else if ((shapeElf == 'B') && (shapeMe == 'X'))
                {
                    calculatePoints(shapeElf, 'X');
                }
                else if ((shapeElf == 'B') && (shapeMe == 'Y'))
                {
                    calculatePoints(shapeElf, 'Y');
                }
                else if ((shapeElf == 'B') && (shapeMe == 'Z'))
                {
                    calculatePoints(shapeElf, 'Z');
                }
                else if ((shapeElf == 'C') && (shapeMe == 'X'))
                {
                    calculatePoints(shapeElf, 'Y');
                }
                else if ((shapeElf == 'C') && (shapeMe == 'Y'))
                {
                    calculatePoints(shapeElf, 'Z');
                }
                else if ((shapeElf == 'C') && (shapeMe == 'Z'))
                {
                    calculatePoints(shapeElf, 'X');
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

    private static void calculatePoints(char shapeElf, char shapeMe)
    {
        if ((shapeElf == 'A') && (shapeMe == 'X'))
        {
            points += 4;
        }
        else if ((shapeElf == 'A') && (shapeMe == 'Y'))
        {
            points += 8;
        }
        else if ((shapeElf == 'A') && (shapeMe == 'Z'))
        {
            points += 3;
        }
        else if ((shapeElf == 'B') && (shapeMe == 'X'))
        {
            points += 1;
        }
        else if ((shapeElf == 'B') && (shapeMe == 'Y'))
        {
            points += 5;
        }
        else if ((shapeElf == 'B') && (shapeMe == 'Z'))
        {
            points += 9;
        }
        else if ((shapeElf == 'C') && (shapeMe == 'X'))
        {
            points += 7;
        }
        else if ((shapeElf == 'C') && (shapeMe == 'Y'))
        {
            points += 2;
        }
        else if ((shapeElf == 'C') && (shapeMe == 'Z'))
        {
            points += 6;
        }
    }
}