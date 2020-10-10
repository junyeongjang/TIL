### chapter 03 - 노드 기능 알아보기

**3.1 REPL 사용하기**
-

- 자바스크립트는 스크립트 언어이므로 미리 컴파일을 하지 않아도 즉석에서 코드를 실행 할 수 있다.  노드가 제공하는 콘솔은 REPL이라고 하는데, Read(읽고), Eval(해석하고), Print(반환하고), Loop(반복한다) 라고 해서 REPL이라고 부른다.
- REPL은 한두 줄 짜리 코드를 테스트를 해보는 용도로 사용하고, 긴 코드는 코드를 자바스크립트로 만든 후, 파일을 통째로 실행하는 것이 좋다.

**3.2 JS 파일 실행하기**
-

- REPL에 직접 코드를 입력하는 대신 자바스크립트 파일을 만들어 실행해보자.
- 3-2.js 파일을 만들어 실행해보았다.


**3.3 모듈로 만들기**
-

- 노드는 코드를 모듈로 만들 수 있다는 점에서 브라우저의 자바스크립와는 다르다.
- 모듈이란 *특정한 기능*을 하는 함수나 변수들의 집합이다. 
- 모듈로 만들어두면 여러 프로그램에 해당 모듈을 재사용할 수 있다.
- 한 파일에서 다른 파일에 사용가능하려면 export, 다른 파일에서 다른 모듈을 사용하려면 require 사용해야함 (export와 require은 내장 객체이다.)
- 실제로 모듈 실습한 파일은 3-3-var.js, 3-3-func.js, 3-3-index.js
    

**3.4 노드 내장 객체 알아보기**
-

- 노드에서는 기본적인 내장 객체와 내장 모듈을 제공하기 때문에, 따로 설치 하지 않더라도 바로 사용할 수 있다.


**3.4.1 global**
-

