snake = [{"x":1,"y":1, "dir":0}]
dir_list = []
dx = [1,0,-1,0]
dy = [0,1,0,-1]
# 입력 받기
N = int(input())
K = int(input())
board = [[0 for _ in range(N+1)] for _ in range(N+1)]
for i in range(K):
    x, y = map(int, input().split())
    board[y][x] = 1 # 사과는 1번
L = int(input())
for i in range(L):
    n, d = input().split()
    dir_list.append({"sec": int(n), "dir" : d})
time = 0
idx = 0
def snake_move():
    dir = snake[0]["dir"]
    x = snake[0]["x"]
    y = snake[0]["y"]
    # dir %= 4
    nx = x + dx[dir]
    ny = y + dy[dir]
    if(0<nx<=N and 0<ny<=N):
        for i in range(len(snake)):
            if(nx == snake[i]["x"] and ny == snake[i]["y"]) : # 뱀 몸이랑 부딪히는 경우
                return 0

        snake_tail = {"x": snake[len(snake)-1]["x"], "y": snake[len(snake)-1]["y"]}
        for i in range(len(snake) - 1, 0, -1):
            snake[i]["x"] = snake[i - 1]["x"]
            snake[i]["y"] = snake[i - 1]["y"]
        if(board[nx][ny]==1): #사과를 만날 때
            snake.append(snake_tail)
            board[nx][ny] = 0 #사과를 먹는다
        # 뱀 이동
        snake[0]["x"] = nx
        snake[0]["y"] = ny
    else: # 벽이랑 부딪힘
        return 0
while True:
    time += 1 # 시간 증가
    if(snake_move() == 0) :
        break
    # 방향 변경
    if(idx < len(dir_list) and dir_list[idx]["sec"] == time):
        if(dir_list[idx]["dir"] == "L"): # 시계 반대
            if(snake[0]["dir"] == 0):
                snake[0]["dir"] = 3
            else:
                snake[0]["dir"] = (snake[0]["dir"] - 1) % 4
        elif(dir_list[idx]["dir"] == "D"): # 시계 방향
            snake[0]["dir"] = (snake[0]["dir"] + 1) % 4
        idx+=1
print(time)





