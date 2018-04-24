package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Capítulo 2: iterar y colectar Streams
public class Ejemplo7 {
  public static void main(String[] args) throws IOException {
    // Iterar un Stream
    Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
    while (iter.hasNext()) System.out.println(iter.next());

    // usar forEach
    Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);

    // Generar un arreglo de tipo Integer
    Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
    System.out.println(Arrays.toString(numbers3));

    String path = "/Users/enrique7mc/IdeaProjects/java8/src/" +
        "la/devcode/capitulo2/war-and-peace.txt";
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), StandardCharsets.UTF_8);
    List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));

    // Colectar resultados a un Set
    HashSet<String> hashSet = wordList.stream()
        .filter(w -> w.length() > 5)
        .collect(HashSet::new, HashSet::add, HashSet::addAll);
    show("hashSet", hashSet);

    Set<String> set = wordList.stream()
        .skip(1000)
        .collect(Collectors.toSet());
    show("set", set);

    TreeSet<String> treeSet = wordList.stream()
        .limit(800)
        .collect(Collectors.toCollection(TreeSet::new));
    show("treeSet", treeSet);

    // Juntar las cadenas de un Stream
    String result = wordList.stream().limit(10).collect(Collectors.joining(", "));
    System.out.println(result);
  }

  // Muestra el contenido de un Set, hasta 10 elementos.
  private static <T> void show(String label, Set<T> set) {
    System.out.print(label + ": " + set.getClass().getName());
    System.out.println("[" +
        set.stream().limit(10).map(Object::toString).collect(Collectors.joining(", "))
        + "]");
  }
}
