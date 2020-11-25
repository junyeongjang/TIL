#include <stdio.h>

char *ft_strncat(char *dest, char *src, unsigned int nb);
int main(void)
{
	char str[20] = "hi";
	printf("%s \n", ft_strncat(str, "123", 2));
}
