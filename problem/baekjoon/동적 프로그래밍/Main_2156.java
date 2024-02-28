import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] wine = new int[n];

    for (int i = 0; i < n; i++) {
      wine[i] = Integer.parseInt(br.readLine());
    }

    int[][] caseOfWine = new int[n][3];

    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        caseOfWine[i][0] = wine[i];
        caseOfWine[i][1] = wine[i];
        caseOfWine[i][2] = 0;
        continue;
      }

      caseOfWine[i][0] = wine[i] + caseOfWine[i + 1][1];
      caseOfWine[i][1] = wine[i] + caseOfWine[i + 1][2];
      caseOfWine[i][2] = Math.max(caseOfWine[i + 1][0],
          Math.max(caseOfWine[i + 1][1], caseOfWine[i + 1][2]));
    }

    System.out.println(Math.max(caseOfWine[0][0], Math.max(caseOfWine[0][1], caseOfWine[0][2])));
  }
}
