package model;

public class DBCreation {
	DBConnection db=new DBConnection();
	
	public void createDatabase() {
		String query = "CREATE DATABASE IF NOT EXISTS recipebook";
		db.execute(query);
		
		query = "CREATE TABLE 'recipebook'.'recipeData' (\r\n" +
				"'ID” INT NOT NULL AUTO_INCREMENT ,\r\n" +
				"'title' VARCHAR( 500 ) NOT NULL ,\r\n" +
				"'category' VARCHAR( 50 ) NOT NULL ,\r\n" +
				"'ingredients' TEXT NOT NULL ,\r\n" +
				"'recipe' TEXT NOT NULL ,\r\n" +
				"PRIMARY KEY ( 'ID' )\r\n" +
				") ENGINE = INNODB;";
		
		db.execute(query);
	}
}