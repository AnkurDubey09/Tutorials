package com.ad.auto.sel.pract;

import java.io.FileReader;

//Java FileReader class is used to read data from the file. It returns data in byte format like FileInputStream class.

//It is character-oriented class which is used for file handling in java.

public class IOFileReaderExampleClass {
	
	   public static void main(String args[])throws Exception{    
	          FileReader fr=new FileReader("D:\\testout.txt");    
	          int i;    
	          while((i=fr.read())!=-1)    
	          System.out.print((char)i);    
	          fr.close();    
	    } 

}
