/**
 * 실행 시간: 3128ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11004 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq;

    if (K <= N / 2) {
      pq = new PriorityQueue<>();
    } else {
      K = N - K + 1;
      pq = new PriorityQueue<>(Collections.reverseOrder());
    }

    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      pq.add(Integer.parseInt(st.nextToken()));
    }

    while (K >= 2) {
      pq.poll();
      K--;
    }

    System.out.println(pq.poll());
  }
}
