package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelOperationsClass {
	
	public static FileInputStream file = null;
	
	//Get the workbook instance for XLS file 
	public static HSSFWorkbook workbook = null;
	
	//Get first sheet from the workbook
	public static HSSFSheet sheet = null;
	
	public static HSSFWorkbook getFile(){
		try {
			file = new FileInputStream(new File("D:\\Personal\\Tutorials\\Eclipse\\MyWorkspace\\MyProject\\src\\Test Data\\Test Data File.xls"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}
	
	public static HSSFSheet getSheet(){
		sheet = getFile().getSheet("Sheet1");
		return sheet;
	}
	
	public static void readFile(){
		HSSFSheet sheet = getSheet();
		
		//Iterate through each rows from first sheet
	    Iterator<Row> rowIterator = sheet.iterator();
	    while(rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	         
	        //For each row, iterate through each columns
	        Iterator<Cell> cellIterator = row.cellIterator();
	        while(cellIterator.hasNext()) {
	             
	            Cell cell = cellIterator.next();
	             
	            switch(cell.getCellType()) {
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.print(cell.getBooleanCellValue() + "\t\t");
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    System.out.print(cell.getNumericCellValue() + "\t\t");
	                    break;
	                case Cell.CELL_TYPE_STRING:
	                    System.out.print(cell.getStringCellValue() + "\t\t");
	                    break;
	            }
	        }
	        System.out.println("");
	    }
	}
	
	public static String getValue(String prop){
		HSSFSheet sheet = getSheet();
		String value = null;
		//Iterate through each rows from first sheet
	    Iterator<Row> rowIterator = sheet.iterator();
	    while(rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	         
	        //For each row, iterate through each columns
	        Iterator<Cell> cellIterator = row.cellIterator();
	        while(cellIterator.hasNext()) {
	             Cell cell = cellIterator.next();
	             
	            if(cell.getStringCellValue().matches(prop)){
	            	int rowIndex = cell.getRowIndex();
	            	int colIndex = cell.getColumnIndex();
	            //	row = rowIterator.next();
	            //	value=row.getCell(colIndex).getStringCellValue();
	            	value = sheet.getRow(rowIndex+1).getCell(colIndex).getStringCellValue();

	            }
	        }
	    }
	    return value;
	}
}
