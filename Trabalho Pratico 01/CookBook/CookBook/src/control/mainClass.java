package control;

import model.DBCreation; 
import view.mainView;

public class mainClass {

	public static void main(String[] args) {
		DBCreation dbc = new DBCreation();
		dbc.createDatabase();
		
		mainView mv = new mainView();
		mv.setLocationRelativeTo(null);
		mv.setVisible(true);
	}
}
