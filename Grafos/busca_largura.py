from Queue import Queue

__author__ = "Daniel Mitre"

"""
A busca em largura eh muito util para encontrar a menor distancia,
pois em um grafo com arestas sem peso ela garante que o primeiro
caminho encontrado de um vertice a outro eh o menor possivel

OBS.: Substituindo a fila por uma pilha, esse algoritmo vira uma busca em profundidade
"""

adj = {1: [2, 5], 2: [3], 3: [4], 4: [5]} #listas de adjacencia

def bfs(de, para):
    fila = Queue()
    fila.put((de, 0))   #(no_atual, distancia_atual)

    while not fila.empty():
        node, dist = fila.get()
        if node == para:
            return dist

        if node not in adj:
            adj[node] = []

        for viz in adj[node]:
            fila.put((viz, dist+1))

    return -1
