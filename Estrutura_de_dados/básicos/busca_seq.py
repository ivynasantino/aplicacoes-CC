# coding: utf-8
__author__ = 'Ivyna Santino'

'''
O algoritmo de busca sequencial é mais simples e intuitivo, no
entanto possui um custo bem maior para a máquina, já que é 
necessário percorrer todo o conjunto até achar o elemento. Em
grandes conjuntos de dados, torna-se um processo muito lento
e muitas das vezes impossível de realizar.

Complexidade: O(n) --> sendo n o tamanho da lista
'''

def busca_seq(lista, valor):
	result = 'Valor nao pertence ao conjunto'
	for i in lista:
		if i == valor:
			result = i
	return result
