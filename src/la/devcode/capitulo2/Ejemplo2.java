package la.devcode.capitulo2;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Capítulo 2: crear streams
public class Ejemplo2 {

  public static void main(String[] args) throws IOException {
    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/test.txt";
    String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

    Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
    show("words", words);

    Stream<Integer> numbers = Stream.of(1, 4, 8, 10);
    show("numbers", numbers);

    Stream<String> emptyStream = Stream.empty();
    show("empty", emptyStream);

    Stream<String> oneString = Stream.generate(() -> "Using generate");
    show("oneString", oneString);

    Stream<Double> randoms = Stream.generate(Math::random);
    show("randoms", randoms);

    Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
    show("integers", integers);

    Stream<String> wordsAnotherWay = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
    show("wordsAnotherWay", wordsAnotherWay);
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
