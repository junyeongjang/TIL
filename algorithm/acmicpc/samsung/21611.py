from copy import deepcopy
import sys
from collections import deque
input = sys.stdin.readline
ball = []
fire = []
N, M = map(int, input().split())
for _ in range(N):
    ball.append(list(map(int, input().split())))
for _ in range(M):
    fire.append(list(map(int, input().split())))
dx = [0,1,0,-1]
dy = [-1,0,1,0]
line_size = 0
shark_x = int((N+1)/2) - 1
shark_y = int((N+1)/2) - 1
f_dx = [-1,1,0,0]
f_dy = [0,0,-1,1]
ans = 0

def print_map(board):
    for i in range(N):
        print(board[i])
    print()

def fire_ball(idx):
    d = fire[idx][0] -1
    n = fire[idx][1]
    for i in range(1, n+1):
        x = (i * f_dx[d]) + shark_x
        y = (i * f_dy[d]) + shark_y
        if (0 <= x < N and 0 <= y):
            ball[x][y] = 0 # 블리자드로 빈 공간


def two_to_one():
    global line_size
    cx = int(N//2)
    cy = int(N//2)
    d = 0
    loop_count = 2
    for dist in range(1, N):
        if (dist == N-1):
            loop_count = 3
        for i in range(loop_count):
            for j in range(dist):
                cx += dx[d]
                cy += dy[d]
                new_board.append(ball[cx][cy])
                line_size+=1
            d =  (d+1) % 4



def one_to_two():
    cx = int(N//2)
    cy = int(N//2)
    d = 0
    loop_count = 2
    num = 0
    cur = 0
    for dist in range(1, N):
        if (dist == N-1):
            loop_count = 3
        for i in range(loop_count):
            for j in range(dist):
                cx += dx[d]
                cy += dy[d]
                if (cur < line_size):
                    ball[cx][cy] = new_board[cur]
                    cur+=1
                else:
                    ball[cx][cy] = 0
            d =  (d+1) % 4


def fill_ball():
    queue= deque([])
    l = len(new_board)
    for i in range(l):
        if(new_board[i] == 0):
            queue.append(i)
        elif (queue and new_board[i] > 0):
            x = queue.popleft()
            queue.append(i)
            new_board[x] = new_board[i]
            new_board[i] = 0


def four_ball():
    global ans
    queue = deque([])
    cnt = 1
    flag = 0
    l = len(new_board)
    for i in range(l- 1):
        if(new_board[i] == new_board[i+1] and new_board[i] != 0):
            cnt += 1
        elif((new_board[i] != new_board[i+1] and new_board[i] != 0)):
            if(cnt >= 4):
                for j in range(cnt):
                    flag = 1
                    ans += new_board[i - j]
                    new_board[i-j] = 0
            cnt = 1
    if (cnt >= 4):
        for j in range(cnt):
            flag = 1
            ans += new_board[i - j -1]
            new_board[i - j] = 0
    if(flag == 1): return 1
    else: return 0




def ball_group():
    A = 1
    queue = deque([])
    copy_board = []
    for i in range(len(new_board) - 1):
        if (new_board[i] == new_board[i+1]):
            A+=1
        elif (new_board[i] != new_board[i + 1]):
            queue.append(A)
            queue.append(new_board[i])
            A=1
    for i in range(len(new_board)):
        if(queue):
            new_board[i] = queue.popleft()
        else:
            new_board[i] = 0
    while(queue):
        new_board.append(queue.popleft())
for i in range(M):
    new_board = []
    line_size = 0
    fire_ball(i)
    two_to_one()
    # print(new_board)
    fill_ball()
    while(four_ball()):
        fill_ball()
    fill_ball()
    ball_group()
    # print(new_board)
    one_to_two()

    # print_map(ball)

print(ans)

