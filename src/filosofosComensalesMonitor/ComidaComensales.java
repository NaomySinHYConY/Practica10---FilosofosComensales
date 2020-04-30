package filosofosComensalesMonitor;
import prodComMonitores.Util;

public class ComidaComensales {
	String[] estadof = new String[5];
	
	// Estas son las variables de condición.
	int cont = 0;
	// Se define el máximo de filósofos que pueden comer a la vez.
	final int MaxCom = 2;
	
	public ComidaComensales()
	{
		for (int i = 0; i < 5; i++){
			estadof[i] = "Pensar";
		}
	}
	
	// Método de ingreso 
	public synchronized void tomar_tenedores(int i)
	{		
		estadof[i] = "Hambre";
		System.out.println("El filósofo " + i + " tiene hambre )=");
		
		probar_bocado(i);
		
		// Condición de sincronización
		
		while(cont == MaxCom)
			Util.myWait( this );
		//Aumentamos el contador
		cont++;
	}
	
	// Método de ingreso.
	public synchronized void soltar_tenedores(int i)
	{
		estadof[i] = "Pensar";
		
		int left = (i-1)%5;
		int right = (i+1)%5;
		
		if(left == -1) {
			left = 4;
		}
		if(right == 5) {
			right = 0;
		}
		
		probar_bocado(left); //Come el filósofo de la izquierda, si es posible.
		
		probar_bocado(right); //Come el filósofo de la derecha, si es posible.
		//Disminuímos el contador
		cont--;
	}
	
	private void probar_bocado(int i)
	{
		int left = (i-1)%5;
		int right = (i+1)%5;
		
		if(left == -1) {
			left = 4;
		}

		if(right == 5) {
			right = 0;
		}
		
		if ( estadof[i] == "Hambre" && estadof[left] != "Comer" 
			 && estadof[right] != "Comer") 
		{ 
			estadof[i] = "Comer";
			// Operación de notificación: el filósofo i está comiendo.
			notify(); 
		} 
		
	}
}
