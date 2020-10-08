char * ft_strrev(char * str)
{
	char * str2;
	int index = 0;
	int cnt = 0;
	while(*(str+index) != '\0'){
		index++;
	}

	write(1,str,index);
	write(1,"=>",1);
	while(index>=0){
		*(str2+cnt) = *(str+index);
		index--;
		cnt++;	
	}
	retunr str2;
} 
