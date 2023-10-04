package view;

import model.recipe;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.filechooser.*;

public class AddRecipe extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txt_title;
	private JComboBox cb_category;
	private JTextArea  txt_ingredients;
	private JTextArea txt_recipe;
	private JButton btn_imagem;
	private recipe rcp = new recipe();
	private JLabel imagemLabel;
	private byte[] recipeImageBytes; // armazena a imagem em bytes

	/**
	 * Create the panel.
	 */
	public AddRecipe() {
		setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(350, 5, 0, 0);
		add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(355, 5, 0, 0);
		add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 10, 83, 35);
		add(lblNewLabel);
		
		cb_category = new JComboBox();
		cb_category.setModel(new DefaultComboBoxModel(new String[] {"Entradas", "Carnes", "Aves", "Vegetariano", "Doces", "Salgados"}));
		cb_category.setBounds(121, 18, 147, 22);
		add(cb_category);
		
		JLabel lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIngredientes.setBounds(28, 56, 105, 35);
		add(lblIngredientes);
		
		JLabel lblModoDePreparo = new JLabel("Modo de preparo:");
		lblModoDePreparo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblModoDePreparo.setBounds(28, 239, 157, 35);
		add(lblModoDePreparo);
		
		txt_ingredients = new JTextArea();
		txt_ingredients.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txt_ingredients.setBounds(28, 95, 254, 133);
		JScrollPane scroll_2 = new JScrollPane(txt_ingredients);
		scroll_2.setBounds(28, 95, 254, 133);
		scroll_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll_2);
		
		txt_recipe = new JTextArea();
		txt_recipe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txt_recipe.setBounds(28, 285, 644, 133);
		JScrollPane scroll_1 = new JScrollPane(txt_recipe);
		scroll_1.setBounds(28, 285, 644, 133);
		scroll_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNome.setBounds(329, 10, 83, 35);
		add(lblNome);
		
		txt_title = new JTextField();
		txt_title.setBounds(395, 19, 277, 20);
		add(txt_title);
		txt_title.setColumns(10);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setBounds(605, 434, 89, 23);
		add(btnNewButton);
		
		
		// add imagem1
		btn_imagem = new JButton("Carregar Imagem");
	    btn_imagem.setBounds(406, 155, 150, 23);
	    add(btn_imagem);

	    imagemLabel = new JLabel();
	    imagemLabel.setBounds(387, 69, 200, 200);
	    add(imagemLabel);

	    btn_imagem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));

	            int resultado = fileChooser.showOpenDialog(null);

	            if (resultado == JFileChooser.APPROVE_OPTION) {
	                try {
	                    File arquivoImagem = fileChooser.getSelectedFile();
	                    BufferedImage imagemOriginal = ImageIO.read(arquivoImagem);

	                    int larguraMaxima = 200; // Defina a largura máxima desejada
	                    int alturaMaxima = 200; // Defina a altura máxima desejada

	                    int larguraOriginal = imagemOriginal.getWidth();
	                    int alturaOriginal = imagemOriginal.getHeight();

	                    double escalaLargura = (double) larguraMaxima / larguraOriginal;
	                    double escalaAltura = (double) alturaMaxima / alturaOriginal;
	                    double escala = Math.min(escalaLargura, escalaAltura);

	                    int larguraRedimensionada = (int) (larguraOriginal * escala);
	                    int alturaRedimensionada = (int) (alturaOriginal * escala);

	                    // Converte a imagem em bytes
	                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                    ImageIO.write(imagemOriginal, "jpg", baos);
	                    recipeImageBytes = baos.toByteArray(); // Uncomment this line to store the image data

	                    // Exibe a imagem redimensionada
	                    Image imagemRedimensionada = imagemOriginal.getScaledInstance(larguraRedimensionada, alturaRedimensionada, Image.SCALE_SMOOTH);
	                    ImageIcon imagemIcon = new ImageIcon(imagemRedimensionada);
	                    imagemLabel.setIcon(imagemIcon);

	                    // Esconde o botão "Carregar Imagem" após carregar a imagem com sucesso
	                    btn_imagem.setVisible(false);
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
	    });
	
	    btnNewButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (txt_title.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Enter title of the recipe.", "Title Missing", JOptionPane.ERROR_MESSAGE);
	            } else {
	                rcp.setTitle(txt_title.getText());
	                rcp.setRecipe(txt_recipe.getText());
	                rcp.setCategory(cb_category.getSelectedItem().toString());
	                rcp.setIngredients(txt_ingredients.getText());

	                // Convert the image to a byte array
	                if (recipeImageBytes != null) {
	                    //rcp.setImagem(recipeImageBytes);

	                    // Save the recipe data including the image to the database
	                    if (rcp.saveData()) {
	                        JOptionPane.showMessageDialog(null, "Recipe has been added Successfully", "Data insertion Successful", JOptionPane.INFORMATION_MESSAGE);
	                        restoreDefaultValue();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Check connection and Try again", "Data insertion Failed", JOptionPane.ERROR_MESSAGE);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Please select an image.", "Image Missing", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    });	
	}	
	
	public void restoreDefaultValue() {
        txt_title.setText("");
        cb_category.setSelectedIndex(0);
        txt_ingredients.setText("");
        txt_recipe.setText("");
        btn_imagem.setVisible(true);
    }    
}
