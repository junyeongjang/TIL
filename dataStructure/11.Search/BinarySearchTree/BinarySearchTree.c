#include <stdio.h>
#include "BinaryTree2.h"
#include "BinarySearchTree.h"

typedef BTData	BSTData;

// BST의 생성 및 초기화
void BSTMakeAndInit(BTreeNode ** pRoot){
	*pRoot = NULL;
}

// 노드에 저장된 데이터 반환
BSTData BSTGetNodeData(BTreeNode * bst){
	return GetData(bst);
}

// BST를 대상으로 데이터 저장(노드의 생성과정 포함)
void BSTInsert(BTreeNode ** pRoot, BSTData data){
	BTreeNode * pNode = NULL; //부모 노드
 	BTreeNode * cNode = *pRoot; // 현재 노드
	BTreeNode * nNode = NULL; // 새로운 노드
	
	// 새로운 노드가 추가될 위치를 찾음
	while(cNode != NULL){
		if(data == GetData(cNode))
			return;
		pNode = cNode;

		if(GetData(cNode) > data)
			cNode = GetLeftSubTree(cNode);
		else 
			cNode = GetRightSubTree(cNode);

	}
	// 새 노드를 추가
	nNode = MakeBTreeNode();
	SetData(nNode, data);

	if(pNode !=NULL){
		if(data < GetData(pNode))
			MakeLeftSubTree(pNode, nNode);
		else 
			MakeRightSubTree(pNode, nNode);
	}
	else{
		*pRoot = nNode;
	}

}

// BST를 대상으로 데이터 탐색
BTreeNode * BSTSearch(BTreeNode * bst, BSTData target){
	BTreeNode * cNode = bst;
	BSTData cd;

	while(cNode != NULL ){
		cd = GetData(cNode);

		if(target == cd )
			return	cNode;
		else if(target < cd)
			cNode = GetLeftSubTree(cNode);
		else 
			cNode = GetRightSubTree(cNode); 
	}
	return NULL;
}
