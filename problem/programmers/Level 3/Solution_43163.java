/*
단어 변환 - BFS
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution_43163 {

  public static void main(String[] args) {
    Solution_43163 solution_43163 = new Solution_43163();
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    System.out.println(solution_43163.solution("hit", "cog", words));
  }


  private static int minCount = 0;
  private static int wordLength = 0;

  public int solution(String begin, String target, String[] words) {

    boolean[] visited = new boolean[words.length];
    wordLength = begin.length();

    bfs(begin, target, words, visited);

    return minCount;
  }

  private void bfs(String begin, String target, String[] words, boolean[] visited) {
    Queue<Word> queue = new LinkedList<>();
    queue.add(new Word(begin, 0));

    while (!queue.isEmpty()) {
      Word word = queue.poll();

      if (word.str.equals(target)) {
        minCount = word.changeCount;
        return;
      }

      for (int i = 0; i < wordLength; i++) {
        for (int j = 0; j < words.length; j++) {
          if (!visited[j] && isReplaceable(word.str, words[j], i)) {
            queue.add(new Word(words[j], word.changeCount + 1));
            visited[j] = true;
          }
        }
      }
    }
  }

  private boolean isReplaceable(String s1, String s2, int index) {
    for (int i = 0; i < s1.length(); i++) {
      if (i != index && s1.charAt(i) != s2.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  static class Word {

    private String str;
    private int changeCount;

    public Word(String str, int changeCount) {
      this.str = str;
      this.changeCount = changeCount;
    }
  }

}
