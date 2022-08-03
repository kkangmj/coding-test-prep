import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_8980 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int numOfTown = Integer.parseInt(st.nextToken());
    int truckCapacity = Integer.parseInt(st.nextToken());
    int iteration = Integer.parseInt(br.readLine());

    PriorityQueue<Box> pq = new PriorityQueue<>();

    for (int i = 0; i < iteration; i++) {
      st = new StringTokenizer(br.readLine());
      pq.add(new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    int[] towns = new int[numOfTown];
    Arrays.fill(towns, truckCapacity);

    int answer = 0;

    while (!pq.isEmpty()) {
      Box box = pq.poll();

      int min = 10001;
      for (int i = box.from; i < box.to; i++) {
        min = Math.min(min, towns[i]);
      }

      if (min == 0) {
        continue;
      }

      int subtract = Math.min(min, box.weight);

      for (int i = box.from; i < box.to; i++) {
        towns[i] -= subtract;
      }

      answer += subtract;
    }

    System.out.println(answer);
  }

  static class Box implements Comparable<Box> {

    private int from;
    private int to;
    private int weight;

    protected Box(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Box box) {
      if (this.to > box.to) {
        return 1;
      } else if (this.to == box.to) {
        if (this.from > box.from) {
          return 1;
        } else {
          return -1;
        }
      } else {
        return -1;
      }
    }
  }
}
