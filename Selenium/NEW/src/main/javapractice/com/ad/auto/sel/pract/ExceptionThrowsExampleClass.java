package com.ad.auto.sel.pract;

import java.io.IOException;

public class ExceptionThrowsExampleClass {
	
	public static void main(String args[]) throws IOException{
		
		A a = new A();
		a.p();
		System.out.println("normal flow...");
		
		B b = new B();
		b.p();
		System.out.println("normal flow...");
		
		C c = new C();
		c.p();
		System.out.println("normal flow...");
		
	}

}

class A{
	
	void m() throws IOException{
		
		throw new IOException("IO Device Error...");
		
	}
	
	void n() throws IOException{
		
		m();
		
	}
	
	void p(){
		
		try{
			n();
		}catch(IOException e){
			
			System.out.println("Exception handlled...");
			
		}
		
	}
	
}

class B{
	
	void m() throws IOException{
		
		System.out.println("not throwing exception...");
		
	}
	
	void n() throws IOException{
		
		m();
		
	}
	
	void p() throws IOException{
		
		n();
		
	}
	
}

class C{
	
	void m() throws IOException{
		
		throw new IOException("Device exception...");
		
	}
	
	void n() throws IOException{
		
		m();
		
	}
	
	void p() throws IOException{
		
		n();
		
	}
	
}
