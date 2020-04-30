package filosofosComensales;
//import prodComMonitores.Util;

class filosofo implements Runnable{
	ComidaComensales b = null;
	int ID = -1;
	public filosofo( ComidaComensales initb , int id) {
		b = initb;
		ID = id;
	}
	public void run() {
		while( true ) {
			System.out.println("filosofo " + ID + " pensando");
			b.tomar_tenedores(ID);
			System.out.println("filosofo " + ID + " comiendo con tenedor " + ID + " y tenedor " + ID+1%5);
			b.soltar_tenedores(ID);
		}
	}
}
