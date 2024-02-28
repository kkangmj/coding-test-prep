/**
 * 센서 위치 배열에 저장 후 정렬 (sensors)
 * 해당 배열 기반으로 센서 간 간격 구해서 정렬하기 (distanceBtwSensors)
 * (센서의 개수 - 기지국의 개수)만큼 distanceBtwSensors 배열 요소들을 더하면 최소 수신 영역이 나옴.
 * 센서 A와 센서 B를 나눠 양쪽에 기지국을 설치하면 A와 B 사이의 거리는 수신 영역에 포함되지 않기 때문
 *
 * 실행 시간: 188ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numOfSensor = Integer.parseInt(br.readLine());
    int numOfCenter = Integer.parseInt(br.readLine());
    int[] sensors = new int[numOfSensor];
    int[] distanceBtwSensors = new int[numOfSensor - 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < numOfSensor; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(sensors);

    for (int i = 0; i < numOfSensor - 1; i++) {
      distanceBtwSensors[i] = sensors[i + 1] - sensors[i];
    }

    Arrays.sort(distanceBtwSensors);
    int answer = 0;

    for (int i = 0; i < numOfSensor - numOfCenter; i++) {
      answer += distanceBtwSensors[i];
    }

    System.out.println(answer);
  }
}
