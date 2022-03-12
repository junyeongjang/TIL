n = int(input())
k = int(input())
arr = list(map(int, input().split()))

# sort
ans = 0
arr.sort()
m_arr = []
for i in range(0, len(arr) - 1):
    temp = arr[i + 1] - arr[i]
    m_arr.append(temp)

m_arr.sort(reverse=True)
for i in range(k-1, len(m_arr)):
  ans += m_arr[i]
print(ans)
