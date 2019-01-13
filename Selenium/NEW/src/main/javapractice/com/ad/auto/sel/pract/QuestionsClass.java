package com.ad.auto.sel.pract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuestionsClass {

	public static void main(String args[]){
		
		System.out.println("=============================================================================");
		System.out.println("=======================1. Swapping without third variable ===================");
		int a=10;
		int b=20;
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		a = a*b;
		b = a/b;
		a = a/b;
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		a = a^b;
		b = a^b;
		a = a^b;
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		System.out.println("=============================================================================");
		System.out.println("=======================2. Swapping string without third variable ===================");
		
		String str1 = "Hello";
		String str2 = "Cricket";
		
		str1 = str1 + str2;
		str2 = str1.substring(0, str1.length()-str2.length());
		str1 = str1.substring(str2.length());
		
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		
		System.out.println("=============================================================================");
		System.out.println("=======================3. Reverse string ===================");
		
		StringBuilder sb = new StringBuilder(str1);
		System.out.println("Reverse is = "+sb.reverse());
		
		String str3 = "";
		for(int i=str1.length()-1; i>=0; i--){
			
			str3 = str3+str1.charAt(i);
			
		}
		System.out.println("Reverse is str3 = "+str3);
		
		System.out.println("=============================================================================");
		System.out.println("=======================4. Missing number in array ===================");
		
		int []nums = {1,2,4,5,6};
		int sumOfArray = 0;
		int sumOfSeries = 0;
		for(int i=0; i<nums.length; i++){
			
			sumOfArray = sumOfArray + nums[i];
			
		}
		System.out.println("Sum of array is = "+ sumOfArray);
		
		int maxNum = nums[nums.length-1];
		for(int i=1; i<=maxNum; i++){
			
			sumOfSeries = sumOfSeries + i;
			
		}
		System.out.println("Sum of series is = "+ sumOfSeries);
		
		System.out.println("Missing number is = "+ (sumOfSeries-sumOfArray));

		System.out.println("=============================================================================");
		System.out.println("=======================5. Remove junk chars ===================");
		
		String junkStr = "&^&^&^123Hello456&*&*";
		System.out.println("Removed junk chars from the string "+junkStr.replaceAll("[^a-zA-Z0-9]", "")); // i.e. replace all except [a-zA-Z0-9]
		
		System.out.println("=============================================================================");
		System.out.println("=======================6. Reverse number ===================");
		
		int num= 34589;
		int revNum = 0;
		while(num>0){
			
			revNum = revNum * 10 + num%10;
			num = num/10;
			
		}
		System.out.println("Reverse of the number is "+revNum);

		System.out.println("=============================================================================");
		System.out.println("=======================7. Max/Min number in an array ===================");
		
		int numbs[] = {45, 56,12,2,67,89,1809};
		int min = numbs[0];
		int max = numbs[0];
		
		for(int i=1; i<numbs.length; i++){
			
			if(numbs[i] > max){
				
				max = numbs[i];
				
			}else if(numbs[i] < min){
				
				min = numbs[i];
				
			}
			
		}
		System.out.println("Max number is "+max);
		System.out.println("Minimum number is "+min);
		
		System.out.println("=============================================================================");
		System.out.println("=======================8. Find duplicate number in an array ===================");
		
		int num1[] = {12, 11, 13, 14, 90, 92, 37, 12, 90};
		
		// A - using loops
		for(int i=0; i<num1.length-1; i++){
			
			for(int j=i+1; j<=num1.length-1; j++){
				
				if(num1[i] == num1[j]){
					
					System.out.println("Duplicate item is "+num1[i]);
					
				}
				
			}
			
		}
		
		// B - using Set
		Set<Integer> s = new HashSet<Integer>();
		
		for(int i=0; i<num1.length; i++){
			
			if(s.add(num1[i]) == false){
				
				System.out.println("Duplicate number is "+num1[i]);
				
			}
			
		}
		
		// C - using HashMap
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(Integer n: num1){
			Integer count = m.get(n);
			if(count == null){
				
				m.put(n, 1);
				
			}else {
				
				m.put(n, ++count);
				
			}
			
		}
		
		Set<Entry<Integer, Integer>> es = m.entrySet();
		for(Entry<Integer, Integer> es1: es){
			
			if(es1.getValue()>1){
				
				System.out.println("Duplicate element is "+es1.getKey());
				
			}
			
		}
		
		System.out.println("=============================================================================");
		System.out.println("=======================9. Generate Binay of the Decimal number ===================");
		
		int dNumber = 25;
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int dNum = dNumber;
		while(dNum>0){
			
			al.add(dNum%2);
			dNum = dNum/2;
			
		}
		
		int len = al.size();
		System.out.print("Binary of the given value "+dNumber+" is ");
		for(int i=len-1; i>=0; i--){
			
			System.out.print(al.get(i));
			
		}
		
		System.out.println("=============================================================================");
		System.out.println("=======================10. Generate Decimal value of the Binary number ===================");
		
		Integer bNumber = 1010;
		int dNumber1 = 0;
		
		for(int i=0; i<bNumber.SIZE; i++){
						
			for(int j=0; j<bNumber; j++){
				
				
				
			}
			
		}
		
		System.out.println("=============================================================================");
		System.out.println("=======================10. Ternary operator ===================");
		
		int a1 = 90;
		int t;
		
		t = (a1 == 90) ? 1 : -1;
		
		System.out.println("Ternary operator's result is : "+t);
		

	}
		
	
	
}
