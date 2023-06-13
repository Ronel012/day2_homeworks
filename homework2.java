import java.util.*;
import java.io.*;


public class homework2{

	
	//generate a fixed value of 3x3
	//ask the user what cell should be edited
	//then ask the user whether key or value field are you to be edited
	//after edited, print the new table with the new value
	//ask the user whether to reset the table or not
		//if yes, the application will restart and asking
		//the user what will be the new dimension
	//depending on the answer, then the apps will restart
	//
	

	public static void main(String args[]){
	
	while (true) {
	
		Scanner scanner  = new Scanner(System.in);
		String[][] array2DToCreate = null;
		
		System.out.print("Create 2D array by (upload/default/customize): ");
		String create2dArrayBy = scanner.next();
		scanner.nextLine();
		
		//test the user input
		if (create2dArrayBy.equals("upload")){
			
			
			System.out.println("\nUpload table: ");
			array2DToCreate = extactData();
			printEachCellInTable(array2DToCreate);
			
		} else if (create2dArrayBy.equals("customize")){
		
			//ask user to input desired dimension
			System.out.print("Enter your desired table dimension: ");
			String tableDimension = scanner.next();
			scanner.nextLine();
			
			//create a empty 2d array
			array2DToCreate = generateTable(tableDimension);
			
			//insert random string each cell on the table
			insertRandomString(array2DToCreate);
			
			//print each cell
			System.out.println("\nCustomized table:  ");
			printEachCellInTable(array2DToCreate);
			
		} else {
		
			//create default empty 2d array 3x3
			array2DToCreate = generateTable("3x3");
			
			//insert random string each cell
			insertRandomString(array2DToCreate);
			
			//print each cell
			System.out.println("\nDefault table:  ");
			printEachCellInTable(array2DToCreate);
		}
		
		
		
		
		
		//generate a default empty 3x3 table
		//String[][] table = generateTable();
		
		//insert random string per table cell
		//insertRandomString(table);
		
		//print each table cell
		//System.out.println("Default table:  ");
		//printEachCellInTable(table);
		
		//ask the user what dimension is going to edit
		System.out.println();
		System.out.print("Edit: ");
		String locationToEdit = scanner.nextLine();
		
		//ask the user what would be the new  value
		System.out.print("New value: ");
		String newValue = scanner.next();
		
		//for tracking the original cell value
		String originalCellValue = trackTheOriginalCellValue(array2DToCreate, locationToEdit);
		
		//locate and update the value per user input
		locateAndUpdateValue(array2DToCreate, locationToEdit, newValue);
		
		//print each table cell
		printEachCellInTable(array2DToCreate);
		
		//ask the to reset or not
		System.out.print("\nAre you going to reset? (y/n): ");
		String resetOrNot = scanner.next(); 
	
		//reset the table or onot
		if (resetOrNot.equals("y")){
			locateAndUpdateValue(array2DToCreate, locationToEdit, originalCellValue);
			printEachCellInTable(array2DToCreate);	
			System.out.println();
		} else {
			System.out.println();
		}
		
		
		//ask the user to sort each row of the table by asc or desc
		System.out.print("Sort each rows by (asc/desc): ");
		String sortingOrder = scanner.next();
		scanner.nextLine();
		
		//process of ascending or descending each row
		String[] sortedInArray = sortedEachRow(array2DToCreate, sortingOrder);
		
		
		//from sortedTable array, transform into a sorted 2d array
		int originalRow = array2DToCreate.length;
		int originalColumn = array2DToCreate[0].length;
		String[][] newSortedTable = arrayTo2DArray(sortedInArray, originalRow, originalColumn);
		
		//show each new sorted row as table
		printEachCellInTable(newSortedTable);
		System.out.println();
		
		//ask user what row add a column
		System.out.print("Add column on row: ");
		int row = scanner.nextInt();
		
		//process of adding column on a row
		//return new table
		String[][] tableWithAddedColumn = addColumnOnRow(newSortedTable, row);
		
		//print new table
		printEachCellInTable(tableWithAddedColumn);
		System.out.println();
		
		//automatic save the table to a file.txt;
		try {
			saveTableIntoTextFile(tableWithAddedColumn);
		} catch (IOException e){
			System.out.println("Table data has not been saved!");
			e.printStackTrace();
		}
		
		
		System.out.println("\n\n\n------------------------------");
		System.out.println("The application will restart..");
		System.out.println("------------------------------\n\n\n");
	
		
	
	
		} //end of while
	
		
	} //end of main method







