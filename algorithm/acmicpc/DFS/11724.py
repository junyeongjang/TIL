import sys
sys.setrecursionlimit(10000)


def dfs(v):
  visited[v] = True
  for i in adjacency_list[v]:
    if not visited[i]:
      dfs(i)
  
N, M = map(int, input().split())
visited = [False] * (N + 1)
adjacency_list = [[] for _ in range(N + 1)]
count = 0


for _ in range(M):
  a,b = map(int, input().split())
  adjacency_list[a].append(b)
  adjacency_list[b].append(a) 
for j in range(1, N + 1):
    if not visited[j]:
        dfs(j)
        count += 1
print(count)
