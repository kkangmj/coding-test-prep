import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_2403 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());

    for (int i = 0; i < c; i++) {
      int x = Integer.parseInt(br.readLine());
      int[][] a = new int[2][x];

      for (int j = 0; j < 2; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int k = 0; k < x; k++) {
          a[j][k] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] m = new int[2][x + 1];
      m[0][1] = a[0][0];
      m[1][1] = a[1][0];

      for (int j = 2; j < x + 1; j++) {
        m[0][j] = Math.max(m[1][j - 1], m[1][j - 2]) + a[0][j - 1];
        m[1][j] = Math.max(m[0][j - 1], m[0][j - 2]) + a[1][j - 1];
      }

      System.out.println(Math.max(m[0][x], m[1][x]));
    }
  }
}
