#define HEAP_LEN 100

typedef char HData;
typedef int Priority;

typedef struct _heapElem{
    Priority pr;
    HData data;
} HeapElem;

typedef struct _heap{
    int numOfData;
    HeapElem heapArr[HEAP_LEN];
} Heap;

void HeapInit(Heap * ph);
int HIsEmpty(Heap * ph);

void HInsert(Heap * ph, HData data, Priority pr);
HData HDelete(Heap * ph);