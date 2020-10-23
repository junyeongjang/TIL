/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_iterative_power.c                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/23 09:16:26 by jjang             #+#    #+#             */
/*   Updated: 2020/10/23 09:24:32 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int		ft_iterative_power(int nb, int power)
{	
	int res;

	res = 1;
	if (power < 0)
		return (0);
	else if (nb == 0)
		return (1);
	while (power > 0)
	{
		res *= nb;
		power--;
	}
	return (res);
}
