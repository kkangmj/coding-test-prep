import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_2403 {

  private static int n = 0;
  private static int m = 0;
  private static int v = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    boolean[][] graph = new boolean[n + 1][n + 1];
    boolean[] visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = true;
      graph[b][a] = true;
    }

    dfs(v, graph, visited, bw);

    visited = new boolean[n + 1];
    bw.newLine();

    bfs(v, graph, visited, bw);

    bw.flush();

  }


  public static void dfs(int v, boolean[][] graph, boolean[] visited, BufferedWriter bw)
      throws IOException {
    visited[v] = true;
    bw.write(v + " ");

    for (int i = 1; i < n + 1; i++) {
      if (!visited[i] && graph[i][v]) {
        dfs(i, graph, visited, bw);
      }
    }
  }

  public static void bfs(int v, boolean[][] graph, boolean[] visited, BufferedWriter bw)
      throws IOException {
    Queue<Integer> queue = new LinkedList<>();
    visited[v] = true;
    queue.add(v);

    while (!queue.isEmpty()) {
      int q = queue.poll();
      bw.write(q + " ");

      for (int i = 1; i < n + 1; i++) {
        if (!visited[i] && graph[i][q]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}
