#include <iostream>
#include <queue>
using namespace std;
string mat[1001];
int check[1001][1001];
int fired[1001][1001];
int r,c;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
queue<pair<int, int>> Q1;
queue<pair<int, int>> Q2;


inline void swap(int &a, int &b){
    int t = a; a = b; b = t;
}

void quickSort(int A[], int low, int high) {
    if(low >= high) return; // base condition

    // divide process
    int i = low-1, j = low;
    int&pivot = A[high];
    for (; j < high; ++j) {
        if ( A[j] < pivot)
            swap(A[++i], A[j]);
    }
    swap(A[++i], pivot);
    for(int i=0;i<8;i++){
        cout<<A[i] << " ";
    }
    cout<<"\n";
    // conquer process
    quickSort(A, low, i-1);
    quickSort(A, i+1, high);
}

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    
    int A[] = {6,3,8,2,1,5,7,4};
    quickSort(A, 0, 7);
    for(int i=0;i<7;i++){
        cout<<A[i] << "\n";
    }
 
    return 0;
}
