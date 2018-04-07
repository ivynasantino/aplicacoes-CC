# coding: utf-8
__author__ = "Ivyna Santino"

'''
Pequeno algoritmo para exemplicar o conceito de união abordado 
no conteúdo de Teoria dos conjuntos. No qual, existem dois conjuntos
exemplificados com listas, e seu objetivo é fazer o merge das duas
listas retirando os elementos que irão se repetir.

Exemplo: a = [1,2,5] e b = [2,7,4]
		Resultado = [1,2,5,7,4]
		
As linguagens implementam o conceito de conjunto com os Set 
que implementam as definições de não aceitar elementos
repetidos.

'''

def uniao(l1, l2):
	uniao = l1 + l2
	return retiraIguais(uniao)

def retiraIguais(l1):
	aux = []
	for i in l1:
		if i not in aux:
			aux.append(i)
	return aux

