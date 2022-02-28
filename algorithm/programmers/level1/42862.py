def solution(n, lost, reserve):
    answer = 0

    n = [1 for x in range(n)]

    for l in lost:
        n[l - 1] -= 1
    for r in reserve:
        n[r - 1] += 1

    for i in range(len(n)):
        if n[i] == 0:
            if i - 1 >= 0 and n[i - 1] == 2:
                n[i] = 1
                n[i - 1] = 1
            elif i + 1 < len(n) and n[i + 1] == 2:
                n[i] = 1
                n[i + 1] = 1
    for i in n:
        if(i > 0):
            answer+=1
    return answer
