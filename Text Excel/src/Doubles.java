
public class Doubles extends Cell 
{

	public double value = 0;
	
	public Doubles(double input)
	{
		value = input;
	}
	
	public Doubles(int input) 
	{ // allows double cell to be constructed with Integer input
		this((double) input);
	}
	
	public String toString() 
	{
		return Double.toString(value);
	}
	
	public String getText() 
	{
		return Double.toString(value);
	}
	
	public void setValue(double input)
	{
		value = input;
	}
	public void setValue(int input)
	{ // allows double cell to be set to Integer input
		value=(double) input;
	}
	public String evaluate() 
	{
		return Double.toString(value);
	}
}