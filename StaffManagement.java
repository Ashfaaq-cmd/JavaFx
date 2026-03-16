import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StaffManagement extends Application{
	
	 public static void main(String[] args) {
	        launch(args);
	    }
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Label lblid = new Label("ID: ");
		Label lblName = new Label("Name: ");
		Label lblAge = new Label("Age: ");
		Label lblSearch = new Label("Search a user: ");
		Label lblResult = new Label("Result: ");
		
		//Txtfield
		TextField id = new TextField();
		TextField name = new TextField();
		TextField age = new TextField();
		TextField search = new TextField();
		
		TextArea result = new TextArea();
		 result.setEditable(false);
	        result.setPrefRowCount(8);
	        result.setPrefColumnCount(30);
		
	        //Buttons
	        Button btnInput = new Button("Input");
	        Button btnList = new Button("List All");
	        Button btnSearch = new Button("Search");
	        Button btnSortAsc = new Button("Sort Asc");
	        Button btnSortDesc = new Button("Sort Desc");
	        Button btnExit = new Button("Exit");
	        
	       
	        
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(15));
	        grid.setHgap(10);
	        grid.setVgap(10);
	        
	        //Position
	        grid.add(lblid, 0, 0);
	        grid.add(id, 1, 0);
	        grid.add(lblName,   0, 1);
	        grid.add(name, 1, 1);
	        grid.add(lblAge, 0, 2); 
	        grid.add(age, 1, 2);
	        grid.add(lblSearch, 0, 3); 
	        grid.add(search, 1, 3);
	        grid.add(lblResult, 0, 4);
	        grid.add(result, 0, 5, 2, 1); 
	        
	        HBox btnBox = new HBox(8, btnInput , btnList,btnSearch,btnSortAsc,btnSortDesc,btnExit);
	        btnBox.setAlignment(Pos.CENTER_RIGHT);
	        grid.add(btnBox, 0, 6,2,1);
		
		 Scene scene = new Scene(grid,480, 370);
	        stage.setTitle("Staff Management Form");
	        stage.setScene(scene);
	        stage.show();
	}

}
