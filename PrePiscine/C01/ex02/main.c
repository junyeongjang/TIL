#include<stdio.h>
void ft_swap(int * a, int * b);

int main(void)
{
	int a = 25;
	int b = 12;

	ft_swap(&a,&b);
	printf("a= %d b= %d \n", a,b);

	return 0;
}
