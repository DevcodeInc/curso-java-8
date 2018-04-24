package la.devcode.capitulo2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Capítulo 2: limitar y combinar streams
public class Ejemplo4 {
  public static void main(String[] args) {
    Stream<Double> randoms = Stream.generate(Math::random).limit(100);
    show("randoms", randoms);

    Stream<Integer> integers = Stream.iterate(0, n -> n + 1);
    Stream<Integer> firstFive = integers.limit(5);
    show("firstFive", firstFive);

    integers = Stream.iterate(0, n -> n + 1);
    Stream<Integer> notTheFirst = integers.skip(1).limit(5);
    show("notTheFirst", notTheFirst);

    Stream<Character> combined = Stream.concat(
        Stream.of('H', 'e', 'l', 'l', 'o'),
        Stream.of('w', 'o', 'r', 'l', 'd'));
    show("combined", combined);

    Object[] powers = Stream.iterate(1.0, p -> p * 2)
        .peek(e -> System.out.println("Fetching " + e))
        .limit(10)
        .toArray();
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
