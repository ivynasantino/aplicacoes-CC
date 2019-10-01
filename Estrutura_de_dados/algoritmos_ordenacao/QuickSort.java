/*
O algoritmo do QuickSort usa uma técnica conhecida por divisão e conquista, muito conhecida por reduzir problemas complexos
em problemas menores para tentar chegar em uma solução. Sendo assim, o resultado do problema inicial é dada como a soma 
do resultado de todos os problemas menores. Sua complexidade é:

- Complexidade Pior Caso: O(n²)
- Complexidade Caso Médio: (nlogn)
- Complexidade Melhor Caso: (nlogn)

O algoritmo consiste nos seguintes passos:

- Escolhe-se um elemento qualquer da lista, que será chamado de pivô.
- Todos os elementos antes do pivô devem ser menores que ele e todos os elementos após o pivô devem ser maiores que ele. 
Quando esse processo de separação for finalizado, então o pivô deve estar exatamente no meio da lista.
- De forma recursiva os elementos da sublista menor e maiores são ordenados.
*/
public class QuickSort<T extends Comparable<T>> {

	public void sort(T[] array, int left, int right) {
		if (left < right) {
			int m = this.partition(array, left, right);
			this.sort(array, left, m-1);
			this.sort(array, m+1, right);
		}
	}

	private int partition(T[] array, int left, int right) {
		T pivot = array[left];
		int m = left;
		for (int i = left+1; i <= right; i++) {
			if (array[i].compareTo(pivot) <= 0) {
				m++;
				this.swap(array, i, m);
			}
		}
		this.swap(array, m, left);
		return m;
	}
	
	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
