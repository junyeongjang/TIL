#include <stdio.h>

int		ft_strcmp(char *s1, char *s2);
int main(void)
{
	printf("%d \n", ft_strcmp("123", "123"));
	printf("%d \n", ft_strcmp("123", "456"));
	printf("%d \n", ft_strcmp("1234", "123"));
	printf("%d \n", ft_strcmp("123", "1234"));
	
}
