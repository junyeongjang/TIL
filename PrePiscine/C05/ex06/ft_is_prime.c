/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_is_prime.c                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/23 09:43:14 by jjang             #+#    #+#             */
/*   Updated: 2020/10/23 09:49:05 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int	ft_is_prime(int nb)
{
	int temp;
	int i;

	if (nb <= 1)
		return (0);
	temp = nb / 2;
	i = 2;
	while (i <= temp)
	{
		if (nb % i == 0)
			return (0);
		i++;
	}
	return (1);
}
