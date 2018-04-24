package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Capítulo 2: métodos filter, map y flatMap
public class Ejemplo3 {

  public static void main(String[] args) throws IOException {
    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/war-and-peace.txt";
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), StandardCharsets.UTF_8);

    List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
    Stream<String> words = wordList.stream();
    Stream<String> longWords = words.filter(w -> w.length() > 12);
    show("longWords", longWords);

    words = wordList.stream();
    Stream<String> lowercaseWords = words.map(String::toLowerCase);
    show("lowercaseWords", lowercaseWords);

    Stream<String> strings = Stream.of("java", "8", "streams", "and", "lambdas", "examples");
    Stream<Character> firstChars = strings.filter(w -> w.length() > 0).map(s -> s.charAt(0));
    show("firstChars", firstChars);

    strings = Stream.of("java", "8", "streams", "and", "lambdas", "examples");
//    Stream<Stream<String>> letters = strings.map(w -> Stream.of(w.split("")));
    Stream<String> letters = strings.flatMap(w -> Stream.of(w.split("")));
    show("letters", letters);
  }

  // Muestra hasta 10 elementos de un Stream.
  private static <T> void show(String title, Stream<T> stream) {
    int size = 10;
    List<T> firstElements = stream.limit(size + 1).collect(Collectors.toList());
    System.out.print(title + ": ");
    if (firstElements.size() <= size)
      System.out.println(firstElements);
    else {
      firstElements.remove(size);
      String out = firstElements.toString();
      System.out.println(out.substring(0, out.length() - 1) + ", ...]");
    }
  }
}
