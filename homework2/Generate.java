
package homework2;

import homework2.TextFileProcessor;
import homework2.CRUDTable;


public class Generate{

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



}
