import java.util.LinkedList;
import java.util.List;

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