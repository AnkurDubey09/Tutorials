package com.ad.auto.sel.pract;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileExampleClass {
	
	public static File file = null;
	public static FileOutputStream fos = null;
	public static FileInputStream fis = null;
	public static BufferedInputStream bis = null;
	public static BufferedOutputStream bos = null;
	
	public static void writeInFile(){
		
		file  = new File ("D:\\test\\test.txt");
		String hello= "Hello Hello";
		byte b[] = hello.getBytes();
		
		try {
			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos); 
			
			bos.write(b);
			bos.flush();
			fos.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public static void readFromFile(){
		
		file  = new File ("D:\\test\\test.txt");
		try {
			
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			
			int i;    
            while((i=bis.read())!=-1){    
             System.out.print((char)i);    
            } 
			
            bis.close();
			fis.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
				
		
	}
	
	public static void main(String args[]){
		
		writeInFile();
		readFromFile();
		
	}

}
