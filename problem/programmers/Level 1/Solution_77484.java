public class Solution_77484 {

  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];

    int numberMatches = 0;
    int numberOfZeros = 0;

    for (int lotto : lottos) {
      if (lotto == 0) {
        numberOfZeros++;
        continue;
      }

      for (int win_num : win_nums) {
        if (lotto == win_num) {
          numberMatches++;
        }
      }
    }

    answer[0] = getRank(numberMatches + numberOfZeros);
    answer[1] = getRank(numberMatches);

    return answer;
  }

  private int getRank(int n) {
    if (n == 0) {
      n++;
    }
    return Math.abs(n - 7);
  }
}
