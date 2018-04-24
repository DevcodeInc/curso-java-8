package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Capítulo 2: operaciones que dependen del estado de un Stream.
public class Ejemplo5 {

  public static void main(String[] args) throws IOException{
    Stream<String> uniqueWords
        = Stream.of("hello", "hello", "world", "java", "hello").distinct();
    show("uniqueWords", uniqueWords);

    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/war-and-peace.txt";
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), StandardCharsets.UTF_8);

    List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
    Stream<String> words = wordList.stream();
    Stream<String> sorted = words.sorted();
    show("sorted", sorted);

    words = wordList.stream();
    Stream<String> distinctSorted = words.distinct().sorted();
    show("distinctSorted", distinctSorted);

    words = wordList.stream();
    Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
    show("longestFirst", longestFirst);

    words = wordList.stream();
    Stream<String> distinctLongestFirst = words
        .distinct()
        .sorted(Comparator.comparing(String::length).reversed());
    show("distinctLongestFirst", distinctLongestFirst);
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
