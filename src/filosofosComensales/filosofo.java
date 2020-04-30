package filosofosComensales;
import prodComMonitores.Util;

class filosofo implements Runnable{
	ComidaComensales b = null;
	int ID;
	public filosofo( ComidaComensales initb , int id) {
		b = initb;
		ID = id;
	}
	public void pensar()
	{
		System.out.println("Soy el filosofo " + ID + " pensando, sí que sí.");
		Util.mySleep(200);
	}
	
	public void comer()
	{
		System.out.println("Filosofo " + ID + " comiendo. Yummi :D");
		Util.mySleep(200);
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
