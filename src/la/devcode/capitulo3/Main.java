package la.devcode.capitulo3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = Collections.emptyList();
    int option = 0;

    while (option != 8) {
      displayMenu();
      option = scanner.nextInt();
      scanner.nextLine();
      String name;

      switch (option) {
        case 1:
          products = listAllProducts();
          break;
        case 2:
          System.out.print("Ingrese precio: ");
          double price = scanner.nextDouble();
          products = listProductsBy(p -> p.price > price);
          break;
        case 3:
          System.out.print("Ingrese nombre: ");
          name = scanner.nextLine();
          products = listProductsBy(p -> p.name.contains(name));
          break;
        case 4:
          products = listMostExpensiveProducts(5);
          break;
        case 5:
          System.out.println("Productos con 10% de descuento");
          products = listProductsWithDiscount(10);
          break;
        case 6:
          System.out.print("Ingrese nombre: ");
          name = scanner.nextLine();
          boolean productExists = checkExistence(name);
          System.out.printf("Producto %s %s encontrado\n", name, productExists ? "" : "NO");
          break;
        case 7:
          double total = calculateTotal();
          System.out.printf("El total de los productos es: $%.2f\n", total);
          break;
      }

      displayProducts(products);
      products = Collections.emptyList();
      System.out.println("Presione una tecla y ENTER para continuar ");
      scanner.next();
    }
  }

  /** Listar todos los productos. */
  private static List<Product> listAllProducts() {
    return ProductReader.readProducts().collect(Collectors.toList());
  }

  /** Listar todos los productos que coincidan con {@code predicate}. */
  private static List<Product> listProductsBy(Predicate<Product> predicate) {
    return ProductReader.readProducts()
        .filter(predicate)
        .collect(Collectors.toList());
  }

  /** Listar los {@code count} productos con mayor precio. */
  private static List<Product> listMostExpensiveProducts(int count) {
    return ProductReader.readProducts()
        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
        .limit(count)
        .collect(Collectors.toList());
  }

  /** Listar los productos en orden alfabético. */
  private static List<Product> listProductsAlphabetically() {
    throw new UnsupportedOperationException();
  }

  /** Listar los productos aplicando un {@code discount} del precio original. */
  private static List<Product> listProductsWithDiscount(int discount) {
    return ProductReader.readProducts()
        .map(p -> new Product(p.getId(), p.getName(),
            p.getPrice() * ((100.0 - discount) / 100)))
        .collect(Collectors.toList());
  }

  /** Regresa un boolean especificando si el producto de nombre {@code name} está en la lista. */
  private static boolean checkExistence(String name) {
    return ProductReader.readProducts()
        .anyMatch(p -> p.getName().equalsIgnoreCase(name));
  }

  /** Regresa el total de los productos. */
  private static double calculateTotal() {
    return ProductReader.readProducts()
        .mapToDouble(Product::getPrice)
        .sum();
  }

  private static void displayProducts(List<Product> products) {
    products.stream()
        .map(Product::toString)
        .forEach(System.out::println);
  }

  private static void displayMenu() {
    clearConsole();
    System.out.println("Escoge una opción:\n" +
        "1. Mostrar todos productos\n" +
        "2. Filtrar por precio\n" +
        "3. Filtrar por nombre\n" +
        "4. Mostrar 5 más caros\n" +
        "5. Aplicar 10% de descuento\n" +
        "6. Revisar existencia\n" +
        "7. Calcular el total\n" +
        "8. Salir");
  }

  private static void clearConsole() {
    System.out.println("TRACE.clear");
  }
}
