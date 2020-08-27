# chapter17
## 정규표현식(regular expression)

#### 개요 

- 정규표현식은 정규한 문자열 매칭 기능을 제공한다.
- URL, 전화번호처럼 보이는 문자열을 찾고 싶다면 정규표현식에 익숙해져야 한다.
- 정규표현식은 정규식이라고 부르기도 한다.

#### 부분 문자열 검색과 대체

- 정규식으로 하는 일은 문자열 속에서 부분 문자열을 찾는 일이며 찾은 부분을 교체할 때도 사용한다.

- 정규식을 쓰지 않고 검색하고 교체하는 방법 (String.prototype 메서드를 사용)

- 이 메서드들은 모두 대소문자를 구분한다.

  ```javascript
  const input = "As I was going to Sait Ives";
  input.startsWith("As") //true
  input.endsWith("Ives") // true
  input.startsWith("going", 9) // true , 인덱스 9에서 시작
  input.endsWith("going", 14) // true , 인덱스 14를 문자열의 끝으로 간주한다.
  
  input.includes("going") // true
  input.includes("going", 10) //  false , 인덱스 10에서 시작하면 going이 없다
  	
  input.indexOf("going") // 9 
  input.indexOf("going", 10) // -1
  input.indexOf("nope") // -1 
  
  
  // 대소문자를 구분하고 싶다면
  
  input.toLowerCase().startsWith("as") //true
  
  
  // 부분 문자열을 찾아 교체하고 싶다면
  
  const input = "As I was going to Saint Ives";
  const output = input.replace("going", "walking");
  ```



#### 정규식 만들기

- 자바스크립트의 정규식은 RegExp 클래스이다. RegExp는 생성자로도 정규식을 만들 수 있지만 간단한 리터럴 문법도 있다. 

- 간단한 정규식 리터럴은 슬래시로 감싼 형태이다.

- 특수한 경우에는 RegExp 생성자를 써야하지만, 그 외에는 더 간단한 리터럴 문법을 써야 한다. 

  ```javascript
  const re1 = /going/;   //"단어 going을 찾을 수 있는 정규식"
  const re2 = new RegExp("going") // 생성자를 사용했다. 결과는 같음 
  ```



#### 정규식 검색

- 정규식이 만들어지면 다양한 옵션으로 문자열을 검색할 수 있다.

- match와 test가 가장 많이 쓰인다.

  ```javascript
  const input = "As I was going to Saint Ives"
  const re = /\w{3,}/ig; //세글자 이상인 단어에 모두 일치하고
  
  
  // 문자열(input)의 메서드를 사용할 때 
  input.match(re); //["was", "going", "Saint", "Ives"]
  input.search(re); //5 (세글자 이상으로 이루어진 첫 단어의 인덱스는 5이다).
  
  
  //정규식(re)의 메서드를 사용할 때 
  re.exec(input); //["was"] (처음 일치하는 것)
  re.exec(input); //["going"](exec는 마지막 위치를 '기억'한다)
  re.exec(input); //["Saint"]
  re.exec(input); // ["Ives"]
  re.exec(input); // null 
  
  re.test(input); // true
  
  
  // 정규식 리터럴을 그래도 써도 된다.
  
  
  input.match(/\w{3,}/ig);
  input.search(/\w{3,}/ig);
  /\w{3,}/ig.test(input);
  /\w{3,}/ig.exec(input);
  //...
  ```



#### 정규식을 사용한 문자열 교체

- String.prototype.replace 메서드에도 정규식을 쓸 수 있다.
- 정규식을 사용하면 더 여러 가지 일을 할 수 있따.

```javascript
// 네 글자 이상으로 이루어진 단어를 모두 교체

const input = "As I was going to Saint Ives";
const output = input.replace(/\w{4,}/ig, '****'); //" As I was ****"
```



#### 입력 소비

- 정규식을 '큰 문자열에서 부분 문자열을 찾는 방법'이라고만 생각해서는 안된다.
- 좀 더 나은 개념은 정규식이 입력 문자열을 소비하는 패턴이라고 생각하는 것
- 





