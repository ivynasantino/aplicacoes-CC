#coding: utf-8
__author__ = "Hiago Fernandes"

'''
Uma breve explicacao: A permutação é uma forma particular de arranjo, 
é um método de contagem que faz parte do conteúdo de análise combinatória.
O algoritmo abaixo gera todas as permutacoes possiveis de uma dada entrada. 
'''

def permuta(sequencia, inicio = 0):
	if inicio == len(sequencia) - 1:
		print sequencia
	else:
		for i in range(inicio, len(sequencia)):
			temp = sequencia
			sequencia = sequencia[i] + sequencia[:i] + sequencia[(i + 1):] 
			permuta(sequencia, inicio + 1)
			sequencia = temp
			
sequencia = raw_input()

permuta(sequencia)
