

# chapter09

## 객체와 객체지향 프로그래밍

**프로퍼티(property)**

- 해당 오브젝트(object)의 특징. propery는 보통 데이터 구조와 연관된 속성을 나타냄

- Ex) 문자열의 length라는 property, 객체의 property(키와 값) 등등

- 프로퍼티 종류 2가지

  - 인스턴스 Property : 특정 object 인스턴스의 특정한 데이터를 갖고 있다.

  - Static Propery: 모든 object 인스턴스들에게 공유 된 데이터를 갖고 있다.

    

**프로퍼티 나열**

- 객체도 컨테이너이기 때문에 프로퍼티 나열을 지원한다. 하지만 순서가 보장되지 않는다.

- 객체 프로퍼티에는 순서가 없다

  - Object.keys

    - 객체에서 나열 가능한 문자열 프로퍼티를 배열로 반환한다.
    - 객체의 프로퍼티 키를 배열로 가져와야 할 때는 Obect.keys가 편리함.

    ```javascript
    const SYM = simbol();
    
    const o = {a:1, b: 2, c: 3, [SYM]: 4};
    Object.keys(o).forEach(prop => console.log(`${prop}: ${o[prop]}`)); 
    ```

    - 객체에서 x로 시작하는 프로퍼티를 모두 가져옴.

    ```javascript
    const o = {apple: 1 , xochitl: 2, balloon: 3, guitar: 4, xylophone:5 ,};
    
    Object.Keys(o)
    	.filter(prop => prop.match(/^x/))
    	.forEach(prop => console.log(`${prop}: ${o[prop]}`));
    	
    ```

    

  - for...in 

    - HasOwnProperty는 상송된 프로퍼티가 for...in에 나타날 위험을 제거하기 위해 사용함

    - 다른 사람이 만든 객체의 프로퍼티를 나열하다 보면 예상치 못한 상황이 생길 수 있다.

    - HasOwnPropery를 쓰는 습관을 들이는 것을 권한다.

    - for...in을 배열에 사용할 수도 있겠지만,  for 루프나 forEach를 사용하는 것이 바람직함.

      

    ```javascript
    const SYM = Symbol();
    
    const o = { a: 1, b: 2, c: 3, [SYM]: 4};
    
    for(let prop in o){
      if(!o. hasOwnProperty(prop)) continue;
      console.log(`${prop}: ${o[prop]}`);
    }
    ```

**객체지향 프로그래밍(OOP)**

- **객체**는 데이터와 기능을 논리적으로 묶어 놓은 것.
- **클래스**는 어떤 자동차처럼 추상적이고 범용적인 것.
  - 예를 들어 운송 수단은 슈퍼클래스, 자동차는 운송 수단의 서브 클래스 
- **인스턴스**는 특정 자동차처럼 구체적이고 한정적인 것. 
  - 인스턴스를 처음 만들 때는 생성자(constructor)가 실행됨.
  - 생성자는 객체 인스턴스를 초기화함.
- **메서드**는 기능.
- 클래스에 속하지만 특정 인스턴스에 묶이지 않는 기능을 클래스 메서드라고 함.

**클래스와 인스턴스 생성**

- ES6에서는 클래스를 만드는 간편한 새 문법을 도입했다.

