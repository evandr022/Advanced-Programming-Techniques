package control;

import javax.swing.*;

public class recipe {
	//Data members
	private String title;
	private String ingredients;
	private String category;
	private String recipe;

	//private byte[] imagem;
	
	// Logical Function code
	private model.recipe rcp = new model.recipe();
	
	public recipe(String title, String ingredients, String category, String recipe/*, byte[] imagem*/) {
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
	
	/*public byte[] getImagem() {
    	return imagem;
    }
    
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }*/	
	
	public boolean saveData() {
		rcp.setCategory(this.category);
		rcp.setIngredients(this.ingredients);
		rcp.setRecipe(this.recipe);
		rcp.setTitle(this.title);
		//rcp.setImagem(this.imagem);
		
		return rcp.saveData();
	}
	
	public void populateTable1(JTable table, String category) {
		rcp.populateTable(table, category);
	}

	public recipe getRecipeData() {
		rcp.setTitle(this.title);
		rcp.getRecipeData();
		if(rcp!=null) {
			this.setIngredients(rcp.getIngredients());
			this.setRecipe(rcp.getRecipe());
			
			return this;
		}
		return null;
		
	}

	public void DeleteRecipe() {
		rcp.setTitle(this.title);
		rcp.DeleteRecipe();
	}

	public void UptadeRecipe() {
		rcp.setTitle(this.title);
		rcp.setIngredients(this.ingredients);
		rcp.setRecipe(this.recipe);
		rcp.UptadeRecipe();
		
	}
}
