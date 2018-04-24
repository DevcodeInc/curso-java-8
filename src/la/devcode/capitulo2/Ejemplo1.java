package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ejemplo1 {
  public static void main(String[] args) throws IOException {
    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/war-and-peace.txt";
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), StandardCharsets.UTF_8);
    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    // Contar las palabras cuya longitud es > 12
    long count = 0;
    for (String word : words) {
      if (word.length() > 12) count++;
    }
    System.out.println(count);

    count = words.stream().filter(w -> w.length() > 12).count();
    System.out.println(count);

    count = words.parallelStream().filter(w -> w.length() > 12).count();
    System.out.println(count);
  }
}
