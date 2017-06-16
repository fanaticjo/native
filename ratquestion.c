#include<iostream>
using namespace std;
#define m 4
#define n 4
int solvemaze(int grid[m][n],int x,int y);
int ispath(int grid[m][n],int r,int t)
{
    return solvemaze(grid,0,0);

}
int solvemaze(int grid[m][n],int x,int y)
{
    
    if(x>=0 && y>=0 && x<=m && y<=n)
    {
        if(grid[x][y]==9)
        {
            return 1;
        }
        if(grid[x][y]==1)
        {
            if(solvemaze(grid,x+1,y+1)==1)
               return 1;
            if(solvemaze(grid,x+1,y)==1)
            
                return 1;
            
            if(solvemaze(grid,x,y+1)==1)
            
                return 1;
            
        }
        grid[x][y]=0;
        return 0;
    }
    return 0;
}
int main()
{   
    int maze[4][4]={
                1, 1, 0,
                0, 1, 1,
                1, 9, 1,
                0, 0, 1,
        };
    
    int x=ispath(maze,3,3);
    cout<<x;
    return 0;
}