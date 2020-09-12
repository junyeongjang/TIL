#include<stdio.h>
//	문자열 s 중의 문자 c를 모두 제거하는 함수 
void squeeze(char s[], int c){
	int i,j;

	for(i = j = 0; s[i] != '\0', i++)
		if(s[i]!=c)
			s[j++] = s[i];
	s[j] = '\0';
}


