package view;

import javax.swing.*;
import javax.swing.border.*;


public class mainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public mainView() {
		setTitle("Gerenciamento de Receitas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 38, 705, 495);
		contentPane.add(tabbedPane);
		
		JPanel panel = new AddRecipe();
		tabbedPane.addTab("Add Receita", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new RecipeManager();
		tabbedPane.addTab("Gerenciamento", null, panel_1, null);
		panel_1.setLayout(null);
	}

}
