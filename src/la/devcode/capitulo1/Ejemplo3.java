package la.devcode.capitulo1;

import java.util.function.*;

// Capítulo 1: interfaces funcionales
public class Ejemplo3 {
  public static void main(String[] args) {
    // Ejemplo Predicate
    Predicate<String> stringLen  = (s) -> s.length() < 10;
    System.out.println(stringLen.test("Interface") + " - longitud menor que 10");

    // Ejemplo Consumer
    Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
    consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

    // Ejemplo Function
    Function<Integer,String> converter = (num) -> Integer.toString(num);
    System.out.println("length of 26: " + converter.apply(26).length());

    // Ejemplo Supplier
    Supplier<String> s  = () -> "Java 8";
    System.out.println(s.get());

    // Ejemplo Binary Operator
    BinaryOperator<Integer> add = (a, b) -> a + b;
    System.out.println("suma 10 + 25: " + add.apply(10, 25));

    // Ejemplo Unary Operator
    UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
    System.out.println(str.apply("Este es un mensaje en mayúsculas"));

    // Ejemplo Functional Interface
    Action action = () -> System.out.println("Esta es una acción");
  }
}

@FunctionalInterface
interface Action {
  void execute();
}
