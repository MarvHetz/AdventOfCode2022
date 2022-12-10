import java.awt.*;
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
	private static int markerPosition, messagePosition;
	public static void main(String[] args)
	{
		markerPosition = 0;
		messagePosition = 0;
		readFile();
		System.out.println("Solution Part 1: " + markerPosition);
		System.out.println("Solution Part 2: " + messagePosition);
	}

	private static void readFile()
	{
		try
		{
			try
			{
				br = new BufferedReader(new FileReader("Day 6.txt"));
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not found");
			}
			String line = br.readLine();
			char [] lineArray = line.toCharArray();
			boolean markerFound = false, messageFound = false;

			for(int i = 0; i < lineArray.length && !markerFound; i++)
			{
				if(i >= 4)
				{
					List<Character> windowListTemp = Arrays.asList(lineArray[i-3], lineArray[i-2], lineArray[i-1], lineArray[i]);
					ArrayList<Character> windowList = new ArrayList<Character>();
					windowList.addAll(windowListTemp);
					markerFound = checkForMarker(windowList);
				}
				markerPosition++;
			}

			for(int i = 0; i < lineArray.length && !messageFound; i++)
			{
				if(i >= 14)
				{
					List<Character> windowListTemp = Arrays.asList(lineArray[i-13], lineArray[i-12], lineArray[i-11], lineArray[i-10], lineArray[i-9], lineArray[i-8], lineArray[i-7], lineArray[i-6], lineArray[i-5], lineArray[i-4], lineArray[i-3], lineArray[i-2], lineArray[i-1], lineArray[i]);
					ArrayList<Character> windowList = new ArrayList<Character>();
					windowList.addAll(windowListTemp);
					messageFound = checkForMessage(windowList);
				}
				messagePosition++;
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

	private static boolean checkForMarker(ArrayList<Character> window)
	{
		for (int i = 0; i < 4; i++)
		{
			if (window.lastIndexOf(window.get(i)) != i)
			{
				return false;
			}
		}
		return true;
	}

	private static boolean checkForMessage(ArrayList<Character> window)
	{
		for (int i = 0; i < 14; i++)
		{
			if (window.lastIndexOf(window.get(i)) != i)
			{
				return false;
			}
		}
		return true;
	}
}