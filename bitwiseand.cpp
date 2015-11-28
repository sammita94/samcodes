// A Simple C++ program to compute sum of bitwise AND 
// of all pairs
#include <bits/stdc++.h>
using namespace std;

// Returns value of "arr[0] & arr[1] + arr[0] & arr[2] + 
// ... arr[i] & arr[j] + ..... arr[n-2] & arr[n-1]"
int pairAndSum(int arr[], int n)
{
    int ans = 0;  // Initialize result

    // Consider all pairs (arr[i], arr[j) such that
    // i < j
    for (int i = 0; i < n; i++)
        for (int j = i+1; j < n; j++)
           ans += arr[i] & arr[j];

    return ans;
}

// Driver program to test above function
int main()
{
    int arr[] = {5, 10, 15};
    int n = sizeof(arr) / sizeof (arr[0]);
    cout << pairAndSum(arr, n) << endl;
    return 0;
}
