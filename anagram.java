import java.util.*;
class anagram
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		s1.toLowerCase();
		String s2=sc.next();
		s2.toLowerCase();
		char ch1[]=s1.toCharArray();
		char ch2[]=s2.toCharArray();
		Arrays.sort(ch1);
		
		Arrays.sort(ch2);
		
		
		if(Arrays.equals(ch1,ch2))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}




		
		
		