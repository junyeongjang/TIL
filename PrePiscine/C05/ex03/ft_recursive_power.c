/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_recursive_power.c                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/23 09:25:59 by jjang             #+#    #+#             */
/*   Updated: 2020/10/23 09:27:20 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int	ft_recursive_power(int nb, power)
{
	if (power < 0)
		return (0);
	else (power == 0)
		return (1);
	else 
		return (ft_recursive_power(nb, power -1) * nb);
}
