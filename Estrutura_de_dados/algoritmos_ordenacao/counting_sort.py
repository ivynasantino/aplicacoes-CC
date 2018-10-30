'''
A ideia do counting sort eh determinar, para cada valor da lista, quantos
elementos da lista sao menores que este valor. Desta forma, se ha 15 elementos
menores que um dado valor x na lista, x ocupara a posicao 16

Complexidade: O(m), sendo m o maior elemento da lista 

Funciona apenas para ordenar listas de valores inteiros não-negativos,
porém é possível somar um valor fixo a todos os elementos até que estejam todos não-negativos
e subtrair o valor após a ordenação.
'''

#ordenação in-place via counting sort
def counting_sort(lista):
    maior = max(lista)
    tamanho = maior + 1
    frequencia = [0] * tamanho
	
    for valor in lista:
        frequencia[valor] += 1
	
    j = 0
    for valor in range(tamanho):
        for _ in range(frequencia[valor]):
            lista[j] = valor
            j += 1

		
#ordenação via counting sort sem efeito colateral
def sorted(lista):
    maior = max(lista)
    tam = maior + 1
    freq = [0] * tam

    for valor in lista:
        freq[valor] += 1

    output = []
    for valor in range(tam):
        for _ in range(freq[valor]):
            output.append(valor)

    return output
