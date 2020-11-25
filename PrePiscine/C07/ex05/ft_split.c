/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_split.c                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jjang <jjang@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/10/30 21:49:34 by jjang             #+#    #+#             */
/*   Updated: 2020/10/30 23:50:15 by jjang            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdlib.h>

char	**g_res;
int 	g_k;

int		ft_strlen(char *str)
{
	int len;

	len = 0;
	while (str[len])
		len++;
	return (len);
}

int		is_charset(int index, char c, char *charset, int len)
{
	int i;

	i = -1;
	if (index == 0)
		return (1);
	else if (index + 1 == len)
		return (1);
	else
	{
		while (charset[++i])
			if (charset[i] == c)
				return (1);
	}
	return (0);
}

void	push_char(char *str, int start, int end, int cnt)
{
	int i;
	
	i = 0;
	g_res[g_k] = (char*)malloc(sizeof(char) * cnt + 2);
	while (start <= end)
	{
		g_res[g_k][i] = str[start];
		start++;
		i++;
	}
	g_res[g_k][i] = '\0';
	g_k++;
}

void	check_str(char *str, char *charset, int size)
{
	int i;
	int j;
	int cnt;

	i = 0;
	while (str[i])
	{
		if (is_charset(i, str[i], charset, size))
		{	
			j = i + 1;
			cnt = 0;
			while (str[j])
			{
				if (is_charset(j, str[j], charset, size)) 
				{
					push_char(str, i,  j, cnt);
					break;
				}
				j++;
				cnt++;
			}
		}
		i++;
	}
}

char	**ft_split(char *str, char *charset)
{
	int	size;
	
	size = ft_strlen(str);
	g_res = (char**)malloc(sizeof(char*) * size);
	check_str(str, charset, size);

	return (g_res);
}
