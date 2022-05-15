package TelaGraficaSwingThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout()); /*Painel de componentes*/
	
	private JLabel descricaoHora = new JLabel("Time Thread 1");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Time Thread 2");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jButton = new JButton("Start"); 
	private JButton jButton2 = new JButton("Stop"); 
 	
	public TelaTimeThread() { /*Executa o que estiver dentro no momeno da abertura ou execu��o*/
		
		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		/*Primeira tela conclu�da*/
		
		GridBagConstraints bagConstraints = new GridBagConstraints(); /*Controlador de posicionamento de componentes*/
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(5, 10, 5, 5);
		
		bagConstraints.anchor = GridBagConstraints.WEST;
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, bagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy++;
		mostraTempo.setEditable(false);
		jPanel.add(mostraTempo, bagConstraints); 
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy++;
		jPanel.add(descricaoHora2, bagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy++;
		mostraTempo2.setEditable(false);
		jPanel.add(mostraTempo2, bagConstraints);
		
		bagConstraints.gridwidth = 1;
		
		jButton.setPreferredSize(new Dimension(92, 25));
		bagConstraints.gridy++;
		jPanel.add(jButton, bagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		bagConstraints.gridx++;
		jPanel.add(jButton2, bagConstraints);
		
		add(jPanel, BorderLayout.WEST);
		/*Sempre ser� o �ltimo comando*/
		setVisible(true); /*Torna a tela visivel para o usu�rio*/
	}

}
