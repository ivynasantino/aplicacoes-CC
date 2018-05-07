__author__ = "Daniel Mitre"

'''
Listas de adjacencia eh uma forma de representar grafos, podem ser implementados
com mapa/dicionario para grafos esparsos. Nela, cada linha/chave representa
um vertice, e ela contem uma lista dos vertices aos quais ele esta conectado.

Por exemplo, o grafo:
1 <--> 2 --> 3

Seria representado assim:
{
    1: [2],
    2: [1, 3],
    3: []
}

Complexidade*:
    Adicionar aresta: O(logn)
    Recuperar arestas de um vertice: O(logn+m), onde m eh a quantidade de arestas ligadas ao vertice
    Saber se ha ligacao entre vertices: O(logn+m)**, onde m eh a quantidade de arestas ligadas ao vertice
    Remover aresta: O(logn+m), onde m eh o total de elementos na frente do elemento a ser removido na lista

*O custo real dependera da implementacao da estrutura usada,
aqui assumiremos a complexidade em uma implementacao de mapa em arvore
**O custo pode ser reduzido para O(logn+logm) se a lista estiver ordenada
'''

lista_adj = {}

def add(de, para):
    if de not in lista_adj:
        lista_adj[de] = []
    lista_adj[de].append(para)

def add_undirect(node1, node2):
    add(node1, node2)
    add(node2, node1)

def remove(de, para):
    lista_adj[de].remove(para)

def remove_undirect(node1, node2):
    remove(node1, node2)
    remove(node2, node1)

def eh_vizinho(node1, node2):
    return node2 in lista_adj[node1]
