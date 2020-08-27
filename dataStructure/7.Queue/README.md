# 큐(Queue)

- FIFO (선입선출)
- 먼저 들어간 데이터가 먼저 나온다 !
- ex) 터널, 극장 표 예매처, 고무 호스


## 큐의 ADT


1. void queue_init(queue * pq)
    - 큐 초기화 진행
    - 큐 생성 후 제일 먼저 호출되어야 하는 함수

2. int is_empty(queue * pq)
    - 큐가 빈 경우 TRUE, 아니면 FALSE 반환

3. void enqueue(queue * pq, Data data)
    - 큐에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

4. Data dequeue(queue * pq)
    - 저장순서가 가장 앞선 데이터를 삭제한다.
    - 삭제된 데이터는 반환됨

5. Data peek(queue * pq)
    - 저장 순서가 가장 앞선 데이터를 반환하되 삭제 하지 않는다.


