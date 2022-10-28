/*
실행 시간: 124ms
메모리: 14244KB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    input = input.replaceAll("c=", "c");
    input = input.replaceAll("c-", "c");
    input = input.replaceAll("dz=", "c");
    input = input.replaceAll("d-", "c");
    input = input.replaceAll("lj", "c");
    input = input.replaceAll("nj", "c");
    input = input.replaceAll("s=", "c");
    input = input.replaceAll("z=", "c");

    System.out.println(input.length());
  }
}
