public class Shape
{
	public char getSymbol()
	{
		return symbol;
	}

	private final char symbol;

	public int getPoints()
	{
		return points;
	}

	private final int points;

	public Shape(char symbol, int points)
	{
		this.symbol = symbol;
		this.points = points;
	}
}
