package commonutils;

public class JustLikeThat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long years=5;
		long fix=100000;
		long sum=0;
		long sum1=0;
		long percentage=8;
		for(int i=1;i<=years;i++){
			sum=sum+fix;
			sum1=sum+(sum*percentage)/100;
			System.out.println(i+"---->"+sum1);
		}
		
		System.out.println("-----"+sum1);
		

	}

}
