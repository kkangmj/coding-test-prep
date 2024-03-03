import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10845_2403 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    Deque<Integer> deque = new ArrayDeque<>();
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();

      switch (s) {
        case "push":
          deque.add(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
          sb.append("\n");
          break;
        case "size":
          sb.append(deque.size());
          sb.append("\n");
          break;
        case "empty":
          sb.append(deque.isEmpty() ? 1 : 0);
          sb.append("\n");
          break;
        case "front":
          sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
          sb.append("\n");
          break;
        default:
          sb.append(deque.isEmpty() ? -1 : deque.peekLast());
          sb.append("\n");
          break;
      }
    }

    System.out.println(sb);
  }
}
