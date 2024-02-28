import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int[] answer = new int[26];
    Arrays.fill(answer, -1);

    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 97;
      if (answer[index] == -1) {
        answer[index] = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      sb.append(answer[i]);
      sb.append(" ");
    }

    System.out.println(sb);
  }
}

