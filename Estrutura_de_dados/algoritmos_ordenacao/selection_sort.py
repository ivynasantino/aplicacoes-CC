'''
O principal objetivo do selection sort é colocar o menor elemento de uma lista
na primeira posicao nao ordenada.

Complexidade:
	pior caso:   O(n^2)
	caso medio:  O(n^2)
	melhor caso: O(n^2)

Nao indicado para ordenar listas de tamanho elevado.
'''

def selection_sort(lista, inicio, fim):
	for i in range(inicio, fim):
		menor = i
		for j in range(i+1, fim):
			if lista[j] < lista[menor]:
				menor = j
		
		if lista[i] != lista[menor]:
			aux = lista[i]
			lista[i] = lista[menor]
			lista[menor] = aux
			
