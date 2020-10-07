## shell01(쉘 문제)

- ex01

  - Turn-in directory : ex01/
     Files to turn in : print_groups.sh Allowed functions : None
     Notes : n/a

  - Write a command line that will display the list of groups for which the login, contained in the environment variable FT_USER , is a member. Separated by commas without spaces.

  - 번역 : 환경변수 FT_USER가 포함된 멤버를 공백 없이 출력하는 코드를 작성한다.

  - Examples :

    - for FT_USER=nours,theresultis"god,root,admin,master,nours,bocal"(with-out quotation marks)	
    - for FT_USER=daemon, the result is "daemon,bin" (without quotation marks)

    ```
    답: 
    id -G -n $FT_USER | sed 's/ /,/g' | tr -d '\n'
    
    // sed는 원본 파일에 영향을 주지않고 출력에만 영향을 주는 리눅스 명령어이다.
    // sed s 는 문자열 치환 명령어 , 마지막의 g는 행을 치환하는 것이 아닌 파일 전체를 치환한다는 이야기임
    // tr -d 는 문자열을 제거함
    // 
    ```

- ex02

  - find_sh.sh
    - Turn-in directory : ex02/
    -  Files to turn in : find_sh.sh 
    - Allowed functions : None
    -  Notes : n/a
  - Write a command line that searches for all file names that end with ".sh" (without quotation marks) in the current directory and all its sub-directories. It should display only the file names without the .sh.
  - 번역 : 현재 디렉토리 및 하위 디렉토리에서 .sh로 끝나는 모든 파일 이름을 검색하는 코드를 작성하라 단 .sh없이 파일 명만 출력 해야한다.
  - 

