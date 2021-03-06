
#include <unistd.h>

void	print_number(int num)
{
	char n[2];

	n[0] = num / 10 + '0';
	n[1] = num % 10 + '0';
	write(1, &n, 2);
}

void	ft_print_comb2(void)
{
	int		num[2];
	char	chars[2];

	num[0] = 0;
	chars[0] = ',';
	chars[1] = ' ';
	while (num[0] <= 98)
	{
		num[1] = num[0] + 1;
		while (num[1] <= 99)
		{
			print_number(num[0]);
			write(1, &chars[1], 1);
			print_number(num[1]);
			if (!(nums[0] == 98 && num[1] == 99))
			{
				write(1, &chars, 2);
			}
			num[1]++;
		}
		num[0]++;
	}
}
