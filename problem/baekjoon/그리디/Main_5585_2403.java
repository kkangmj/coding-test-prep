import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585_2403 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = 1000 - Integer.parseInt(br.readLine());
    int r = 0;
    int[] c = {500, 100, 50, 10, 5, 1};

    for (int i = 0; i < 6; i++) {
      r += m / c[i];
      m %= c[i];
    }

    System.out.println(r);
  }
}
