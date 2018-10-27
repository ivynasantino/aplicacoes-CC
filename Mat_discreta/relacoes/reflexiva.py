# -*- coding: utf-8 -*-

'''
Algoritmo que recebe como parâmetros um conjunto no qual a relação será aplicada e a própria relação.

Exemplos: conjunto = [1,2,3,4] relacao = [(1, 1),(1, 2),(2, 1),(2, 2),(3, 4),(4, 1),(4, 4)]
		  resultado = False

		  conjunto = [1,2,3,4] relacao= [(1, 1),(1, 2),(1, 4),(2, 1),(2, 2),(3, 3),(4, 1),(4, 4)]
		  resultado = True
'''
def reflexiva(conjunto, relacao):
    for elemento in conjunto:
        if not (elemento, elemento) in relacao:
            return False
    return True
