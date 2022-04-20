import copy
N, M = map(int, input().split())

board = []
CCTV = []
cctv_cnt = 0
rotate_size = [4, 2, 4, 4, 1]
def update_board(dir, CCTV):
    global board
    dir = (dir % 4)
    if dir == 0:  # 남쪽
        for x in range(CCTV.get("x") + 1, N):
            if board[x][CCTV.get("y")] == 6: break
            board[x][CCTV.get("y")] = -1
    elif dir == 1: #서쪽
        for y in range(CCTV.get("y") - 1, -1, -1):
            if board[CCTV.get("x")][y] == 6: break
            board[CCTV.get("x")][y] = -1
    elif dir == 2 : #북
        for x in range(CCTV.get("x") - 1, -1, -1):
            if board[x][CCTV.get("y")] == 6: break
            board[x][CCTV.get("y")] = -1
    elif dir == 3 : # 동족
        for y in range(CCTV.get("y") + 1, M):
            if board[CCTV.get("x")][y] == 6: break
            board[CCTV.get("x")][y] = -1

ans = 100
def dfs(depth):
    global board
    global ans
    if(depth == cctv_cnt):
        candi = 0
        for i in range(N):
            for j in range(M):
                if board[i][j] == 0:
                    candi+=1
        if(ans > candi):
            ans = candi
        return
    back_up = []
    t = CCTV[depth].get("type")
    for dir in range(rotate_size[t]):
        back_up = copy.deepcopy(board)
        if t == 0:
            update_board(dir, CCTV[depth])
        elif t == 1:
            update_board(dir, CCTV[depth])
            update_board(dir + 2, CCTV[depth])
        elif t == 2:
            update_board(dir, CCTV[depth])
            update_board(dir + 1, CCTV[depth])
        elif t == 3:
            update_board(dir, CCTV[depth])
            update_board(dir + 1, CCTV[depth])
            update_board(dir + 2, CCTV[depth])
        elif t == 4:
            update_board(dir, CCTV[depth])
            update_board(dir + 1, CCTV[depth])
            update_board(dir + 2, CCTV[depth])
            update_board(dir + 3, CCTV[depth])
        # print(board)
        dfs(depth + 1)
        board = copy.deepcopy(back_up)

for i in range(N):
    board.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if  0 < board[i][j] < 6:
            CCTV.append({"x": i, "y": j, "type": board[i][j] - 1}) # x,y,cctv num
            cctv_cnt+=1
dfs(0)

print(ans)

