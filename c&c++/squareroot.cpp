// A Simple C++ program to check if square root of a number
// under modulo p exists or not
#include<iostream>
using namespace std;
 
// Returns true if square root of n under modulo p exists
bool squareRootExists(int n, int p)
{
    n = n%p;
 
    // One by one check all numbers from 2 to p-1
    for (int x=2; x<p; x++)
        if ((x*x)%p == n)
            return true;
    return false;
}
 
// Driver program to test
int main()
{
   int p = 7;
   int n = 2;
   squareRootExists(n, p)? cout << "Yes": cout << "No";
   return 0;
}
