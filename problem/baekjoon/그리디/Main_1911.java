import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1911 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    PriorityQueue<Pond> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      pq.offer(new Pond(start, end));
    }

    int index = 0;
    int answer = 0;

    while (!pq.isEmpty()) {
      Pond pond = pq.poll();
      int start = pond.start;
      int end = pond.end;

      if (end < index) {
        continue;
      }

      if (start < index) {
        start = index;
      }

      int lengthOfPond = end - start;
      int num = lengthOfPond / L;

      if (lengthOfPond % L != 0) {
        num += 1;
      }

      answer += num;
      index = start + num * L;
    }

    System.out.println(answer);
  }

  static class Pond implements Comparable<Pond> {

    private int start;
    private int end;

    private Pond(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Pond pond) {
      return this.start - pond.start;
    }
  }
}
