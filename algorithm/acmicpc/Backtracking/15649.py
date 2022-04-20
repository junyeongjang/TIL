N, M = map(int, input().split())
visited = [0] * 10
arr = [0] * 10

def dfs(depth):
    if(depth == M):
        for i in range(M):
            print(arr[i], end =' ')
        print()
    for i in range(1, N + 1):
        if(visited[i] == 1): continue
        visited[i] = 1
        arr[depth] = i
        dfs(depth+1)
        visited[i] = 0
dfs(0)

