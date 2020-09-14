
//do while 문이 사용되는 itoa 예제 
void itoa(int n, char s[])
{
	int i, sign;

	if ((sign = n) < 0)
		n = -n;

	i=0;
	do{
		s[i++] = n % 10 +'0';
	}while((n/=10)>0);
	
	if(sign<0)
		s[i++] = '-';
	s[i] = '\0';

	reverse(s);


}
