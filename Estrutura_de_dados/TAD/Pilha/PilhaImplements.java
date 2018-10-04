package pilha;

public class PilhaImplements<T extends Comparable<T>> implements Pilha<T>{
	
	private T[] pilha;
	private int topo;
	private int capacidade;
	
	@SuppressWarnings("unchecked")
	public PilhaImplements(int capacidade) {
		this.capacidade = capacidade;
		this.pilha = (T[]) new Comparable[capacidade];
		this.topo = -1;
	}   

	@Override
	public boolean push(T element) {
		if (isFull())
			return false;
		topo++;
		pilha[topo] = element;
		return true;
	}

	@Override
	public T peek() {
		if (!(isEmpty()))
			return pilha[topo];
		throw new RuntimeException("A pilha não possui elementos.");
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Não há elementos para remover");
		T valorRemovido = pilha[topo];
		topo--;
		return valorRemovido;
	}

	@Override
	public void desempilha() {
		for (int i = topo; i >= 0; i--) {
			System.out.println(pop());
		}
	}

	@Override
	public boolean isEmpty() {
		return (this.topo == -1);
	}

	@Override
	public boolean isFull() {
		return (this.topo == capacidade - 1);
	}

	@Override
	public int size() {
		return topo + 1;
	}
}
