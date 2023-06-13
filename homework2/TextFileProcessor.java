package homework2;


import homework2.Generate;
import homework2.CRUDTable;
import java.util.*;
import java.io.*;


public class TextFileProcessor{


	//save the matrix table to a file.txt
	//separated by ","
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
