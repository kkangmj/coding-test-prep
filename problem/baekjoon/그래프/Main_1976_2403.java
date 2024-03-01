import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_2403 {

  private static int[] p;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    p = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
      p[i] = i;
    }

    for (int i = 1; i < n + 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
        if (st.nextToken().equals("1")) {
          union(i, j);
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b;

    for (int i = 0; i < m - 1; i++) {
      b = Integer.parseInt(st.nextToken());

      if (find(a) != find(b)) {
        System.out.println("NO");
        return;
      }

      a = b;
    }

    System.out.println("YES");
  }

  public static void union(int x, int y) {
    int a = find(x);
    int b = find(y);

    if (a < b) {
      p[b] = a;
    } else {
      p[a] = b;
    }
  }

  public static int find(int x) {
    if (p[x] == x) {
      return p[x];
    }
    p[x] = find(p[x]);
    return p[x];
  }
}
