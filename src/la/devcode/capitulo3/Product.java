package la.devcode.capitulo3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
  int id;
  String name;
  double price;

  public Product(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=$" + price +
        '}';
  }
}

class ProductReader {
  private static List<Product> productList;

  static {
    try {
      productList = Files.lines(
          Paths.get("/Users/enrique7mc/IdeaProjects/java8/src/la/devcode/capitulo3/products.txt"))
          .map(l -> l.split(","))
          .map(a -> new Product(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2])))
          .collect(Collectors.toUnmodifiableList());
    } catch (IOException e) {
      System.out.println("Exception occurred " + e);
    }
  }

  static Stream<Product> readProducts() {
    return productList.stream();
  }
}
