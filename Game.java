import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        int[] count = {0};

        Label lblCount = new Label("Score: 0");
        lblCount.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 8px;");

        Label click = new Label("Don't Click Me!");
        click.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: red; -fx-padding: 4px;");

        Circle circle = new Circle(50);
        circle.setFill(Color.AQUAMARINE);
        circle.setCenterX(250);
        circle.setCenterY(175);

        Pane pane = new Pane(circle);
        pane.setPrefSize(500, 350);

        Random random = new Random();

        circle.setOnMouseClicked(e -> {
            count[0]++;
            lblCount.setText("Score: " + count[0]);

            double radius = circle.getRadius();
            double newX = radius + random.nextDouble() * (pane.getPrefWidth()  - 2 * radius);
            double newY = radius + random.nextDouble() * (pane.getPrefHeight() - 2 * radius);

            circle.setCenterX(newX);
            circle.setCenterY(newY);

            circle.setFill(Color.color(
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble()
            ));
        });

        VBox topBox = new VBox(2, lblCount, click);
        topBox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(pane);

        Scene scene = new Scene(root, 500, 420);
        stage.setTitle("Don't Click the Circle!");
        stage.setScene(scene);
        stage.show();
    }
}