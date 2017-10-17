import java.time.LocalDate;

public class Dates extends Cell
{
	public String cellDateInput;
	public LocalDate dateFormat;
	
	public Dates(String input) 
	{ // creates a date cell
//		input = "01/34/6789";
		cellInput = input;
		dateFormat = LocalDate.of(Integer.parseInt(input.substring(6, 10)), Integer.parseInt(input.substring(0, 2)), Integer.parseInt(input.substring(3, 5)));
	}
	
	public String toString() 
	{
		return cellInput;
	}
	
	public String getText() 
	{
		return cellInput;
	}
	
	public void setValue(String input) 
	{ // sets value of date cell
		cellInput = input;
		dateFormat = LocalDate.of(Integer.parseInt(input.substring(6, 10)), Integer.parseInt(input.substring(0, 2)), Integer.parseInt(input.substring(3, 5)));
	}
}
