package com.ad.auto.sel.pract;

import java.io.IOException;


/*If the superclass method declares an exception
1) Rule: If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception. 
*/

public class ExceptionClassForOverridingMethods2 {
	
	public static void main(String args[]){
		
		try{
			
			parent2 p2 = new child2();
			p2.msg();
			
			parent3 p3 = new child3();
			p3.msg();
			
			parent4 p4 = new child4();
			p4.msg();
			
		}catch(Exception e){
			
			
		}
		
	}

}

//Example in case subclass overridden method declares parent exception - compile time error
class parent1 {
	
	void msg() throws IOException{
		
		System.out.println("parent1:msg()");
		
	}
	
}

class child1 extends parent1{
	
	//void msg() throws Exception{}
	
}

//Example in case subclass overridden method declares same exception

class parent2 {
	
	void msg() throws IOException{
		
		System.out.println("parent2:msg()");
		
	}
	
}

class child2 extends parent2{
	
	void msg() throws IOException{
		
		System.out.println("child2::msg()");
		
	}
	
}

//Example in case subclass overridden method declares subclass exception

class parent3 {
	
	void msg() throws Exception{
		
		System.out.println("parent3:msg()");
		
	}
	
}

class child3 extends parent3{
	
	void msg() throws IOException{
		
		System.out.println("child3::msg()");
		
	}
	
}

//Example in case subclass overridden method declares no exception

class parent4 {
	
	void msg() throws Exception{
		
		System.out.println("parent4:msg()");
		
	}
	
}

class child4 extends parent4{
	
	void msg(){
		
		System.out.println("child4::msg()");
		
	}
	
}