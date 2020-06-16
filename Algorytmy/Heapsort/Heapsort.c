#include<stdio.h>
#include<math.h>
void heapify (int size, int i,int *tab)
{
        int largest, temp;
        int l =2*i, r=(2*i)+1;
        if(l <= size && tab[l] > tab[i])
                largest = l;
        else largest = i;
        if(r <= size && tab[r] > tab[largest])
                largest = r;
        if(largest != i)
        {
                temp = tab[largest];
                tab[largest] = tab[i];
                tab[i] = temp;
                heapify(size,largest,tab);
        }
}
void buildHeap(int n, int *tab)
{
        for(int i= n/2; i > 0; i--)
        {
                heapify(n,i,tab);
        }
}
void heapSort(int n, int *tab)
{
        int temp;
        buildHeap(n,tab);
        for(int i = n; i > 1; i--)
        {
                temp = tab[i];
                tab[i] = tab[1];
                tab[1] = temp;
                n--;
                heapify(n,1,tab);
        }
}

int main()
{
int size = 0;
int temp;
int zak1, zak2;
FILE *fp;
fp  = fopen("dane.txt","r");
if(fp == NULL)
{
        printf("File Error!\n");

}
while(!feof(fp))
{
        fscanf(fp,"%d",&temp);
        size++;
}
rewind(fp);
int *tab = malloc((size) * sizeof(int));
temp = 1;
while(!feof(fp))
{
        fscanf(fp,"%d",&tab[temp]);
        temp++;
}
fclose(fp);
size--;
heapSort(size,tab);
for(int i = 1; i <= size; i++)
        printf("%d\n",tab[i]);

FILE *writef = fopen("output.txt","w");
if(writef == NULL)
{
        printf("File Error!\n");
        return 1;
}
for(int i = 1; i <=size; i++)
        fprintf(writef,"%d \n",tab[i]);
fclose(writef);
free(tab);
return 0;
}


