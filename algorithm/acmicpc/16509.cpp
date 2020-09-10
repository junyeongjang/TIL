#include<iostream>
#include<vector>
#include<queue>
#include<string.h>
using namespace std;
int dx[10] = {-3,-3,-2, 2, 3, 3, 2, -2};
int dy[10] = {-2, 2, 3, 3, 2, -2, -3, -3};


int r1,c1; //출발 지점
int r2,c2; //도착 지점
int check[10][10];
struct point{
    int x,y;
};

int checkFunc(int index,int x,int y){
    if(index==0 || index==7){
        for(int i=1;i<=2;i++){
            if(x+i == r2 && y+i == c2) return 0;
        }
    }
    if(index==1 || index == 2){
        for(int i=1;i<=2;i++){
            if(x+i == r2 && y-i == c2) return 0;
        }
    }
    if(index == 3 || index == 4){
        for(int i=1;i<=2;i++){
            if(x-i == r2 && y-i == c2) return 0;
        }
    }
    
    if(index==5 || index == 6){
        for(int i=1;i<=2;i++){
            if(x-i == r2 && y+i == c2) return 0;
        }
    }
    return 1;
}


int BFS(){
    queue<point> q;
    q.push({r1,c1});
    while(!q.empty()){
        int x = q.front().x, y = q.front().y;
        q.pop();
        if(x==r2 && y==c2){
            return check[x][y];
        }
        for(int i=0;i<8;i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx<0 || ny<0 || nx>=10 || ny>=9) continue;
            if(check[nx][ny]) continue;
            if(checkFunc(i, nx, ny)){
                q.push({nx,ny});
                check[nx][ny] = check[x][y]+1;
            }
        }
    }
    return -1;
}

void sol(){
    cin>>r1>>c1;
    cin>>r2>>c2;
    int ans = BFS();
    cout<<ans;
    
}

int main(void){
    sol();
    return 0;
}
