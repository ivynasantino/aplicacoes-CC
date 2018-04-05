__author__ = "Ivyna Santino"

'''
O algoritmo quick sort percorre uma lista recursivamente
selecionando um pivot pelo metodo de particao. Dessa forma, 
tudo que for menor que o pivot ficara para a esquerda dele, 
e tudo que for maior a sua direita.

Complexidade:
	
	pior caso: O(n^2)
	caso medio: O(n.logn)
	melhor caso: O(n.logn)
	
'''


def quick(lista, ini, fim):
	if ini < fim:
		pivot = partition(lista, ini, fim)
		quick(lista, ini, pivot - 1)
		quick(lista, pivot + 1, fim)


def partition(lista, ini, fim):
	pivot = lista[ini]
	cont = ini
	
	for i in range(ini + 1, fim + 1):
		if lista[i] < pivot:
			cont += 1
			lista[cont], lista[i] = lista[i], lista[cont]
				
	lista[ini], lista[cont] = lista[cont], lista[ini]

	return cont
	
