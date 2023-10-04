package model;

public class DBCreation {
    DBConnection db = new DBConnection();

    public void createDatabase() {
        // Cria o banco de dados se ele não existir
        String query = "CREATE DATABASE IF NOT EXISTS recipebook";
        db.execute(query);

        // Usa o banco de dados
        query = "USE recipebook";
        db.execute(query);

        // Cria a tabela recipeData
        query = "CREATE TABLE IF NOT EXISTS `recipebook`.`recipedata` ("
                + "ID INT NOT NULL AUTO_INCREMENT,"
                + "title VARCHAR(500) NOT NULL,"
                + "category VARCHAR(50) NOT NULL,"
                + "ingredients TEXT NOT NULL,"
                + "recipe TEXT NOT NULL,"
                //+ "Image BLOB"
                + "PRIMARY KEY (ID)"
                + ") ENGINE=INNODB";
        db.execute(query);
    }
}
