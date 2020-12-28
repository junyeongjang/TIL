#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int dx[5] = {1,0,-1,0};
int dy[5] = {0,1,0,-1};
struct point{
    int x1,y1;
    int x2,y2;
    int cnt;
};
int n,m; // 세로 n, 가로 m
char map[21][21]; // 20 x 20
int check[21][21][21][21];

queue<point> q;

void input_data(){
    char c; // 임시 변수
    vector<pair<int, int>> temp_v;
    cin>>n>>m;
    for(int i=0;i<n;i++){ //데이터 입력
        for(int j=0;j<m;j++){
            cin>>c;
            map[i][j] = c;
            if(c == 'o') temp_v.push_back(make_pair(i, j));
        }
    }
    q.push({temp_v[0].first, temp_v[0].second, temp_v[1].first, temp_v[1].second, 0}); //큐에 동전 좌표 삽입
}

int check_coin(int x1, int y1, int x2, int y2)
{
    if((x1 >= n || x1 < 0 || y1 >= m || y1 < 0) && (x2 >= n || x2 < 0 || y2 >= m || y2 < 0))
        return 0; //동전 2개 다 떨어짐
    if(x1 >= n || x1 < 0 || y1 >= m || y1 < 0)
        return 1; // 1번 동전만 떨어짐
    if(x2 >= n || x2 < 0 || y2 >= m || y2 < 0)
        return 2; //2번 동전만 떨어짐
    return -1;
}

int bfs(){
    point cur;
    while(!q.empty()){
        cur = q.front();
        int x1 = cur.x1; int y1 = cur.y1;
        int x2 = cur.x2; int y2 = cur.y2;
        check[x1][y1][x2][y2] = true;
        q.pop();
        
        if(cur.cnt > 10) break;
        
        for(int i=0;i<4;i++){
            int nx1 = dx[i] + x1; int ny1 = dy[i] + y1; //같은 방향으로 움직여야함
            int nx2 = dx[i] + x2; int ny2 = dy[i] + y2; //같은 방향으로 움직여야함
            int temp = (check_coin(nx1, ny1, nx2, ny2));
            if(temp == 0) continue; // 동전 2개 떨어짐
            if(temp == 1 || temp == 2){ //동전 1개 떨어짐
                if(cur.cnt+1> 10)
                    return -1;
                return cur.cnt+1;
            }
            if(map[nx1][ny1] == '#' && map[nx2][ny2] == '#') continue;
            if(map[nx1][ny1] == '#'){
                nx1 = cur.x1;
                ny1 = cur.y1;
            }
            if(map[nx2][ny2] == '#'){
                nx2 = cur.x2;
                ny2 = cur.y2;
            }
            if(!check[nx1][ny1][nx2][ny2]){
                q.push({nx1, ny1, nx2, ny2, cur.cnt + 1});
                check[nx1][ny1][nx2][ny2] = true;
            }
        }
    }
    return -1;
}

int main(int argc, const char * argv[]) {
    input_data();
    cout<<bfs();
}
