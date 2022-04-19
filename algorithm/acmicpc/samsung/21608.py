N = int(input())


dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
# 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
# 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
# 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.





student = []
for i in range(N**2):
    student.append(list(map(int, input().split()))) # 입력받는 것 꼭 기억
board = [[0 for _ in range(N)] for _ in range(N)]
ans = 0
for i in range(0, N**2):
    real_x = 0
    real_y = 0
    real_z = -1 # 핵심
    real_l = -1 # 핵심:
    for j in range(0, N):
        for k in range(0, N):
            if (board[j][k] == 0):
                love_cnt = 0
                zero_cnt = 0
                for m in range(0, 4):
                    nx = dx[m] + j
                    ny = dy[m] + k
                    if(nx >= N or nx < 0 or ny >= N or ny < 0): continue
                    if(board[nx][ny] == 0): zero_cnt +=1
                    if(board[nx][ny] == student[i][1] or board[nx][ny] == student[i][2] or  board[nx][ny] == student[i][3] or board[nx][ny] == student[i][4]): love_cnt+= 1

                if (real_l < love_cnt):
                    real_l = love_cnt
                    real_x = j
                    real_y = k
                    real_z = zero_cnt
                elif (real_l== love_cnt):
                    if(real_z < zero_cnt):
                        real_z = zero_cnt
                        real_x = j
                        real_y = k
                        real_l = love_cnt
    board[real_x][real_y] = student[i][0]

for i in range(0, N):
    for j in range(0, N):
        for k in range(0, N**2):
            if (board[i][j] == student[k][0]):
                cnt = 0
                for m in range(0, 4):
                    nx = dx[m] + i
                    ny = dy[m] + j
                    if (nx >= N or nx < 0 or ny >= N or ny < 0): continue
                    if (board[nx][ny] == student[k][1] or board[nx][ny] == student[k][2] or board[nx][ny] == student[k][3] or board[nx][ny] == student[k][4]): cnt += 1
        if (cnt == 1): ans+= 1
        if (cnt == 2): ans+= 10
        if (cnt == 3): ans += 100
        if (cnt == 4): ans += 1000
print(ans)





