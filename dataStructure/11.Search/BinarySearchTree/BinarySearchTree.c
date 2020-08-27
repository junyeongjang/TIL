#include <stdio.h>
#include "BinaryTree2.h"
#include "BinarySearchTree.h"

typedef BTData	BSTData;

// BST�� ���� �� �ʱ�ȭ
void BSTMakeAndInit(BTreeNode ** pRoot){
	*pRoot = NULL;
}

// ��忡 ����� ������ ��ȯ
BSTData BSTGetNodeData(BTreeNode * bst){
	return GetData(bst);
}

// BST�� ������� ������ ����(����� �������� ����)
void BSTInsert(BTreeNode ** pRoot, BSTData data){
	BTreeNode * pNode = NULL; //�θ� ���
 	BTreeNode * cNode = *pRoot; // ���� ���
	BTreeNode * nNode = NULL; // ���ο� ���
	
	// ���ο� ��尡 �߰��� ��ġ�� ã��
	while(cNode != NULL){
		if(data == GetData(cNode))
			return;
		pNode = cNode;

		if(GetData(cNode) > data)
			cNode = GetLeftSubTree(cNode);
		else 
			cNode = GetRightSubTree(cNode);

	}
	// �� ��带 �߰�
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

// BST�� ������� ������ Ž��
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
