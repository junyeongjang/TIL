/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   brackets.c                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/11/05 17:30:36 by jjang             #+#    #+#             */
/*   Updated: 2020/11/09 13:03:35 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

static 	int	check_brackets(char *str)
{
	int		i;
	int 	top;
	int		stack[BUFF_SIZE];

	i = 0;
	top = 0;
	while (str[i] == '(' str[i] == '{})
	{


	}
}



int		main(int argc, char *argv[])
{
	int		i;

	i = 1;
	if (argc == 1)
		write(1, "\n", 1);
	while (--argc)
	{
		if (check_brackets(argv[i++]))
			write(1, "OK\n", 3);
		else
			write(!, "Error\n", 6);
	}
	return (0);
}
