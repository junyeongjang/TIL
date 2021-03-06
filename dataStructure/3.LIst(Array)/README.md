# 리스트(list)

## 추상 자료형(Abstract Data Type) 

- 구체적인 기능의 완성과정을 언급하지 않고, 순수하게 기능이 무엇인지를 나열한 것 
### ex) 리스트의 자료구조 ADT 
 1) void ListInit(List * plist) 
    - 초기화할 리스트의 주소 값을 인자로 전달한다.
        - 리스트 생성 후 제일 먼저 호출되어야 하는 함수이다.,
 2) void LInset(List * plist, LData) 
        - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
 3) int LFirst(List * plist, LData * pdata);
        - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
        - 데이터의 참조를 위한 초기화가 진행된다.
        - 참조 성공 시 TRUE(1) , 실패 시 FALSE(0) 반환
 4) int LNext(List * plist, LData * pdata);
        - 참조된 데이터의 다음 데이터가 pdata가 가리키는 메모리에 저장된다.
        - 순차적인 참조를 위해서 반복 호출이 가능하다.
        - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
        - 참조 성공 시 TRUE(1), 실패 시 FALSE(0) 반환

 5) LData LRemove(List * plist);
    - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
        - 삭제된 데이터는 반환된다.
        - 마지막 반환 데이터를 삭제함으로 연이은 반복 호출을 허용하지 않는다.

 6) int LCount(List * plist)
    - 리스트에 저장되어 있는 데이터의 수를 반환한다.


## 배열 기반 리스트 장단점

### 장점 
- 데이터의 참조과 쉽다.
- 인덱스 값을 기준으로 어디든 한 번에 참조가 가능하다.

### 단점 
- 배열의 길이가 초기에 결정되어야한다. 변경이 불가능하다.
- 삭제의 과정에서 데이터의 이동(복사)가 매우 빈번히 일어난다.

