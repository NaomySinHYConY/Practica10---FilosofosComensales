package filosofosComensalesMonitor;

public class Monitor {
	public static void main( String[] args )
    {
		int tamagno = 5;
    	ComidaComensales buffer = new ComidaComensales();
        Filosofo[] grupo = new Filosofo[tamagno];
        
        for(int i = 0; i < tamagno; i++){
        	grupo[i] = new Filosofo(buffer, i);
        }
        
        for(int i = 0; i < tamagno; i++){
        	grupo[i].start();
        }
    }
}
