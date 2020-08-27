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

	// ���ο� ��尡 �߰��� ��ġ�� ã�´�.
	while(cNode != NULL)
	{
		if(data == GetData(cNode))
			return;    // Ű�� �ߺ��� ������� ����

		pNode = cNode;

		if(GetData(cNode) > data)
			cNode = GetLeftSubTree(cNode);
		else
			cNode = GetRightSubTree(cNode);
	}
	
	// pNode�� ���� ��忡 �߰��� �� ����� ����
	nNode = MakeBTreeNode();    // �� ����� ����
	SetData(nNode, data);    // �� ��忡 ������ ����

	// pNode�� ���� ��忡 �� ��带 �߰�
	if(pNode != NULL)    // �� ��尡 ��Ʈ ��尡 �ƴ϶��,
	{
		if(data < GetData(pNode))
			MakeLeftSubTree(pNode, nNode);
		else
			MakeRightSubTree(pNode, nNode);
	}
	else    // �� ��尡 ��Ʈ �����,
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

	BTreeNode * pNode = pVRoot; // �θ� ���
	BTreeNode * cNode = *pRoot; // ���� ���
	BTreeNode * dNode; // ������ ���

	// ��Ʈ ��带 pVRoot�� ����Ű�� ����� ������ ���� ��尡 �ǰ� �Ѵ�.
	ChangeRightSubTree(pVRoot, *pRoot);

	// ������ ��� Ž��	

	while(cNode != NULL && GetData(cNode) != target){
		pNode = cNode;

		if(target < GetData(cNode))
			cNode = GetLeftSubTree(cNode);
		else 
			cNode = GetRightSubTree(cNode);
	}

	if(cNode == NULL)  //���� ����� ���� �� 
		return NULL;

	dNode = cNode;

	// 1. ������ ��尡 �ܸ� ����� ���

	if(GetRightSubTree(dNode) == NULL && GetRightSubTree(dNode) == NULL){

		if(GetLeftSubTree(pNode) == dNode)
			RemoveLeftSubTree(pNode);
		else 
			RemoveRightSubTree(pNode);
	}
	// 2. ������ ��尡 �ڽ��� 1�� �ִ� ���
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
	// 3. ������ ��尡 �ڽ��� 2�� �ִ� ���
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