 

## OS 정의 (Operating System Definition)

### OS is a resource allocator

-   시스템 관점에서 OS는 자원할당자라고 볼 수 있다. (Manages all resoures)
-   제한된 자원에 대해 동시에 요청이 들어오면 효율적으로 분배해주는 역할을 한다. (Decides between conflicting requests for efficient and fair resource use)
-   자원 할당은 매우 중요한 이슈이다.

### OS is a control program

-   프로그램의 동작을 통제하는 제어프로그램이라고 할 수 있다.(Controls execution of programs to prevent errors and improper use of the computer)
-   프로그램의 입출력 연산에 깊이 관여한다.

### No universally accepted definition

-   운영체제는 한 문장으로 정의하기는 쉽지 않다.
-   전체 시스템에서 OS에 속한 부분이 무엇인지에 따른 보편적인 정의는 없다.
-   다만, 초창기 운영체제가 만들어지고 사용되기 시작한 과정을 돌이켜보면, 다양한 응용 프로그램이 필요로 하는 입출력 연산들과 자원을 할당하고 제어하는 공통기능을 하나의 소프트웨어로 통합하는 과정에서 운영체제라는 소프트웨어가 탄생했다.
-   컴퓨터 하드웨어와 사용자의 중간 역활을 해주는 프로그램이라고 하기도 함
-   다른 관점에서는 새로운 컴퓨터에 운영체제를 설치하는 경우에 운영체제를 설치한 직후 컴퓨터 시스템에 담기게 되는 모든 것을 운영체제로 볼 수 있다.
-   그렇다면 '메모장'프로그램도 운영체제로 포함해야할 것인지는 의문이 든다.

### Kernel

-   전체 운영체제 중에서 컴퓨터와 동작하는 중에 항상 실행되는 부분을 따로 '커널'이라고 부른다. (커널에 포함되지 않는 프로그램을 시스템 소프트웨어 또는 응용 소프트웨어라고 함)

### OS의 목표 (Operating system goals)

1.  사용자 프로그램을 진행함 (Execute user programs and make solving user problems easier)
2.  컴퓨터 시스템을 편리하게 사용하게 해 줌 (Make the computer system convenient to use)
3.  컴퓨터 하드웨어가 효율적으로 사용될 수 있는 것 (Use the computer hardware in an efficient manner)

-   사용자의 편의성과 효율성의 조화를 이루기는 매우 힘듦

### 캐싱의 정의

-   저속의 저장장치에 저장되어있는 데이터에 대해 그 일부의 복사본을 그보다 빠른 저장장치에 보관에서 컴퓨터 동작의 성능을 향상하는 기법  
    (copying information into faster storage system; main memory can be viewed as a cache for secondary storage)  
    (메모리 계층간의 캐싱 가능)
-   컴퓨터 시스템의 여러 부분에서 동작하는 성능 향상 기법
-   주어진 하드웨어에서 최대한 빨리 데이터에 접근(캐싱의 목적)

### 캐싱의 원리

-   저속 저장장치에 담긴 원본 데이터를 고속 저장장치에 임시로 복사해놓는다.
-   이렇게 되면 CPU는 같은 데이터를 고속 저장장치에서 데이터를 가져와서 성능을 향상 시킬 수 있다.
-   단, 고속 저장장치는 저속 저장장치보다 메모리가 작기 때문에 모든 데이터를 보관할 수 없다. (일부만 캐싱할 수 있음)
-   그렇다면 원본 데이터에서 어떤 데이터를 캐싱할까? -> 일반적으로 가장 최근에 사용한 데이터를 캐싱 (가장 최근에 사용된 데이터는 가까운 미래에 다시 사용될 확률이 높아서)

### 캐싱 기법에서 데이터 접근

