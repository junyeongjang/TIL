import copy
N,M,K = map(int,input().split())
dx = [1,0,-1,0]
dy = [0,1,0,-1]

board = []
mirror_board = []
T = []

def rotate_board(idx, dir):
    if(dir == 0): # 0이면 시계 방향
        temp = board[idx][M-1]
        for i in range(M-1, -1, -1):
            board[idx][i] = board[idx][i-1]
        board[idx][0] = temp
    elif(dir == 1): # 1이면 반시계 방향
        temp = board[idx][0]
        for i in range(M-1):
            board[idx][i] = board[idx][i+1]
        board[idx][M-1] = temp

def cal_circle():
    flag = 0
    global board
    mirror_board = copy.deepcopy(board) # 이 부분이 핵심 
    for i in range(N):
        for j in range(M):
            if(board[i][j] == 0): continue
            temp = board[i][j]
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if(M>ny  and N> nx >=0  and temp == board[nx][ny]):
                    flag = 1
                    mirror_board[i][j] = 0
                    mirror_board[nx][ny] = 0
    board = copy.deepcopy(mirror_board)
    if(flag == 0):
        temp = 0
        cnt = 0
        for i in range(N):
            for j in range(M):
                if (board[i][j] == 0): continue
                temp+= board[i][j]
                cnt+=1
        if(cnt == 0): return 0
        for i in range(N):
            for j in range(M):
                if (board[i][j] == 0): continue
                if (board[i][j] < (temp / cnt)): board[i][j] = board[i][j] + 1
                elif (board[i][j] > (temp / cnt)): board[i][j] = board[i][j] - 1

def print_board(board):
    for i in range(N):
        print(board[i])
    print()


for _ in range(N):
    board.append(list(map(int, input().split())))
for _ in range(K):
    T.append(list(map(int, input().split())))

ans = 0
for i in range(K): # 번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
    x = T[i][0]
    d = T[i][1]
    k = T[i][2]
    for j in range(N):
        if((j+1) == 1 ): continue
        if((j+1) % x == 0):
            for _ in range(k):
                rotate_board(j, d)
    # print("rotate")
    # print(T[i])
    # print_board(board)
    cal_circle()
    # print("cal")
    # print_board(board)


for i in range(N):
    for j in range(M):
        if(board[i][j] <= 0): continue
        ans+=board[i][j]

print(ans)


