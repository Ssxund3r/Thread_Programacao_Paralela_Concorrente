package Thread;

import javax.swing.JOptionPane;

public class ExemploThread {

	public static void main(String[] args) throws InterruptedException {

		/* Thread processando em paralelo - envio de e-mail */
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		/*-----------------------------------------------------DIVIS?O DAS THREADS-----------------------------------------------*/

		/* Thread processando em paralelo - envio nota fiscal */
		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();

		/* C?digo do sistema continua o fluxo de trabalho */
		System.out.println("CHEGOU AO FIM DO C?DIGO DE TESTE - THREAD!");
		/*
		 * Exemplo de fluxo do sistema -> Cadastro de venda, emiss?o de nota fiscal
		 * etc....
		 */
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usu?rio!!!");
	}

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			/* Executa o que queremos */
			/* C?digo da rotina */

			/* C?digo da rotina para executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				/* Executar este envio com um tempo de parada, ou com um tempo determinador */
				System.out.println("Executando alguma rotina. EX: envio de e-mail...");
				try {
					Thread.sleep(2000); /* Aplica o tempo proposto */
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/* Fim do c?digo */

		}
	};

	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			/* Executa o que queremos */
			/* C?digo da rotina */

			/* C?digo da rotina para executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				/* Executar este envio com um tempo de parada, ou com um tempo determinador */
				System.out.println("Executando alguma rotina. EX: envio de NF-e...");
				try {
					Thread.sleep(4000); /* Aplica o tempo proposto */
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/* Fim do c?digo */
		}
	};
}
