'''
O objetivo do insertion sort é criar uma sub-lista ordenada no inicio 
de uma lista, e ir inserindo nessa sub-lista os elementos na ordem correta,
até que a sub-lista contenha todos os elementos da lista, fazendo com que
a mesma esteja ordenada

Complexidade:
	pior caso:   O(n^2)
	caso medio:  O(n^2)
	melhor caso: O(n)
	
Nao eh indicado para ordenar listas de tamanho elevado, mas eh o mais 
rápido entre os algoritmos de ordenacao O(n^2).
'''

def insertion_sort(lista, inicio, fim):
	for i in range(inicio+1, fim):
		pivot = lista[i]
		controle = i
		while controle > inicio and pivot < lista[controle-1]:
			lista[controle] = lista[controle-1]
			controle -= 1
		lista[controle] = pivot
