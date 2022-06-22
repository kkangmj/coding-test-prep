import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18185 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numOfFactory = Integer.parseInt(br.readLine());
    int[] ramen = new int[numOfFactory];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < numOfFactory; i++) {
      ramen[i] = Integer.parseInt(st.nextToken());
    }

    int cost = 0;
    int min;

    for (int i = 0; i < numOfFactory - 2; i++) {
      if (ramen[i + 1] > ramen[i + 2]) {
        min = min(ramen[i], ramen[i + 1] - ramen[i + 2]);
        cost += min * 5;
        ramen[i] -= min;
        ramen[i + 1] -= min;

        min = min(ramen[i], min(ramen[i + 1], ramen[i + 2]));
        cost += min * 7;
        ramen[i] -= min;
        ramen[i + 1] -= min;
        ramen[i + 2] -= min;
      } else {
        min = min(ramen[i], min(ramen[i + 1], ramen[i + 2]));
        cost += min * 7;
        ramen[i] -= min;
        ramen[i + 1] -= min;
        ramen[i + 2] -= min;

        min = min(ramen[i], ramen[i + 1]);
        cost += min * 5;
        ramen[i] -= min;
        ramen[i + 1] -= min;
      }
      cost += ramen[i] * 3;
    }
    min = min(ramen[numOfFactory - 2], ramen[numOfFactory - 1]);
    cost += min * 5;
    ramen[numOfFactory - 2] -= min;
    ramen[numOfFactory - 1] -= min;

    cost += (ramen[numOfFactory - 2] + ramen[numOfFactory - 1]) * 3;

    System.out.println(cost);
  }
}
