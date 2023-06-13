import java.util.*;
import java.io.*;

class main{

	public static void main(String args[]) {
	
	Scanner scanner = new Scanner(System.in);
		
	//
	

	
	
		
	while (true){
		System.out.println("Start: ");	
		System.out.print("Upload a table (y/n): ");
		String uploadOrNotUpload = scanner.next();
		
		//
		if (uploadOrNotUpload.equals("y")){
		
			try {
				readFile();
			} catch (IOException e){
				System.out.println("Error!");
				e.printStackTrace();
			}
		}
		
		
		
		String[][] array = {
		        {"A", "B", "C"},
		        {"D", "E", "F"},
		        {"G", "H", "I"}
		};

		System.out.println("original table: ");
		printAsTable(array);
		System.out.println("");
		
		//ask the user to add dynamic column with specific location and new value
		System.out.print("Add an additional column on row: ");
		int row = scanner.nextInt();
		System.out.println("");
		
		
		String[][] newTable = addColumnToRow(array, row);
		
		printAsTable(newTable);
		
		
		//ask the user if the table is going to save to a file or not
		System.out.println("Are you going the table to a file? (y/n): ");
		String saveOrNotSave = scanner.next();
		
		if (saveOrNotSave.equals("y")){
			
			try {
				savedTheTable(newTable);
			} catch (IOException e){
				System.out.println("Error!!");
				e.printStackTrace();
			}
		}
		
		clearScreen();
		
		
		
	} //end of while loop
	
	
		
	} //end of main method
	
	
	//clear screen
	public static void clearScreen() {
        	System.out.print("\033[H\033[2J");
        	System.out.flush();
    }	
	
	
	//start of the app
	public static void printAsTable(String[][] table){
	
		int rows = table.length;
		int columns = table[0].length;
	
		for (int i=0; i<rows; i++){
		
			for (int j=0; j<columns; j++){
				System.out.print("  " + table[i][j] + "  " );
			}
			
			System.out.println();
		}
	}
	
	
	
	//add column on specific row
	public static String[][] addColumnToRow(String[][] table, int row) {
		int rows = table.length;
		int columns = table[0].length;
		String originalContent = "";
	
		String[][] newTable = new String[rows][columns+1];
		
		for (int i=0; i<rows; i++){
		
			for (int j=0; j<columns; j++){
				
				originalContent = table[i][j];
				newTable[i][j] = originalContent;
			}
		}
		
		newTable[row][newTable[0].length-1] = "wow";
			
		return newTable;
	}
	
	
	
	//save the table in a .txt file
	public static void savedTheTable(String[][] table) throws IOException{

		int rows = table.length;
		int columns = table[0].length;
		
		try {
		
		
		
		String filepath = "homework2_table.txt";
		FileWriter fileWriter = new FileWriter(filepath);
		
		//fileWrite act as a printer between the program and the .txt file
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				
				fileWriter.write(table[i][j] + "\t");
			}
			
			fileWriter.write("\n");
		}
		
		
		//close the fileWriter
		fileWriter.close();
		
		//notification that the information has been write.
		System.out.println("Table data has been saved to a file.");
		
		} catch (IOException e){
			System.out.println("table has not been saved!");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//read a txt file 
	public static void readFile() throws IOException{

		try {	
		
			File file = new File("homework2_table.txt");	
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
		
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	//read and save from file to a table 
	public static void readAndSaveFile() throws Exception{
	
		String filepath = "homework2_table.txt";
		ArrayList<String[]> tableData = new ArrayList<>();
		Scanner scan = new Scanner(new File(filepath));
		
		//check the String[][] size
		
		
		
		
		try {
		
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] columns = line.split(" ");
				
				tableData.add(columns);
					
			}
			
			//check the size of tableData
			int rows = tableData.size();
			int columns = tableData.size();
			String[][] tableArray = new String[rows][columns];
			
			//copy data from ArrayList to String[][]
			for (int i=0; i<rows; i++){
				String[] row = tableData.get(i);
				
				for (int j=0; j<row.length; j++){
					tableArray[i][j] = row[j];
				}
			}	
			
			
		
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	
	
	
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
