import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_2251 {

  private static TreeSet<Integer> answerSet;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] bottles = new int[3];

    for (int i = 0; i < 3; i++) {
      bottles[i] = Integer.parseInt(st.nextToken());
    }

    boolean[][] visited = new boolean[201][201];
    answerSet = new TreeSet<>();

    dfs(0, 0, bottles[2], bottles, visited);

    StringBuilder sb = new StringBuilder();

    for (Integer answer : answerSet) {
      sb.append(answer).append(" ");
    }

    System.out.println(sb);
  }

  private static void dfs(int a, int b, int c, int[] bottleCapacity, boolean[][] visited) {

    if (visited[a][b]) {
      return;
    }

    visited[a][b] = true;

    if (a == 0) {
      answerSet.add(c);
    } else {  // a -> b OR a -> c
      int availableB = bottleCapacity[1] - b;
      if (a > availableB) {
        dfs(a - availableB, bottleCapacity[1], c, bottleCapacity, visited);
      } else {
        dfs(0, b + a, c, bottleCapacity, visited);
      }

      int availableC = bottleCapacity[2] - c;
      if (a > availableC) {
        dfs(a - availableC, b, bottleCapacity[2], bottleCapacity, visited);
      } else {
        dfs(0, b, c + a, bottleCapacity, visited);
      }
    }

    if (b != 0) { // b -> a OR b -> c
      int availableA = bottleCapacity[0] - a;
      if (b > availableA) {
        dfs(bottleCapacity[0], b - availableA, c, bottleCapacity, visited);
      } else {
        dfs(a + b, 0, c, bottleCapacity, visited);
      }

      int availableC = bottleCapacity[2] - c;
      if (b > availableC) {
        dfs(a, b - availableC, bottleCapacity[2], bottleCapacity, visited);
      } else {
        dfs(a, 0, c + b, bottleCapacity, visited);
      }
    }

    if (c != 0) {  // c -> a OR c -> b
      int availableA = bottleCapacity[0] - a;
      if (c > availableA) {
        dfs(bottleCapacity[0], b, c - availableA, bottleCapacity, visited);
      } else {
        dfs(a + c, b, 0, bottleCapacity, visited);
      }

      int availableB = bottleCapacity[1] - b;
      if (c > availableB) {
        dfs(a, bottleCapacity[1], c - availableB, bottleCapacity, visited);
      } else {
        dfs(a, 0, c + b, bottleCapacity, visited);
      }
    }
  }
}
