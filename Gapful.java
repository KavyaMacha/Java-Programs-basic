import java.util.*;
class Gapful
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    
	    String str=sc.next();
	    int n=Integer.parseInt(str);
	    int l=str.length();
	    int f=Integer.parseInt(""+str.charAt(0)+str.charAt(l-1));
	    
	    if(n>=100 && n%f==0)
	    {
	        System.out.println("Yes");
	    }
	    else
	    {
	         System.out.println("No");
	    }
	    
	}
}
