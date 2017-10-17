import persistence.Savable;

public class Spreadsheet implements Savable 
{
	
	static Cell[][] values;
	static char rowHeader;
	
	
	
	
public Spreadsheet() 
{ 
	
	values = new Cell[10][7];
	
	//initialize array of cells
	for(int i = 0; i < values.length; i++) 
	{
		for(int j = 0; j < values[0].length; j++)
		{
			values[i][j] = new Cell(); //initialize each Cell
		}
	}
	
}

public static void print(Spreadsheet s)
{ 
	String line = "\n";
	for (int i = 0; i <values[0].length+1; i++) 
	{ // for-loop to print lines
	line = line + "------------+";
	}

for (int i=0; i<values.length+1; i++) 
{
	for (int j=0; j<values[0].length+1; j++) 
	{
		if (i==0 && j==0) 
		{ // top-left corner space
			System.out.print("            ");
		} else if (j==0) 
		{ // column identifiers (numbers)
			FormatText(Integer.toString(i));
		} else if (i==0 && j!=0) 
		{ // row identifiers (letters)
			rowHeader = (char) (j + 64);
			FormatText(Character.toString(rowHeader));
		} else 
		{ // creates regular cells
			FormatText(values[i-1][j-1].getText()); 
		}
		System.out.print("|");
	}
	System.out.println(line);
}
System.out.println();
}

public static void clearCell(String cellLocation) 
{ // clears specific cell
	int j = cellLocation.charAt(0)-'A';
	int i = Integer.parseInt(cellLocation.substring(1))-1;
	values[i][j] = new Cell();
}



public static void setCell(String address, String input) 
{ // changes value of a cell
	int j = address.charAt(0)-'A'; // parses column
	int i = Integer.parseInt(address.substring(1))-1; // parses row
	try { // try catch to check if input is a double
		double inputDouble=Double.parseDouble(input);
		values[i][j] = new Doubles(inputDouble);
	} catch (NumberFormatException e) 
	{
		if (input.charAt(0)=='"') 
		{ // checks if input is a String
			values[i][j] = new Strings(input);
		} else if (input.equals("<empty>")) { // checks if input is "<empty>" and clears cell
			values[i][j] = new Cell();
		} else if (input.charAt(0)=='(') { // checks if input is a function
			values[i][j] = new Formulas(input, values);
		} else { // if not, it's a date cell!
			values[i][j] = new Dates(input);
		}
	}
}

public static void FormatText(String input) 
{ // prints and formats cells
	if (input.length()>12) 
	{
		input = input.substring(0, 11) + ">";
	} // truncates cells with length greater than 12
	int spaces = (12 - input.length()) / 2; // defines number of spaces
	for (int i=0; i<spaces; i++) 
	{
		System.out.print(" ");
	} // prints left-side spaces
	if (input.length()%2 == 1) 
	{
		System.out.print(" ");
	} // prints extra space if odd
	System.out.print(input); // prints value of cell
	for (int i=0; i<spaces; i++) 
	{
		System.out.print(" ");
	} //prints right-side space
}





public static String getCell(String cellLocation)
{
	 // gets raw value from cell and returns it as a String
		int j = cellLocation.charAt(0)-'A';
		int i = Integer.parseInt(cellLocation.substring(1))-1;
		return values[i][j].toString();
	
}



public static void clear() 
{ //Clears spreadsheet
	for (int i = 0; i < values.length; i++) 
	{
		for (int j = 0; j < values[0].length; j++) 
		{
			values[i][j] = new Cell();
			
		}
	}
}

public void sortA(Spreadsheet s, String input, String cellLocation)
{
	
	
	int col1 = input.charAt(4)-'A';
	int row1 = Integer.parseInt(input.substring(5, input.indexOf(" ", 5)))-1;
	int col2 = input.charAt(input.indexOf(" - ") + 3)-'A';
	int row2 = Integer.parseInt(input.substring(input.indexOf(" - ") + 4))-1;
		int i, j;
		for (i = 0; i < values.length - 1; i++) 
		{
			for (j = i+1; j < values[0].length; j++) // locate smallest element between							// positions 1 and i.
			{
				double firstValue=0.0, jValue=0.0;
				if(values[col1][row1] != null && values[col1][row1] instanceof Formulas || values[col1][row1] instanceof Doubles) 
				{
					firstValue = Double.parseDouble(values[col1][row1].getText());
				}
				if(values[col2][row2] != null && values[col2][row2] instanceof Formulas || values[col2][row2] instanceof Doubles) 
				{
					jValue = Double.parseDouble(values[col2][row2].getText());
				}
				if (jValue < firstValue) {
				}
			}
			/*
			temp = Double.parseDouble(s.getCell((s.getCell(input, null)), null)); 
			s.setCell(s.getCell(cellLocation, values[col1][row1]), Double.parseDouble(s.getCell(s.getCell(input, null))));
			s.setCell(values.get(i), temp);
			*/
		}
		Spreadsheet.print(s);
}

public void sortD(Spreadsheet s, String input, String cellLocation)
{
	int col1 = input.charAt(4)-'A';
	int row1 = Integer.parseInt(input.substring(5, input.indexOf(" ", 5)))-1;
	int col2 = input.charAt(input.indexOf(" - ") + 3)-'A';
	int row2 = Integer.parseInt(input.substring(input.indexOf(" - ") + 4))-1;
		int i, j;
		for (i = 0; i < values.length - 1; i++) 
		{
			for (j = i+1; j < values[0].length; j++) // locate smallest element between							// positions 1 and i.
			{
				double firstValue=0.0, jValue=0.0;
				if(values[col1][row1] != null && values[col1][row1] instanceof Formulas || values[col1][row1] instanceof Doubles) 
				{
					firstValue = Double.parseDouble(values[col1][row1].getText());
				}
				if(values[col2][row2] != null && values[col2][row2] instanceof Formulas || values[col2][row2] instanceof Doubles) 
				{
					jValue = Double.parseDouble(values[col2][row2].getText());
				}
				if (jValue < firstValue) {
				}
			}
			/*
			temp = Double.parseDouble(s.getCell((s.getCell(input, null)), null)); 
			s.setCell(s.getCell(cellLocation, values[col1][row1]), Double.parseDouble(s.getCell(s.getCell(input, null))));
			s.setCell(values.get(i), temp);
			*/
		}
		Spreadsheet.print(s);
}

public String[] getSaveData() 
{ // implements getSaveData() method from Savable
	
	
	String[] saveData = new String[values.length * values[0].length + 2]; // creates String[] array that will be returned
	saveData[0] = Integer.toString(values.length); // saves height of spreadsheet to first index
	saveData[1] = Integer.toString(values[0].length); // saves length of spreadsheet to second index
	for (int i=0; i < values.length; i++) 
	{
		for (int j=0; j<values[0].length; j++) 
		{
			saveData[i * values[0].length + j + 2] = values[i][j].toString(); // sets values in array to spreadsheet cell values
		}
	}
	return saveData;
}

public void loadFrom(String[] saveData)
{ // implements loadFrom() method from Savable
	
	values = new Cell[Integer.parseInt(saveData[0])][Integer.parseInt(saveData[1])]; // sets spreadsheet height and width from loaded file
	String cellLocation; // declares String to store address
	for (int i=0; i < values.length; i++) 
	{
		for (int j=0; j < values[0].length; j++) 
		{
			cellLocation = Character.toChars('A' + j)[0] + Integer.toString(i+1); // parses address from index
			setCell(cellLocation, saveData[i * values[0].length + j + 2]); // sets value of cell from value at index
		}
	}
}



}



