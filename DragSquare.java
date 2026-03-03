import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DragSquare extends Application{
private double offsetX;
private double offsetY;

@Override
public void start(Stage stage) throws Exception {
	
	//Label to display coordinates
	
	Label lblCoordinates = new Label("X:0 Y:0");
	
	//Square(Rectangle with equal width and height
	Rectangle square = new Rectangle(200,150,80,80);
	square.setFill(Color.color(0.3, 0.7, 1.0,0.3));
	square.setStroke(Color.BLACK);
	
	Pane pane = new Pane(square);
	pane.setPrefSize(500, 350);
	
	square.setOnMousePressed(e -> {
		offsetX=  e.getX() - square.getX();
		offsetY=  e.getY() - square.getY();
		
	});
	
	//Mouse dragged: move square and update coordinates
	square.setOnMouseDragged(e -> {
		square.setX(e.getX()- offsetX);
		square.setY(e.getY()- offsetY);
		
		lblCoordinates.setText(String.format("X: %.0f Y: %.0f", square.getX(), square.getY()));
		
	
	});
	
	BorderPane root = new BorderPane();
	root.setTop(lblCoordinates);
	root.setCenter(pane);
	
	 Scene scene = new Scene(root, 500, 380);
     stage.setTitle("Drag a Square with Coordinates");
     stage.setScene(scene);
     stage.show();
	
}
public static void main(String[] args) {
    launch(args);
}


}
