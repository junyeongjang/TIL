#include <stdio.h>
#include <stdlib.h>
#include "BinaryTree3.h"
#include "BinarySearchTree2.h"

void BSTMakeAndInit(BTreeNode ** pRoot)
{
	*pRoot = NULL;
}

BSTData BSTGetNodeData(BTreeNode * bst)
{
	return GetData(bst);
}

void BSTInsert(BTreeNode ** pRoot, BSTData data)
{
	BTreeNode * pNode = NULL;    // parent node
	BTreeNode * cNode = *pRoot;    // current node
	BTreeNode * nNode = NULL;    // new node

	// 새로운 노드가 추가될 위치를 찾는다.
	while(cNode != NULL)
	{
		if(data == GetData(cNode))
			return;    // 키의 중복을 허용하지 않음

		pNode = cNode;

		if(GetData(cNode) > data)
			cNode = GetLeftSubTree(cNode);
		else
			cNode = GetRightSubTree(cNode);
	}
	
	// pNode의 서브 노드에 추가할 새 노드의 생성
	nNode = MakeBTreeNode();    // 새 노드의 생성
	SetData(nNode, data);    // 새 노드에 데이터 저장

	// pNode의 서브 노드에 새 노드를 추가
	if(pNode != NULL)    // 새 노드가 루트 노드가 아니라면,
	{
		if(data < GetData(pNode))
			MakeLeftSubTree(pNode, nNode);
		else
			MakeRightSubTree(pNode, nNode);
	}
	else    // 새 노드가 루트 노드라면,
	{
		*pRoot = nNode;
	}
}

BTreeNode * BSTSearch(BTreeNode * bst, BSTData target)
{
	BTreeNode * cNode = bst;    // current node
	BSTData cd;    // current data

	while(cNode != NULL)
	{
		cd = GetData(cNode);

		if(target == cd)
			return cNode;
		else if(target < cd)
			cNode = GetLeftSubTree(cNode);
		else
			cNode = GetRightSubTree(cNode);
	}

	return NULL;
}

BTreeNode * BSTRemove(BTreeNode ** pRoot, BSTData target)
{	
	BTreeNode * pVRoot = MakeBTreeNode();

	BTreeNode * pNode = pVRoot; // 부모 노드
	BTreeNode * cNode = *pRoot; // 현재 노드
	BTreeNode * dNode; // 삭제할 노드

	// 루트 노드를 pVRoot가 가리키는 노드의 오른쪽 서브 노드가 되게 한다.
	ChangeRightSubTree(pVRoot, *pRoot);

	// 삭제할 노드 탐색	

	while(cNode != NULL && GetData(cNode) != target){
		pNode = cNode;

		if(target < GetData(cNode))
			cNode = GetLeftSubTree(cNode);
		else 
			cNode = GetRightSubTree(cNode);
	}

	if(cNode == NULL)  //삭제 대상이 없을 때 
		return NULL;

	dNode = cNode;

	// 1. 삭제할 노드가 단말 노드인 경우

	if(GetRightSubTree(dNode) == NULL && GetRightSubTree(dNode) == NULL){

		if(GetLeftSubTree(pNode) == dNode)
			RemoveLeftSubTree(pNode);
		else 
			RemoveRightSubTree(pNode);
	}
	// 2. 삭제할 노드가 자식이 1개 있는 경우
	else if(GetLeftSubTree(dNode) == NULL || GetRightSubTree(dNode)== NULL){

		BTreeNode * dcNode;

		if(GetLeftSubTree(dNode) != NULL)
			dcNode = GetLeftSubTree(dNode);
		else 
			dcNode = GetRightSubTree(dNode);
		
		if(GetLeftSubTree(pNode) == dNode)
			ChangeLeftSubTree(pNode, dcNode);
		else 
			ChangeRightSubTree(pNode, dcNode);
	}	
	// 3. 삭제할 노드가 자식이 2개 있는 경우
	else{

		BTreeNode * mNode = GetRightSubTree(dNode);
		BTreeNode * mpNode = dNode;
		int delData;

		while(GetLeftSubTree(mNode) != NULL){
			mpNode = mNode;
			mNode = GetLeftSubTree(mNode);
		}

		delData = GetData(dNode);
		SetData(dNode, GetData(mNode));

		if(GetLeftSubTree(mpNode) == mNode)
			ChangeLeftSubTree(mpNode, GetRightSubTree(mNode));
		else 
			ChangeRightSubTree(mpNode, GetRightSubTree(mNode));


	dNode = mNode;
	SetData(dNode, delData);
	}
	if(GetRightSubTree(pVRoot) != *pRoot)
		*pRoot = GetRightSubTree(pVRoot);
	
	free(pVRoot);
	return dNode;

}

void ShowIntData(int data)
{
	printf("%d ", data);
}

void BSTShowAll(BTreeNode * bst)
{
	InorderTraverse(bst, ShowIntData);
}