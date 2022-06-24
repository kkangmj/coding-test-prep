/**
 * Quick Sort
 * 실행 시간: 1164ms
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main_11004_other_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] array = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    quickSort(array, 0, N - 1, K - 1);

    bw.write(array[K-1]);
    bw.flush();
  }

  private static void quickSort(int[] array, int left, int right, int order) {
    int index = partition(array, left, right);
    if (left < index - 1 && order <= index - 1) {
      quickSort(array, left, index - 1, order);
    }
    if (index < right && order >= index) {
      quickSort(array, index, right, order);
    }
  }

  private static int partition(int[] array, int start, int end) {
    int left = start;
    int right = end;
    int pivot = array[(start + end) / 2];

    while (left <= right) {
      while (array[left] < pivot) {
        left++;
      }
      while (array[right] > pivot) {
        right--;
      }

      if (left <= right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
      }
    }

    return left;
  }

}
