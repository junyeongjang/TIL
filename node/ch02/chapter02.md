### chapter 02 -알아두어야 할 자바스크립트

---

 - 자바스크립트는 매년 새로운 버젼을 출시하고 있으며, 노드도 주기적으로 버전을 올리며 변경된 자바스크립트 문법을 반영하고 있다.
 - 2015년에는 자바스크립트 문법에 매우 큰 변화가 있었다. 바로 ES2015(ES6)의 등장이다.
 
 ---
 
 **1.1 const**
 
~~~
if(true){
  var x = 3;
}
console.log(x); //3

if(true){
var y = 3;
}
console.log(y); //error
~~~
y는 정상적으로 출력되지 않는다. 이유는 var은 함수 스코프를 가지기 때문에 if문의 블록과 관계없이 접근할 수 있다. <br>
하지만 const, let은 블록 스코프를 가지므로 블록 밖에서는 변수에 접근할 수 없다.<br>
블록의 범위는 if, while, for, function 등의 중괄호이다. <br>
함수 스코프 대신 블록 스코프를 사용해 호이스팅(hoisting) 같은 문제도 해결되고 코드 관리도 수월해졌다.<br>


**1.2 let**
<br>
const,let과 var의 차이가 어떤 스코프를 취하는지 였다면, const와 let의 차이는 const는 한 번 대입하면 다른 값을 대입할 수 없다. <br>

~~~
const a = 0;
a = 1; 
let b =0;
b=1; 

const c;
~~~
따라서 기본저긍로 변수 선언 시에는 const를 사용하고, 다른 값을 대입해야 하는 상황이 생겼을 때 let을 사용하면 된다 <br>



**1.3 템플릿 문자열**
<br>

-기존 ES5 문법을 사용한 문자열

~~~
var num1 = 1;
var num2 = 2;
var result =3;
var string = num1 + '더하기' + num2 + '는\''+ result + '\'';
console.log(string); // 1 더하기 2는 '3'
~~~


- ES2015의 문법을 사용한 문자열

~~~
const num3 = 1; 
const num4 =2;
const result2 =3;
const string = `${num3} 더하기 ${num4}는 '${result}'`;
console.log(string2); //1 더하기 2는 '3'

~~~
이처럼 ${변수} 형식으로 변수를 더하기 기호 없이 문자열에 넣을 수 있다. 하지만 맥북을 쓰는 나로서는 백틱(`)키가 쓰기 너무 번거롭다.<br>
한글 상태라면 ₩를 눌러줘야 하기 때문이다. 
<br>


**1.4 객체 리터럴**

- oldObject 객체에 동적으로 속성을 추가하고 있다. 
```
var sayNode = function()
{
    console.log('Node');
};
var es = 'ES':
var oldObject ={
 sayJS: function(){
    console.log('JS');
},
    sayNode: sayNode,
};

oldObject[es + 6] = 'Fantastic';
oldObject.sayJS(); //JS
console.log(oldObject.ES6); //Fantastic
```

- 앞의 코드를 이와 같이도 쓸 수 있다.

```
const newObject= {
sayJS(){
    console.log('JS');
},
    sayNode,
    [es+6]: 'Fantastic',
};

newObject.sayNode();//Node
newObject.sayJS(); //JS
console.log(newObject.ES6);//Fantastic
```

- sayJS와 같은 객체의 메서드에 함수를 연결할 때 콜른(:)과 function을 붙이지 않아도 된다.
- sayNode : sayNode처럼 속성명과 변수명이 겹치는 경우에는 한 번만 쓸 수 있게 되었다. 

<br>ex)
```
{name: name, age: age} //ES5
{name, age} //ES2015
```
**1.5 화살표 함수**
 
 - 화살표 함수(arrow function)라는 새로운 함수가 추가되었다. 기존의 function{}도 그대로 사용할 수 있다.

```
function add(x,y){
    return x+y;
}

const add2 = (x,y) => {
    return x+y;
};

const add3= (x,y)=>x+y;
const add4= (x,y)=>(x+y);

function no1(x){
    return !x;
}

//add1, add2, add3, add4,와 같은 기능을 하는 함수이다.

```

- this 바인드 방식 때 더욱 달라진다.

```
var relationship1 {
    name : 'zero', 
    freinds: ['nero', 'hero', 'xero'],
     logFriends: function(){
     var that = this;
     this.friends.forEach(function(friend)){
     console.log(that.name, friend);
     });
},
};
relationship1.logFriends();
```
- ES2015+ 문법
```
const relationship2 = {
    name : 'zero' ,
    friends: ['nero', 'hero', 'xero'],
    logFreinds(){
        this.friends.forEach(friend=> {
            console.log(this.name, friend);
        });
    },
};
relationship2.logFreinds();

```
- 기본적으로 화살표 함수를 쓰되, this를 사용해야 하는 경우에는 화살표 함수와 함수 선언문(function) 둘 중에 하나를 고르면 된다.

**1.6 비구조화 할당**

- 기존
```
var candyMachine = {
    status:{
        name: 'node',
        count: 5,
    },
    getCandy: function(){
        this.status.count--;
        return this.status.count;
    }
};
var getCandy= candyMachine.getCandy;
var count= candyMachine.status.count;

console.log(count);

```
- ES2015+ 
```
var candyMachine = {
    status:{
        name: 'node',
        count: 5,
    },
    getCandy: function(){
        this.status.count--;
        return this.status.count;
    }
};
const {getCandy, status: {count} } = candyMachine;
```

- 비구조화 할당 문법도 코드 줄 수를 상당히 줄여주므로 유용하다. 특히 노드는 모듈을 사용하므로 이러한 방식을 자주 사용.
- 배열도 이와 같이 비구조화 할당으로 줄일 수 있으나 기재하진 않음


**1.7 프로미스**

- 자바스크립트와 노드에서는 주로 비동기 프로그래밍을 함. 특히 이벤트 주도 방식 때문에 콜백 함수를 자주 사용
- ES2015+ 부터는 자바스크립트와 노드의 API들이 콜백 대신 프로미스(promise) 기반으로 재구성됨
- 악명 높은 콜백 헬을 극복했다는 평가를 받음

```
const condition = true;
const promise = new Promise((resolve, reject) => {
    if(condition){
        resolve('성공');
    }else{
        reject('실패');  //reject는 받지 않다라는 뜻
    }
});

promise
    .then((message) =>{
    console.log(message);
    })
    .catch((error) => {
        console.log(error);
    });
```
- new promise로 프로미스 객체를 생성하고, resolve와 reject를 매개변수로 갖는 콜백 함수를 넣어준다. 
- 이렇게 만든 promise 변수에 then과 catch 메서드를 붙일 수 있고, resolve가 호출되면 then, reject가 실행되면 catch가 실행된다.
- resolve와 reject에 넣어준 인자는 각각 then과 catch의 매개변수에서 받을 수 있다. 즉, relsolve가 호출되면 message는 '성공', reject가 호출되면 error는 '실패'가 된다.



**async/await**

- 노드 7.6 버전부터 지원되는 기능. 최신 기능이면서 정말 혁신적인 기능 (비동기 프로그래밍을 해야 할 때 도움이 많이 된다)
- 프로미스가 콜백 지옥을 해겼했다지만, 여전히 코드가 장황하다. 
- async/await 문법은 프로미스를 사용한 코드를 한 번 더 깔끔하게 줄여준다.

```
실전상황에 적용해보자 아직은 공부 x
```
