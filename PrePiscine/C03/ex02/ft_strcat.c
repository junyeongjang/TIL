/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_strcat.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/21 15:55:52 by jjang             #+#    #+#             */
/*   Updated: 2020/10/21 16:00:11 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

char	*ft_strcat(char *dest, char *src)
{
	int index;
	int index2;

	index = 0;
	index2 = 0;
	while (dest[index])
		index++;
	while (src[index2])
	{
		dest[index] = src[index2++];
		index++;
	}
	dest[index] = '\0';
	return (dest);
}
