package la.devcode.capitulo3;

import java.util.*;
import java.util.function.Predicate;

// Estado inicial del proyecto
public class MainInicial {
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
          // TODO: usar listProductsBy
          break;
        case 3:
          System.out.print("Ingrese nombre: ");
          name = scanner.nextLine();
          // TODO: usar listProductsBy
          break;
        case 4:
          // TODO: usar listMostExpensiveProducts
          break;
        case 5:
          System.out.println("Productos con 10% de descuento");
          // TODO: usar listProductsWithDiscount
          break;
        case 6:
          System.out.print("Ingrese nombre: ");
          name = scanner.nextLine();
          boolean productExists = false; // TODO: usar checkExistence
          System.out.printf("Producto %s %s encontrado\n", name, productExists ? "" : "NO");
          break;
        case 7:
          double total = 0; // TODO: usar calculateTotal
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
    throw new UnsupportedOperationException();
  }

  /** Listar todos los productos que coincidan con {@code predicate}. */
  private static List<Product> listProductsBy(Predicate<Product> predicate) {
    throw new UnsupportedOperationException();
  }

  /** Listar los {@code count} productos con mayor precio. */
  private static List<Product> listMostExpensiveProducts(int count) {
    throw new UnsupportedOperationException();
  }

  /** Listar los productos en orden alfabético. */
  private static List<Product> listProductsAlphabetically() {
    throw new UnsupportedOperationException();
  }

  /** Listar los productos aplicando un {@code discount} del precio original. */
  private static List<Product> listProductsWithDiscount(int discount) {
    throw new UnsupportedOperationException();
  }

  /** Regresa un boolean especificando si el producto de nombre {@code name} está en la lista. */
  private static boolean checkExistence(String name) {
    throw new UnsupportedOperationException();
  }

  /** Regresa el total de los productos. */
  private static double calculateTotal() {
    throw new UnsupportedOperationException();
  }

  private static void displayProducts(List<Product> products) {
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
