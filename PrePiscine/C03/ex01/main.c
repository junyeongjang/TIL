#include <stdio.h>

int		ft_strncmp(char *s1, char *s2, unsigned int);
int main(void)
{
	printf("%d \n", ft_strncmp("123", "123", 3));
	printf("%d \n", ft_strncmp("123", "456", 3));
	printf("%d \n", ft_strncmp("1234", "123", 5));
	printf("%d \n", ft_strncmp("123", "1234",3));
	
}
