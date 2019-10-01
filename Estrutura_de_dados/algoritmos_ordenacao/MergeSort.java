import java.util.LinkedList;
import java.util.List;

/*
Sua ideia básica consiste em Dividir (o problema em vários subproblemas e resolver esses subproblemas através da 
recursividade) e Conquistar (após todos os subproblemas terem sido resolvidos ocorre a conquista que é a união das 
esoluções dos subproblemas). Como o algoritmo Merge Sort usa a recursividade, há um alto consumo de memória e tempo 
de execução, tornando esta técnica não muito eficiente em alguns problemas.

Os três passos úteis dos algoritmos de divisão e conquista, que se aplicam ao merge sort são:
	- Dividir: Calcula o ponto médio do sub-arranjo, o que demora um tempo constante {\displaystyle \Theta (1)}{\displaystyle \Theta (1)};
	- Conquistar: Recursivamente resolve dois subproblemas, cada um de tamanho n/2, o que contribui com {\displaystyle 2T(n/2)}{\displaystyle 2T(n/2)} para o tempo de execução;
	- Combinar: Unir os sub-arranjos em um único conjunto ordenado, que leva o tempo {\displaystyle \Theta (n)}{\displaystyle \Theta (n)}.

Complexidade:
	- Pior caso: O(nlogn)
	- Caso medio: O(nlogn)
	- Melhor caso: O(nlogn)

*/
public class MergeSort<T extends Comparable<T>> {

	public void sort(T[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int meio = (left + right) / 2;
		sort(array, left, meio);
		sort(array, meio+1, right);
		this.merge(array, left, meio, right);
	}

	private void merge(T[] array, int left, int meio, int right) {
		int limite1 = meio - left;
		int limite2 = right - meio;
		
		List<T> lista1 = new LinkedList<>();
		List<T> lista2 = new LinkedList<>();
		
		for (int i = 0; i <= limite1; i++) {
			lista1.add(array[left + i]);
		}
		
		for (int i = 0; i < limite2; i++) {
			lista2.add(array[meio + 1 + i]);
		}
		
		int i = 0;
		int j = 0;
		int k = left;
		
		while((i <= limite1) && (j < limite2)) {
			if (lista1.get(i).compareTo(lista2.get(j)) > 0) {
				array[k] = lista2.get(j);
				j++;
			} else {
				array[k] = lista1.get(i);
				i++;
			}
			k++;
		}
		while (i <= limite1) {
			array[k] = lista1.get(i);
			i++;
			k++;
		}

		while (j < limite2) {
			array[k] = lista2.get(j);
			j++;
			k++;
		}
	}
}
