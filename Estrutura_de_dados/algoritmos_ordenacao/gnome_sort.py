'''
O algoritmo Gnome Sort ordena uma lista comparando seus elementos em pares.
Assim que um elemento maior que seu sucessor for detectado, a posicao 
desses elementos eh invertida em direcao ao inicio da lista ate que estejam 
na posicao correta.

Complexidade: O(n^2)

Nao indicado para ordenar listas de tamanho elevado.
'''

def gnome_sort(lista):
  pivot = 0
  tamanho = len(lista) 
  while pivot < tamanho - 1:
    if lista[pivot] > lista[pivot + 1]:
      lista[pivot + 1], lista[pivot] = lista[pivot], lista[pivot + 1]
      if pivot > 0:
        pivot -= 2
    pivot += 1
