

# Chapter10

## 맵과 셋

#### 맵

- 키와 값을 연결하는 객체의 단점
  - 프로토타입 체인 때문에 의도하지 않은 연결이 생길 수 있다.
  - 객체 안에 연결된 키와 값이 몇 개나 되는지 쉽게 알아낼 수 있는 방법이 없다.
  - 키는 반드시 문자열이나 심볼이어야 하므로 객체를 키로 써서 값과 연결할 수 없다.
  - 객체는 프로퍼니 순서를 전혀 보장하지 않는다.
- Map 객체는 위와 같은 단점을 모두 해결했고, **키와 값을 연결할 것이라면 맵이 객체보다 더 나은 선택이다.**

```javascript
const ul = {name: 'Cynthia'};
const u2 = {name: 'Jackson'};
const u3 = {name: 'Olive'};
const u4 = {anme: 'James'};

// 맵 생성
const userRoles = new Map();

userRoles.set(u1, 'User');
userRoles.set(u2, 'User');
userRoles.set(u3, 'Admin');

userRoles
	.set(u1, 'User')
	.set(u2, 'User')
	.set(u3, 'Adimin');

const userRoles = new Map([ //생성자에 배열의 배열을 넘기는 형태
  [u1, 'User'],
  [u2, 'User'],
  [u3, 'Admin'],
]);


userRoles.get(u2); // "User"

userRoles.has(u1); //true
userRoles.get(u1); //"User"
userRoles.has(u4); //false
userRoles.get(u4); //undefined

userRoles.get(u1); // 'User'
userRoles.set(u1, 'Admin'); // 맵에 이미 존재하는 키에 set()을 호출하면 값이 교체된다.
userRoles.get(u1); // 'Admin'

userRoles.size; //3
```

- 맵의 for...of 루프

```javascript
for(let u of uerRoles.keys()) // keys() 메서드는 맵의 키를, values() 메서드는 값을   
	console.log(u.name);

for(let u of userRoles.values())
  console.log(r);

for(let ur of userRoles.entries())
	console.log(`${ur[0].name}: ${ur[1]}`);

for(let [u,r] of userRoles.entries()) //맵을 분해
	console.log((`${u.name}: ${r}`))


[...userRoles.values()]; // ["User", "User", "Admin"]
 
userRoles.delete(u2); //맵의 요소를 지울 때 
userRoles.size; //2
 
userRoles.clear(); //맵의 요소를 모두 지울 때 
userRolse.size; //0
```

#### 위크맵(WeakMap)

- 

#### 셋(Set)

- 셋은 중복을 허용하지 않는 데이터 집합

- 셋의 장점은 추가하려는 것이 셋에 이미 있는지 확인할 필요가 없다.

- 이미 있다면 아무일도 일어나지 않는다.

  ```javascript
  const roles = new Set();
  
  roles.add("User");
  
  roles.add("Admin");
  
  roles.size; //2
  
  roles.add("Users"); 
  roles.delete("Admin"); //역할을 제거할때  
  ```

  

#### 요약

- 객체 대신에 맵과 셋을 많이 쓰는 연습을 해라 