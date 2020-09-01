#include<iostream>
#include<vector>
#include<queue>
using namespace std;
struct robot{
    int x,y,d;
};
int dx[15] = {0,0,1,-1};
int dy[15] = {1,-1,0,0};

int N,M;
int board[101][101];
int check[101][101][5];
vector<robot> v; //v[0] 출발위치, v[1] 도착 위치

void inputData(){
    int x,y,d;
    cin>>N>>M;
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>board[i][j];
        }
    }

    for(int i=0;i<2;i++){
        cin>>x>>y>>d;
        v.push_back({x,y,d});
    }
}


void bfs(){
    queue<robot> q;
    q.push({v[0].x-1, v[0].y-1, v[0].d-1});
//    check[v[0].x][v[0].y][v[0].d] = 1;
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int d = q.front().d;
        q.pop();
        if(x==v[1].x-1 && y==v[1].y-1 && d==v[1].d-1){
            cout<<check[x][y][d]<<"\n";
          return;
        }
        for(int i=1;i<=3;i++){
            int nx = x + (dx[d] * i);
            int ny = y + (dy[d] * i);
            if(nx<0 || ny<0 || nx>=N || ny>=M) break;
            if(board[nx][ny]) break;
            if(check[nx][ny][d]) continue;
            q.push({nx,ny,d});
            check[nx][ny][d] = check[x][y][d] +1 ;
        }
        for(int i=0;i<4;i++){
            if(i==d) continue;
            if(check[x][y][i]) continue;
            int k = (i+d)%4 == 1 ? 2 : 1;
            q.push({x,y,i});
            check[x][y][i] = check[x][y][d] + k;
        }
    }
}





int main(void){
    inputData();
    bfs();

    return 0;
}
