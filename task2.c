#include<stdio.h>

void BubbleSort(int array[], int length);

int main(void)
{
    int m,length;//变量length用于限定数组长度，m用于遍历数组进行赋值
    printf("Please enter the length of the array you want to sort:");
    scanf("%d",&length);//获取数组长度
    int array[length];//声明所需排列数组为array
    printf("Please enter the array(After entering each number you should press \"Enter\"):\n");
    for(m=0;m<length;m++)//获取数组
    scanf("%d",&array[m]);
    printf("The array you enter is:");//确认输入数组
    for(m=0;m<length;m++)
    printf("%d ",array[m]);
    printf("\n");
    BubbleSort(array,length);//使用改良的冒泡排序进行由小到大排列
    printf("Sort completely:");
    for(m=0;m<length;m++)//打印排序好的数组
    printf("%d ",array[m]);
    printf("\n");
    return 0;
}

void BubbleSort(int array[],int length)
{
    int a,l,r,end=0;//声明变量a表示数组通过冒泡排序法排序好的前n个数，l为数组末的array[l]用于规划每一次循环的起点，r、end均为标记,
    for(a=0;length>a;a=end)//标记o表示上一次排序中最后一次进行数字对调的位置，将其值赋给a，最大程度缩短遍历数组的长度
    {
        l=length-1;
        r=1;//给标记r赋初值1
        while(l>a)
	{
            if(array[l]<=array[l-1])
            {
                r=array[l-1];//此处顺便使用r完成数字对调
                array[l-1]=array[l];
                array[l]=r;
                r=0;//若执行if语句，即说明排序尚未完成，赋值r=0
                end=l;
            }
            l--;
        }
        if(r==1)//若某次循环未执行if语句，即说明排序已完成，r值仍为1，跳出排序循环
            break;
    }
}
