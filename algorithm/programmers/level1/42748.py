def solution(array, commands):
    answer = []
    for comm in commands:
        i,j,k = comm
        new_arr = array[i-1 : j]
        new_arr.sort()
        answer.append(new_arr[k-1])
    return answer
