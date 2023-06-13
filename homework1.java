import java.util.*;

public class homework1{

	
	//generate a table dimension based on the user input
	//once generated, loop thru each cell
	//then generate a 3 random char for each key and value pair
	//each cell, insert the key value pair random char and should be separated by comma
	
	//ask the user which character is going to find
	//loop thru each cell to find it
		//if found, output the location, number of occurence, key/value field found


	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
		
		//ask the user for table dimension
		System.out.print("Enter your table dimension: ");
		String tableDimension = scanner.next();
		
		//generate an empty table based on user input
		System.out.println("");
		String[][] tableCreated = generateTable(tableDimension);
		
		//insert a string each cell
		insertStringPerCell(tableCreated);
		
		//display each cell in table
		displayTable(tableCreated);
		
		//ask the user what to search within the table
		System.out.print("\nSearch for: ");
		String stringToSearch = scanner.next();
		
		//find the total occurence
		searchEachTableCell(tableCreated, stringToSearch);
		
		
		
	
	}




	//generate table dimension based on user input
	public static String[][] generateTable(String tableDimension){
		
		int rows = 0;
		int columns = 0;
		
		String[] table2DArray = tableDimension.split("");
		rows = Integer.parseInt(table2DArray[0]);
		columns = Integer.parseInt(table2DArray[2]);  
	
		String[][] table = new String[rows][columns];
		return table;
	}
	
	
	//generate random number
	public static int generateNumber(){
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
	
	
	//generate 3 random character as string per call
	public static String generateThreeRandomCharAsString(){
		StringBuilder generatedString = new StringBuilder();
		
		//limit size of char 
		int limit = 3;
		
		//per loop, call the generateRandomNum 
		//then convert it to char
		//the char will be append to generatedString variable
		for (int i=0; i<limit; i++){
			char numberToChar = (char) generateNumber();
			generatedString.append(numberToChar);
		}
		
		return generatedString.toString();
	}
	
	
	//concatenate the key/value pair as String
	public static String concatenateTwoString(){
		StringBuilder keyValueAsString =  new StringBuilder();
		
		//as key
		keyValueAsString.append(generateThreeRandomCharAsString());
		
		//separator
		keyValueAsString.append(",");
	
		//as pair
		keyValueAsString.append(generateThreeRandomCharAsString());
		
		return keyValueAsString.toString();
	}
	
	
	//insert the concatenateTwoString per cell in the table
	public static void insertStringPerCell(String[][] table){
	
		int rows = table.length;
		int columns = table[0].length;
	
		//loop each cell then insert the return from concatenateTwoString();
		for(int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				table[i][j] = concatenateTwoString();	
			}
		}
	}
	
	
	//display each cell in table
	public static void displayTable(String[][] table){
		int rows = table.length;
		int columns = table[0].length;
		
		for(int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				System.out.print(table[i][j] + "  ");
			}
			
			System.out.println("");
		}
	}


	//search each table cell
	public static void searchEachTableCell(String[][] table, String word){
		int rows = table.length;
		int columns = table[0].length;
		
		
		//loop each to find
		for (int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
			
				int[] exactLocation = {i,j}; 
				
				//assign the string
				String stringToCheck = table[i][j];
				
				//from "123,456" to "123"
				String keyString = stringToCheck.substring(0,3);
				
				//from "123,456" to "456"
				String valueString = stringToCheck.substring(4,7);
				
				//return is the number of occurence in that field
				int countOccurenceInKeyField = keyField(keyString, word);
				
				//test the number of occurence in key field
				//if > 0,show the number of occurence and and the exact location
				if (countOccurenceInKeyField > 0){
					printTheOccurenceInAField(countOccurenceInKeyField, "key field.", exactLocation);
				}			
				
				//return is the number of occurence in that field
				int countOccurenceInValueField = valueField(valueString, word);
				
				//test the number of occurence in value field
				//if > 0,show the number of occurence and and the exact location
				if (countOccurenceInValueField > 0){
					printTheOccurenceInAField(countOccurenceInValueField, "value field.", exactLocation);
				}
						
	
			}
		}
	}
	

	
	
	
	//search within "KEY" field
	public static int keyField(String keyword, String wordToFind){
		int count = 0;
		for (int i=0; i<3; i++) {
			String word = keyword.substring(i, i+1);
			
			if(word.equals(wordToFind)){
				count++;
			}
		
		}
		
		return count;
	}
	
	
	
	//search within "VALUE" field
	public static int valueField(String keyword, String wordToFind){
		int count = 0;
		for (int i=0; i<3; i++) {
			String word = keyword.substring(i, i+1);
			
			if(word.equals(wordToFind)){
				count++;
			}
		
		}
		
		return count;
	}
	
	
	//print the number of occurence in a key/value field
	public static void printTheOccurenceInAField(int countOccurence, String fieldType, int[] location){
	
		System.out.println(Arrays.toString(location) + " - " + 
			countOccurence + " Occurence found on " + fieldType);
		
	
	}


}
