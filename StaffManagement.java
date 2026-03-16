import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StaffManagement extends Application{
	private final ArrayList<Staff> staffList = new ArrayList<>();
	
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
	        
	       //Input Logic
	        btnInput.setOnAction(e ->{
	        	int txtid = Integer.parseInt(id.getText());
	        	String txtname = name.getText();
	        	int txtage = Integer.parseInt(age.getText());
	        	 
	        	
	        	Staff s = new Staff(txtid, txtname, txtage);
	        	staffList.add(s);
	        	result.setText("Staff Added:\nID: " + s.getId()+ "  Name: " + s.getName() + "  Age: " + s.getAge());
	        	id.clear();
                name.clear();
                age.clear();
	        	
	        });
	        
	        //List
	        btnList.setOnAction(e->{
	        	if (staffList.isEmpty()) {
	        		result.setText("No Records Found");
	        		return;
	        	}
	        	StringBuilder sb = new StringBuilder();
	        	sb.append(String.format("%-6s %-20s %s%n", "ID", "Name", "Age"));
	            sb.append("-".repeat(32)).append("\n");
	            ListIterator<Staff> it = staffList.listIterator();
	            while (it.hasNext()) {
	                Staff s = it.next();
	                sb.append(String.format("%-6d %-20s %d%n", s.getId(), s.getName(), s.getAge()));
	            }
	            result.setText(sb.toString());
	        });
	        btnSearch.setOnAction(e -> {
	            String query = search.getText().trim();
	            if (query.isEmpty()) {
	            	showAlert("Search", "Please enter a name or ID.");
	            	return;
	            	}
	            
	            StringBuilder sb = new StringBuilder("Results for \"" + query + "\":\n");
	            boolean found = false;
	            
	            ListIterator<Staff> it = staffList.listIterator();
	            
	            while (it.hasNext()) {
	                Staff s = it.next();
	                if (s.getName().toLowerCase().contains(query.toLowerCase())
	                        || String.valueOf(s.getId()).equals(query)) {
	                    sb.append(String.format("%-6d %-20s %d%n",
	                            s.getId(), s.getName(), s.getAge()));
	                    found = true;
	                }
	            }
	            result.setText(found ? sb.toString() : "No results found for \"" + query + "\".");
	        });
	 
	        // Sort Ascending
	        btnSortAsc.setOnAction(e -> {
	            if (staffList.isEmpty()) { 
	            	result.setText("No records to sort.");
	            	return; 
	            	}
	            
	            staffList.sort(Comparator.comparing(Staff::getName));
	            result.setText("Sorted ascending by Name. Click List All to view.");
	        });
	 
	        // Sort Descending
	        btnSortDesc.setOnAction(e -> {
	            if (staffList.isEmpty()) {
	            	result.setText("No records to sort.");
	            	return;
	            	}
	            staffList.sort(Comparator.comparing(Staff::getName).reversed());
	            result.setText("Sorted descending by Name. Click List All to view.");
	        });
	 
	        // Exit
	        btnExit.setOnAction(e -> stage.close());
	 
	        
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
	private void showAlert(String title, String msg) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
	}

}
