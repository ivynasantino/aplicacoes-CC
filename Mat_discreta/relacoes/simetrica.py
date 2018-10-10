# -*- coding: utf-8 -*-

'''
Algoritmo que recebe como parâmetros um conjunto no qual a relação será aplicada e a própria relação.

Exemplos: conjunto = [1,2,3,4] relacao = [(1, 1),(1, 2),(2, 1),(2, 2),(3, 4),(4, 1),(4, 4)]
		  result = False

		  conjunto = [1,2,3,4] relacao = [(1, 1),(1, 2),(1, 4),(2, 1),(2, 2),(3, 3),(4, 1),(4, 4)]
		  result = True
'''
def simetrica(conjunto, relacao):
    for a in conjunto:
        for b in conjunto:
            if (a,b) in relacao and not (b,a) in relacao:
                return False
    return True