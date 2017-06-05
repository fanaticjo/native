/**Biswajit Mohapatra
   quicksort using interface dynamic method dispatch 
   low is for the front  element for the array 
   high is for the rear element of the array 
   last elemnet is taken as pivot and is compared from the starting element 
   (i starts from -1 )
   in the first half smallest elemnt are gathered and in the last half highest elemt are gathered comparing the last element 
   sort(arr,low,a-1) keeps the samllest element from arr[high]
   sort(arr,a+1,high) keeps the higher elemts from arr[high]
   and then recursively it is called */
import java.util.*;
import java.io.*;
interface sort
{
	int partition(int arr[],int low,int high);
	void print(int arr[]);
	void sort(int arr[],int low,int high);

}
public class quicksort implements sort
{   
	quicksort()
	{
		System.out.println("non parameterised constructor called");
	}
    @Override 
    public int  partition(int arr[],int low,int high)
    {
    	int x=arr[high];
    	int i=low-1;
    	for(int j=low;j<high;j++)
    	{
    		if(arr[j]<=x)
    		{  
    			 i=i+1;
    		     int temp=arr[i];
    		     arr[i]=arr[j];
    		     arr[j]=temp;
    		}
    	}
    	int temp=arr[i+1];
    	arr[i+1]=arr[high];
    	arr[high]=temp;
    	return i+1;
    }
    @Override
    public void sort(int arr[],int low,int high)
    {
    	if(low<high)
    	{
    		int a=partition(arr,low,high);
    		sort(arr,low,a-1);
    		sort(arr,a+1,high);
    	}
    }
    @Override
    public void print(int arr[])
    {   
    	System.out.println("\nthe sorted elements are");
    	for(int i=0;i<arr.length;i++)
    	{
    		System.out.print(arr[i]+"\t");
    	}
    }
    public static void main(String[] args) throws IOException {
    	quicksort dd=new quicksort();
    	int arr[];
    	int n;
    	Scanner sc=new Scanner(System.in);
    	DataInputStream dis=new DataInputStream(System.in);
    	System.out.println("enter the array size");
    	n=Integer.parseInt(dis.readLine());
    	arr=new int[n];
    	System.out.println("enter the elements u want to be sorted");
    	for(int i=0;i<n;i++)
    	{
    		arr[i]=sc.nextInt();
    	}
    	System.out.println("the elements u want to be sorted are of length "+arr.length+"\n");
    	for(int i : arr)
    	{
    		System.out.print(i+"\t");
    	}
    	dd.sort(arr,0,arr.length-1);
    	
    	dd.print(arr);

    }

}