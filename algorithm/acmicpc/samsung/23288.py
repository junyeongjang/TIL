from collections import deque
dice = [
        [0,2,0],
        [4,1,3],
        [0,5,0],
        [0,6,0]
        ]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
def BFS(b_x, b_y):
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[b_x][b_y] = 1
    queue = deque([])
    queue.append([b_x, b_y])
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and board[b_x][b_y] == board[nx][ny]):
                visited[nx][ny] = 1
                queue.append((nx,ny))
                cnt+=1
    return cnt


def dice_move(dir):
    if(dir == 0): #동족
        temp  = dice[3][1]
        dice[3][1] = dice[1][2]
        dice[1][2] = dice[1][1]
        dice[1][1] = dice[1][0]
        dice[1][0] = temp
    elif(dir == 1) : #남쪽
        temp = dice [3][1]
        dice[3][1] = dice[2][1]
        dice[2][1] = dice[1][1]
        dice[1][1] = dice[0][1]
        dice[0][1] = temp
    elif(dir == 2) : #서쪽
        temp = dice[3][1]
        dice[3][1] = dice[1][0]
        dice[1][0] = dice[1][1]
        dice[1][1] = dice[1][2]
        dice[1][2] = temp
    elif(dir == 3) : #북쪽
        temp = dice[3][1]
        dice[3][1] = dice[0][1]
        dice[0][1] = dice[1][1]
        dice[1][1] = dice[2][1]
        dice[2][1] = temp
N, M, K = map(int, input().split())
board = []
res = 0
dice_status = {"x" : 0, "y" : 0, "dir":0, "num": 6}
for i in range(N):
    board.append(list(map(int, input().split())))

for i in range(K):
    dir = dice_status["dir"]
    num = dice_status["num"]
    x = dice_status["x"] + dx[dir]
    y = dice_status["y"] + dy[dir]

    # 1. 주사위 이동
    if (0 <= x < N and 0 <= y < M):
        dice_status["x"] = x
        dice_status["y"] = y
        dice_move(dir)
        dice_status["num"] = dice[3][1] # 주사위 아랫면
        num = dice_status["num"]
    else:
        dir += 2 # 반대방향으로 방향을 돌림
        dir = dir % 4
        x = dice_status["x"] + dx[dir]
        y = dice_status["y"] + dy[dir]
        dice_status["x"] = x
        dice_status["y"] = y
        dice_status["dir"] = dir
        dice_move(dir)
        dice_status["num"] = dice[3][1]  # 주사위 아랫면
        num = dice_status["num"]

    # 2. 점수 획득
    res += (board[x][y] * BFS(x,y))

    # 3. 방향 결정
    if(num > board[x][y]):
        dice_status["dir"] += 1
        dice_status["dir"] = dice_status["dir"] % 4
    elif(num < board[x][y]):
        if (dice_status["dir"] == 0):
            dice_status["dir"] = 3
        else:
            dice_status["dir"] = dice_status["dir"] - 1


print(res)
