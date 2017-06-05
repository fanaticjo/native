import java.util.*;
interface check 
{
	public boolean check(int grid[][],int n,int key);
    public void rowsort(int grid[][],int row,int col);
    public void colsort(int grid[][],int row,int col);
    public void display(int grid[][],int row,int col);
}
public class sortarray implements check
{
	@Override
	public boolean check(int grid[][],int n,int key)
	{
		//xint i,j;
		int i=0,j=n-1;
		while(i<n && j>=0)
		{
			if(grid[i][j]==key)
			{
				return true;
			}
			if(grid[i][j]>key)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
		return false;
	}
	@Override
	public void rowsort(int arr[][],int row,int col)
	{
        for(int i=0;i<row;i++) //rows sort 
	    {
			for(int j=0;j<col;j++)
			{
				for (int k =(j + 1); k < col; ++k)
            	{
                	if (arr[i][j] > arr[i][k])
                	{
                    int a = arr[i][j];
                    arr[i][j] = arr[i][k];
                    arr[i][k] = a;
                	}
            	}
			}
		}
	}
	@Override
	public void colsort(int arr[][],int row,int col)
	{
		for(int j=0;j<col;j++)
		{
			for(int i=0;i<row;i++)
			{
				for(int k=(i+1);k<row;k++)
				{
					if(arr[i][j]>arr[k][j])
					{
 						int a=arr[i][j];
 						arr[i][j]=arr[k][j];
 						arr[k][j]=a;
					}
				}
			}
		}
	}
	@Override
	public void display(int arr[][],int row,int col)
	{
        System.out.println("display the matrix");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
			System.out.print(arr[i][j]+"\t");
			}
		 	System.out.println("\n");
		}
	}
public static void main(String[] args) {
	int row,col;
	sortarray dd=new sortarray();
	Scanner ss=new Scanner(System.in);
	System.out.println("enter the row size ");
	row=ss.nextInt();
	System.out.println("enter the col size");
	col=ss.nextInt();
    System.out.println("enter the matrix");

	int arr[][]=new int[row][col];
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			arr[i][j]=ss.nextInt();
		}
	}
    int ch;
    System.out.println("1.display the matrix  ");
    System.out.println("2.sort the matrix in ascending order row wise");
   	System.out.println("3.sort the matrix in ascending order col wise");
   	System.out.println("4.break from loop and please sort both in asc and des u will get a suprise ");
   	
    while(true)
    {   ch=ss.nextInt();
    	switch(ch)
    	{
    	case 1: dd.display(arr,row,col);
    	        break;
    	case 2: dd.rowsort(arr,row,col);

    	       break;
    	case 3: dd.colsort(arr,row,col);
    	        break;
        default: System.out.println("wrong choice");
                 break;
    	}
    	if(ch==4)
    	{
    		break;
    	}
	}
		int key;
         System.out.println("enter the key to be found in matrix ");
         key=ss.nextInt();
         if(dd.check(arr,row,key))
         {
         	System.out.println("element found");
         }
         else
         {
         	System.out.println("element  nt found");
         }
}
}