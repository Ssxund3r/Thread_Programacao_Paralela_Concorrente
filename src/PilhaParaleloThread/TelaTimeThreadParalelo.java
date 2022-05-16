package PilhaParaleloThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.github.javafaker.Faker;

public class TelaTimeThreadParalelo extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

	private JButton jButton = new JButton("Gerar...");
	private JButton jButton2 = new JButton("Stop");

	private FilaThreadImpl fila = new FilaThreadImpl();

	private static Faker faker = new Faker(Locale.ENGLISH);

	public TelaTimeThreadParalelo() { /* Executa o que estiver dentro no momento da abertura ou execução */

		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		/* Primeira tela concluída */

		GridBagConstraints bagConstraints = new GridBagConstraints(); /* Controlador de posicionamento de componentes */
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(5, 10, 5, 5);

		bagConstraints.anchor = GridBagConstraints.WEST;

		bagConstraints.gridwidth = 1;

		jButton.setPreferredSize(new Dimension(92, 25));
		bagConstraints.gridy++;
		jPanel.add(jButton, bagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		bagConstraints.gridx++;
		jPanel.add(jButton2, bagConstraints);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { /* Executa o click no botão */
				
				if(fila == null) {
					fila = new FilaThreadImpl();
					fila.start();
				}
				
				for (int i = 0; i < 100; i++) { /* Simulando 100 gerações para massas de dados */

					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(faker.name().fullName() + i);
					filaThread.setEmail(faker.internet().emailAddress() + i);

					fila.add(filaThread);
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fila.stop();
				fila = null;
			}
		});

		fila.start();
		add(jPanel, BorderLayout.WEST);
		/* Sempre será o último comando */
		setVisible(true); /* Torna a tela visivel para o usuário */
	}

}
