package PilhaParaleloThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FilaThreadImpl extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilhaFila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilhaFila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		while (true) {

			synchronized (pilhaFila) { /* Bloquear o acesso a esta lista por outro processo */
				Iterator iteracao = pilhaFila.iterator();

				while (iteracao.hasNext()) { /* Enquanto conter dados na lista irá processar */

					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next(); /* Pega o objeto atual */

					/*
					 * Processar 10k notas fiscais | Gerar uma lista enorme de PDF| Gerar um envio
					 * em massa de email
					 */
					System.out.println("------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
					iteracao.remove();

					try {
						Thread.sleep(500); /* Dar um tempo para descarga de memoria */
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
			try {
				Thread.sleep(1000); /* Processou toda a lista dar um tempo para limpeza de memória */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
