package browseroperations;

import java.io.FileNotFoundException;
import java.io.IOException;

import browseroperations.ExcelOperations;

public class TestSample {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddRole","Role_Name"));
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddRole","Module_Name"));
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddRole","Permisssion_Name"));
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddUser","User_Name"));
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddUser","Password"));
		
		System.out.println("-----> "+ExcelOperations.getStringValueFromExcel("./Spectrum.xlsx","AddUser","Assign_Role"));
		

	}

}
