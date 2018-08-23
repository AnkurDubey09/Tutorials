package browseroperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	//"../Spectrum.xlsx"
	public static XSSFWorkbook myWorkBook;
	public static XSSFSheet mySheet;
	
	public static XSSFWorkbook getWorkbook(String wbName, String wbSheet) throws IOException{
		
		File myFile = new File(wbName);
	    FileInputStream fis = new FileInputStream(myFile);
		
	    
	    // Finds the workbook instance for XLSX file
	    
			myWorkBook = new XSSFWorkbook (fis);
		
	   
	    // Return first sheet from the XLSX workbook
	    mySheet = myWorkBook.getSheet(wbSheet);
	    
	    return myWorkBook;
		
	}
	
	public static String getStringValueFromExcel(String wbName, String wbSheet, String property) throws IOException{

		
		myWorkBook = getWorkbook(wbName, wbSheet);
		
		mySheet = myWorkBook.getSheet(wbSheet);
		
		int celIndex=0;
	   
	   Row row0 = mySheet.getRow(0);
	   short celCount = row0.getLastCellNum();
	   
	   for(int i=0; i<celCount; i++){
		   
		   if(row0.getCell(i).getStringCellValue().equalsIgnoreCase(property))
		   {
			   celIndex = i;
			   break;
		   }
	   }
	   
	   Cell cell = mySheet.getRow(1).getCell(celIndex);
	   
       return cell.getStringCellValue();
           
	}
	
  public double getNumericValueFromExcel(String wbName, String wbSheet, String property) throws IOException{

		
		myWorkBook = getWorkbook(wbName, wbSheet);
		
		mySheet = myWorkBook.getSheet(wbSheet);
		
		int celIndex=0;
	   
	   Row row0 = mySheet.getRow(0);
	   short celCount = row0.getLastCellNum();
	   
	   for(int i=0; i<celCount; i++){
		   
		   if(row0.getCell(i).getStringCellValue().equalsIgnoreCase(property))
		   {
			   celIndex = i;
			   break;
		   }
	   }
	   
	   Cell cell = mySheet.getRow(1).getCell(celIndex);
	   
       return cell.getNumericCellValue();
           
	}
  
  public Boolean getBooleanValueFromExcel(String wbName, String wbSheet, String property) throws IOException{

		
		myWorkBook = getWorkbook(wbName, wbSheet);
		
		mySheet = myWorkBook.getSheet(wbSheet);
		
		int celIndex=0;
	   
	   Row row0 = mySheet.getRow(0);
	   short celCount = row0.getLastCellNum();
	   
	   for(int i=0; i<celCount; i++){
		   
		   if(row0.getCell(i).getStringCellValue().equalsIgnoreCase(property))
		   {
			   celIndex = i;
			   break;
		   }
	   }
	   
	   Cell cell = mySheet.getRow(1).getCell(celIndex);
	   
     return cell.getBooleanCellValue();
         
	}
	
  
  public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			myWorkBook = getWorkbook(fileName, sheetName);
			
			mySheet = myWorkBook.getSheet(sheetName);
			Row r0 = mySheet.getRow(0);

			int totalNoOfCols = r0.getLastCellNum();
			int totalNoOfRows = mySheet.getLastRowNum();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = mySheet.getRow(i).getCell(j).getStringCellValue();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}
	
	
}


