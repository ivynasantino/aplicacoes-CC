__author__ = "Matheus Alves"

'''
A valência (ou grau) de um nó é dada pelo número de arestas incidentes a
ele. As arestas que conectam um nó a si mesmo (diz-se laço) são contadas
duas vezes. Por exemplo, considerando o grafo representado pela lista de
adjacência:

                      { A: [B], B: [B], C: [] }
                      
O nó "A" possui grau 1, o nó "B" possui grau 3 e o nó "C" possui grau 0.
Em situações que podem ser representadas por grafos, a valência de um nó
é utilizada para avaliar a importância de um componente para o sistema e
para medir o acoplamento do sistema.
'''

graph = {}

def add_node(node):
    if node not in graph:
        graph[node] = []

def add_edge(node1, node2):
    if node1 not in graph:
        add_node(node1)
    if node2 not in graph:
        add_node(node2)
    
    graph[node1].append(node2)

def add_undirected_edge(node1, node2):
    add_edge(node1, node2)
    add_edge(node2, node1)

def remove_node(node):
    if node in graph:
        graph.pop(node)
        for key in graph:
            if node in graph[key]:
                graph[key].remove(node)

def node_degree(node):
    return len(graph[node]) + graph[node].count(node)
