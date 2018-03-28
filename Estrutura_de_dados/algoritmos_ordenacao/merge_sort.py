__author__ = "Thalyta Fabrine"

'''
O merge sort eh um algoritmo do tipo dividir-para-conquistar, o objetivo
eh dividir a lista em duas a partir do ponto medio e resolver cada sub-lista
recursivamente, unindo as sub-listas em uma unica lista ja ordenada.

Complexidade:
	
	pior caso: O(n.logn)
	caso medio: O(n.logn)
	melhor caso: O(n.logn)

'''

def mergeSort(lista):
	if len(lista) > 1:
		meio = len(lista)/2
		esquerda = lista[:meio]
		direita = lista[meio:]
		
		mergeSort(esquerda)
		mergeSort(direita)
		
		i, j, k = 0
		
		while i < len(esquerda) and j < len(direita):
			if esquerda[i] < direita[j]:
				lista[k] = esquerda[i]
				i += 1
			else:
				lista[k] = direita[j]
				j += 1
			k += 1
		
		while i < len(esquerda):
			lista[k] = esquerda[i]
			i += 1
			k += 1
			
		while j < len(direita):
			lista[k] = direita[j]
			j += 1
			k += 1
