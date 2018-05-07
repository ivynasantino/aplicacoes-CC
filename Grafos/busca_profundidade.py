__author__ = "Daniel Mitre"

'''
A busca em profundidade percorre todas as arestas a partir de um vertice.
Apesar da complexidade, sua implementacao eh simples e eh muito util,
principalmente em grafos sem ciclos (arvores, por exemplo)
'''

adj = {1: [4, 2], 2: [3], 4: [5]} #listas de adjacencia

def dfs(atual):
    '''
    Percorre todas as arestas a partir de um vertice
    '''
    print "entrei no vertice", atual
    if atual not in adj:
        adj[atual] = []
    for viz in adj[atual]:
        dfs(viz)
