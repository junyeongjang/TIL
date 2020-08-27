# 10. 정렬(Sorting)

## 오름차순 & 내림차순
- 오름차순: 값이 클 수록 뒤에 위치시키는 방법
- 내림차순: 값이 작을 수록 뒤에 위치시키는 방법

## 버블 정렬 (Bubble Sort)
- 앞에서부터 순서대로 비교하고 교환하는 일련의 과정이 거품이 일어나는 모습에 비유되어 버블 정렬
- ex) 버블 정렬 예시 
    1) 3 -> 2 -> 4 -> 1  
    2) 2 -> 3 -> 4 -> 1 (swap(2,3))
    3) 2 -> 3 -> 1 -> 4 (swap(4,1))
    4) 2 -> 3 -> 1 -> 4 (swap(4,1))
    5) 2 -> 1 -> 3 -> 4 (swap(3,1))
    6) 1 -> 2 -> 3 -> 4 (swap(2,1))
![bubble sort](https://i1.faceprep.in/fp/articles/img/71784_1580551129.png)

## 버블 정렬의 성능 평가
- 정렬 알고리즘의 성능은 '비교연산' 과 '대입연산' 근거로 판단한다.
- 버블 정렬의 비교 연산 (n-1) + (n-2) + (n-3) + ... + 2 +. 1 : 등차 수열의 합 n^2 -n/2 즉, O(n^2);
- 대입 연산 O(n^2) 


## 선택 정렬 (Selection Sort)
- 정렬순서상 가장 앞서는 것을 선택하여 가장 왼쪽으로 이동시키고, 원래 그 자리에 있던 데이터는 빈 자리에 가져다 놓는다.
- 선택 정렬 예시  (swap과정만 작성)
    1) 3 -> 2 -> 4 -> 1
    2) 1 -> 2 -> 4 -> 3
    3) 1 -> 2 -> 3 -> 4  
![selection sort](https://www.w3resource.com/w3r_images/selection-short.png)

## 선택 정렬의 성능 평가
- 비교 연산은 버블 정렬과 동일 ( 등차 수열의 합 ) O(n^2)
- 대입 연산은 O(n)

## 삽입 정렬 (Insertion Sort)
- 정렬 안된 부분에 있는 데이터를 정렬 된 부분의 특정 위치에 '삽입'해 가면서 정렬을 진행하는 알고리즘
![insertion sort ](https://media.geeksforgeeks.org/wp-content/uploads/insertionsort.png)

## 삽입 정렬의 성능 평가
- 비교, 대입 모두 O(n^2)

## 힙 정렬 (Heap Sort)
- 자료구조 Heap을 이용한 정렬
- O(nlog2n)

## 합병 정렬 (Merge Sort)
- divide and conquer (분할 정복) 해결
- 병합 부분 구현이 좀 까다로웠음
- O(nlog2n)

## 퀵 정렬 (Quick Sort)

- 피봇(pivot)을 중심으로 한 정렬(합병 정렬과 유사함)
- 최악의 경우는 O(n^2)이지만, 최선의 경우는 O(nlog2n)이고 , 동일한 빅-오를 갖느 다른 정렬 알고리즘 중에서 평균적으로 가장 빠른 정렬속도를 보인다.

## 종합적인 성능 평가
![big-o notaion](https://tomysispblog.files.wordpress.com/2018/04/screen-shot-2018-04-03-at-14-26-13.png)
