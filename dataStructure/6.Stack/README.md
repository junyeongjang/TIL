# 스택(stack)

- LIFO (후입선출)
- 먼저 들어간 것이 나중에 나온다 ! 


## 스택의 ADT


1. void stack_init(stack * pstack)
    - 스택 초기화 진행
    - 스택 생성 후 제일 먼저 호출되어야 하는 함수

2. int is_empty(stack * pstack)
    - 스택이 빈 경우 TRUE, 아니면 FALSE 반환

3. void push(stack * pstack, Data data)
    - 스택에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

4. Data pop(stack * pstack)
    - 마지막에 저장된 요소를 삭제
    - 삭제된 데이터는 반환됨

5. Data peek(stack * pstack)
    - 마지막에 저장된 요소를 반환하되 삭제는 하지 않음.


