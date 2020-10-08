#include<unistd.h>


void ft_putstr(char * str)
{

	int index = 0;
	while(1){
		if(*(str+index) == '\0') break;
		else index++;
	}	

	write(1, str, index); 

}
