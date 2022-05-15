package Thread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread extends JDialog {
	
	public TelaTimeThread() { /*Executa o que estiver dentro no momeno da abertura ou execução*/
		
		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		/*Primeira tela concluída*/
		
		/*Sempre será o último comando*/
		setVisible(true); /*Torna a tela visivel para o usuário*/
	}

}
