package com.ad.auto.sel.pract;

public class ExceptionClass {
	
	public static void validate(int age)throws invalidAgeException{
		
		if(age<18)
			throw new invalidAgeException("not ready to caste the vote ... ");
		else
			System.out.println("you are ready to caste your vote .... ");
		
	}
	
	public static void main(String args[]){
		
		try{
			
			validate(17);
			
		}catch(Exception e){
			
			System.out.println("Exception being handlled "+ e);
			
		}
		
	}
	
	

}


