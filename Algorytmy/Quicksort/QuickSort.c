#include<stdio.h>
#include <time.h>
int partition(int *tab, int p , int r)
{
	int x = tab[r];
	int i = p - 1;
	for(int j = p; j <= r; j++)
	{
		if(tab[j] <= x)
		{
			i = i+1;
			int pom = tab[j];
			tab[j] = tab[i];
		tab[i] = pom;
		}
	}
	
	if(i < r)
		return i;
	else
		return i-1;
	
}
void quickSort(int *tab, int p, int r,int c)
{
	if(p < r)
	{
		if(r-1+1 >= c) 
		{
			int q = partition(tab, p, r);
			quickSort(tab,p,q,c);
			quickSort(tab,q+1,r,c);
		}
	}
}
void InsertionSort(int *tab,int n) {
		if( n <= 1)
			return;
		InsertionSort(tab,n-1);
		int last = tab[n-1];
		int j = n - 2;
		
		while(j >= 0 && tab[j] > last)
		{
				tab[j+1] = tab[j];
				j--;
		}
		tab[j+1] = last;
}
int main(){
	clock_t t;
	double time_taken;
	int n,c;
	int los;
	printf("Podaj stala c:\n");
	scanf("%d",&c);
	printf("Podaj dlugosc tablicy:\n");
	scanf("%d",&n);
	int *tab1 = malloc(n*sizeof(int));
	int *tab2 = malloc(n*sizeof(int));
	int *tab1_2 = malloc(n*sizeof(int));
	int *tab2_2 = malloc(n*sizeof(int));
	srand(time(NULL));
	for(int i = 0; i < n; i++)
	{
		los = rand()%100+1;
		tab1[i] = los;
		tab1_2[i] = los;
	}
	for(int i = 0; i < n; i++)
	{
		tab2[i] = n-i;
		tab2_2[i] = n - i;
	}
	t= clock();
	quickSort(tab1,0,n-1,c);
	InsertionSort(tab1,n);
	t= clock() - t;
	time_taken = ((double)t)/CLOCKS_PER_SEC;
	printf("Broken quickSort with InsertionSort with random numbers took %f to execute \n",time_taken);
	t= clock();
	quickSort(tab2,0,n-1,c);
	InsertionSort(tab2,n);
	t= clock() - t;
	time_taken = ((double)t)/CLOCKS_PER_SEC;
	printf("Brokenken quickSort with InsertionSort with numbers that are getting smaller took % f to execute \n",time_taken);
	c = 0;
	t= clock();
	quickSort(tab1_2,0,n-1,c);
	t= clock() - t;
	time_taken = ((double)t)/CLOCKS_PER_SEC;
	printf("Normal quicksort with random data took %f to execute \n",time_taken);
	t= clock();
	quickSort(tab2_2,0,n-1,c);
	t= clock() - t;
	time_taken = ((double)t)/CLOCKS_PER_SEC;
	printf("Normal quicksort with numbers that are getting smaller  took %f to execute \n",time_taken);
	/*for(int i = 0; i < n; i++)
	{
		printf("%d ",tab[i]);
	}*/
	free(tab1);
	free(tab2);
	free(tab1_2);
	free(tab2_2);
	return 0;
}