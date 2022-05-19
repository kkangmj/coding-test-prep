import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution10610 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] digitOfN = bufferedReader.readLine().split("");
    ArrayList<Integer> digits = new ArrayList<>();

    for (String digit : digitOfN) {
      digits.add(Integer.parseInt(digit));
    }

    if (!isValid(digits)) {
      System.out.println(-1);
    } else {
      digits.sort(Collections.reverseOrder());
      for (Integer digit : digits) {
        sb.append(digit);
      }
      System.out.println(sb);
    }
  }

  private static boolean isValid(ArrayList<Integer> digits) {

    int sum = 0;
    for (Integer digit : digits) {
      sum += digit;
    }

    return sum % 3 == 0 && digits.contains(0);
  }
}
