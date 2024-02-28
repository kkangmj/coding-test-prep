import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int initialValue = Integer.parseInt(st.nextToken());
      int expectedValue = Integer.parseInt(st.nextToken());

      sb.append(getOperation(initialValue, expectedValue));
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static String getOperation(int initialValue, int expectedValue) {
    Queue<Number> queue = new LinkedList<>();
    boolean[] visited = new boolean[10000];

    queue.add(new Number(initialValue, ""));
    String[] operations = {"D", "S", "L", "R"};

    while (!queue.isEmpty()) {
      Number number = queue.poll();
      int value = number.value;

      if (visited[value]) {
        continue;
      }

      visited[value] = true;
      String operation = number.operation;

      for (String op : operations) {
        int calculatedValue = getCalculatedValue(op, value);

        if (calculatedValue == expectedValue) {
          return operation + op;
        }

        if (!visited[calculatedValue]) {
          queue.add(new Number(calculatedValue, operation + op));
        }
      }
    }

    return "";
  }

  private static int getCalculatedValue(String op, int value) {
    switch (op) {
      case "D":
        return value * 2 % 10000;
      case "S":
        return (value + 9999) % 10000;
      case "L":
        return (value % 1000) * 10 + value / 1000;
      default:
        return (value % 10) * 1000 + value / 10;
    }
  }

  static class Number {

    private int value;
    private String operation;

    public Number(int value, String operation) {
      this.value = value;
      this.operation = operation;
    }
  }
}
