/**insertion sort 
 Biswajit Mohapatra
 */
 import java.util.*;
 abstract class sort
 {
 	sort()
 	{
 		System.out.println("object constructed of abstract class ");
 	}
 	public abstract void sort(int arr[],int n);
 }
 public class insertionsort extends sort
 {
 	@Override
 	public  void sort(int arr[],int n)
 	{
 		
 		for(int i=1;i<n;i++)
 		{
 			int key=arr[i];
 			int j=i-1;
 			while(j>=0 && arr[j]>key)
 			{
 				arr[j+1]=arr[j];
 				j=j-1;
 			}
 			arr[j+1]=key;
 		}
 	}
 	protected static void print(int arr[])
 	{
 		for(int i=0;i<arr.length;i++)
 		{
 			System.out.println(arr[i]);
 		}
 	}
   public static void main(String[] args) {
   	
   	insertionsort dd=new insertionsort();int n;
   	Scanner sc=new Scanner(System.in);
   	System.out.println("enter the size");
   	n=sc.nextInt();
   	int arr[];
   	arr=new int[n];
   	System.out.println("enter the elements");
   	for(int i=0;i<n;i++)
   	{
   		arr[i]=sc.nextInt();
   	}
   	
   	System.out.println("sorted elements are");
   	dd.sort(arr,n);
   	print(arr);

   }
 }
