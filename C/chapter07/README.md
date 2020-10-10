## Chapter07

----

### 핵심 내용

- <string.h>
  - strcat(s,t) : t를 s의 끝에 연결시킨다.
  - strncat(s,t,n) : t 중의 n개 문자를 s의 끝에 연결시킨다. 
  - strcmp(s,t) : s<t, s==t나 s>t에 대해 -,0,+로 리턴한다.
  - strncmp(s,t,n) : strcmp와 같은데 단지 처음의 n개의 문자만 비교한다.
  - strcpy(s,t) : s에 t를 복사한다. 
  - strncpy(s,t,n): t의 n개 문자를 s에 복사한다. 
  - strlen(s) : s의 길이를 리턴한다.
  - strchr(s,c) : s에서 첫 번째 c의 포인터를 리턴하거나 존재하지 않으면 NULL을 리턴한다.
  - strrchr(s,c) : s에서 마지막 c의 포인터를 리턴하거나 존재하지 않으면 NULL을 리턴한다.
- <ctype.h>
  - isalpha(c) : c가 알파벳이면 0 아닌 숫자, 아니면 0
  - isupper(c) : c가 대문자라면 0 아닌 숫자, 아니면 0
  - islower(c) : c가 소문자면 0 아닌 숫자, 아니면 0
  - isdigit(c) : c가 숫자(digit)이면 0 아닌 숫자, 아니면 0
  - isalnum(c) : isalpha(c)이거나 isdigit(c)이면 0아닌 숫자, 아니면 0
  - issapace(c) : c가 공백, 탭, newline, 리턴, formfeed, 수직 탭이면 0아닌 숫자
  - toupper(c) : c는 대문자로 변환
  - tolower(c) : c는 소문자로 변환
- <math.h>
  - sin(x) : x의 sine, x는 라디안
  - cos(x) : x의 cosine, x는 라디안
  - atan2(y,x) : y/x의 arctangent,라디안 
  - exp(x) : 지수함수 e^x
  - log(x) : 자연로그 (x>0)
  - Log10(x) : 상용로그(x>0)
  - pow(x,y) : x^y
  - Sqrt(x) : x의 제곱근(x>=0)
  - Fabs(x) : x의 절댓값
