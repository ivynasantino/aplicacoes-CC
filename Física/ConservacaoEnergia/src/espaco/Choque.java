package espaco;

public class Choque {
	
	public void choque(Particula particula1, Particula particula2) {
		reduzMetade(particula1, particula2);
	}
	
	private void reduzMetade(Particula p1, Particula p2) {
		double media = (p1.getEnergia() + p2.getEnergia())/2.0;
		p1.setEnergia(media);
		p2.setEnergia(media);
	}
	
}