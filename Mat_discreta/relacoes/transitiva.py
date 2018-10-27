# -*- coding: utf-8 -*-

'''
Algoritmo que recebe como parâmetros um conjunto no qual a relação será aplicada e a própria relação.

Exemplos: conjunto = [1,2,3,4] relacao = [(1, 1),(1, 2),(1, 4),(2, 1),(2, 2),(3, 3),(4, 1),(4, 4)]
		  result = False

		  conjunto = [1,2,3,4] relacao = [(2, 1),(3, 1),(3, 2),(4, 1),(4, 2),(4, 3)]
		  result = True
'''
def transitiva(A, relacao):
    for a in A:
        for b in A:
            for c in A:
                if (a,b) in relacao and (b,c) in relacao and not (a,c) in relacao:
                    return False
    return True

