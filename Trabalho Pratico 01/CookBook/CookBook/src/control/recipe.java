package control;

import model.DBConnection;

public class recipe {
	private String title;
	private String ingredients;
	private String category;
	private String recipe;
	private String imagem;
	DBConnection db = new DBConnection();
	
	public boolean saveData() {
		String query = "INSERT INTO 'recipebook'.''recipedata' (\r\n" + 
					   "'ID' , \r\n" +
					   "'title' ,\r\n" +
					   "'category' , \r\n" +
					   "'ingredients' , \r\n" +
					   "'recipe' ,\r\n" +
					   "'imagem' ,\r\n" + ")\r\n" +
					   "'VALUES' , (\r\n" + "NULL \r\n " +
					   this.title + "', '" +
					   this.category + "', '" +
					   this.ingredients + "', '" +
					   this.recipe + "', '" +
					   this.imagem + "', '" +
					   "\r\n " + ");";
		
		db.executeInsertUpdate(query);
		
		return true;
	}
	
	public recipe(String title, String ingredients, String category, String recipe, String imagem) {
		super();
		this.title = title;
		this.ingredients = ingredients;
		this.category = category;
		this.recipe = recipe;
		this.imagem = imagem;
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
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

}