- 객체가 클래스의 인스턴스인지 확인하는 instanceof 연산자

  ```javascript
  class Car { //클래스를 생성
  	constructor(){
  	}
  }
  // 인스턴스를 생성 new 키워드 사용
  const car1 = new Car(); 
  const car2 = new Car();
  
  //
  car1 instanceof Car // true
  car1 instanceof Array //false
  ```

  - this 키워드는, 호출한 인스턴스를 가리키는 목적으로 쓰였음. (일종의 플레이스홀더라고 생각)
  - 아래 코드의 문제점은 사용자가 shift 메서드를 사용하지 않고 car.userGear = 'X' 와 같은 입력을 하는 것  (자바스크립트의 단점)

  ```javascript
  class Car{
    constructor(make, model){
      this.make = make;
      this.model = model;
      this.userGears =  ['P', 'N', 'R', 'D'];
      this.userGear = this.userGears[0]; 
    }
    shift(gear){
      if(this.userGears.indexOf(gear)<0)
        throw new Error(`invalid gear: ${gear}`);
      this.userGear = gear;
    }
  }
  
  const car1 = new Car("Tesal", "Model S");
  const car2 = new Car("Mazda", "3i");
  car1.shift('D'); // this는 car1에 묶인다. 
  car2.shift('R'); // this는 car2에 묶인다.
  
  car1.userGear // "D"
  car2.userGear // "R"
  
  ```

  - 프로퍼티 앞에 _(밑줄)을 붙이는 '가짜 접근 제한'을 사용해서 사용자의 어느정도 실수를 방지할 수 있음. 

  ```javascript
  class Car{
   	 constructor(make, model){
     	 this.make = make;
     	 this.model = model;
     	 this._userGears =  ['P', 'N', 'R', 'D'];
     	 this._userGear = this.userGears[0]; 
    	}
  	 get userGear() {return this._userGear;}
  	 set userGear(value){
     		if(this._userGears.indexOf(gear)<0)
        		throw new Error(`invalid gear: ${gear}`);
      	this._userGear = gear;
  	 }
    shift(gear){this.userGear = gear;}
  }
  ```

  - 프로퍼티를 꼭 보호해야 한다면 스코프를 이용해 보호하는 WeakMap 인스턴스를 사용할 수 있다. 
  - WeakMap은 클래스 외부에서 접근하면  안 되는 프로퍼티를 안전하게 저장함.

  ```javascript
  const Car = (function(){
  	const carProps = new WeakMap();
  	
  	class Car{
  		constructor(make, model){
  			this.make = make;
  			this.model = model;
  			this._userGears = ['P','N','R','D'];
  			carProps.set(this, { userGear: this._userGears[0]});
      }
  		get userGear() {return this._userGear;}
  	 	set userGear(value){
     		if(this._userGears.indexOf(gear)<0)
        		throw new Error(`invalid gear: ${gear}`);
      	this._userGear = gear;
  	  }
    shift(gear){this.userGear = gear;}
  	}
  	return Car;
  )}();
  ```

**클래스는 함수다**

- 클래스는 사실 함수일 뿐이다. ES5는 함수처럼 만들어서 사용했지만, 단지 ES6에서 표기법만(새 문법) 달라진 것임.

**프로토타입**

- 클래스의 인스턴스에서 사용할 수 있는 메서드라고 하면 그건 프로토타입 메서드를 말하는 것이다.
- ex) Car의 인스턴스에서 사용할 수 있는 shitf 메서드는 프로토타입 메서드이다.
- 프로토타입 메서드를 표기할 때는 Car.prototype.shift 나 Car#shitf로 표기할 때가 많다.
- 모든 함수에서는 prototype이라는 특별한 프로퍼티가 있다. 일반적인 함수에서는 프로토타입을 사용할 일이 없지만, 객체 생성자로 동작하는 함수에서는 프로토타입이 대단히 중요하다.
- 함수의 prototype 프로퍼티가 중요해지는 시점은 new 키워드로 새 인스턴스를 만들었을 때이다. new 키워드로 만든 새 객체는 생성자의 prototype 프로퍼티에 접근할 수 있다. 객체 인스턴스는 생성자의 prototype 프로퍼티를 _ _ proto_ _ 프로퍼티에 저장한다.

