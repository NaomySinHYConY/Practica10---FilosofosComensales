package filosofosComensales;

public class ComensalesFilosofos {
	public static void main(String args[]) {
		ComidaComensales buffer = new ComidaComensales();
		filosofo grupo[] = new filosofo[5];
		
		for(int i=0; i<5; i++) {
			grupo[i] = new filosofo(buffer, i);
		}
		for(int i=0; i<5; i++) {
			new Thread( grupo[i] ).start();
		}
	}
}
