def count_board():
    global res
    for i in range(100):
        for j in range(100):
            if(board[i][j] == 1 and board[i+1][j] == 1 and board[i][j+1] == 1 and board[i+1][j+1] == 1):
                res+=1
N = int(input())
board_size = 101
board = [[0 for _ in range(board_size)] for _ in range(board_size)]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
res = 0

for _ in range(N):
    x,y,d,n = map(int, input().split())
    board[x][y] = 1
    temp = [d]
    dir_list = [d]
    for _ in range(n + 1):
        for k in dir_list:
            x += dx[k]
            y += dy[k]
            board[x][y] = 1
        dir_list = [(i + 1) % 4 for i in temp]
        dir_list.reverse()
        temp = temp + dir_list
count_board()

print(res)

