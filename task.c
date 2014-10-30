#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void)
{
    int m[4],a=0,b;
    srand((unsigned)time(NULL));
    m[a++]=1+rand()%9;
    while(a<4)
    {
        b=0;
        m[a]=rand()%10;
        while(b<a)
            if(m[b++]==m[a])
            {
                a--;
                break;
            }
        a++;
    }
    int n[4],c,t,p=0,q=0;
    printf("Please enter the number you guess:");
    for(t=0;p!=4;t++)
    {
        p=0,q=0,b=3;
        scanf("%d",&c);
        while(b>=0)
        {
            n[b--]=c%10;
            c/=10;
        }
        for(a=0;a<4;a++)
        {
            for(b=0;b<4;b++)
            {
                if(n[a]==m[b])
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
