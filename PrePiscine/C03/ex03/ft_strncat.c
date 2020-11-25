/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_strncat.c                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/21 16:07:47 by jjang             #+#    #+#             */
/*   Updated: 2020/10/21 16:20:16 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

char	*ft_strncat(char *dest, char *src, unsigned int nb)
{
	unsigned int index;
	unsigned int index2;

	index = 0;
	index2 = 0;
	while (dest[index])
		index++;
	while (index2 < nb && src[index2])
	{
		dest[index] = src[index2++];
		index++;
	}
	dest[index] = '\0';
	return (dest);
}
