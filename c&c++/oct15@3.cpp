#include<bits/stdc++.h>
using namespace std;

#define ll long long int
int main()
{
    ll t,k,j;
    double n,compute[725];
    for(int i=0;i<360;i++)
    {
        k=i/60;
        compute[i]=30*k;
    }
    j=360;
    for(int i=360;i>0;i--)
    {
        k=i/60;
        j++;
        compute[j]=30*k;
    }
    for(int i=0;i<12;i++)
        printf("%lf\n",compute[60*i]);
    return 0;
}
