/*
실행 시간: 124ms, 메모리: 14300KB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1459 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int straightTime = Integer.parseInt(st.nextToken());
    int diagonalTime = Integer.parseInt(st.nextToken());

    System.out.println((long) Math.min(x, y) * Math.min(diagonalTime, straightTime * 2)
        + (long) (Math.abs(x - y) / 2) * Math.min(straightTime, diagonalTime) * 2
        + (Math.abs(x - y) % 2) * straightTime);
  }
}