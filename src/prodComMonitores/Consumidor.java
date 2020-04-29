package prodComMonitores;

class Consumidor implements Runnable {
	BufferLimitadoMonitor b = null;
	public Consumidor( BufferLimitadoMonitor initb ) {
		b = initb;
		new Thread( this ).start();
	}
	public void run() {
		double item;
		while( true ) {
			item = b.fetch();
			System.out.println( "Art�culo extra�do " + item );
			Util.mySleep(400);
		}
	}
}