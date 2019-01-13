package com.ad.auto.sel.pract;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;
//// public class SequenceInputStream extends InputStream
public class IOSequenceInputStreamExampleClass {
	
	//Java SequenceInputStream class is used to read data from multiple streams. It reads data sequentially (one by one).	
	static void readFromMultipleFiles() throws IOException{
		
		   FileInputStream input1=new FileInputStream("D:\\testin1.txt");    
		   FileInputStream input2=new FileInputStream("D:\\testin2.txt");    
		   SequenceInputStream inst=new SequenceInputStream(input1, input2);    
		   int j;    
		   while((j=inst.read())!=-1){    
		    System.out.print((char)j);    
		   }    
		   inst.close();    
		   input1.close();    
		   input2.close();    
		
	}
	
	//Example that reads the data from two files and writes into another file
	static void readFromMultipleWriteIntoOneFile() throws IOException{
		
		   FileInputStream fin1=new FileInputStream("D:\\testin1.txt");    
		   FileInputStream fin2=new FileInputStream("D:\\testin2.txt");    
		   FileOutputStream fout=new FileOutputStream("D:\\testout.txt");      
		   SequenceInputStream sis=new SequenceInputStream(fin1,fin2);    
		   int i;    
		   while((i=sis.read())!=-1)    
		   {    
		     fout.write(i);        
		   }    
		   sis.close();    
		   fout.close();      
		   fin1.close();      
		   fin2.close();       
		   System.out.println("Success..");  
			
	}
	
	//SequenceInputStream example that reads data using enumeration and writing on another file
	static void readingDataUsingEnumeration() throws IOException{
		
		FileInputStream fin=new FileInputStream("D:\\a.txt");    
		FileInputStream fin2=new FileInputStream("D:\\b.txt");    
		FileInputStream fin3=new FileInputStream("D:\\c.txt");    
		FileInputStream fin4=new FileInputStream("D:\\d.txt"); 
		FileOutputStream fout=new FileOutputStream("D:\\testout1.txt");
		//creating Vector object to all the stream    
		Vector v=new Vector();    
		v.add(fin);    
		v.add(fin2);    
		v.add(fin3);    
		v.add(fin4);              
		//creating enumeration object by calling the elements method    
		Enumeration e=v.elements();      
		//passing the enumeration object in the constructor    
		SequenceInputStream bin=new SequenceInputStream(e);    
		int i=0;      
		while((i=bin.read())!=-1){
			fout.write(i);
			System.out.print((char)i);    
		}     
		bin.close();    
		fin.close();    
		fin2.close();    
		
	}
	
	public static void main(String args[]) throws IOException{
		
		readFromMultipleFiles();
		readFromMultipleWriteIntoOneFile();
		
		readingDataUsingEnumeration();
		
	}

}
