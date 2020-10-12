Shell00



- EX00 :  **Z**
  - Only the best know how to display Z
  - turn-in directory : ex00/ 
  - Files to turn in : z 
  - Allowed functions : None
  -  z라는 이름의 파일을 만들고, 이 파일에 cat 명령어를 사용하면 ’Z’와 함께 줄바꿈이 표시되도록 만드세요.
  - Z 입력후 cat으로 출력

```
Z
```

- EX01: **testShell00**

  - Turn-in directory : ex01/
  - Files to turn in : testShell00.tar
  -  Allowed functions : None
  - 제출 디렉토리에 testShell00라는 이름의 파일을 만드세요.
  - 출력 결과가 다음과 같이 나오도록 할 방법을 찾아보세요. (단 ’total 1’ 행은 제외)
  - 이전 단계들을 완료하였으면 다음 명렁어를 실행하여 제출할 파일을 생성하세 요.tar -cf testShell00.tar testShell00.

- EX02: **Oh yeah, mooore...**

  - Turn-in directory : ex02/ 
  - Files to turn in : exo2.tar 
  - Allowed functions : None
  - Turn-in directory : ex02/ Files to turn in : exo2.tar Allowed functions : None
  - 위의 작업을 다 하셨으면 tar -cf exo2.tar * 를 실행하여 제출할 파일을 생성하세요.
  - 파일 타입 뒤에 나오는 9개의 문자로 각 3글자씩 소유자(u), 그룹 사용자(g), 기타 사용자의 권한 표시(o)
  - chmod로 알아서 해결
  - 심볼릭 링크는 ln -s test0 test6

- EX03: 생략

- EX04: **midLS**

  - Turn-in directory : ex04/ 
  - Files to turn in : midLS 
  - Allowed functions : None
  -  midLS 파일에 본인의 현재 디렉토리 내의 모든 파일 및 디렉토리(숨겨진 파일이나 점 1개 또는 2개로 시작하는 모든 파일은 제외)를 생성일 순서로 쉼표로 분리해 나 열하는 명령어를 적으세요. 이 때, 디렉토리 이름 뒤에는 슬래시가 추가되어 있는지 확인하세요.
  - ls 옵션 잘 공부 (메뉴얼 보면서)

  ```
  ls -tUmp
  
  -t Sort by time modified (most recently modified first) before sorting the operands by lexicographical order.
  -U Use time of file creation, instead of last modification for sorting (-t) or long output (-l).
  -m Stream output format; list files across the page, separated by commas.
  -p Write a slash (`/') after each filename if that file is a directory.
  ```

    

- EX05: **GiT commit**

  - Turn-in directory : ex05/
  - Files to turn in : git_commit.sh 
  - Allowed functions : None
  - 자신의 git 저장소의 커밋 중 마지막 5개의 ID를 표시하는 쉘 스크립트를 작성하세요.
  - git log 옵션과  pretty옵션 찾아보기

  ```
  git log -5 --pretty="%H"
  ```

- EX06: **gitignore**

  - Turn-in directory : ex06/
  - Files to turn in : git_ignore.sh 
  - Allowed functions : None
  - 테스트위해 .gitignore 만들고 테스트
  - .DS_Store , mywork.c~ 

```
git ls-files --others --ignored --exclude-standard
```

- EX07 : **diff** 

  - Turn-in directory : ex07/ 
  - Files to turn in : b 
  - Allowed functions : None
  - b라는 파일을 생성하세요. 그리고 음... 아래 참조  
  - (현장에서 풀어야되는 문제)

  ```
  %>cat -e a
  STARWARS$
  Episode IV, A NEW HOPE It is a period of civil war.$
  $
  Rebel spaceships, striking from a hidden base, have won their first victory against the evil
  Galactic Empire.$
  During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon, the
  DEATH STAR,$
  an armored space station with enough power to destroy an entire planet.$
  $
  Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship, custodian of
  the stolen plans that can save her people and restore freedom to the galaxy...$ $
  ```

- EX08 : **clean**

  - Turn-in directory : ex08/ 

  - Files to turn in : clean

  -  Allowed functions : None

  - 현재 디렉토리와 그 하위 디렉토리들에서 파일 이름이 ~로 끝나거나, #로 시작하고 끝나는 모든 파일을 검색하는 명령어를 찾아 clean이라는 파일에 적으세요.

  - 이 명령어는 검색한 모든 파일을 표시하고 삭제합니다.

  - 오직 하나의 명령어만 사용해야 합니다. ’;’ 나 ’&&’, 또는 그 어떤 속임수도 허용되지 않습니다.

  - TIP: manfile

  - ```
    -name     : 지정된 문자열 패턴에 해당하는 파일 검색.
    ```

  - ```
     -exec     : 검색된 파일에 대해 지정된 명령 실행.
    ```

  - ```
    답 : find ./ -type f \( -name '#*#' -o -name '#' -o -name '*~' \) -exec rm -v {} \; 
    ```

- EX09:  **Illusions, not tricks, Michael...**

  - Turn-in directory : ex09/

  -  Files to turn in : ft_magic 

  - Allowed functions : None

  -  ft_magic라는 이름의 마법의 매직파일을 만들어주세요. 이 마법의 파일은 42 file 형식의 파일들을 탐지할 겁니다. 아 42 file 형식은 42번째 바이트에 "42" 문자열이 나오는 것을 뜻해요!

  - magic file에 대해 공부 

  - ```
    답 : 41 string 42 42 file
    ```

    

