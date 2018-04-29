'''
O algoritmo bubble sort percorre uma lista diversas vezes de forma que, 
a cada percorrida, o maior elemento va para o fim da lista.

Complexidade:
	pior caso:   O(n^2)
	caso medio:  O(n^2)
	melhor caso: O(n)

Nao indicado para ordenar listas de tamanho elevado.

'''

def bubblesort(lista, inicio, fim):
	trocou = True
	while trocou:
		trocou = False
		for i in range(inicio, fim-1):
			if lista[i] > lista[i+1]:
				lista[i], lista[i+1] = lista[i+1], lista[i]
				trocou = True
