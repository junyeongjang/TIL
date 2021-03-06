#include <stdio.h>
#include <stdlib.h>
#include "BinaryTree.h"

// typedef struct _bTreeNode{
//     BTData data;
//     struct _bTreeNode * left;
//     struct _bTreeNode * right;
// } BTreeNode;


BTreeNode * MakeBTreeNode(void){
    BTreeNode * nd = (BTreeNode*)malloc(sizeof(BTreeNode));
    nd->left = NULL;
    nd->right = NULL;
}

BTData GetData(BTreeNode * bt){
    return bt->data;
}
void SetData(BTreeNode * bt, BTData data){
    bt->data = data;
}

BTreeNode * GetLeftSubTree(BTreeNode * bt){
    return bt->left;
}
BTreeNode * GetRightSubTree(BTreeNode * bt){
    return bt->right;
}

void MakeLeftSubTree(BTreeNode * main, BTreeNode * sub){
    if(main->left != NULL) 
        free(main->left);
    
    main->left = sub;

}
void MakeRightSubTree(BTreeNode * main, BTreeNode * sub){
    if(main->right != NULL)
        free(main->right);
    
    main->right = sub;
}