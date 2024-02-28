import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10799 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] brackets = br.readLine().toCharArray();

    int numOfStick = 0;
    int slicedStick = 0;

    for (int i = 0; i < brackets.length; i++) {
      if (brackets[i] == '(') {
        if (brackets[i + 1] == ')') {
          slicedStick += numOfStick;
          i++;
          continue;
        }
        numOfStick++;
      } else {
        numOfStick--;
        slicedStick++;
      }

    }
    System.out.println(slicedStick);
  }
}
