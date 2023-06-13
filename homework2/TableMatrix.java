package homework2;

import homework2.TextFileProcessor;
import homework2.Generate;
import homework2.CRUDTable;
import java.util.*;
import java.io.*;



public class TableMatrix{

	public static void main(String[] args){
	
	while (true) {
	
		Scanner scanner  = new Scanner(System.in);
		String[][] array2DToCreate = null;
		
		System.out.print("Create 2D array by (upload/default/customize): ");
		String create2dArrayBy = scanner.next();
		scanner.nextLine();
		
		//test the user input
		if (create2dArrayBy.equals("upload")){
			
			
			System.out.println("\nUpload table: ");
			array2DToCreate = TextFileProcessor.extactData();
			CRUDTable.printEachCellInTable(array2DToCreate);
			
		} else if (create2dArrayBy.equals("customize")){
		
			//ask user to input desired dimension
			System.out.print("Enter your desired table dimension: ");
			String tableDimension = scanner.next();
			scanner.nextLine();
			
			//create a empty 2d array
			array2DToCreate = Generate.generateTable(tableDimension);
			
			//insert random string each cell on the table
			CRUDTable.insertRandomString(array2DToCreate);
			
			//print each cell
			System.out.println("\nCustomized table:  ");
			CRUDTable.printEachCellInTable(array2DToCreate);
			
		} else {
		
			//create default empty 2d array 3x3
			array2DToCreate = Generate.generateTable("3x3");
			
			//insert random string each cell
			CRUDTable.insertRandomString(array2DToCreate);
			
			//print each cell
			System.out.println("\nDefault table:  ");
			CRUDTable.printEachCellInTable(array2DToCreate);
		}
		
		
		
		//ask the user what dimension is going to edit
		System.out.println();
		System.out.print("Edit: ");
		String locationToEdit = scanner.nextLine();
		
		//ask the user what would be the new  value
		System.out.print("New value: ");
		String newValue = scanner.next();
		
		//for tracking the original cell value
		String originalCellValue = CRUDTable.trackTheOriginalCellValue(array2DToCreate, locationToEdit);
		
		//locate and update the value per user input
		CRUDTable.locateAndUpdateValue(array2DToCreate, locationToEdit, newValue);
		
		//print each table cell
		CRUDTable.printEachCellInTable(array2DToCreate);
		
		//ask the to reset or not
		System.out.print("\nAre you going to reset? (y/n): ");
		String resetOrNot = scanner.next(); 
	
		//reset the table or onot
		if (resetOrNot.equals("y")){
			CRUDTable.locateAndUpdateValue(array2DToCreate, locationToEdit, originalCellValue);
			CRUDTable.printEachCellInTable(array2DToCreate);	
			System.out.println();
		} else {
			System.out.println();
		}
		
		
		//ask the user to sort each row of the table by asc or desc
		System.out.print("Sort each rows by (asc/desc): ");
		String sortingOrder = scanner.next();
		scanner.nextLine();
		
		//process of ascending or descending each row
		String[] sortedInArray = CRUDTable.sortedEachRow(array2DToCreate, sortingOrder);
		
		
		//from sortedTable array, transform into a sorted 2d array
		int originalRow = array2DToCreate.length;
		int originalColumn = array2DToCreate[0].length;
		String[][] newSortedTable = CRUDTable.arrayTo2DArray(sortedInArray, originalRow, originalColumn);
		
		//show each new sorted row as table
		CRUDTable.printEachCellInTable(newSortedTable);
		System.out.println();
		
		//ask user what row add a column
		System.out.print("Add column on row: ");
		int row = scanner.nextInt();
		
		//process of adding column on a row
		//return new table
		String[][] tableWithAddedColumn = CRUDTable.addColumnOnRow(newSortedTable, row);
		
		//print new table
		CRUDTable.printEachCellInTable(tableWithAddedColumn);
		System.out.println();
		
		//automatic save the table to a file.txt;
		try {
			TextFileProcessor.saveTableIntoTextFile(tableWithAddedColumn);
		} catch (IOException e){
			System.out.println("Table data has not been saved!");
			e.printStackTrace();
		}
		
		
		System.out.println("\n\n\n------------------------------");
		System.out.println("The application will restart..");
		System.out.println("------------------------------\n\n\n");
	


		} //end of try/catch
	} //end of main method

} //end of class
