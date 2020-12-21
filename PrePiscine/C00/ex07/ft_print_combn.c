#include <unistd.h>

void 	print(int n, int *arr)
{
		int  i;
		char c;

		i = 0;
		while (i < n)
		{
			c = arr[i++] + '0';
			write(1, &c, 1);
		}
		write(1, &", ", 2);
}

void	dfs(int n, int depth, int *arr)
{
	int	i;

	if (n == depth)
		print(n, arr);
	else
	{
		if (depth == 0) 
			 i = 0;
		else 
			 i = arr[depth - i] + 1; 
		while(i <= 9)
		{	
			arr[depth] = i;
			dfs(n, depth+1, arr);
			i++;
		}
	}
}

void	ft_print_combn(int n)
{
	int arr[10];

	dfs(n, 0, arr);
}
