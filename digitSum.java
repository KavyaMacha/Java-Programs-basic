import java.util.*;  
public class digitSum  
{  
      
	public static int digSum(int num)  
	{  
		int sum = 0;  
		while (num > 0 || sum > 9)  
		{  
			if (num == 0)   
			{  
				num = sum;  
				sum = 0;  
			}  
 			sum = sum + num % 10;  
			num = num / 10;  
		}  
		return sum;  
}  

	public static void main(String args[])  
	{ 
		Scanner sc=new Scanner(System.in); 
		int num =sc.nextInt();  
		System.out.println(digSum(num));  
	}  
}  