- 전역 객체이다. 전역 객체이므로 모든 파일에서 접근할 수 있다.  
- 사용할 때 global을 생략할 수 있다. (이전에 사용했던 require 함수도 global.require에서 global이 생략된 것이다.
- global 전역 객체 내부에는 많은 속성들이 들어있는데 보려면 REPL을 이용하면 된다.
- global은 전역 객체라는 점을 이용하여 간단한 데이터를 파일끼리 공유할 때 사용하기도 한다.
- global 객체의 속성에 값을 대입하여 파일 간에 데이터를 공유할 수 있지만, 이를 남용하면 안된다. 프로그래므이 규모가 커질수록 어떤 파일에서 global 객체에 값을 대입했는지 찾기 힘들어 유지보수에 어려움을 겪게 된다.  (가급적 모듈을 만들어 사용)
- 실습 파일 3-4-globalA.js / 3-4-globalB.js

**3.4.2 console**
-

- console 객체는 보통 디버깅을 위해 사용된다.
- console.time(레이블):  console.timeEnd(레이블)과 대응되어 같은 레이블을 가진 time과 timeEnd 사이의 시간을 측정한다.
- console.log(내용) : 평범한 로그를 콘솔에 표시함.
- console.error(에러 내용): 에러를 콜솔에 표시함.
- console.dir(객체, 옵션): 객체를 콘솔에 표시할 때 사용함. 첫 번째 인자로 표시할 객체를 넣고, 두 번째 인자로 옵션을 넣는다. 
옵션 colors을 true로하면 콘솔에 색이 추가되고, depth는 기본 값이 2이고, 객체 안의 객체를 몇 단계까지 보여줄지를 결정
- console.trace(레이블): 에러가 어디서 발생했는지 추척함.


**3.4.3 타이머**
-

- 타이머 기능을 함수를 알아보자.
- setTimeout(콜백 함수, 밀리초) : 주어진 밀리초(1000분의 1초) 이후에 콜백 함수를 실행합니다.
- setIntervar(콜백 함수, 밀리초) : 주어진 밀리초마다 콜백 함수를 반복 실행합니다.
- setImmediate(콜백 함수) : 콜백 함수를 즉시 실행합니다.
- 이 3가지 타이머 함수들은 모두 아이디를 반환한다. 이 아이디를 이용하여 타이머를 취소할 수 있다.
- clearTimeout(아이디) : setTimeout을 취소한다.
- clearInterval(아이디) : setIntervar을 취소한다.
- clearImmediate(아이디): setImmediate를 취소한다.
- 예제 파일은 3-4-timer.js


**3.4.4 __filename, __dirname**
-

- 노드에서는 파일 사이에 모듈 관계가 있는 경우가 많아 현재 파일의 경로나 파일명을 알아야 하는 경우가 있다.
- 노드는 __filename과 __dirname이라는 키워드로 경로에 대한 정보를 제공함.
- __filename은 파일 이름까지, __dirname은 현재 파일의 경로까지 알려줌
- 예제 파일은 3-4-filename.js


**3.4.5 modue, exports**
-

- 지금까지는 모듈을 만들 때 module.exports만 사용했는데, module 객체 말고 exports 객체로도 모듈을 만들 수 있다.
```
exports.odd = '홀수 입니다';
exports.even = '짝수 입니다';
```


**3.4.6 process**
-

- process객체는 현재 실행되고 있는 노드 프로세스에 대한 정보를 담고 있다. (p89)


**3.4.6.1 process.env**
-

- process.env는 서비스의 중요한 키를 저장하는 공간으로 사용됨.
- 서버나 데이터베이스의 비밀번호와 각종 API 키를 코드에 직접 입력하는 것은 위험하다.
- 혹여 서비스가 해킹당해 코드가 유출되었을 때 비밀번호가 코드에 남아 있어 추가 피해가 발생한다.

```
const secretId = process.env.SECRET_ID;
const secretCode = process.env.SECRET_CODE;

```
- 이제 porcess.env에 직접 SECRET_ID와 SECRET_CODE를 넣어주면 된다. 넣는 방법은 나중에 배운다.


**3.4.6.2 process.nextTick(콜백)**
-

- 이벤트 루프가 다른 콜백 함수들보다 nextTick의 콜백 함수를 우선으로 처리하도록 만든다.

```
setImmediate(()=>{
    console.log('immediate');
});

process.nextTick(()=>{
    console.log('nextTick');
});
setTimeout(() =>{
    console.log('timeout');
},0);
Promise.resolve().then(() => console.log('promise'));
```

- 실행 순서는 nextTick -> promise.resolve 순인데, 이유는 resolve()된 Promise도 nextTick처럼 다른 콜백들보다 우선시되기 때문이다. 이 둘을  마이크로태스크라고 따로 구분지어 부른다.



**3.4.6.3 process.exit(코드)**
-

- 실행 중인 노드 프로세스를 종료시킴
- 서버에 이 함수를 사용하면 서버가 멈추므로 서버에는 거의 사용 하지 않음


**3.5 노드 내장 모듈 사용하기**
-

- 노드는 웹 브라우저에서 사용되는 자바스크립트보다 더 많은 기능을 제공한다.
- 운영체제 정보에도 접근 할 수 있고, 클라이언트가 요청한 주소에 대한 정보도 가져올 수 있다.
- 바로 노드에서 제공하는 모듈을 사용하면 된다.


**3.5.1 os**
-

- os모듈은 주로 컴퓨터 내부 자원에 빈번하게 접근하는 경우 사용됨. 일반적인 웹 서비스를 제작할 때는 사용 빈도가 높지 않다.
- os.uptime() : 운영체제 부팅 이후 흐른 시간(초)를 보여준다. process.uptime()은 노드의 실행 시간이었다.
- os.hostname() : 컴퓨터의 이름을 보여준다.
- os.release(): 운영체제의 버전을 보여준다.
- os.homedir(): 홈 디렉터리 경로를 보여준다.
- os.tmpdir(): 임시 파일 저장 경로를 보여준다.
- os.cpus(): 컴퓨터의 코어 정보를 보여준다.
- os.freemem(): 사용 가능한 메모리(RAM)를 보여준다.
- os.totalmem(): 전체 메모리 용량을 보여준다.


**3.5.2 path**
- 

- 폴더와 파일의 경로를 쉽게 조작하도록 도와주는 모듈이다. path 모듈이 필요한 이유 중 하나는 운영체제별로 경로 구분자가 다르기 때문이다. 
- Windows 과 POSIX 타입으로 구분되는데, POSIX는 유닉스 기반의 운영체제들로 macOs와 리눅스가 속해 있다.
- POSIX은 /로 구분되고, Windows는 ₩로 구분된다.

---
- path.sep: 경로의 구분자이다. Windows는 \, POSIX은 /이다.
- path.delimiter: 환경 변수의 구분자이다. process.env.PATH를 입력하면 여러 개의 경로가 이 구분자로 구분되어 있다. Windows는 ; , POSIX은 :
- path.dirname(경로): 파일이 위치한 폴더 경로를 보여준다.
- path.extname(경로) : 파일의 확장자를 보여준다.
- path.basename(경로, 확장자) : 파일의 이름(확장자 포함)을 보여준다. 파일의 이름만 표시하고 싶다면 basename의 두 번째 인자로 파일의 확장자를 넣어주면 된다.
- path.parse(경로) : 파일 경로를 root, dir, base, ext, name으로 분리한다.
- path.format(객체) : path.parse() 한 객체를 파일 경로로 합친다.
- path.normalize(경로) : /나 \를 신수로 여러 번 사용했거나 혼용했을 때 정상적인 경로로 변환해준다.
- path.isAbsolute(경로) : 파일의 경로가 절대경로인지 상대경로인지 true나 false로 알려준다.
- path.relative(기준경로, 비교경로) : 경로를 두 개 넣으면  첫 번째 경로에서 두 번째 경로로 가는 방법을 알려준다.
- path.join(경로, ...) : 여러 인자를 넣으면 하나의 경로로 합쳐준다.
---
**3.5.3 url**
- 

- 인터넷 주소를 쉽게 조작하도록 도와주는 모듈이다. url 처레이는 크게 두 가지 방식이 있다. 
- 노드 버전 7에서 추가된 WHATWG 방식과 예전부터 노드에서 사용하던 url 방식이 있다.
- 주소가 host 부분 없이 pathname 부분 만오는 경우 WHATWG방식은 이 주소를 처리할 수 없다.

- url.parse(주소) : 주소를 분해한다. WHATWG 방식과 비교하면 username과 password대신 auth 속성이 있고, searchParms 대신 query가 있다.
- url.format(객체) : WHATWG 방식의 url과 기존 노드의 url 모두 사용할 수 있다. 분해되었던 url 객체를 다시 원래 상태로 조립한다.

- WHATWG와 노드의 url은 취향에 따라 사용하면 되지만, 노드의 url 형식을 꼭 사용해야 하는 경우가 있다. 주소가 host 부분 없이 pathname 부분만 오는 경우 꼭 url을 사용해야한다.
- ex) /book/bookList.apsx) 

