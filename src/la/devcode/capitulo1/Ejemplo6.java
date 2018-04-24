package la.devcode.capitulo1;

import java.util.Arrays;
import java.util.List;

public class Ejemplo6 {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 3, 4);
    list.forEach(System.out::println);

    var student = new Student();
    System.out.println(student.getId());
    System.out.println(student.getName());
  }
}

interface Person {
  long getId();
  default String getName() {
    return "John Doe";
  }
}

class Student implements Person {
  @Override
  public long getId() {
    return 1;
  }
}
