
public class Strings extends Cell 
{
	public Strings(String input) 
	{
		cellInput = input;
	}
	
	public Strings() 
	{
		this("");
	}
	
	public String toString() 
	{
		return cellInput;
	}
	
	public String getText() { // prints value of String without quotes
		return cellInput.substring(1, cellInput.length()-1);
	}
	
	public void setValue(String input) {
		cellInput = input;
	}
}
