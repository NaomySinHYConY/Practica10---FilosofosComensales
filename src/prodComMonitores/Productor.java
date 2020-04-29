package prodComMonitores;
import java.util.Random;

class Productor implements Runnable {
	BufferLimitadoMonitor b = null;
	public Productor( BufferLimitadoMonitor initb ) {
		b = initb;
		new Thread( this ).start();
	}
	public void run() {
		double item;
		Random r = new Random();
		while( true ) {
			item = r.nextDouble();
			System.out.println( "Art�culo producido " + item );
			b.deposit( item );
			Util.mySleep(400);
		}
	}
}