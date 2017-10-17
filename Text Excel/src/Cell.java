
public class Cell {

	public String cellInput;
	
	public Cell() 
	{
		cellInput = "";
	}
	
	public String toString() 
	{
		return "<empty>";
	}
	
	public String getText() 
	{
		return cellInput;
	}

	public void setValue(String input) 
	{
		cellInput = input;
	}
	
	public String evaluate() 
	{
		return "0";
	}
}

