
typedef int Data;

typedef struct _node{
    Data data;
    struct _node * next;
    struct _node * prev;
} Node;


typedef struct _dbDLinkedList{
    Node * head;
    Node * tail;
    Node * cur;
    int numOfData;
} DBLinkedList;

typedef DBLinkedList List;

void list_init(List * plist);
void l_insert(List * plist, Data data);

int l_first(List * plist, Data * data);
int l_next(List * plist, Data * data);

Data l_remove(List * plist);
int LCount(List * plist);