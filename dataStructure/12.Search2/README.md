# 12. 탐색2(search)


## 균형 잡힌 이진 트리

- 이진 탐색 트리의 탐색 연산은 O(log2n)의 시간 복잡도를 가짐
- 균형이 맞지 않을수록 O(n)에 가까운 시간 복잡도를 보임
- 이러한 단점을 해결한 트리를 가리켜 '균형 잡힌 이진 트리'라고 한다.

- 균형 잡힌 이진 트리의 종류
    1. AVL 트리
    2. 2-3 트리
    3. 2-3-4 트리
    4. Red - Black 트리
    5. B 트리
    
## AVL 트리
- 노드가 추가될 때, 그리고 삭제될 때 트리의 균형상태를 파악해서 스스로 그 구조를 변경하여 균형을 잡는 트리
- 균형의 정도를 표현하기 위해 '균형 인수 (Balance Factor)'라는 것을 사용
- 균형 인수 = 왼쪽 서브 트리의 높이 - 오른쪽 서브 트리의 높이

![Balance Factor](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile26.uf.tistory.com%2Fimage%2F2318554C5753F647082511)

- 군형 인수의 절대값이 2 이상인 경우에 트리 구조의 재조정(리밸런싱)함

## 리밸런싱(rebalancing)
- AVL 트리의 균형이 무너지는 상태는 4가지로 정리 된다.
- 자세한 리밸런싱은 [유튜브 강의](https://www.youtube.com/watch?v=7m94k2Qhg68) 참조

1. LL 회전 

- 균형 인수가 +2인 노드를 균형 인수가 +1인 노드의 오른쪽 자식 노드가 되게 한다.
- ChangeLeft(+2인 노드, GetRightSubTree(+1인 노드)) -> ChangeRightSubTree(+1인 노드, +2인 노드)
![LLlocation](https://www.codingeek.com/wp-content/uploads/2017/04/LL.png)


2. RR 회전

- LL 회전의 반대방향
- ![RRLocation](https://raw.githubusercontent.com/HebleV/valet_parking/master/images/avl_left_rotation.jpg)

3. LR 회전 
- 부분 RR 회전 후 LL 회전

4. RL 회전
- 부분 LL 회전 후 RR 회전
