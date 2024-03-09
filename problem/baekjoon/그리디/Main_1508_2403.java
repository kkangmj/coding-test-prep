import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1508_2403 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    st.nextToken();

    int judge = Integer.parseInt(st.nextToken());
    int location = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder("1");

    if (judge == location) {
      sb.append("1".repeat(judge - 1));
      System.out.println(sb);
      return;
    }

    int[] locations = new int[location];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < location; i++) {
      locations[i] = Integer.parseInt(st.nextToken());
    }

    int l = 0;
    int r = locations[location - 1];
    int[] answer = new int[location];

    while (l <= r) {
      int mid = (l + r) / 2;
      int count = 1;
      int prev = 0;
      int[] m = new int[location];
      m[0] = 1;

      for (int i = 1; i < location; i++) {
        if (locations[i] - locations[prev] >= mid) {
          count++;
          prev = i;
          m[prev] = 1;
        }
        if (count == judge) {
          break;
        }
      }
      if (count == judge) {
        l = mid + 1;
        answer = m;
      } else {
        r = mid - 1;
      }
    }

    System.out.println(arrToStr(answer));
  }

  public static String arrToStr(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int j : arr) {
      sb.append(j);
    }
    return sb.toString();
  }
}
