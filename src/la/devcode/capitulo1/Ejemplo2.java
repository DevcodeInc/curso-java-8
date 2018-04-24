package la.devcode.capitulo1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Arrays;
import java.util.Comparator;

// Capítulo 1: usando expresiones lambda
public class Ejemplo2 {
  public static void main(String[] args) {
    String[] strings = "Java con expresiones lambda".split(" ");

    Comparator<String> comp =
        (String first, String second)
            -> Integer.compare(first.length(), second.length());

    // Equivalente
    comp =
        (String first, String second) -> {
          if (first.length() < second.length()) return -1;
          else if (first.length() > second.length()) return 1;
          else return 0;
        };

    // Equivalente
    comp = (first, second) -> Integer.compare(first.length(), second.length());

    Arrays.sort(strings, comp);
    System.out.println(Arrays.toString(strings));

    EventHandler<ActionEvent> listener = (ActionEvent e) -> System.out.println(e.getTarget());
    //Otras opciones (e) -> or (ActionEvent e) ->

    Runnable runner =
        () -> { for (int i = 0; i < 10; i++) doWork(); };
    new Thread(runner).start();
  }

  static void doWork() {
    System.out.println("Doing work");
  }
}
