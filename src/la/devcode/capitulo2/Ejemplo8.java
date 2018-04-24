package la.devcode.capitulo2;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

// Capítulo 2: colectar un mapa.
public class Ejemplo8 {
  public static void main(String[] args) {
    Map<Integer, String> idToName =
        people().collect(toMap(Person::getId, Person::getName));
    System.out.println("idToName: " + idToName);

    Map<Integer, Person> idToPerson = people().collect(toMap(Person::getId, p -> p));
    System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

    idToPerson = people().collect(
        toMap(
            Person::getId,
            Function.identity(),
            (existingValue, newValue) -> newValue,
            TreeMap::new));

    System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

    Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
    Map<String, String> languageToCountry = locales.collect(
        toMap(
            Locale::getDisplayLanguage,
            Locale::getCountry,
            (existingValue, newValue) -> existingValue));
    System.out.println("languageToCountry: " + languageToCountry);
  }

  private static Stream<Person> people() {
    return Stream.of(
        new Person(1001, "John"),
        new Person(1002, "Jane"),
        new Person(1003, "Bob"));
  }
}

class Person {
  private int id;
  private String name;

  Person(int id, String name) { this.id = id; this.name = name; }
  int getId() { return id; }
  String getName() { return name; }

  @Override
  public String toString() { return getClass().getName() +
      "[id=" + id + ",name=" + name + "]";
  }
}