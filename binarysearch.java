import java.util.*;
interface print 
{
	public void print(int arr[],int n);
}
interface sort extends print
{
	public boolean search(int arr[],int x,int n);
}
abstract class bsort implements sort
{
   bsort()
   {
   	System.out.println("object constructed of abstract class");
   }
   @Override
   public void print(int arr[],int n)
   {
   	 for(int i=0;i<n;i++)
   	 {
   	 	System.out.print(arr[i]+"\t");
   	 }
   }
   @Override
   public boolean search(int arr[],int x,int n)
   {
   	int low=0;
   	int high=n;
   	while(low<high)
   	{
   		int m=(high+low)/2;
   		if(arr[m]==x)
   		{
   			return true;
   		}
   		else if(arr[m]<=x)
   		{
   			low=m+1;
   		}
   		else 
   		{
   			high=m-1;
   		}
   	}
   	return false;
   }
}
public class binarysearch extends bsort
{
	binarysearch()
	{
		System.out.println("i am at bsearch constructor");

	}
	public static void main(String[] args) {
		binarysearch dd=new binarysearch();
		int n;
		Scanner ss=new Scanner(System.in);
		System.out.println("enter the range");
		n=ss.nextInt();
		int arr[]=new int[n];
        System.out.println("enter the array elements");
        for(int i=0;i<n;i++)
        {
        	arr[i]=ss.nextInt();
        }
        System.out.println("the elements are ");
        dd.print(arr,n);
       
        while(true)
        {   
        	int key;
        	System.out.println("\nenter the key to be searched enter 00 to quit ");
        	key=ss.nextInt();
        	if(dd.search(arr,key,n)==true)
        	{
        	System.out.println("element found ");
        	}
        	else
       		 {
        	  System.out.println("element nt found ");
       		 }
            if(key==00)
            {
            	System.exit(0);
            }
        }

        
	}
	
}