/**
 * 1792. Maximum Average Pass Ratio
 * Runtime: 1005ms, Memory: 137MB
 */

import java.util.PriorityQueue;

public class Solution_1792 {

  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<ClassInfo> pq = new PriorityQueue<>();

    for (int i = 0; i < classes.length; i++) {
      pq.add(new ClassInfo(classes[i][0], classes[i][1]));
    }

    while (!pq.isEmpty() && extraStudents > 0) {
      ClassInfo classInfo = pq.poll();
      pq.add(new ClassInfo(classInfo.pass + 1, classInfo.total + 1));

      extraStudents--;
    }

    double sum = 0;

    while (!pq.isEmpty()) {
      ClassInfo classInfo = pq.poll();
      sum += classInfo.pass / classInfo.total;
    }

    return sum / classes.length;
  }

  static class ClassInfo implements Comparable<ClassInfo> {

    private double pass;
    private double total;

    private ClassInfo(double pass, double total) {
      this.pass = pass;
      this.total = total;
    }

    @Override
    public int compareTo(ClassInfo classInfo) {
      double increasedA = ((this.pass + 1) / (this.total + 1)) - (this.pass / this.total);
      double increasedB =
          ((classInfo.pass + 1) / (classInfo.total + 1)) - (classInfo.pass / classInfo.total);
      return increasedA > increasedB ? -1 : 1;
    }
  }
}