- 프로토타입에서 중요한 것은 동적 디스패치라는 메커니즘이다. 디스패치란 메서드 호출과 같은 의미다.
- 객체의 프로퍼티나 메서드에 접근하려 할 때 그런 프로퍼티나 메서드가 존재하지 않으면 자바스크립트는 객체의 프로토타입에서 해당 프로퍼티나 메서드를 찾는다.
- 클래스의 인스턴스는 모두 같은 프로토타입을 공유하므로 프로토타입에 프로퍼티나 메서드가 있다면 해당 클래스의 인스턴스는 모두 그 프로퍼티나  메서드에 접근할 수 있다.
- 인스턴스에서 메서드나 프로퍼티를 정의하면 프로토타입에 있는 것을 가리키는 효과가 있다. 
- 자바스크립트는 먼저 인스턴스를 체크하고 거기에 없으면 프로토타입을 체크하기 때문이다.

```javascript
const car1 = new Car();
const car2 = new Car();
car1.shift === Car.prototype.shift; // true
car1.shift('D');
car1.shift('d'); //error
car1.userGear; //'D'
car1.shift === car2.shift //true

car1.shift = function(gear) {this. userGear = gear.toUpperCase();}
car1.shift === Car.prototype.shift; //false
car1.shift === car2.shift; //false
car1.shift('d');
car1.userGear; //'D'
```



**정적 메서드**

- 정적 메서드(클래스 메서드)는 특정 인스턴스에 적용되지 않는다.
- 정적 메서드에서 this는 인스턴스가 아니라, 클래스 자체에 묶인다.
- 정적 메서드는 클래스와 관련되지만, 인스턴스와는 관련이 없는 범용적인 작업에 사용된다.

```javascript
class Car{
	static getNextdVin(){
		return Car.nextVin++; 
	}
	constructor(make, model){
		this.make = make;
		this.model = model;
		this.vin = Car.getNextVin();
	}
	static.areSimiliar(car1, car2){
		return car1.make===car2.make && car1.model === car2.model;
	}
	static areSame(car1, car2){
		return car1.vin === car2.vin;
	}
}

Car.nextVin = 0 ;
const car1 = new Car("Tesla", "S");
const car2 = new Car("Mazda", "3");
const car3 = new Car("Mazda", "3");

car1.vin;
car2.vin;
car3.vin;

Car.areSimiliar(car1, car2); // false
Car.areSimiliar(car2, car3); //true
Car.areSame(car2, car3); //false
Car.areSame(car2, car3); //true
```

**상속**

- 클래스의 인스턴스는 클래스의 기능을 모두 상속한다.
- 객체의 프로토타입에서 메서드를 찾지 못하면 자바스크립트는 프로토타입의 프로토타입을 검색한다.

```javascript
class Vehicle{
	constructor(){
  	this.passengers = [];
    console.log("Verhicle created");
  }
  addPassenger(p){
    this.passsngers.push(p);
  }
}

class Car extends Vehicle{
  constructor(){
  	super();
  	console.log("Car created");
  }
  deployAirbags(){
  	console.log("BWOOSH!");
  }
}


const v = new Vehicle();
v.addPassenger("Frank");
v.addPassenger("Judy");
v.passengers;

const c = new Car();

c.addPassenger("Alice");
c.addPassenger("Cameron");
c.passengers;

v.deployAirbags(); //error
c.deployAirbags();

```

- extends 키워드는 Car를 Vehicle의 서브클래스로 만든다.
- Super()는 슈퍼클래스의 생성자를 호출하는 함수
- 서브클래스에서는 반드시 super() 함수를 반드시 호출해야한다.



##### 다형성(polymorphism)

- 객체지향 언어에서 여러 슈퍼클래스의 멤버인 인스턴스를 가리키는 말
- 자바스크립트의 객체는 모두 다형성을 갖고 있다고 할 수 있다. (자바스크립트는 느슨한 타입을 사용하고 어디서든 객체를 쓸 수 있음으로)
- 객체가 클래스이 인스턴스인지 확인하는 instanceof 연산자가 있다.





----

다른 내용은 추후 복습 때 공부





