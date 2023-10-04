package model;

import java.sql.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.table.*;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class recipe {
    private String title;
    private String ingredients;
    private String category;
    private String recipe;
    //private byte[] imagem;
    
    DBConnection db = new DBConnection();

    public boolean saveData() {
        String query = "INSERT INTO `recipebook`.`recipedata` " +
                       "(`title`, `category`, `ingredients`, `recipe`) " +
                       "VALUES " +
                       "('" + this.title + "', '" + this.category + "', '" + this.ingredients + "', '" + this.recipe /*+ this.imagem*/ + "');";

        db.executeInsertUpdate(query);

        return true;
    }


    public recipe(String title, String ingredients, String category, String recipe /*, byte[] imagem*/) {
        super();
        this.title = title;
        this.ingredients = ingredients;
        this.category = category;
        this.recipe = recipe;
        //this.imagem = imagem;
    }

    public recipe() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


    public void populateTable(JTable table, String category2) {
		String query = "SELECT title FROM `recipebook`.`recipedata` WHERE category='" + category2 + "'";
		ResultSet rs = db.executeSelect(query); 
		
		if(rs != null) {
			table.setModel(resultSetToTableModel(rs));
		}
	}
    
    public TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();

            // Adicione nomes de colunas à lista de nomes de colunas
            for (int column = 1; column <= numberOfColumns; column++) {
                columnNames.add(metaData.getColumnLabel(column));
            }

            Vector<Vector<Object>> data = new Vector<>();

            // Preencha os dados da tabela
            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.add(rs.getObject(i));
                }
                data.add(newRow);
            }

            // Crie e retorne um DefaultTableModel
            return new DefaultTableModel(data, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public recipe getRecipeData() {
        String query = "SELECT ingredients, recipe FROM `recipebook`.`recipedata` WHERE title = '" + this.title + "'";
        ResultSet rs = db.executeSelect(query);
        
        if (rs != null) {
            try {
                while (rs.next()) {
                    this.setIngredients(rs.getString("ingredients"));
                    this.setRecipe(rs.getString("recipe"));
                    return this;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


	public void DeleteRecipe() {
		String query = "DELETE FROM `recipebook`.`recipedata` WHERE title = '" + this.title + "'";
		db.execute(query);
		
	}


	public void UptadeRecipe() {
		String query = "UPDATE  `recipebook`.`recipedata` SET ingredients = '" + this.ingredients +"',recipe = '" + this. recipe + "' WHERE title = '" + this.title + "'";
		db.executeInsertUpdate(query);
		
	}

    
    /*public byte[] getImagem() {
    	return imagem;
    }
    
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }*/
    
}
