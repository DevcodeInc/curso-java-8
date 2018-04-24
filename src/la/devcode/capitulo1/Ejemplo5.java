package la.devcode.capitulo1;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

// Capítulo 1: referencias de constructor
public class Ejemplo5 extends Application {
  public void start(Stage stage) {
    List<String> labels = Arrays.asList("Ok", "Cancel", "Yes", "No", "Maybe");
    Stream<Button> stream = labels.stream().map(Button::new);

    stream.forEach(button -> System.out.println(button.getText()));
  }
}
