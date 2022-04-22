from collections import deque
import copy

board = []
dx = [1,0,-1,0]
dy = [0,1,0,-1]
res = 0
rainbow_max = -1;

N, M = map(int, input().split())
for i in range(N):
    board.append(list(map(int, input().split())))


# 9는 빈칸
def down_baord():
    for i in range(N):
        for j in range(N-1, -1, -1):
            if (board[j][i] == 9):
                for k in range (j - 1, -1, -1):
                    if(board[k][i] == -1): break
                    if(board[k][i] != 9) :
                        board[j][i] = board[k][i]
                        board[k][i] = 9
                        break
def rotated_board() : # 시계 반대방향  90도로 회전
    global board
    temp = [[N for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            temp[i][j] = board[j][N-i-1]
    board = copy.deepcopy(temp)

def BFS(b_x,b_y, color):
    global max_block
    global rainbow_max
    queue = deque([])
    queue.append([b_x,b_y])
    visited.append([b_x,b_y])
    block = []
    block.append({"x": b_x, "y": b_y})
    rainbow_cnt = 0
    while queue:
        x, y = queue.popleft()
        for dir in range(4):
            nx = dx[dir] + x
            ny = dy[dir] + y
            if 0 <= nx < N and 0 <= ny < N:
                if(board[nx][ny] == -1): continue
                if [nx,ny] not in visited and (board[nx][ny] == color or board[nx][ny] == 0):
                    if board[nx][ny] == 0 : rainbow_cnt+=1
                    visited.append([nx,ny])
                    queue.append([nx,ny])
                    block.append({"x": nx, "y": ny})

    #핵심
    if(len(block) > len(max_block) or (len(block) == len(max_block) and rainbow_max < rainbow_cnt)
            or (len(block) == len(max_block) and rainbow_max == rainbow_cnt and block[0]["x"]> max_block[0]["x"])
            or (len(block) == len(max_block) and rainbow_max == rainbow_cnt and block[0]["x"] == max_block[0]["x"] and block[0]["y"] > max_block[0]["y"])):
        rainbow_max = rainbow_cnt
        max_block = copy.deepcopy(block)
    return len(block)

while True:
    max_block = []

    for color in range(1, M+1):
        visited = []
        for i in range(N):
            for j in range(N):
                if([i,j] not in visited and board[i][j] == color):
                    BFS(i,j, color)
    if (len(max_block) >= 2):
        res += len(max_block) * len(max_block)
        for i in range(len(max_block)):
            x = max_block[i]["x"]
            y = max_block[i]["y"]
            board[x][y] = 9
    else : break
    down_baord()
    rotated_board()
    down_baord()


print(res)


