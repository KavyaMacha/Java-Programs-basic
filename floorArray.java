import java.util.*;
 
class floorArray {
    static int floorSearch(int arr[], int n, int x)
    {
        if (x >= arr[n - 1])
            return n - 1;
 
        if (x < arr[0])
            return -1;
        for (int i = 1; i < n; i++)
            if (arr[i] > x)
                return (i - 1);
 
        return -1;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
	Scanner sc=new Scanner(System.in);
	 int n = 7;
        int arr[] = new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=sc.nextInt();
	}
       
        int x =sc.nextInt();
        int index = floorSearch(arr, n, x);
        if (index == -1)
            System.out.print("-1");
        else
            System.out.print(index);
    }
}