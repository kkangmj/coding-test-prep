/*
N개의 최소공배수
 */

public class Solution_12953 {

  public static void main(String[] args) {
    Solution_12953 solution_12953 = new Solution_12953();
    int[] arr = {2, 6, 8, 14};
    System.out.println(solution_12953.solution(arr));
  }

  private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
      59, 61,
      67, 71, 73,
      79, 83, 89, 97};

  public int solution(int[] arr) {
    int answer = 1;
    int[] maxPrimeInNum = new int[101];

    for (int i = 0; i < arr.length; i++) {
      int n = arr[i];
      int index = 0;
      int[] primeInNum = new int[101];

      while (n != 1) {
        int d = primes[index];

        if (n % d == 0) {
          n /= d;
          primeInNum[d]++;
        } else {
          index++;
        }
      }

      for (int j = 0; j < 100; j++) {
        maxPrimeInNum[j] = Math.max(maxPrimeInNum[j], primeInNum[j]);
      }
    }

    for (int i = 2; i < 100; i++) {
      int power = maxPrimeInNum[i];
      if (power != 0) {
        answer *= Math.pow(i, power);
      }
    }

    return answer;
  }
}
