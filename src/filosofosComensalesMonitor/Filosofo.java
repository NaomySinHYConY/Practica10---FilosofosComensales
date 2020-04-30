package filosofosComensalesMonitor;
import prodComMonitores.Util;

public class Filosofo extends Thread
{
	ComidaComensales b = null;
	int ID;
	
	public Filosofo(ComidaComensales buff, int id)
	{
		b = buff;
		ID = id;
	}

	public void pensar()
	{
		System.out.println("Soy el filosofo " + ID + " pensando, sí que sí.");
		Util.mySleep(400);
	}
	
	public void comer()
	{
		System.out.println("Filósofo " + ID + " comiendo. Yumm :D");
		Util.mySleep(400);
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			pensar();
			b.tomar_tenedores(ID);
			comer();
			b.soltar_tenedores(ID);
		}
	}
}
