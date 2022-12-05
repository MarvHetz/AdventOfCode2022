public class Elf
{
	public int getCalories()
	{
		return calories;
	}

	private int calories;

	public Elf()
	{
		calories = 0;
	}

	public void addCalories(int add)
	{
		calories += add;
	}

	@Override
	public String toString()
	{
		return String.valueOf(calories);
	}
}