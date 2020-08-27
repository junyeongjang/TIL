# chapter04
## 제어문

- 기본적으로 아는 내용 (생략) [if, if else, while, for, do while, switch ~~]

- throw : 예외 핸들러에서 반드시 처리해야 할 예외를 일으킴, 예회 핸들러는 현재 제어문 바깥에 있어도 상관없음
- 메타 문법: 다른 문법을 설명하는 문법
- for(;;) : 제어부에 아무것도 쓰지 않아. 무한 루프
- switch: 참/거짓 같은 갓뽀다는 다양하게 나뉘는 조건을 사용 
- for ... in 루프 : 객체의 프로퍼티에 루프를 실행하도록 설게된 루프. 

        
        for(variable in object)
            statement


- for ... of 루프 : ES6에서 새로 생긴 반복문이며 컬렉션의 요소에 루프를 실행하는 다른 방법
    -  배열을 물론 이터러블 객체에 모두 사용할 수 있는 범용적인 루프
    -  배열에 루프를 실행해야 하지만 각 요소의 인덱스를 알 필요 없을 때 사용함 

        ```
            for(variable of object)
                statement
        ```
        