-   캐싱 기법에서 데이터 접근은 캐시 역할을 하는 고속 저장장치부터 탐색한다.
-   고속 장치에 원하는 데이터가 있을 경우에는 성능향상, 원하는 데이터가 없는 경우에는 원본이 있는 데이터에 접근하고 캐싱 (고속 저장장치에 저속 저장장치 원본 데이터를 복사하는 것을 (caching replacement)
-   Faster storage (cache) checked first to determine if information is there
    -   If it is, information used directly from the cache (fast)
    -   If not, data copied to cache and used there
-   모든 데이터를 캐시에 넣을 수 없다는게 중요함



# Operating System Structure

-   운영체제와 같은 크고 복잡한 소프트웨어는 잘 동작하고, 쉽게 변경할 수 있도록 구조를 만드는 것이 매우 중요
-   운영체제를 구성하는 구조들은 여러 가지가 있다.

### 모놀로식 커널 (Monolithic kernel)

-   단일형 커널
-   cpu스케쥴링, 메모리 관리 등 운영체제의 일반적인 기능들이 전부 커널이라는 하나의 프로그램에 담겨있는 구조 (전혀 계층적이지 않음)
-   계층적인 구조보다 성능적인 부분에서는 우위를 보이나, 구현과 수정이 어렵다.
-   장점 : 성능이 더 좋다.
-   단점 : 수정과 구현이 어려움 (유지보수가 어렵다)

### 계층적인 접근 (Layered Apporach)

-   계층적인 구조라면 커널 자체도 여러개의 계층으로 이루어져있어야 함.
-   전형적인 하나의 계층은 자신의 자료구조와 코드, 자신의 아래 계층의 함수에 대한 호출로 이루어짐
-   각 계층은 자신과 자신의 하위계층의 함수를 호출할 수 있다.
-   상위 계층의 입장에서는 하위 계층의 구조와 코드는 알 필요 없고 어떤 역할을 하는지만 알면 된다.
-   각 layer에 어떤 기능을 넣을 것인지 잘 설계해야 함.
-   장점 : 구현과 디버깅이 간단함 -> 각 계층은 단지 자신의 하위계층의 서비스와 기능만을 사용하기 때문에 검증과 디버깅이 매우 쉬워짐
-   ex) layer1은 layer0만 신경 쓰고 개발하면 된다.
-   단점 : 하나의 동작이 이루어지는데 여러 계층을 거치다 보니 다른 구조보다 효율성이 떨어짐



### 마이크로커널 시스템 구조 (Microkernel System Structure)

-   모놀로식 커널이 점점 커지게 되자 카네기멜런 대학 연구자들이 마이크로커널을 기반으로한 마크(Mach)를 개발함
-   마이크로커널은 기존 모놀로식 커널에 있었던 일부 기능을 떼어내어 사용자 수준 프로그램으로 구현하고, 커널에는 아주 기본적인 기능만 넣은 작은 형태의 커널을 의미함.
-   프로세스 관리, 메모리 관리, 프로세스 간 통신 -> 이 3가지 기능만 마크의 커널에 있음 (모든 마이크로커널이 그런 것은 아님)
-   메시지 전달 방식을 사용해서 (message passing) 프로그램을 동작하게 함.
-   장점: 운영체제의 확장이 쉽다(새로 추가되는 서비스는 사용자 공간에 주면 됨), 보안성이나 신뢰성이 높음(대부분 사용자 공간에 주기 때문에)
-   단점: 모놀리식 커널에 비해 성능이 떨어짐(마이크로커널은 수차례의 메시지 전달 과정이 필요하기 때문에)

### 커널 모듈 (modules)(loadable kernel modules)

-   커널의 핵심적인 기능 외에 동적으로 서비스들이 추가될 수 있는 형태
-   예를 들어 특정한 파일 시스템을 커널 모듈로 구현하면, 파일 시스템은 커널 부팅과 동시에 동작하지 않고, 필요할 때 동작하는 방식
-   장점 : 필요한 해당 기능들을 수정할 때 필요한 기능들만 수정해서 컴파일하면 됨



### 하이브리드 시스템 (Hybrid Systems)

-   오늘날의 운영체제들은 위와 같은 구조를 명확하게 사용하지 않고, 성능, 보안, 편의성을 고려해서 여러 방식을 혼용해서 사용함

## 멀티프로그래밍(Multiprogramming)

### 개요

-   프로세스(process)에 대해 공부하기 전에 먼저 멀티프로그래밍을 공부하는 것이 좋다.

### Uni-Programming (단일 프로그래밍)

