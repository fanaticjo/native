#include<iostream>
using namespace std;
int cellcompete(int *cells,int day)
{
	for(int i=0;i<day;i++)
	{
		cells[-1]=0;
		cells[8]=0;
		int u[8];
		for(int j=-1;j<9;j++)
		{
			u[j]=cells[j];
		}
		for(int k=0;k<8;k++)
		{
			if(u[k-1]==u[k+1])
			{
				cells[k]=0;
			}
			else
			{
				cells[k]=1;
			}
		}
	}
	for(int l=0;l<8;l++)
	{
		cout<<cells[l]<<"\t";
	}
}
int main(){ //main function
int days,cells[]={1,0,0,0,0,1,0,0}; //array to pass through function
int *cellsptr=cells; //creating array values to pointer
cout<<"enter days:"; //for days
cin>>days; 
cout<<"n[1,0,0,0,0,1,0,0]n";
cellcompete(cellsptr, days); //passing to function
return 0;
}
