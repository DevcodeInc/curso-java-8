package la.devcode.capitulo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Arrays;

// Capítulo 1: Referencias de método
public class Ejemplo4 extends Application {
  public void start(Stage stage) {
    Button button = new Button("Click me!");
    button.setOnAction(System.out::println);
    stage.setScene(new Scene(button));
    stage.show();

    String[] strings = "Java 8 referencias de método".split(" ");
    Arrays.sort(strings, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(strings));
  }
}
