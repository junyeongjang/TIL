// 문자열 복사 함수
void strcpy(char * s, char * t)
{
	while((*s=*t) != '\0'){
		s++;
		t++;
	}
}

void strcpy2(char *s, char * t)
{
	while((*s++=*t++) !='\0');

}

void strcpy3(char *s, char *t)
{
	while(*s++ = *t++);
}
