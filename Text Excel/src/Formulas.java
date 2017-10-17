public class Formulas extends Cell 
{

	 Cell[][] spreadsheet;
	
	public Formulas(String input, Cell[][] spreadsheet) 
	{
		cellInput = input;
		this.spreadsheet = spreadsheet;
	}
	
	public String toString() 
	{
		return cellInput;
	}
	
	public String getText() 
	{ // evaluates formula and returns as String
		return evaluate(cellInput.substring(2,cellInput.length()-2)); // evaluates formula without and excludes parenthesis
	}
	
	public String evaluate(String input) 
	{
		if (input.contains("sum")) 
		{ // calculates sum
			return Double.toString(sum(input));
		} else if (input.contains("avg")) 
		{ // calculates average
			return Double.toString(average(input));
		}
		int index1 = 0;
		int opIndex = 0;
		String temp;
		String remaining;
		double num1 = 0;
		double num2 = 0;
		
		while (input.indexOf(" ") != -1) 
		{ // runs loop while terms are still left
			opIndex = input.indexOf(" ") + 1; // sets index of first operator
			
			if (input.indexOf(" ", opIndex + 2) == -1) 
			{ // if last number, then set index to end of String
				index1 = input.length();
			} else 
			{
				index1 = input.indexOf(" ", opIndex + 2);
		}
			
			temp = input.substring(0, index1); // isolates first two numbers
			num1 = getNumber(temp.substring(0, temp.indexOf(" "))); // sets first number to double
			num2 = getNumber(temp.substring(temp.lastIndexOf(" ")+1)); // sets second number to double
			
			if (input.substring(opIndex, opIndex+1).equals("+")) 
			{ // adds numbers
				temp = Double.toString(num1 + num2);
			} else if (input.substring(opIndex, opIndex+1).equals("-")) 
			{ // subtracts numbers
				temp = Double.toString(num1 - num2);
			} else if (input.substring(opIndex, opIndex+1).equals("*")) 
			{ // multiplies numbers
				temp = Double.toString(num1 * num2);
			} else if (input.substring(opIndex, opIndex+1).equals("/"))
			{ // divides numbers
				temp = Double.toString(num1 / num2);
			}
			
			remaining = input.substring(index1); // isolates remaining part of String
			input = temp + remaining; // recombines isolated numbers and remainder of String
		}
		
		return input; // returns final calculated value
	}
	
	public double getNumber(String input) 
	{
		if (Character.isLetter(input.charAt(0))) 
		{
			int j = input.charAt(0)-'A';
			int i = Integer.parseInt(input.substring(1))-1;
			return Double.parseDouble(spreadsheet[i][j].evaluate());
		} else {
			return Double.parseDouble(input);
		}
	}
	
	public double sum(String input) 
	{
		double sum = 0;
		int col1 = input.charAt(4)-'A';
		int row1 = Integer.parseInt(input.substring(5, input.indexOf(" ", 5)))-1;
		int col2 = input.charAt(input.indexOf(" - ") + 3)-'A';
		int row2 = Integer.parseInt(input.substring(input.indexOf(" - ") + 4))-1;
		
		for (int i=row1; i<row2+1; i++) 
		{
			for (int j=col1; j<col2+1; j++) 
			{
				sum += Double.parseDouble(spreadsheet[i][j].evaluate());
			}
		}
		return sum;
	}
	
	public double average(String input) 
	{
		double sum = 0;
		int col1 = input.charAt(4)-'A';
		int row1 = Integer.parseInt(input.substring(5, input.indexOf(" ", 5)))-1;
		int col2 = input.charAt(input.indexOf(" - ") + 3)-'A';
		int row2 = Integer.parseInt(input.substring(input.indexOf(" - ") + 4))-1;
		
		int count = 0;
		for (int i=row1; i<row2+1; i++) 
		{
			for (int j=col1; j<col2+1; j++) 
			{
				sum += Double.parseDouble(spreadsheet[i][j].evaluate());
				count++;
			}
		}
		return sum / count;
	}
	
}



	

