__author__ = "Daniel Mitre"

'''
A matriz de adjacencia eh uma forma de representar um grafo.
Nessa estrutura, as linhas e colunas sao vertices, e quando ha
uma aresta entre eles, este fica representado nas posicoes da matriz

Por exemplo, o grafo:
1 --> 2 --> 3
Seria representado assim:
[False,  True, False]
[False, False,  True]
[False, False, False]

Complexidade:
    Adicionar aresta: O(1)
    Recuperar arestas de um vertice: O(n)
    Saber se ha ligacao entre vertices: O(1)
'''

SIZE = 3 #tamanho

matriz = [[False for _ in xrange(SIZE)] for _ in xrange(SIZE)]

def add(de, para):
    matriz[de-1][para-1] = True

def add_undirect(node1, node2):
    add(node1, node2)
    add(node2, node1)

def remove(de, para):
    matriz[de-1][para-1] = False

def remove_undirect(node1, node2):
    remove(node1, node2)
    remove(node2, node1)

def eh_vizinho(node1, node2):
    return matriz[node1-1][node2-1]
