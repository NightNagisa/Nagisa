#include<stdio.h>

void BubbleSort(int array[], int length);

int main(void)
{
    int m,n;
    printf("Please enter the length of the array you want to sort:");
    scanf("%d",&n);
    int array[n];
    printf("Please enter the array(After entering each number you should press \"Enter\"):\n");
    for(m=0;m<n;m++)
    scanf("%d",&array[m]);
    for(m=0;m<n;m++)
    printf("%d ",array[m]);
    BubbleSort(array,n);
    printf("Sort completely:");
    for(m=0;m<n;m++)
    printf("%d ",array[m]);
    printf("\n");
    return 0;
}

void BubbleSort(int array[],int length)
{
    int a,l,r,o=0;
    length-=1;
    for(a=0;length>a;a=o)
    {
        l=length;
        r=1;
        while(l>a)
	{
            if(array[l]<=array[l-1])
            {
                r=array[l-1];
                array[l-1]=array[l];
                array[l]=r;
                r=0;
                o=l;
            }
            l--;
        }
        if(r==1)
            break;
    }
}
