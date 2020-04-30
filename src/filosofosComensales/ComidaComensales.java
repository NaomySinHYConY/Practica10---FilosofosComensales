package filosofosComensales;

public class ComidaComensales {
	final int size = 5;
	double buffer[] = new double[size];
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador sinc[] = new SemaforoContador[5];
	String estadosf[] = new String[5];
	public ComidaComensales(){
		for (int i=0; i < 5; i++) {
			sinc[i] = new SemaforoContador(0);
			estadosf[i] = "Pensar";
			}
		}
	
	public void tomar_tenedores(int i) {
		System.out.println("Entrando ID: " + i);
		mutex.P(); // asegura la exclusión mutua
		estadosf[i] = "Hambre";
		probar_bocado(i);
		mutex.V();
		sinc[i].P(); // notifica a algún consumidor en espera
	}
	
	public void soltar_tenedores(int i)	{
		mutex.P(); // asegura la exclusión mutua
		estadosf[i] = "Pensar";
		int left = (i-1%5);
		int right = (i+1%5);
		
		if(left == -1) {
			left = 4;
		}
		if(right == 5) {
			right = 0;
		}
		
		probar_bocado(left);
		probar_bocado(right);
		mutex.V();
	}
	
	public void probar_bocado(int i) {
		int left = (i-1%5);
		int right = (i+1%5);
		
		if(left == -1) {
			left = 4;
		}

		if(right == 5) {
			right = 0;
		}
		if(estadosf[i] == "Hambre" && estadosf[left] != "Comer" && estadosf[right]!="Comer") {
			estadosf[i] = "Comer";
			mutex.V();
		}
	}

}
