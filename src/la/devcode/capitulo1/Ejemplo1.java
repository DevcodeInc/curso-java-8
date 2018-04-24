package la.devcode.capitulo1;

import java.util.Arrays;
import java.util.Comparator;

public class Ejemplo1 {
  public static void main(String[] args) {
    String[] strings = "Java sin expresiones lambda".split(" ");
    Arrays.sort(strings, new LengthComparator());
    System.out.println(Arrays.toString(strings));

    var worker = new Worker();
    new Thread(worker).start();
  }
}

class LengthComparator implements Comparator<String> {
  public int compare(String first, String second) {
    return Integer.compare(first.length(), second.length());
  }
}

class Worker implements Runnable {
  public void run() {
    for (int i = 0; i < 10; i++)
      doWork();
  }

  public void doWork() {
    System.out.println("Doing work...");
    try {
      Thread.sleep(100);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}
