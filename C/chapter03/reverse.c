#include<string.h>

// 문자열을 뒤집는 함수
void reverse(char s[]){
	int c,i.j;

	for(i=0, j=strlen(s)-1; i<j; i++, j--){
		c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}
