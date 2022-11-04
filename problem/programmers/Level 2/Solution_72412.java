/*
순위 검색
- 1차 시도) 비트 마스킹으로 풀었더니 정확도 테스트는 모두 통과했지만 효율성 테스트 하나도 통과하지 못함.
- 2차 시도) Map을 사용해 모든 경우의 수를 조합해 key로 저장, 이분탐색으로 해결함. 정확도 테스트 모두 통과했지만 효율성 테스트 4개 중 2개만 통과함.
- 3차 시도) query를 도는 for문 안에서 매번 sort를 하는 것이 아니라 그 전에 map의 모든 key에 대해 sort하도록 변경함. 정확도, 효율성 테스트 모두 통과!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_72412 {

  public static void main(String[] args) {
    Solution_72412 solution_72412 = new Solution_72412();
    String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260",
        "java backend junior chicken 80", "python backend senior chicken 50"};
    String[] query = {"java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150", "- and - and - and chicken 100",
        "- and - and - and - 150"};

    System.out.println(Arrays.toString(solution_72412.solution(info, query)));
  }

  public int[] solution(String[] info, String[] query) {

    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    int[] answer = new int[query.length];

    for (int i = 0; i < info.length; i++) {
      String[] tokens = info[i].split(" ");

      int n = tokens.length - 1;
      boolean[] visited = new boolean[n];

      for (int j = 0; j < 5; j++) {
        combination(0, j, n, tokens, visited, map);
      }
    }

    for (String key : map.keySet()) {
      Collections.sort(map.get(key));
    }

    for (int i = 0; i < query.length; i++) {
      StringTokenizer st = new StringTokenizer(query[i].replace(" and ", " "));
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < 4; j++) {
        sb.append(st.nextToken());
      }

      String key = sb.toString();
      int score = Integer.parseInt(st.nextToken());

      if (map.containsKey(key)) {
        ArrayList<Integer> list = map.get(key);
        answer[i] = list.size() - binarySearch(score, list);
      }
    }

    return answer;
  }

  private int binarySearch(int key, ArrayList<Integer> list) {
    int pl = 0;
    int pr = list.size();

    while (pl < pr) {
      int pc = (pl + pr) / 2;
      if (key <= list.get(pc)) {
        pr = pc;
      } else {
        pl = pc + 1;
      }
    }

    return pl;
  }

  private void combination(int start, int r, int n, String[] tokens, boolean[] visited,
      HashMap<String, ArrayList<Integer>> map) {
    if (r == 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          sb.append(tokens[i]);
        } else {
          sb.append("-");
        }
      }

      String key = sb.toString();
      int value = Integer.parseInt(tokens[4]);

      if (map.containsKey(key)) {
        map.get(key).add(value);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value);
        map.put(key, list);
      }

      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(i + 1, r - 1, n, tokens, visited, map);
      visited[i] = false;
    }
  }
}
