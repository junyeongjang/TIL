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

void BFS(){
    while(!Q1.empty()){
        auto cur = Q1.front(); Q1.pop();
        for(int k=0;k<4;k++){
            int nx = dx[k] + cur.first;
            int ny = dy[k] + cur.second;
            if(nx>=r || nx<0 || ny>=c || ny<0) continue;
            if(fired[nx][ny] >= 0 || mat[nx][ny] == '#') continue;
            fired[nx][ny] = fired[cur.first][cur.second] + 1;
            Q1.push({nx,ny});
        }
    }
}

void BFS2(){
    while(!Q2.empty()){
        auto cur = Q2.front(); Q2.pop();
        for(int k=0;k<4;k++){
            int nx = dx[k] + cur.first;
            int ny = dy[k] + cur.second;
            if(nx>=r || nx<0 || ny>=c || ny<0){
                cout<<check[cur.first][cur.second] + 1;
                return ;
            }
            if(check[nx][ny] >= 0 || mat[nx][ny] == '#') continue;
            if(fired[nx][ny] != -1 && fired[nx][ny] <= check[cur.first][cur.second] + 1) continue;
            check[nx][ny] = check[cur.first][cur.second] + 1;
            Q2.push({nx,ny});
        }
    }
    cout << "IMPOSSIBLE";
}

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>r>>c;
    
    for(int i = 0; i < r; i++){
      fill(fired[i], fired[i]+c, -1);
      fill(check[i], check[i]+c, -1);
    }

    for(int i = 0; i < r; i++)
        cin >> mat[i];
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(mat[i][j] == 'F'){
                Q1.push({i,j});
                fired[i][j] = 0;
            }
            if(mat[i][j] == 'J'){
                Q2.push({i,j});
                check[j][j] = 0;
            }
        }
    }
    
    BFS();
    BFS2();
 
    
    return 0;
}
