# chapter06
## 함수

- 함수 : 하나의 단위로 실행되는 문의 집합
```
function getGreeting(){ // 함수의 기본적인 형태
    return "Hello World!";
}
```
- return을 명시적으로 호출하지 않으면 반환 값은 defined가 된다.
- 함수도 객체이다.
- 함수 식별자 뒤에 ()를 쓰면 함수 바디를 실행하고, 쓰지 않으면 함수는 실행되지 않는다.

```
const f = getGreeting;
f() // 함수는 실행되지 않지만, 값을 넘겨줄 수 있다.
//자바스크립트를 유연한 언어로 만드는 특징
const o = {};
o.a = getGreeting // 객체에도 할당 가능
const array = [1,2,3];
arr[1] = getGreeting // 배열에도 할당 가능함

```
- 자바스크립트에서는 f(x,y) 와 f(x)는 같은 함수이다. 매개변수 개수가 달라도 같은 함수이다.
- 정해진 매개변수에 값을 제공하지 않으면 암시적으로 defined가 할당된다.
- ES6에서는 매개변수에 기본값을 지정하는 기능도 추가 됐다.
```
function f(a,b = "default", c= 3){
return `${a} - ${b} -${c};
}
```

- 객체의 프로퍼티인 함수를 메서드(method)라고 불러서 일반적인 함수와 구별한다.

```
const o {
    name : "Wallance", // 원시 값 프로퍼티
    bark: function() {return 'Woof!';}, // 함수 프로퍼티(메서드) 
}

//아래는 ES6 문법

const o = {
    name : "Wallance",
    bark(): {return 'Woof!:'},
}

```

- 익명 함수에서는 함수에 식별자가 주어지지 않는다. 함수를 만들고 바로 할당 할 때 쓰인다.

```
const f = function(){

//
}

```

## 화살표 표기법 
- 스스로 중요하다고 생각함
- ES6에서 새로 만든 화살표 표기법은 환영받는 문법이다.
- function이라는 단어와 중괄호 숫자를 줄이려고 고안된 단축 문법    
1. function 생략가능
2. 매개변수가 단 하나 뿐이라면 (()) 생략 가능
3. 표현식이 하나라면 중괄호와 return 문도 생략 가능하다.


```
const f1 = function () { return "hello!";}
const f1 = () => "hello";

const f2 = function(name) {return `Hello, $(name)!`;}
const f2 = name -> `Hello, $(name)!`;

const f3 = function(a,b) {return a+b;}
const f3 = (a,b) => a+b;
```


- 화살표 함수는 익명 함수를 만들어 다른 곳에 전달하려 할 때 가장 유용함
- 이름 붙은 함수가 필요하다면 그냥 일반적인 함수 선언을 사용하면 됨
- 화살표 함수는 객체 생성자로 사용할 수 없고, arguments 변수도 사용할 수 없다.


## this, call, apply, bind (필요할 때 더 공부하기)


1. this
- 일반으로 this는 객체의 프로퍼티인 함수에서 의미가 있다. 메서드를 호출하면 this는 호출한 메서드를 소유하는 객체가 된다.

```
const o = {
    name: 'Wallance,
    speak() {return `My name is ${this.name}`;},
}

o.speak(); // o.speak()를 호출하면 this는 o에 묶인다.
```

```



```
