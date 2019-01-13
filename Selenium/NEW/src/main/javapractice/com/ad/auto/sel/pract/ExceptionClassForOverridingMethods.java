package com.ad.auto.sel.pract;

import java.io.IOException;

/*If the superclass method does not declare an exception
1) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception. 
2) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception.*/

public class ExceptionClassForOverridingMethods {
	
	public static void main(String args[]){
		
		parent p = new child();
		p.msg();
		
	}

}

class parent{
	
	void msg(){
		
		System.out.println("parent::msg()");
		
	}
	
}

class child extends parent{
	
	void msg() throws NullPointerException{
		
		System.out.println("child::msg()");
		
	}
	
}
