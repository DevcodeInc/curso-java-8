package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Capítulo 2: Reducciones simples.
public class Ejemplo6 {
  public static void main(String[] args) throws IOException {
    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/war-and-peace.txt";
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), StandardCharsets.UTF_8);

    List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
    Stream<String> words = wordList.stream();

    Optional<String> smallest = words.min(String::compareToIgnoreCase);
    if (smallest.isPresent()) {
      System.out.println("smallest: " + smallest.get());
    }

    words = wordList.stream();
    Optional<String> startsWithQ = words
        .parallel()
        .filter(s -> s.startsWith("Q"))
        .findAny();
    if (startsWithQ.isPresent()){
      System.out.println("startsWithQ: " + startsWithQ.get());
    }
    else {
      System.out.println("No word starts with Q");
    }

    words = wordList.stream();
    boolean aWordStartsWithQ = words.anyMatch(s -> s.startsWith("Q"));
    System.out.println("aWordStartsWithQ: " + aWordStartsWithQ);
  }
}
