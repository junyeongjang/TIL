import math
from collections import  deque

dx = [1,0,-1,0]
dy = [0,1,0,-1]

ans = 0
queue = deque([])
board = []

N, L, R = map(int, input().split())
for _ in range(N):
    board.append(list(map(int, input().split())))

def BFS(b_x, b_y):
    temp = board[b_x][b_y]
    cnt = 1
    temp_list = []
    visited[b_x][b_y] = 1
    queue.append([b_x, b_y])
    temp_list.append([b_x,b_y])
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(0 <= nx <N and 0<= ny < N):
                if visited[nx][ny] == 0:
                    if(L<= abs(board[x][y] - board[nx][ny]) <= R):
                        temp+=board[nx][ny]
                        visited[nx][ny] = 1
                        queue.append([nx,ny])
                        temp_list.append([nx,ny])
                        cnt += 1
    if(cnt > 1):
        for i in range(len(temp_list)):
            x,y = temp_list[i]
            board[x][y] = math.trunc(temp/cnt)
        return 1
    else:
        return 0
while True:
    visited = [[0 for _ in range(N)] for _ in range(N)]
    flag = 0
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                flag += BFS(i,j)
    if (flag == 0): break
    ans+=1


print(ans)

