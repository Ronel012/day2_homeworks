package homework2;

import homework2.TextFileProcessor;
import homework2.Generate;
import java.util.*;
import java.io.*;



public class CRUDTable{

	//print each cell in table
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
	
	
	
	//insert the random  string per each cell in a table
	public static void insertRandomString(String[][] table){
	
		int rows = table.length;
		int columns = table[0].length;
		
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				table[i][j] = Generate.keyAndValueAsString();
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
		table[rows][columns] = Generate.assembleTheNewCellValue(originalString, newValue, fieldType);
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
		String randomString = Generate.keyAndValueAsString();
		
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
		//just locate the location and insert th random char
		newTable[rowNumber][table[0].length] = randomString;
	
		return newTable;
	}




}