-   멀티프로그래밍 이전에는 유니프로그래밍 방식으로 컴퓨터가 동작했다.
-   [##_Image|kage@djRRpW/btq3Fm6lYNE/rZWGGOCz0ECSQOM1pKBR0K/img.png|alignCenter|width="100%" data-origin-width="786" data-origin-height="73" data-ke-mobilestyle="widthContent"|||_##]
-   위의 사진을 보면 Program A가 실행될 때 RUN->Wait->Run->Wait 형태로 프로그램이 동작하기 된다.
-   (이러한 RUN->Wait->Run->Wait 형태는 모든 프로그램에 공통되는 동작이다. CPU연산->입출력을 계속 반복하는 형태)
-   이때 Wait는 CPU idle 상태라고 하는데, I/O(입출력) 상태 이거나 다른 동작을 하고 있기 때문에 CPU가 일을 하지 않고 있다.
-   그 당시에는 CPU 연산과 같은 귀중한 자원이 idle 상태에 장기간 유지되는 것이 굉장한 낭비라고 생각되었기 때문에 Multi-programming이 등장하게 되었다.

### Multi-programming (다중 프로그래밍)

-   간단히 말해서 멀티프로그래밍은 CPU idle 상태 일 때 CPU 연산을 다른 프로그램에게 넘겨주는 것을 의미한다.
-   [##_Image|kage@b6Gz56/btq3yKBn9qa/hcb50gIKZlgGkO2rnIe2gk/img.png|alignCenter|width="100%" data-origin-width="431" data-origin-height="230" data-ke-mobilestyle="widthContent"|||_##]
-   위의 사진을 보면 A의 CPU 연산이 끝나고 I/O 연산이 진행되려고 할 때 CPU가 쓰이지 않기 때문에 프로그램 B에게 CPU 연산을 넘겨준다.
-   이런 식으로 한 개의 프로그래밍만 실행하지 않고 CPU는 여러 프로그래밍을 실행하게 된다. (최근 모든 운영체제는 멀티프로그래밍 방식을 사용함)

### Uni-Programming vs Multi-programming

-   그림을 통해서 Multi-programming과 uni-programming을 비교해보자.
-    [##_Image|kage@cExRO7/btq3y6YwUMn/qhmTVj2oU6Sn7wnYbkkL2k/img.png|alignCenter|width="100%" data-origin-width="603" data-origin-height="206" data-filename="blob" data-ke-mobilestyle="widthContent"|유니프로그래밍||_##]
-   [##_Image|kage@bp47TT/btq3CzlkoHn/4WE5J0yvyuCR1zdlRbVWC1/img.png|alignCenter|width="100%" data-origin-width="431" data-origin-height="230" data-ke-mobilestyle="widthContent"|멀티프로그래밍||_##]
-   먼저 그림의 가장 하단에 보이는 화살표는 CPU 연산 시간이다.
-   멀티프로그래밍의 CPU 연산 시간이 압도적으로 짧은 것을 볼 수 있다. 이를 통해 멀티 프로그래밍의 장점을 정리할 수 있다.
-   장점
    1.  Trought(처리량)이 높다.
    2.  Utillization(활용도)가 높다.
    3.  처리량과 활용도는 Degree of multiprogramming가 높을수록 높다. 즉 최대한 많은 프로그램을 동시에 실행시키는 것이 좋다.

출처 - 공룡 책 (Operating System Concepts)





## 프로세스 (Process)

-   **프로세스**란 실행 중인 프로그램을 의미한다. (프로그램 그 자체는 프로세스가 아님)
-   아래 사진은 프로세스가 메모리에 로드되어 있는 모습이다.
-   ![](https://blog.kakaocdn.net/dn/omGN1/btq3JeoIUrB/w1fpkX63rEl9DjPGbA6ZQk/img.png)
-   0 주소는 프로세스의 시작 위치 주소이고, max 표시는 프로세스의 마지막 주소를 의미한다.
-   Text section : 프로그램의 명령들, 즉 코드들을 의미한다 + 코드가 실행 중이기 때문에 PC와 같은 프로세서 레지스터를 포함
-   Stack : 함수의 동작과 관련된 내용들이 저장되어 있음 ex) 함수의 복귀주소, 로컬 변수, 함수의 매개변수와 같이 임시적인 자료를 가지는 것들
-   Data : 전역 변수가 포함되어 있음
-   Heap : 동적으로 메모리가 할당 되었을 경우 사용됨 ex) C언어의 malloc
-   화살표 부분 : 프로세스의 영역이긴 하지만, 아직 사용되고 있지 않은 빈 공간. 힙과 스택의 메모리 사용 여부에 따라 공간이 달라짐

## 프로세스 상태 (Process State)



-   new : 프로세스가 생성 중
-   ready : 프로세스가 처리기에 할당되기를 기다림
-   running : 명령어들이 실행되고 있다.
-   waiting : 프로세스가 어떤 사건이 일어나기를 기다린다.
-   terminated : 프로세스의 실행이 종료되었다.

## 프로세스 제어 블록



-   커널이 개별 프로세스를 관리하기 위해서 유지하는 자료구조 (커널은 프로세스들의 PCB를 모아서 링크드리스트로 관리한다)
-   한 프로세스에 해당하는 모든 정보들이 담겨 있다.(프로세스마다 PCB가 존재한다)
-   프로세스가 생성되면 PCB도 생성되고, 프로세스가 삭제되면 PCB가 삭제됨
-   Process state: 프로세스의 상태 정보를 담겨있다(프로세스의 상태가 바뀔 떄 이곳의 정보가 바뀜)
-   Process ID : PID 즉, 프로세스 아이디(정수로 표현됨)
-   Program Counter : 현재 실행중인 명령의 위치를 담고 있는 레지스터(CPU의 PC값의 복사본을 저장해놓음) => 상태가 running 아닐 때만 의미 있음
-   CPU registers : PC 레지스터를 제외한 CPU 레지스터 값들의 복사본들이 저장되어 있음, 프로세스의 실행이 멈췄다가 다시 실행할 때 아주 중요한 정보이다.
-   CPU scheduling information : 우선순위, 스케쥴링 포인터 값이 저장되어 있음
-   Memory-management information: 할당 받아 사용되고 있는 메인 메모리 위치
-   Accounting information : 자원 사용 기록이 저장되어 있음
-   I/O status information : 프로세스의 입출력 관련 정보가 들어있음

## 프로세스 스케쥴링(Process Scheduling)

멀티 프로그래밍의 목적은 CPU 목적을 극대화하기 위해서, 항상 어떤 프로세스가 실행되도록 하는 데 있다.  
시분할(time sharing)의 목적은 각 프로그램이 실행되는 동안 사용자가 상호 작용할 수 있도록 프로세스들 사이에서 CPU를 빈번하게 교체하는 것이다.  
이 목적을 달성하기 위해 프로세스 스케쥴러는 CPU에서 실행 가능한 여러 프로세스들 중에서 하나의 프로세스를 선택한다.

-   스케줄링 큐 (Scheduling Queues)
    -   스케줄링 큐마다 해당 큐에 대해서 동작하는 스케쥴러가 있다고 보면 됨  
        [##_Image|kage@H4xqB/btq3ITykk2Z/wVG28AQxLL0lBVzOBxjxS0/img.png|alignCenter|width="100%" data-origin-width="470" data-origin-height="402" data-ke-mobilestyle="widthContent"|||_##]
    -   ready queue : 메인 메모리에 있으면서 즉시 실행 가능한 프로세스들의 큐 (프로세스 상태가 ready인 상태)
    -   device queue: 장치마다 한 개씩 존재, 해당 디바이스에 대해 입출력을 개시하고 완료를 기다리는 큐(device queue에 속한 프로세스의 상태는 wating)
    -   Job queue: 시스템에 있는 모든 프로세스들이 포함되어 있는 큐

## 스케쥴러(Schedulers)

-   단기 스케쥴러 (short-term scheduler / cpu scheduler) : 다음번에 사용할 프로세스를 선택해서, 해당 프로세스에게 CPU를 할당하는 스케쥴러 (ready queue에 대해 동작)
    -   매우 빈번하게 실행 됨
-   장기 스케쥴러 (long-term schelduler /job scheduler) : 어느 프로세스를 ready queue로 가져올지 결정하는 스케쥴러 (프로세스 상태를 new->ready 상태로 바꿀지 결정함)
    -   단기 스케쥴러만큼 빈번하게 동작하지 않음
-   중기 스케쥴러 (medium-term scheduler) : 메인 메모리에서 동작하는 프로세스를 swap disk라는 곳으로 잠깐 swapping 시켜서 메인 메모리 공간을 확보

## 문맥 교환 (Context Switch)

[##_Image|kage@bJDnDc/btq3JSTjpKg/j3XV9YmMcoea9lH9lF9Rx1/img.png|alignCenter|width="100%" data-origin-width="474" data-origin-height="394" data-ke-mobilestyle="widthContent"|||_##]

-   프로세스 사용이 전환될 때(p0->p1) P0가 사용되던 레지스터 값들을 p0의 PCB에 저장해야 한다. p1은 자신의 PCB에서 레지스터 값들을 불러온다.
-   즉, CPU가 이전의 프로세스 상태를 PCB에 보관하고, 또 다른 프로세스의 정보를 PCB에 읽어 레지스터에 적재하는 과정
-   PCB에 context가 저장되어 있다.
-   Context Switch 시간 자체는 시스템의 Overhead라고 할 수 있다. 이유는 시스템은 무조건 Context Switching을 해야 하나 그 행위 자체가 OVerhead라는 것이다. 가급적 Context Switch는 가능한 자주 하지 않고 짧게 하는 것이 좋다.



## 스레드란

-   프로세스의 실행 단위라고 할 수 있으며, 한 프로세스 내에서 동작되는 여러 실행 흐름으로 프로세스 내의 주소 공간이나 자원을 공유할 수 있다.
-   [##_Image|kage@Xfmfi/btq4JwOxi4i/KjwwUIetRf3s8nYmT8rUpK/img.png|alignCenter|width="100%" data-origin-width="244" data-origin-height="300" data-ke-mobilestyle="widthContent"|||_##]
-   위의 그림과 같이 Code, data, files, registers, stack을 담고 있는 프로세스가 있다고 가정하자.
-   만약 사용자가 똑같은 프로그램 3개를 실행한다면, 아래의 그림과 같이 3개의 프로세스가 실행될 것이다.
-   [##_Image|kage@LVtMG/btq4MfyH50y/WSFJTCZ1DUXceEGj9w2kY1/img.png|alignCenter|width="100%" data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]
-   그림을 보면 똑같은 프로그램을 바탕으로 실행한 프로세스임에도 불구하고, code, data, files 부분을 각각 갖고 있다. 이때 자원 낭비를 줄이고자 등장한 개념이 Threads(스레드)이다.
-   code : 실행 중에 바뀌지 않기 때문에 1개만 존재하면 된다.
-   data, files: 프로세스마다 다르기 하지만 자원 공유가 가능하기 때문에 1개만 존재하면 된다.
-   registers, stack: 실행시마다 달라지며, 공유 불가능하기 때문에 각각 존재해야 한다.
-   이러한 점을 고려하면 아래와 그림과 같이 하나의 프로레스로 표현 가능하다. 이때 registers와 stack 부분을 합쳐서 Threads라고 한다.
-   [##_Image|kage@cp7Dwx/btq4HrgAWet/k2uTrXkHoKkKubJlJyvOQ1/img.png|alignCenter|width="100%" data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|||_##]
-   스레드는 한 번의 실행을 나타내는 registers와 stack을 포함하는 개념이고, 그림에서 곡선 모양이 Threads를 의미한다.
-   이러한 그림을 Multithreaded process라고 한다.
-   커널은 일반적으로 멀티 스레드로 구분됨

## 멀티스레드의 장점

1.  Responsiveness(응답성 증가) : (기다리지 않고 다른 동작이 별로도 동작을 하기 때문에)
2.  Resource Sharing (자원 공유) : 프로세스와 달리 요청 없이 자연스럽게 자원을 공유할 수 있다.
3.  Economy (경제성) : 프로세스를 생성하기 위해서는 많은 비용이 들지만, 스레드들은 자원을 공유하기 때문에 경제적이다.

## 멀티스레드의 대표적인 사용 사례 (web server)

-   [##_Image|kage@n6wRg/btq4F2VsSil/RqVPfmXTDKGBJ55OMkWrP0/img.png|alignCenter|width="100%" data-origin-width="1452" data-origin-height="686" data-ke-mobilestyle="widthContent"|||_##]
-   새로운 요청이 올 때 멀티스레드를 사용하여 클라이언트와 통신을 함

출처 - 공룡 책 (Operating System Concepts)

