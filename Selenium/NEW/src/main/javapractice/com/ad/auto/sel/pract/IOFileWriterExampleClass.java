package com.ad.auto.sel.pract;

import java.io.File;
import java.io.FileWriter;

//Java FileWriter class is used to write character-oriented data to a file. It is character-oriented class which is used for file handling in java.
//Unlike FileOutputStream class, you don't need to convert string into byte array because it provides method to write string directly.
//public class FileWriter extends OutputStreamWriter  

public class IOFileWriterExampleClass {
	
	public static void main(String args[]){  
		File file = new File("D:\\testout.txt");
        try{    
          FileWriter fw=new FileWriter(file);    
          fw.write("Welcome to javaTpoint.");    
          fw.close();    
         }catch(Exception e){System.out.println(e);}    
         System.out.println("Success...");    
    } 

}
