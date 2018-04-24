package la.devcode.capitulo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// Capítulo 2: agrupaciones.
public class Ejemplo9 {
  public static void main(String[] args) throws IOException {
    Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
    Map<String, List<Locale>> countryToLocales = locales.collect(groupingBy(Locale::getCountry));
    System.out.println("Swiss locales: " + countryToLocales.get("CH"));

    locales = Stream.of(Locale.getAvailableLocales());
    Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
        Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
    System.out.println("English locales: " + englishAndOtherLocales.get(true));

    locales = Stream.of(Locale.getAvailableLocales());
    Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
        groupingBy(Locale::getCountry, toSet()));
    System.out.println("countryToLocaleSet: " + countryToLocaleSet);

    locales = Stream.of(Locale.getAvailableLocales());
    Map<String, Long> countryToLocaleCounts = locales.collect(
        groupingBy(Locale::getCountry, counting()));
    System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

    Stream<City> cities = readCities();
    Map<String, Integer> stateToCityPopulation = cities.collect(
        groupingBy(City::getState, summingInt(City::getPopulation)));
    System.out.println("stateToCityPopulation: " + stateToCityPopulation);

    cities = readCities();
    Map<String, Optional<String>> stateToLongestCityName = cities.collect(
        groupingBy(City::getState,
            mapping(City::getName,
                maxBy(Comparator.comparing(String::length)))));
    System.out.println("stateToLongestCityName: " + stateToLongestCityName);

    locales = Stream.of(Locale.getAvailableLocales());
    Map<String, Set<String>> countryToLanguages = locales.collect(
        groupingBy(Locale::getDisplayCountry,
            mapping(Locale::getDisplayLanguage,
                toSet())));
    System.out.println("countryToLanguages: " + countryToLanguages);

    cities = readCities();
    Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
        groupingBy(City::getState,
            summarizingInt(City::getPopulation)));
    System.out.println(stateToCityPopulationSummary.get("NY"));
  }

  private static Stream<City> readCities() throws IOException {
    return Files.lines(
        Paths.get("/Users/enrique7mc/IdeaProjects/java8/src/la/devcode/capitulo2/cities.txt"))
        .map(l -> l.split(", "))
        .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
  }
}

class City {
  private String name;
  private String state;
  private int population;
 City(String name, String state, int population) {
    this.name = name;
    this.state = state;
    this.population = population;
  }

  String getName() { return name; }
  String getState() { return state; }
  int getPopulation() { return population; }
}