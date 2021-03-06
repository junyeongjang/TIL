# 9. 우선순위 큐와 힙
 
## 우선순위 큐 (Priority Queue)
- 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조.

## 우선순위 큐의 구현
1. 배열 기반 (삽입 위치를 찾기 위해 모든 데이터를 비교해야되는 단점) O(n)
2. 연결 리스트 기반 (삽입 위치를 찾기 위해 첫 번째 노드에서 시작해 마지막 노드에 저장된 데이터까지 비교해야되는 단점)  O(n)
3. 힙 기반 (가장 효율적 ) O(log2n) 

## 힙
- 힙은 '이진 트리'이되 '완전 이진 트리'이다
- max heap : 루트 노드로 올라갈수록 저장된 값이 커지는 완전 이진 트리
- min heap : 루트 노드로 올라갈수록 저장된 값이 작아지는 완전 이진 트리 

## 우선순위 큐와 힙
- 힙(Heap)의 구현은 곧 우선순위 큐의 구현이다.
- 하지만 우선순위 큐와 힙은 다르다 !
- 힙은 배열 또는 연결리스트로 만들 수 있는 완전 이진 트리, 우선순위 큐는 배열, 연결리스트, 힙으로 구현 가능한 자료구조이다.  

## 힙의 삽입과 삭제 

- 삽입 : 가장 마지막 위치에 저장 후, heapify 
- 삭제 : 루트 노드 반환 후, 마지막 노드를 루트 노드로 옮긴 후 heapify
 
## 우선순위 큐  ADT
1. void PQueueInit(PQueue * ppq, PriorityComp pc); 
  - 우선순위 큐의 초기화를 진행
  - 우선순위 큐 생성 후 제일 먼저 호출되어야 하는 함수.

2. int PQIsEmpty(PQueue * pqq);
  - 우선순위 큐가 빈 경우 TRUE, 아니면 FALSE(0)을 반환

3. void PEnqueue(PQueue* pqq, PQData data);
  - 우선순위 큐에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.
  
4. PQData PDequeue(PQueue * pqq);
  - 우선순위가 가장 높은 데이터를 삭제한다.
  - 삭제된 데이터는 반환된다.

  
