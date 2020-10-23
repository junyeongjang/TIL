/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_iterative_factorial.c                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/22 23:49:31 by jjang             #+#    #+#             */
/*   Updated: 2020/10/23 09:07:40 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>

int ft_iterative_factorial(int nb)
{
	int i;
	int res;

	i = 2;
	res = 1;
	if (nb < 0)
		return (0);
	while (i <= nb)
	{
		res = res * i;
		i++;
	}
	return (res);
}
