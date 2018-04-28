package espaco;

public class Main {

	public static void main(String[] args) {
		Choque ch = new Choque();
		Particula p1 = new Particula(100);
		Particula p2 = new Particula(20);
		
		System.out.println(p1.getEnergia());
		System.out.println(p2.getEnergia());
		
		ch.choque(p1, p2);
		System.out.println(p1.getEnergia());
		System.out.println(p2.getEnergia());
		
	}
	
}
