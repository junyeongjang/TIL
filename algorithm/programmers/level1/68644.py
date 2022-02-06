def solution(numbers):
    temp = set()
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            num = numbers[i] + numbers[j]
            temp.add(num)
    answer = list(temp)
    answer.sort()
    return answer
