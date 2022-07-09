import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2178 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] maze = new int[N][M];
    int[][] distance = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(distance[i], 10001);
    }
    distance[0][0] = 1;

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        if (line.charAt(j) == '1') {
          maze[i][j] = 1;
        }
      }
    }

    PriorityQueue<Position> pq = new PriorityQueue<>();
    pq.add(new Position(0, 0, 1));

    while (!pq.isEmpty()) {
      Position p = pq.poll();
      int x = p.x;
      int y = p.y;
      int distanceP = p.distance;

      if (distanceP > distance[x][y]) {
        continue;
      }

      int[] op1 = {-1, 1, 0, 0};
      int[] op2 = {0, 0, 1, -1};
      int updatedDistance = distance[x][y] + 1;

      for (int i = 0; i < 4; i++) {
        int newX = x + op1[i];
        int newY = y + op2[i];

        if (newX >= 0 && newX < N && newY >= 0 && newY < M && maze[newX][newY] != 0
            && distance[newX][newY] > updatedDistance) {
          pq.add(new Position(newX, newY, updatedDistance));
          distance[newX][newY] = updatedDistance;
        }

      }
    }
    System.out.println(distance[N - 1][M - 1]);

  }

  private static class Position implements Comparable<Position> {

    private int x;
    private int y;
    private int distance;

    @Override
    public int compareTo(Position position) {
      return this.distance - position.distance;
    }

    public Position(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
