package Thread;

public class ExemploThread {

	public static void main(String[] args) throws InterruptedException {

		for (int pos = 0; pos < 10; pos++) {
			Thread.sleep(1000);
			/* Executar este envio com um tempo de parada, ou com um tempo determinador */
			System.out.println("Executando alguma rotina. EX: envio de e-mail...");
		}
	}
}
