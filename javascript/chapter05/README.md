# chapter05
## 표현식과 연산자


1. expression은 값으로 평과될 수 있는 statement
2. 자바스크립트의 mod 음수 연산의 결과는 제수가 아니라 피제수의 부호를 따라감
    -10 mod 3 은 -1이 아니라, 2이다. mod 연산자의 결과가 제수의 부호를 따르기 때문이다.
    - https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/what-is-modular-arithmetic

3. 비교 연산자 (===, == )
    -   === (일치함, strict equality), == (동등함, loose equality)
    - 일치: 두 값이 같은 객체를 가리키거나, 같은 타입이고 값도 같다면 이 값을 일치한다고함
    - 동등: 두 값이 같은 객체를 가리키거나, 같은 값을 갖도록 변환할 수 있다면 동등이라고 한다.
        - 문자열 "33"은 숫자 33으로 변환할 수 있으므로 둘은 동등 33=="33" (true)
    - 동등 연산자는 신중하게 사용해야함
    
```
const n=5;
const s = "5";
n === 3; //false (타입이 다름)
n !== s; //true

n === Number(s); //true
n !== Number(s); //false
n==s; //true 권장 x
n!=s // false 권장 x

const a = {name: "an object"};
const b = {name: "an object"};

a === b; //false -- 객체는 항상 다름
a !== b; //true
a == b; //false 권장 x
a =!b; // true 

```

4. 숫자 비교  
 - 자바스크립트에서 소수점이 있는 숫자를 비교할 때에는 관계 연산자를 써서 충분히 가까운지를 확인하는 것이 좋다
 - Number.EPSILON 관계 연산자를 사용하게 '느슨하게' 비교해서 대수 관계를 표현할 수 있다.
 
 
```
let n = 0;
while(true){
    n+ = 0.1;
    if(n === 0.3) break; //false, 무한 루프 
}

```
 
```
let n = 0;
while(true){
    n+=0.1;
    if(Math.abs(n-0.3)< Number.EPSILON) break;
}
```

5. True/false
 - 자바스크립트에서 거짓(false) 같은 값을 가지는 것들
  1) undefined
  2) null
  3) false
  4) 0
  5) NaN
  6) ' ' (빈 문자열)
  
6. typeof 연산자
    - 피연산자의 타입을 나타내는 문자열을 반환함
    
7. 해제 할당
    - ES6에서 새로 도임한 해제 할당은 매우 환영 받는 기능이다.
    - 객체나 배열을 변수로 '해제'할 수 있습니다.
    - 객체를 해제할 때는 반드시 변수 이름과 객체의 프로퍼티 이름이 일치해야 함
    - 
```

//객체 선언
const obj = { b: 2, c: 3, d:4};

//해체 할당

const {a, b, c} = obj;

a; //undefined
b; // 2
c; // 3 
d; // ReferenceError:

```
