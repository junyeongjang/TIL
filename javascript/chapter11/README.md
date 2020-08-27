

# Chapter11

## 예외와 에러 처리

- 사소한 애플리케이션이라도 예상치 못한 조건이라면 에러를 낼 수 있다.
- 견고하고 품질 좋은 소프트웨어를 만드는 첫 번째 단계는 에러가 일어날 수 있다는 사실을 받아들이는 것
- 두 번째 단계는 에러를 예상하고 타당한 방법으로 처리하는 것
- **예외 처리** 는 에러를 컨트롤 하는 메커니즘이다.
- 에러 처리라고 하지 않고 예외 처리라고 하는 이유는 예상치 못한 상황에 대처하는 방식이기 때문이다



##### Error 객체

- 자바스크립트에는 내장된 Error 객체가 있고 이 객체는 에러 처리에 간단하게 사용할 수 있다.

  ```javascript
  const err = new Error ('invalid email'); //Error 인스턴스를 만들면서 에러 메세지를 지정할 수 있다.
  
  /*이메일 주소이 유효성을 검사하는 함수 */
  function validateEmail(email){
  	return email.match(/@/) ?
      	email : 
    		new Error(`invalid email : ${email}`);
  }
  ```



##### try/catch와 예외 처리

- 예외 처리는 try... catch문을 사용한다(뭔가를 시도하고, 예외가 있으면 그것을 캐치한다는 뜻임)
- try...catch문을 사용하여 에러를 캐치했으므로 프로그램은 멈추지 않는다. 에러를 기록하고 계속 진행할 수 있다.
- 실행 흐름은 에러가 일어나는 즉시 catch 블록으로 이동한다.
- try 블록안에 쓸 수 있는 문의 숫자에 제한은 없다.

```javascript
const email = null;

try{
  const validatedEmail = validatedEmail(email);
  if(validatedEmail instanceof Error){
    console.error(`Error: ${validatedEmail}`);
  } else{
    console.log('Valid email : ${validatedEmail}');
  }
}catch(err){
  console.error(`Error: ${err.message}`);
}
```



##### 에러 일으키기 

- try...catch문에서 자바스크립트가 에어를 일으키기만 기다릴 필요 없이 직ㅈ버 에어를 일으켜서 예외 처리 작업을 시작할 수 있다.
- 예외 처리 기능이 있는 다른 언어와는 달리, 자바스크립트는 에러를 일으킬 때 꼭 객체만이 아니라 숫자나 문자열 등 어떤 값이든 catch 절에 넘길 수 있다. (하지만 Error 인스턴스를 넘기는 것이 가장 편리하다.)

```javascript
/*은행 어플리케이션에 사용할 현금 인출 기능을 만든다고 생각*/
function billPay(amount, payee, count){
  if(amount > account.balance)
    	throw new Error("insufficeint funds"); // 계좌의 잔고가 요청받은 금액보다 적다면 예외를 일으킨다.
  account.transfer(payee.amount);
}
```

- throw를 호출하면 현재 함수는 즉시 실행을 멈춘다.



##### 예외 처리와 호출 스택

- 에러는 호출 스택 어디에서든 캐치할 수 있다. 하지만 에러가 일어날 수 있는 곳은 정말 다양하므로 가능한 에러를 모두 캐치하기는 정말 어렵다.
- 에러를 캐치하면 호출 스택에서 문제 해결에 유용한 정보를 얻을 수 있다. 
- 함수 a가 함수 b를 호출하고 b가 호출한 c에서 에러가 일어났다면, 호출 스택은 c에서 일어난 에러를 보고하는 데 그치지 않고 b가 c를 호출했으며 b는 c에서 호출했다는 것도 함께 알려준다.
- 이런 정보는 디버그에서 유용하게 쓸 수 있다.



##### try...catch...finally

- try 블록의 코드가 HTTP 연결이나 파일 같은 일종의 '자원'을 처리할 때가 있다.
- 프로그램에서 이 자원을 계속 가지고 있을 수 있는 없으므로 에러가 있든 없든 어느 시점에서 이 자원을 해제해야한다.
- 이 책에서는 파일 처리나 HTTP 연결을 다루지 않으므로, console.log로 테스팅

````javascript
try{
	console.log("this line is executed...");
  throw new Error("whoops");
  console.log("this line is not...");
}catch(err){
  console.log("there was an error...");
}finally{
  console.log("...always excuted");
  console.log("perform cleanup here");
}
````





##### 요약

- 예외를 일으키는 것은 대단히 쉽고, 어떻게 처리해야 할지 모르는 상황이 닥쳤을 때 '포기'하는 방법도 고려해야한다.

- 에러 처리 자체도 대가를 지불해야하는 연산이다. 예외는 catch 블록을 만날 때까지 스택을 거슬러 올라가야 하므로 자바스크립트 인터프리티가 예외를 계속 추적하고 있어야 한다.
- 컴퓨터는 점점 더 빨라지고 있으니 이런 비용은 큰 문제가 되지 않을 수 도 있지만, 자주 실행되는 코드에서 예외를 발생시키면 성능 문제가 발생할 가능성이 있다.
- 프로그램을 일부러 멈추려 하는 게 아니라면, 예외를 일으켰으면 반드시 캐치해야한다.
- **예외 처리는 예상할 수 없는 상황에 대한 마지노선으로 생각하고, 예상할 수 있는 에러는 조건문으로 처리하는 것이 최선이다.**