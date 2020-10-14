## shell01(쉘 문제)

- EX01: **print_groups**

  - Turn-in directory : ex01/
     Files to turn in : print_groups.sh Allowed functions : None
     Notes : n/a

  - 환경변수 FT_USER에 포함된 login이 소속되어 있는 그룹의 목록을 표시하는 명령 어를 작성하세요. 공백 없이 쉼표로 분리되어야 합니다

  - 로그인되어 있는 그룹 목록을 표시하기 위해서는 id 혹은 groups 명령어를 통해 출력할 수 있다.(man id , man groups 참고) 둘이 똑같은 명령으로 보여짐

  - 또한 출력형식을 지정하기 위해서 sed와 tr을 사용하면 된다.(sed 문자열 치환, 문자열 제거 -d)

  - tr -d 는 문자열을 제거함

  - ```
     id -Gn $FT_USER | sed 's/ /,/g' | tr -d '\n'
     
     // sed는 원본 파일에 영향을 주지않고 출력에만 영향을 주는 리눅스 명령어이다.
     (sed 's/찾을텍스트/바꿀텍스트/' 파일명)
     // sed s 는 문자열 치환 명령어 , 마지막의 g는 행을 치환하는 것이 아닌 파일 전체를 치환한다는 이야기임ㅌ
     ```

- EX02: **find_sh**

  - Turn-in directory : ex02/
  -  Files to turn in : find_sh.sh 
  - Allowed functions : None
  -  Notes : n/a
  -  현재 디렉토리와 그 하위 디렉토리들에서 파일 이름이 ’.sh’로 끝나는(따옴표 제외) 모 든 파일을 찾는 명령어를 작성하세요. .sh를 제외한 파일 이름만을 표시해야 합니다.
  -  find . 은 현재 디렉토리와 하위 디렉토리를 모두 포함한다.
  -  find 로 찾은 파일을 exac로 실행한다. basename은 순수 파일명을 가져오는 명령어, {}은 Find로 찾은 파일을 의미함
  -  exec는 세미콜론이 나올 때 까지 적용됨

  - ```
    답 : find . -name "*.sh" -exec basename {} \; | sed 's/.sh$//'
    ```

  - shell00과 유사한 문제 있음

  - EX03 : **count_files**

  - Turn-in directory : ex03/

  - Files to turn in : count_files.sh 

  - Allowed functions : None

  - 현재 디렉토리 및 그 하위의 모든 디렉토리에 있는 일반 파일 및 디렉토리의 개수 를 세어 표시하는 명령어를 작성하세요. 여기에는 시작 디렉토리인 ’.’도 포함되어야 합니다.

  - wc를 통해 행 라인을 세고, tr 을 통해 공백을 제거했다, tr대신에 sed도 사용 가능할듯

  - ```
    $ wc  [-clmw] [file ....]
    
    기본형식 : wc 옵션 파일이름
    파일이름을 입력하지 않으면 표준 입력으로 부터 정보를 받아들여 계산한다.
    -l 행
    -w 단어
    -c 문자
    ```

  - ```
    find . | wc -l | tr -d ' '
    ```

- EX04 : **MAC**

  - Turn-in directory : ex04/ 

  - Files to turn in : MAC.sh 

  - Allowed functions : None

  - 컴퓨터의 MAC 주소를 표시하는 명령어를 작성하세요. 각 주소 다음에는 줄바꿈이 나타나야 합니다.

  - ifconfig 네트워크 인터페이스 정보를 출력한후, grep과 sed, tr 을 통해 출력 포맷을 맞췄다.

  - ```
    ifconfig | grep 'ether ' | sed 's/.ether//g'  | tr -d ' '
    ```

- EX05 : **Can you create it ?**

  - Turn-in directory : ex05/ 

  - Files to turn in : "\?$*’MaRViN’*$?\" 

  - Allowed functions : None

  - 오직 "42"만 포함하고 그 밖의 어떠한 것도 포함하지 않는 파일을 작성하세요

  - backspace에 대한 개념 이해가 필요함

  - ```
    Double your \, like this: \\, so that your shell does not interpret the backslashes from your filename as escape characters.
    Escape " and ', like this: \", \', so that your shell interprets the double quotes as part of the filename.
    Escape $, like this: \$, otherwise your shell will think you're using a variable.
    Escape ? and *, like this: \?, \*, to prevent filename expansion.
    ```

  - ```
    touch \"\\\?\$\*\'MaRViN\'\*\$\?\\\"
    ```

  - 

- EX06 :  **Skip**

  - Turn-in directory : ex06/
  - Files to turn in : skip.sh 
  - Allowed functions : None
  -  ls -l 명령어의 첫 번째 행부터 시작하여 한 줄 걸러 보여주는 명령어를 작성하세요 (1,3,57 이런씩으로 홀수행을  출력하는 것으로 의미됨)
  - ls -l 의 리턴값을 받아 레코드를 조작할 수 있는 awk를 사용 
  - `awk`는 데이터를 조작할 수 있기 때문에 쉘 스크립트에서 사용되는 필수 툴이며, 작은 데이터베이스를 관리하기 위해서도 필수
  - awk의 내부 변수를 사용 NR 변수 : 각 레코드들의 번호는 awk의 빌트인 변수 NR에 저장된다. 레코드가 저장된 다음 NR의 값은 하나씩 증가한다
  - FNR 쓰지 않은 이유 : 현재 파일이 기준이라, skip.h의 파일 위치가 바뀌면 출력 결과가 바뀌게됨

- EX07 : **r_dwssap**

  - Turn-in directory : ex07/

  - Files to turn in : r_dwssap.sh 

  - Allowed functions : None

  - cat /etc/passwd 명령어의 출력 결과에서 주석은 삭제하고 두 번째 행부터 시작하 여 다른 모든 행들은 출력하되, 각 login들 거꾸로 반전시키고 알파벳 역순으로 정렬한 후, FT_LINE1 과 FT_LINE2 을 포함한 그 사이의 값들만 남겨두세요. 이 때, 각 login은 ","로 구분되어야 하며 출력 결과는 "."로 끝나야 합니다.(큰따옴표 없이) 

  - ```
    root : x: 0: 0: root: /root: /bin/bash
    
      1     2  3  4   5       6         7
    
    1. 사용자 계정
    
    2. 패스워드 ( /etc/shadow 파일에 암호화 되어 있음)
    
    3. UID
    
    4. GID
    
    5. 사용자 이름
    
    6. 사용자의 홈 디렉터리 설정
    
    7. 사용자의 셸 정의
    ```

  - 

  - grep -v -e "#"  (-v -> ~을 제외하고  출력, -e는 정규표현식 )

  - 

    

