#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void)
{
    int answer[4],a=0,b;//使用answer数组储存正确答案，a、b用于遍历数组进行操作
    srand((unsigned)time(NULL));//获取随机数组
    answer[a++]=1+rand()%9;
    while(a<4)
    {
        b=0;
        answer[a]=rand()%10;
        while(b<a)//保证各个数位数字不重复
            if(answer[b++]==answer[a])
            {
                a--;
                break;
            }
        a++;
    }
    int guess[4],num,t,p=0,q=0;//使用num储存所猜数，t（time）表示猜数次数，p表示数字数位均正确的个数，q表示数字正确数位不正确的个数
    printf("Please enter the number you guess:");
    for(t=0;p!=4;t++)//使用for循环记录达成多次猜数并记录猜数次数
    {
        p=0,q=0,b=3;
        scanf("%d",&num);
        while(b>=0)//除10取余将所猜数按数位储存进guess数组
        {
            guess[b--]=num%10;
            num/=10;
        }
        for(a=0;a<4;a++)//使用a、b遍历两个数组求p、q
        {
            for(b=0;b<4;b++)
            {
                if(guess[a]==answer[b])
                {
                    if(a==b)
                        p++;
                    else
                        q++;
                }
            }
        }
        if(p!=4)
        printf("\n%dA%dB.Try again:",p,q);
    }
    printf("\n\n4A0B.Congratulation!You win!");
    printf("\nThe time you guess:%d\n",t);
    return 0;
}