- WHATWG 방식은 search 부분을 searchParams라는 특수한 객체로 반환하므로 유용하다. search 부분은 보통 주소를 통해 데이터를 전달해서 사용함
- search는 물음표(?)로 시작하고, 그 뒤에 키=값 형식으로 데이터를 전달한다. 여러 키가 있을 경우 &으로 구분
- sarchParams 객체는 search부분을 조작하는 다양한 메드를 지원함 

- getALL(키): 키에 해당하는 모든 값들을 가져온다. category 키에는 두 가지 값, 즉 nodejs와 javascript의 값이 들어 있다.
- get(키): 키에 해당하는 첫 번째 값만 가져온다.
- has(키): 해당 키가 있는지 없는지를 검사한다.
- keys(): searchParams와 모든 키를 반복기 객체로 가져온다.
- values(): searchParams의 모든 값을 반복기 객체로 가져온다.
- append(키, 값): 해당 키를 추가한다. 같으 키의 값이 있다면 유지하고 하나 더 추가한다.
- set(키, 값): append와 비슷하지만 같은 키의 값들을 모두 지우고 새로 추가한다.
- delete(키): 해당 키를 제거한다.
- toString(): 조작한 searchParams 객체를 다시 문자열로 만든다. 이 문자열을 search에 대입하면 주소 객체에 반영된다.


**3.5.4 querystring**
- 

- WHATWG 방식의 url 대신 기존 노드의 url을 사용할 때 search 부분을 사용하기 쉽게 객체로 만드는 모듈이다.

- querystring.parse(쿼리): url의 query부분을 자바스크립트 객체로 분해해준다.
- querystring.stringify(객체): 분해된 query 객체를 문자열로 다시 조립해준다.
- 실습 파일 = > 3-4-querystring.js

**3.5.5 crypto**
- 

- 다양한 방식의 암호화를 도와주는 모듈이다. 


**3.5.5.1 단방향 암호와** 

- 비밀번호는 보통 단방향 암호화 알고리즘을 사용해서 암호화한다. 
- 단방향 암호화란 복호화할 수 없는 암호화 방식을 뜻한다. 즉, 단방향 암호화는 한 번 암호화하면 원래 문자열을 찾을 수 없다.
- 단방향 암호화 알고리즘은 해시 기법을 이용함.

- createHash(알고리즘): 사용할 해시 알고리즘을 넣어준다. md5, sha1, sha256, sha512등이 가능하지만, md5와 sha1은 이미 취약점이 발견되었다. 
sha512는 아직 충분하지만, 취약점이 발견되면 더 강화된 알고리즘으로 바꿔야한다.
- update(문자열) : 변환할 문자열을 넣어줌
- digest(인코딩): 인코딩할 알고리즘을 넣어준다. base64, hex, latin1이 주로 사용되는데, base64가 결과 문자열이 가장 짧아 애용된다.

- 실습파일 3-4-hash.js

**3.5.5.2 양방향 암호와**

- 암호화된 문자열을 복호화할 수 있다. 여기서는 키가 사용되는데 암호를 복호화하려면 함호화할 때 사용한 키와 같은 키를 사용해야함



