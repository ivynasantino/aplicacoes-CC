'''
A ideia do counting sort eh  determinar, para cada valor da lista, quantos
elementos da lista sao menores que este valor. Desta forma, se ha 15 elementos
menores que um dado valor x na lista, x ocupara a posicao 16

Complexidade: O(n) 

Funciona apenas para ordenar listas de valores inteiros positivos
'''

def counting_sort(lista):
	maior = max(lista)
	tamanho = maior + 1
	frequencia = [0] * (tamanho)
	
	for valor in lista:
		frequencia[valor] += 1
	
	j = 0
	for i in range(tamanho):
		for f in range(frequencia[i]):
			lista[j] = i
			j += 1
