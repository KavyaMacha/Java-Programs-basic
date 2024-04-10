/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.


Sample input:
6
3 0 0 2 0 4

Sample Output: 
10

Explanation: We can trap "3*2 units" of water between 3 and 2, 
"1 unit" on top of bar 2 and 
"3 units" between 2 and 4.
*/
import java.util.*;
class water
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int l=arr[0];
        int r=arr[n-1];
        int min=0;
        int sum=0;
        for(int i=1;i<=n-2;i++)
        {
            //l=arr[i];
            for(int j=0;j<i;j++)
            {
                l=Math.max(l,arr[i]);
            }
            //r=arr[i];
            for(int j=i;j<n;j++)
            {
                r=Math.max(r,arr[i]);
            }
            min=Math.min(l,r);
            
            sum+=min-arr[i];
        }
        System.out.println(sum);
        
     
      
        
    }
}
