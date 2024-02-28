import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      if (checkPairs(br.readLine())) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }
    System.out.println(sb);
  }

  private static boolean checkPairs(String s) {
    Stack<Character> stack = new Stack<>();

    for (int j = 0; j < s.length(); j++) {
      if (s.charAt(j) == '(') {
        stack.push('(');
      } else {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
