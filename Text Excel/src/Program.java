import java.util.*;


import persistence.PersistenceHelper;

// Jase Calloway
// Period 1
// AP Computer Science
// 3/28/16 
// Checkpoint 6 Final Submission
// Extra Credit: Help Method 





public class Program 
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to TextExcel! If you need help, please type Help");
		Spreadsheet s = new Spreadsheet();
		System.out.print("Enter command: ");
		String userInput= input.nextLine();
		
		while(!userInput.equalsIgnoreCase("exit"))
		{
				processUserInput(userInput, s);
				System.out.print("Enter another command: ");
				userInput = input.nextLine();
		}
		System.out.println("Farewell");
		input.close();
	}

	public static void processUserInput(String input, Spreadsheet s) 
	{
		
		//determines type of input based on length of input
		try
		{
			// method to parse user input
		if(input.contains("help"))
		{
			printHelpMethod();
		}
			 else if (input.length() == 2 || input.length() == 3) {
				System.out.println(input + " = " + Spreadsheet.getCell(input) + "\n");
			} else if (input.substring(0, 5).equalsIgnoreCase("print")) { //prints spreadsheet
				System.out.println();
				Spreadsheet.print(s);
			} else if (input.contains(" = ")) { // set cell values
				Spreadsheet.setCell(input.substring(0, input.indexOf(" = ")), input.substring(input.indexOf(" = ")+3));
				System.out.println();
			} else if (input.substring(0, 5).equalsIgnoreCase("clear")) { // clears cells or spreadsheet
				if (input.length()>5) { // clear specific cell
					Spreadsheet.clearCell(input.substring(6));
				} else { // clears entire spreadsheet
					Spreadsheet.clear();
				}
			} else if (input.substring(0, 4).equalsIgnoreCase("save")) { // saves spreadsheet to file
				try {
					PersistenceHelper.save(input.substring(5), s);
				} catch (Exception e) { // catches file error
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("Unable to save to path '" + input.substring(5) + "'\n");
				}
			} else if (input.substring(0, 4).equalsIgnoreCase("load")) { // loads spreadsheet from file
				try {
					PersistenceHelper.load(input.substring(5), s);
				} catch (Exception e) { // catches file error
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("Unable to load from path '" + input.substring(5) + "'\n");
				}
			}
			}
		
	
		catch (Exception e)
		{
			System.out.println("The input you entered does not correspond with the set inputs for types of cells. Please try again.");
		}
		
		
		
		
	
	
	}
	public static void printHelpMethod()
	{
		System.out.println("Supported commands and formats are: \n");
		System.out.println("Print: Prints out the spreadsheet");
		System.out.println("Clear: Clears whole spreadsheet // Format for specific cell: Clear A1");
		System.out.println("Save: Saves your specified spreadsheet // Format: Save fileName");
		System.out.println("Load: Loads your specified spreadsheet // Format: Load fileName");
		System.out.println("Cell Setting: Sets a value to a cell // Format: A1 = 5; A1 = \"Print\"; A1 = 01/01/2016; A1 = ( 5 + 5 ); A1 = ( A5 + B4 ); ");
		System.out.println("Cell Value Retrieval: Gets the value of a cell // Format: A1 \n");
		System.out.println("SortA and SortD do not work. Please do not try them.");
	}
			
		

		
	
}


