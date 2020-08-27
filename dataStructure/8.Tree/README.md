# 8. 트리 (tree)

## 트리
- 트리는 계층적 관계를 표현하는 자료구조
- 저장하고 꺼내는 것에 초점을 맞추는 것 보단 '표현'에 초점을 맞추자

## 트리의 용어 
- 노드(node) : 트리의 구성요소에 해당하는 A, B, C, D, E, F와 같은 요소
- 간선: (edge) : 노드와 노드를 연결하는 연결선
- 루트 노드(root node) : 트리 구조에서 최상위에 존재하는 노드
- 내부 노드(internal node): 단말 노드를 제외한 모든 노드 

## 이진 트리
- 아래 두 조건을 만족하면 이진 트리이다.
1. 루트 노드를 중심으로 두 갯의 서브 트리로 나뉘어진다.
2. 나뉘어진 두 서브 트리도 모두 이진 트리이어야 한다.

## 완전 이진 트리
- 모든 레벨이 꽉 찬 상태는 아니지만, 빈 틈 없이 노드가 채워진 이진 트리

## 포화 이진 트리
- 모든 레벨이 꽉 찬 이진트리

## 트리의 구현 
- 트리는 배열과 연결리스트 둘 다 구현 가능하다.
- 배열은 탐색이 용이하다는 장점, 연결리스트는 표현이  유연하다는 장점이 있다.
- 트리는 표현하는데 중점을 둔 자료구조임으로, 연결리스트로 구현하는게 더 바람직하다.
- 배열은 '힙(heap)'을 구현할 때 유용하다.

## 트리의 ADT
1. BTreeNode * MakeBTreeNode(void)
    - 이진 트리 노드를 생성하여 그 주소 값을 반환한다.
2. BTData GetData(BTreeNode * bt)
    - 노드에 저장된 데이터를 반환한다.
3. void SetData(BTreeNode * bt, BTData data)
    - 노드에 데이터를 저장한다.  data로 전달된 값을 저장한다.
4. BTreeNode * GetLeftSubTree(BTreeNode * bt)
    - 왼쪽 서브 트리의 주소 값을 반환한다.
5. BTreeNode * GetRightSubTree(BTreeNode * bt)
    - 오른쪽 서브 트리의 주소 값을 반환한다.
6. void MakeLeftSubTree(BTreeNode * main, BTreeNode * sub)
    -  왼쪽 서브 트리를 연결한다.
7. void MakeRightSubTree(BTreeNode * main, BTreeNode * sub)
    - 오른쪽 서브 트리를 연결한다.

## 트리의 순회(Traversal)
- 순회: 모든 노드를 방문하는 것 
- 노드의 방문순서에 따라 순회의 종류 나눌 수 있다.
    1. 전위 순회 (Preorder Traversal) 루트 노드를 먼저 방문 ! 
    2. 중위 순회 (Inorder Traversal) 루트 노드를 중간에 방문 !
    3. 후위 순회 (Postorder Traversal) 루트 노드를 마지막에 방문 ! 
