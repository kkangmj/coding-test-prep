import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] actualCards = new int[N];

    for (int i = 0; i < N; i++) {
      actualCards[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(actualCards);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      int valueToCompare = Integer.parseInt(st.nextToken());
      if (binarySearch(valueToCompare, actualCards)) {
        bw.write("1 ");
      } else {
        bw.write("0 ");
      }
    }

    bw.flush();
  }

  private static boolean binarySearch(int value, int[] actualCards) {
    int pl = 0;
    int pr = actualCards.length - 1;

    do {
      int pc = (pl + pr) / 2;
      if (actualCards[pc] == value) {
        return true;
      } else if (actualCards[pc] < value) {
        pl = pc + 1;
      } else {
        pr = pc - 1;
      }
    } while (pl <= pr);

    return false;
  }
}