	//generate default  table
	public static String[][] generateTable(String tableDimension){
	
		int rows = 0;
		int columns = 0;
		
		String[] table2DArray = tableDimension.split("");
		rows = Integer.parseInt(table2DArray[0]);
		columns = Integer.parseInt(table2DArray[2]); 
	
		String[][] table = new String[rows][columns];
		return table;
	}
	
	
	//print each cell in table3x3
	public static void printEachCellInTable(String[][] table){
		int rows = table.length;
		int columns = table[0].length;
	
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				System.out.print("  " + table[i][j] + "  ");
			}
			
			System.out.println();
		}
	}
	
	
	//generate random number for creating a random char
	public static int generateRandomNumber(){
		Random random = new Random();
		int randomNum = random.nextInt(127);
		
		//if the number is below 33
		if (randomNum < 1){
			return randomNum = 33;		
		} else if (randomNum < 33){
			randomNum = (33 - randomNum) + randomNum;	
			return randomNum;
		}
		
		return randomNum;
	}
	
	
	//generate random 3 char as string per method call
	public static String generateThreeRandomCharAsString(){
		StringBuilder generatedString = new StringBuilder();
		
		//limit size of char per table cell
		int limit = 3;
		
		//per loop, call the generateRandomNum 
		//then convert it to char
		//the char will be append to generatedString variable
		for (int i=0; i<limit; i++){
			char numberToChar = (char) generateRandomNumber();
			generatedString.append(numberToChar);
		}
		
		return generatedString.toString();
	}
	
	
	
	//concatenate string to form key/value pair separated by comma
	// ex. "abc,dqw"
	public static String keyAndValueAsString(){
		StringBuilder keyAndValueAsString = new StringBuilder();
		
		//for key field
		keyAndValueAsString.append(generateThreeRandomCharAsString());
		
		//separator
		keyAndValueAsString.append(",");
		
		//for value field
		keyAndValueAsString.append(generateThreeRandomCharAsString());
		
		return keyAndValueAsString.toString();
	}	
	
	
	
	//insert the random  string per each cell in a table
	public static void insertRandomString(String[][] table){
	
		int rows = table.length;
		int columns = table[0].length;
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				table[i][j] = keyAndValueAsString();
			}
		}
	}
	
	
	//locate and update cell value
	public static void locateAndUpdateValue(String[][] table, String locationAndField, String newValue){
		int rows = Integer.parseInt(locationAndField.substring(0, 1));
		int columns = Integer.parseInt(locationAndField.substring(2, 3));
		String fieldType = locationAndField.substring(6, locationAndField.length());
		String cellLocation = table[rows][columns];
		
		String originalString = "";
	
		
		//extract information from original cell value
		if (fieldType.equals("key")){
			originalString = cellLocation.substring(4, cellLocation.length());
		} else {
			originalString = cellLocation.substring(0, 3);
		}
		
		//finally update the value
		table[rows][columns] = assembleTheNewCellValue(originalString, newValue, fieldType);
	}
	
	
	//assemble the original and new value as one
	public static String assembleTheNewCellValue(String originalValue, String newValue, String field){
		
		String updatedValue = "";
	
		if (field.equals("key")){
			updatedValue = newValue + "," + originalValue;
		} else {
			updatedValue = originalValue + "," + newValue;
		}
	
		return updatedValue;
	}
	
	
	//track the original cell content
	public static String trackTheOriginalCellValue(String[][] table, String location){
		int rows = Integer.parseInt(location.substring(0, 1));
		int columns = Integer.parseInt(location.substring(2, 3));
		String fieldType = location.substring(6, location.length());
		String cellLocation = table[rows][columns];
		
		String originalContent = "";
		
		//extract information from original cell value
		if (fieldType.equals("key")){
			originalContent = cellLocation.substring(0, 3);
		} else {
			originalContent = cellLocation.substring(4, cellLocation.length());
		}
		
		return originalContent;
	}
	
	
	
	
	//asceding or descending each row in a table
	public static String[] sortedEachRow(String[][] table, String sortedBy){
		int rows = table.length;
		int columns = table[0].length;
		int rowCount = 0;
		ArrayList<String> sortedArrayList = new ArrayList<String>();
		
		
		//loop each table cell
		//for each cell in a row, put it in an array
		//then that array will be sort by asc/desc based on user input

		
		String[] sortedRow = new String[columns];
		
		for (int i=0; i<rows; i++){
		
			for (int j=0; j<columns; j++){
				sortedRow[j] = table[i][j];
			}
			
			//sorted the array
			if (sortedBy.equals("asc")){
				Arrays.sort(sortedRow);
			} else {
				Arrays.sort(sortedRow, Comparator.reverseOrder());
			}
			
			
			//add an entire array
			sortedArrayList.addAll(Arrays.asList(sortedRow));
		}	
		
		return sortedArrayList.toArray(new String[sortedArrayList.size()]);	
	}
	
	//from an array to 2dArray
	//new 2d array with sorted table by asc/desc
	public static String[][] arrayTo2DArray(String[] sortedArray, int originalRow, int originalColumn){
	
		int rows = originalRow;
		int column = originalColumn;
		int count = 0;
		String[][] sorted2DArray = new String[rows][originalColumn]; 
		

		for (int i=0; i<rows; i++){
			for (int j=0; j<column; j++){
				sorted2DArray[i][j] = sortedArray[count];
				count++;
			}
		}
		
		return sorted2DArray;
	}
	
	
	
	//add one dynamic column based on user input
	public static String[][] addColumnOnRow(String[][] table, int rowNumber){
	
		int rows = table.length;
		int columns = table[0].length;
		String originalContent = "";
		String randomString = keyAndValueAsString();
		
		//create new 2d array 
		String[][] newTable = new String[rows][columns + 1];
		
		//loop each item on original table then transfer to the new table
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
					
				//hold original content
				originalContent = table[i][j];
				
				//transfer content from old to new table
				newTable[i][j] = originalContent;
			}
		}
		
		
		//once the original has been transfered,
		//just locate the row and its length and insert th random char
		newTable[rowNumber][table[0].length] = randomString;
	
		return newTable;
	}
	
	
	
	//save the table to a file.txt
	public static void saveTableIntoTextFile(String[][] table) throws IOException{
	
		int rows = table.length;
		int columns = table[0].length;
		
		try {
			String filepath = "homework2_table.txt";
			FileWriter fileWriter = new FileWriter(filepath);
			
			//fileWriter acts a printer between program and file text
			for (int i=0; i<rows; i++){
				for (int j=0; j<columns; j++){
					fileWriter.write(table[i][j] + " ");
				}
			
				fileWriter.write("\n");
			}
			
			//close the fileWriter
			fileWriter.close();
		
			//notification that the information has been write.
			System.out.println("Table data saved to a file.");
		
		} catch (IOException e){
			e.printStackTrace();
		}
	
	}
	
	
	
	
	

	//read a file and extract data and returned it as 2d array
	public static String[][] extactData(){


		//file name/path
		String filepath = "homework2_table.txt";
		
		//empty array
		String[][] array2D = null;
		
		
		try {
			File file = new File(filepath);
			Scanner scanner = new Scanner(file);
			
			//determine the dimensions of the 2d array
			int rowCount = 0;
			int columnCount = 0;
			
			
			//just to determine the dimension of the data within the file
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				rowCount++;
				String[] values = line.split(" ");
				columnCount = values.length;
			}
			
			
			//create a 2d array on the based dimension
			array2D = new String[rowCount][columnCount];
			
			
			//need to reset the scanner to the beginning of the file
			scanner.close();
			scanner = new Scanner(file);			
				
			//populate the array2D with the data on the file
			int row =0;
			
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] value = line.split(" ");
				for (int col=0; col<value.length; col++){
					array2D[row][col] = value[col];
				}
				
				//after each row has been read
				row++;
			}
			
			
			//close the scanner
			scanner.close();
			
		
			
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
	
		return array2D;
	}
	
	
}


	
	
	
	
	
	
	
	
	
