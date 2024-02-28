/**
 * 센서 위치 배열에 저장 후 정렬
 * 정렬된 배열에서 센서 간의 간격 구해서 Priority Queue에 (센서의 인덱스, 간격)으로 삽입
 * 간격이 큰 인덱스를 뽑아 집중국의 개수 - 1만큼 배열에 저장 후 배열 정렬
 * 정렬된 배열 기반으로 수신 가능 영역 계산
 *
 * 실행 시간: 240ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2212 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numOfSensor = Integer.parseInt(br.readLine());
    int numOfCenter = Integer.parseInt(br.readLine());

    HashSet<Integer> hashSet = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < numOfSensor; i++) {
      hashSet.add(Integer.parseInt(st.nextToken()));
    }

    ArrayList<Integer> sensors = new ArrayList<>(hashSet);
    Collections.sort(sensors);

    PriorityQueue<Sensor> pq = new PriorityQueue<>();

    for (int i = 0; i < sensors.size() - 1; i++) {
      pq.add(new Sensor(i, sensors.get(i + 1) - sensors.get(i)));
    }

    pq.add(new Sensor(sensors.size() - 1, -1));

    ArrayList<Integer> indexOfSlice = new ArrayList<>();

    while (numOfCenter > 1 && !pq.isEmpty()) {
      Sensor sensor = pq.poll();

      if (sensor.distance == -1) {
        break;
      }

      indexOfSlice.add(sensor.index);
      numOfCenter--;
    }

    indexOfSlice.add(sensors.size() - 1);

    Collections.sort(indexOfSlice);
    int answer = 0;

    if (indexOfSlice.size() == 1) {
      answer += sensors.get(sensors.size() - 1) - sensors.get(0);
    } else {
      for (int i = 0; i < indexOfSlice.size(); i++) {
        int slice = indexOfSlice.get(i);
        if (i == 0) {
          answer += sensors.get(slice) - sensors.get(0);
        } else {
          answer += sensors.get(slice) - sensors.get(indexOfSlice.get(i - 1) + 1);
        }
      }
    }

    System.out.println(answer);
  }

  private static class Sensor implements Comparable<Sensor> {

    private int index;
    private int distance;

    private Sensor(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Sensor sensor) {
      return sensor.distance - this.distance;
    }
  }
}
