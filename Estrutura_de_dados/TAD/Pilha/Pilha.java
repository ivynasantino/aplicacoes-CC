package pilha;

public interface Pilha<T extends Comparable<T>> {
	
	public boolean push(T element);

	public T peek();
		
	public T pop();
	
	public void desempilha();
	
	public boolean isEmpty();
	
	public boolean isFull();
		
	public int size();
}
