# coding: utf-8
__author__ = 'Ivyna Santino'

'''
O algoritmo de busca binária utiliza da recursão para realizar
uma procura. Dessa forma, o objetivo do algoritmo é otimizar o
tempo de busca fazendo acessos pelo elemento central, se não for
o elemento procurado, realiza a busca novamente mas apenas sobre
os elementos da direita(se o elemento do meio for maior que o
valor do procurado) e a esquerda(se o elemento do meio for menor
que o valor do procurado). Assim, em comparação ao algoritmo de
busca sequencial, faz com que ganhe em performasse, já que faz
menos buscas, e ao trabalhar com grandes quantidades de dados
otimiza o tempo.

Para funcionar corretamente a lista/conjunto deve estar ordenada
e o valor procurado pertencer aos dados.
'''


def busca_binaria(lista, valor, inicio, fim):
	result = 0
	meio = (inicio + fim)/2
	lista.sort()
	if (valor not in lista):
		result = 'Valor nao pertence ao conjunto'
	elif (lista[meio] == valor):
		result = lista[meio]
	elif (lista[meio] > valor):
		result = busca_binaria(lista, valor, inicio, meio-1)
	else:
		result = busca_binaria(lista, valor, meio+1, fim)
	
	return result

