/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_strcmp.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/21 15:24:14 by jjang             #+#    #+#             */
/*   Updated: 2020/10/21 15:36:54 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int		ft_strcmp(char *s1, char *s2)
{
	int index;
	
	index = 0;
	while (s1[index] && s1[index])
	{
		if (s1[index] > s2[index])
			return (1);
		else if (s1[index] < s2[index])
			return (-1);
		index++;
	}

	if (s1[index] == '\0' && s2[index] == '\0')
		return (0);
	else if (s1[index] == '\0')
		return (-1);
	else 
		return (1);
}
