 

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