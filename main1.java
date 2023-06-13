import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class main1 {

	
	public static void main(String args[]){
	
		String a = null;
		boolean b = a == "null";
		System.out.println(b);
		
	
	
	}
	
	//print each cell as table
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
	
	
	//read a file and save it 
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
