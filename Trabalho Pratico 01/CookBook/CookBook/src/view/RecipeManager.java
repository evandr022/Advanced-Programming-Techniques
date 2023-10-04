package view;

import control.recipe;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;


public class RecipeManager extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private recipe rcp = new recipe();

	/**
	 * Create the panel.
	 */
	public RecipeManager() {
		setLayout(null);
		
		JLabel imagemLabel = new JLabel();
		imagemLabel.setBounds(352, 5, 0, 0);
		add(imagemLabel);
		
		JComboBox cb_category = new JComboBox();
		cb_category.setModel(new DefaultComboBoxModel(new String[] {"Entradas", "Carnes", "Aves", "Vegetariano", "Doces", "Salgados"}));
		cb_category.setBounds(115, 24, 147, 22);
		add(cb_category);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 16, 83, 35);
		add(lblNewLabel);
		
		JLabel lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIngredientes.setBounds(410, 85, 105, 35);
		add(lblIngredientes);
		
		JTextArea txt_ingredients = new JTextArea();
		txt_ingredients.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txt_ingredients.setBounds(410, 124, 254, 133);
		JScrollPane scroll_2 = new JScrollPane(txt_ingredients);
		scroll_2.setBounds(410, 124, 254, 133);
		scroll_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll_2);
		
		//JScrollPane txt_ingredients = new JScrollPane((Component) null);
		//txt_ingredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//txt_ingredients.setBounds(410, 124, 254, 133);
		//add(txt_ingredients);
		
		JLabel imagemLabel_1 = new JLabel();
		imagemLabel_1.setBounds(216, 110, 176, 167);
		add(imagemLabel_1);
		
		JLabel lblModoDePreparo = new JLabel("Modo de preparo:");
		lblModoDePreparo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblModoDePreparo.setBounds(20, 257, 157, 35);
		add(lblModoDePreparo);
		
		//JScrollPane txt_recipe = new JScrollPane((Component) null);
		//txt_recipe.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//txt_recipe.setBounds(20, 291, 644, 133);
		//add(txt_recipe);
		
		JTextArea txt_recipe = new JTextArea();
		txt_recipe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txt_recipe.setBounds(20, 291, 644, 133);
		JScrollPane scroll_1 = new JScrollPane(txt_recipe);
		scroll_1.setBounds(20, 291, 644, 133);
		scroll_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll_1);
		
		JButton btnNewButton = new JButton("DELETAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rcp.DeleteRecipe();
				txt_ingredients.setText("");
				txt_recipe.setText("");
				rcp.populateTable1(table, cb_category.getSelectedItem().toString());
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(576, 435, 105, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rcp.setIngredients(txt_ingredients.getText());
				rcp.setRecipe(txt_recipe.getText());
				rcp.UptadeRecipe();
			}
		});
		
		btnNewButton_1.setBounds(467, 435, 105, 23);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 57, 176, 200);
		table = new JTable();
		
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		rcp.populateTable1(table,cb_category.getSelectedItem().toString());
		
		cb_category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				rcp.populateTable1(table,cb_category.getSelectedItem().toString());
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = table.getSelectedRow();
		        if (row != -1) {
		            rcp.setTitle(table.getValueAt(row, 0).toString());
		            rcp = rcp.getRecipeData();
		            
		            if (rcp != null) {
		                txt_ingredients.setText(rcp.getIngredients());
		                txt_recipe.setText(rcp.getRecipe());
		            }
		        }
		    }
		});

	}
}
