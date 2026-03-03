import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NameAddressForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label lblName = new Label("Name: ");
        Label lblAddress = new Label("Address: ");
        Label gender = new Label("Gender:");
        Label title = new Label("Title: ");

        TextField txtName = new TextField();
        TextField txtAddress = new TextField();
        
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        
        Button btnSubmit = new Button("Submit");
        Button btnExit = new Button("Exit");
        
        ComboBox <String> comboBox= new ComboBox<>();
        ObservableList<String> options  = FXCollections.observableArrayList("Mr","Miss","Mrs");
        
        ToggleGroup tg = new ToggleGroup();

        // Submit Action — wrapped inside setOnAction so it runs only when clicked
        btnSubmit.setOnAction(e -> {
            String name = txtName.getText();
            String address = txtAddress.getText();
            String selectedTitle = comboBox.getValue() != null ? comboBox.getValue() : "Not selected";
            String selectedGender = "Not selected";
            if (tg.getSelectedToggle() != null) {
                RadioButton selectedRadio = (RadioButton) tg.getSelectedToggle();
                selectedGender = selectedRadio.getText();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Details Entered");
            alert.setHeaderText("User Information");
            alert.setContentText("Title: "   + selectedTitle + "\nName" + name + "\nAddress: " + address + "\nGender: " + selectedGender );
            alert.showAndWait();
        });

        // Exit Action
        btnExit.setOnAction(e -> stage.close());

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(20);
        grid.setVgap(10);

        grid.add(lblName, 0, 0);
        grid.add(lblAddress, 0, 1);
        grid.add(txtName, 1, 0);
        grid.add(txtAddress, 1, 1);
        grid.add(gender,0,2);
        grid.add(male, 0, 3);
        male.setToggleGroup(tg);
        grid.add(female, 0, 4);
        female.setToggleGroup(tg);
        grid.add(title, 1, 2);
        comboBox.setItems(options);
        grid.add(comboBox, 1, 3);
        

        HBox buttonBox = new HBox(10, btnSubmit, btnExit);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        grid.add(buttonBox, 1, 6);

        Scene scene = new Scene(grid, 350, 250);
        stage.setTitle("User Details Form");
        stage.setScene(scene);
        stage.show();
    
}
        
}
