public class generateCustomizeTableMatrix{

	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
		int rows = 0;
		int columns = 0;
		
		//ask the user for table dimension
		System.out.println("Enter your table dimension: ");
		String tableDimension = scanner.next();
		
		//extract rows and columns
		String[] tableArray = tableDimension.split("");
		rows = Integer.parseInt(tableArray[0]);
		columns = Integer.parseInt(tableArray[2]);
		
		System.out.println("Rows: " + rows);
		System.out.println("Columns: " + columns);
	
	}




	//ask the user for the table dimension to be created
	public static void generateTable(String tableDimension){
		String 
	
	}
	
	
	
	//generate a table dimension based on the user input
	//once generated, loop thru each cell
	//then generate a 3 random char for each key and value pair
	//each cell, insert the key value pair random char and should be separated by comma
	
	//ask the user which character is going to find
	//loop thru each cell to find it
		//if found, output the location, number of occurence, key/value field found



}
