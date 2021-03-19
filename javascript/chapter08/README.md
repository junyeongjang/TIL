# chapter08
## 배열

- push는 배열 자체를 수정하고, concat은 새 배열을 반환한다.

- 배열의 처음이나 끝에서 요소 하나를 추가하거나 제거
    1. push와 pop은 각각 배열의 끝에 요소에 추가하거나 제거함.
    2. shift와 unshift는 각각 배열의 처음에 요소를 제거하거나 추가함.
```
const arr = ["b", "c" ,"d"];
arr.push("e"); //arr = ["b", "c", "d", "e"]
arr.pop(); // ["b","c","d"];
arr.unshift("a");// ["a","b","c","d"];
arr.shitf(); // "a". arr은 이제 ["b", "c", "d"];
```

- 배열의 끝에 여러 요소 추가 
    1. concat 메서드는 배열의 끝에 여러 요소를 추가한 사본을 반환
    2. concat은 제공받은 배열을 한 번만 분해한다.
```
const arr = [1,2,3];
arr.concat(4,5,6); // [1,2,3,4,5,6];
arr.concat([4,5,6]); // [1,2,3,4,5,6];
arr.concat([4,5], 6);// [1,2,3,4,5,6]
arr.concat([4,[5,6]]); //[1,2,3,4,[5,6]]
//arr는 바뀌지 않음
```

- 배열 일부를 가져옴
    1. 배열의 일부만 가져올 때는 slice 메서드를 사용함    
    2. 첫 번째 매개변수는 어디서부터 가져올지를, 두 번째 매개변수는 어디까지 가져올지를 지정
    3. 두 번째 매개변수를 생략하면 배열의 마지막까지 반환한다.
    4. 음수 인덱스를 쓰면 배열의 끝에서 부터 요소를 센다.
    
```
const arr = [1,2,3,4,5];
arr.slice(3);
arr.slice(2,4);
arr.slice(-2);
arr.slice(1,-2);
arr.slice(-2,-1);
//arr는 바뀌지 않는다.
```

- 임의의 위치에 요소 추가하거나 제거하기
    1. splice는 배열을 자유롭게 수정할 수 있다.
    2. 첫 번째 매개변수는 수정을 시작할 인덱스이고, 두 번째 매개변수는 제거할 요소 숫자이다.
    3. 세 번째 매개변수는 복사를 끝낼 위치이다.
    
```
const arr = [1,5,7];
arr.splice(1,0,2,3,4); //[], arr은 이제 [1,2,3,4,5,6,7]이다.
arr.splice(5,0,6); // [], arr은 이제 [1,2,3,4,5,6,7]이다.
arr.splice(1,2);// [2,3], arr은 이제 [1,4,5,6,7]이다.
arr.splice(2,1,'a', 'b'); [5], arr은 이제 [1,4,'a','b',6,7]이다.
```

- 배열 안에서 요소 교체하기
    1. copyWithin은 ES6에서 도입한 새 메서드이다.  배열 요소를 복사해서 다른 위치에 붙여놓고, 기존의 요소를 덮어쓴다.
    2. 첫 번째 매개변수 복사한 요소를 붙여넣을 위치
    3. 두 번째 매개변수는 복사를 시작할 위치, 세 번째 매개변수는 복사를 끝낼 위치

```
const arr =[1,2,3,4];
arr.copyWithin(1,2); // arr은 이제 [1,3,4,4]이다.
arr.copyWithin(2,0,2); // arr은 이제 [1,3,1,3]이다.
arr.copyWithin(0,-3,-1);  // arr은 이제 [3,1,1,3]이다.
```

- 특정 값으로 배열을 채우기
    1. ES6에서 도입한 새 메서드 fill, 이 메서드는 정해진 값으로 배열을 채움

```
const arr = new Array(5).fill(1); //
arr.fill("a"); // arr = ["a","a","a","a","a"];
arr.fill("b", "1")// arr =  ["a","b","b","b","b"];

```
- 배열의 정렬, 역순 정렬
    1. sort, reverse를 사용해 배열을 정렬함.
    2. 객체가 들어있는 배열을 정렬함수를 통해 정렬 할 수 있다.
```
const arr = [1,2,3,4,5];
arr.reverse();
arr.sort();
```
```
const arr = [{name: "Suzanne}, {name: "Jim"}, {name: "Trevor"}, {name: "Amanda"}];
arr.sort();//arr는 바뀌지 않는다.
arr.sort((a,b) => a.name > b.name); // arr는 name 알파벳 순으로 정렬
arr.sort((a,b) => a.name[1] < b.name[1]); //두번 째 글자의 알파벳의 역순으로 정렬
```

- 배열 검색
    1. indexOf : 찾고자 하는 것과 정확히 일치(===)하는 첫 번째 요소의 인덱스를 반환한다.
    2. lastIndexOf: 배열의 끝에서 부터 검색
    3. 일치하는 것을 찾지 못하면 -1을 반환
    4. findIndex라는 함수는 보조 함수를 써서 검색 조건을 지정할 수 있다.
    5. 인덱스가 아닌 요소 자체를 원할 때는 find를 사용. (찾지 못하면 undefined를 반환함)
    6. some 은 조건에 맞는 요소를 찾으면 즉시 검색을 멈추고 true를 반환, 찾지 못하면 false를 반환
    7. every는 배열의 모든 요소가 조건에 맞아야 true를 반환
```
const arr = [{id: 5, name : "Judith"}, {id: 7, name: "Francis"}];
arr.findIndex(o=> o.id ===5); //0
arr.findIndex(=->o.name === "Francis");//1

arr.find(o=> o.id === 5 ); //객체 {id : 5, name "Judith"};
// 각 요소를 첫 번째 매개변수로 받고 현재 요소의 인덱스와 배열 자체도 매개변수로 받을 수 있다.
const arr = [1,17,,16,5,4,16,10,3,49];
arr.find((x,i) => i > 2 && Number.isInteger(Math.sqrt(x))); //4 

//sum, every

arr.some(x=> x%2===0); 
arr.every(x=> x%2===0);
```

- map과 filter
    1. map 
        - 배열의 요소를 변형한다. 
        - 일정한 형식의 배열을 다른 형식으로 바꿔야 할 때 사용한다.

    2. filter 
        - 필요한 것들만 남길 목적으로 사용
```
const cart = [{name :"Widget", price: 9.95}, {name : "Gadget", price: 22.95}];
const names = cart.map(x => x.name);["Widget", "Gadget"];
const prices = cart.map(x => x.price);
//--
const items = ["Widget", "Gadget"];
const prices = [9.95, 22.95];
const cart = items.map((x,i) => ({name: x , price: prices[i]}));
//-- 
```

- reduce(좀 더 공부 필요) 
    - 배열 자체를 변형하는 메서드
    - reduce는 map과 filter를 비롯해 여태까지 설명한 배열 메서드의 동작을 대부분 대신할 수 있다.
    - reduce의 첫 번째 매개변수는 배열이 줄어드는 대상인 어큐뮬레이터이다.
    - 두 번째 매개변수부분 부터는 현재 배열의 요소, 현재 인덱스, 배열 자체이다.
- 문자열 병합
    - join을 통해 합침
    - 정의되지 않은 요소, 삭제된 요소, null, undefined는 모두 빈 문자열로 취급함
```
const arr = [1, null, "hello", "world", tur, undefined];
delete arr[3];
arr.join();//"1,,hello,,true


```
