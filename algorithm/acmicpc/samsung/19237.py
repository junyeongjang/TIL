N,M,K = map(int, input().split())
board =[]
spread = []
shark_dir = []
shark = []

dx = [-1,1,0,0]
dy = [0,0,-1,1]

spread = [[[0,0] for _ in range(N)] for _ in range(N)]

for _ in range(N):
    board.append(list(map(int, input().split())))
shark.append(list(map(int, input().split())))
for _ in range(M):
    for _ in range(4):
        shark_dir.append(list(map(int, input().split())))

def spread_smell():
    for i in range(N):
        for j in range(N):
            if(board[i][j] > 0):
                spread[i][j] = [board[i][j], K]

def spread_minus():
    for i in range(N):
        for j in range(N):
            if(spread[i][j][0] > 0):
                spread[i][j][1] = spread[i][j][1] - 1
            if(spread[i][j][1] == 0):
                spread[i][j][0] = 0
def check_shark():
    cnt = 0
    for i in range(N):
        for j in range(N):
            if(board[i][j]>0): cnt+=1
    if(cnt > 1):
        return 1
    else:
        return 0

def move_shark():
    visited = []
    for i in range(N):
        for j in range(N):
            if(board[i][j] > 0 and [i,j] not in visited): #상어를 찾는다
                # print_board()
                # print()
                flag = 4
                for k in range(4):
                    shark_num = board[i][j] - 1
                    now_dir = shark[0][shark_num] -1
                    num = ((board[i][j] * 4) - 4) + now_dir
                    x = i + dx[shark_dir[num][k] -1]
                    y = j + dy[shark_dir[num][k] -1]
                    if (0 <= x < N and 0 <= y < N):
                        if(spread[x][y][1] > 0): flag -=1
                    else:
                        flag -=1
                if(flag == 0): #4 방향 전부 빈칸이 아님 우선 순위로 가야함
                    for k in range(4):
                        shark_num = board[i][j] - 1
                        now_dir = shark[0][shark_num] - 1
                        num = ((board[i][j] * 4) - 4) + now_dir
                        x = i + dx[shark_dir[num][k] - 1]
                        y = j + dy[shark_dir[num][k] - 1]
                        if (0 <= x < N and 0 <= y < N and board[i][j] == spread[x][y][0] and spread[x][y][1] > 0) :
                            if(board[x][y] > 0 and  board[x][y] < board[i][j]): # 이미 가는 곳에 더 작은 수가 있다면
                                board[i][j] = 0 # 기존 상어를 지운다.
                                break;
                            else: #상어를 이동시킨다.
                                visited.append([x, y])
                                board[x][y] = board[i][j]
                                board[i][j] = 0
                                shark[0][shark_num] = shark_dir[num][k]
                                break
                elif(flag > 0): #이동할 좌표가 있다면
                    for k in range(4):
                        shark_num = board[i][j] - 1
                        now_dir = shark[0][shark_num] - 1
                        num = ((board[i][j] * 4) - 4) + now_dir
                        # print(shark_dir[num][k] -1)
                        x = i + dx[shark_dir[num][k] - 1]
                        y = j + dy[shark_dir[num][k] - 1]
                        # print(shark_dir[num])
                        if (0 <= x < N and 0 <= y < N and spread[x][y][1] <= 0):
                            if (board[x][y] > 0 and board[x][y] < board[i][j]):  # 이미 가는 곳에 더 작은 수가 있다면
                                board[i][j] = 0  # 기존 상어를 지운다.
                                break
                            else:  # 상어를 이동시킨다.
                                visited.append([x, y])
                                board[x][y] = board[i][j]
                                board[i][j] = 0
                                shark[0][shark_num] = shark_dir[num][k]
                                break
ans = 0

spread_smell()
while True:
    if(ans> 1000):
        print(-1)
        break
    move_shark()
    spread_minus()
    spread_smell()
    if(check_shark() == 0):
        print(ans+1)
        break
    ans+=1







