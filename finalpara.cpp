#include<iostream>
#include<stack>
#include<string>
using namespace std;
int check(char ch[],int len)
{
	int c1=0;
	stack<char> s;
	for(int c=0;c<1;c++)
	{
	   bool check=true;
	   string s1=ch;
	   for(int i=0;i<s1.length();i++)
	   {
	   	if(s1[i]=='(')
	   	{
	   		s.push(s1[i]);
	   		continue;
	   	}
	   	if(s.empty())
	   	{   
	   		check=false;
	   		break;
	   	}
	   	if(s1[i]==')' && s.top()=='(')
	   	{   
	   		c1++;
	   		s.pop();
	   	}
	   	else
	   	{
	   		check=false;
	   		break;
	   	}
	   }
	   if(check && s.empty())
	   {
	   	return c1;
	   }
	   else
	   {
	   	return -1;
	   }
	}
}

int main()
{   int n;
	cout<<"enter the size ";
	cin>>n;
	char ch[n];
	gets(ch);
	int c=sizeof(ch)/sizeof(ch[0])-1;;
	cout<<c<<endl;;
	cout<<check(ch,c);
}