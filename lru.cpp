#include<iostream>
using namespace std;
int lrumiss(int max_cache,int *pages,int len)
{
	int miss=0;
	int cache[max_cache];
	for (int i = 0; i < max_cache; i++)
	{
		cache[i]=0x8778;
	}
	for(int i=0;i<len;i++)
	{
		for(int j=0;j<max_cache;j++)
		{
			if(pages[i]==cache[j])
			{
				for(int k=i;k<max_cache;k++)
				{
					cache[i]=cache[i+1];

				}
				cache[max_cache-1]=pages[i];
				break;
			}
		else if(j==(max_cache-1))
		{
			for(int l=0;l<max_cache;l++)
			{
				cache[l]=cache[l+1];

			}
			cache[max_cache-1]=pages[i];
			miss++;
		}

		}
	}
	return miss;
}
int main()
{
	int pages[]={7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0};
	int *cells=pages;
	int miss=lrumiss(3,cells,16);
    cout<<miss;
}