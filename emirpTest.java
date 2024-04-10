import java.util.*;
class emi
{
	int n;
	int prime(int n)
	{
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				c++;
			}
		}
		if(c==1)
		{
			return 1;	
		}	
		else
		{
			return 0;	
		}
		
	}
	
	
	
}
class emirpTest
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=prime(n);
		
	}
}