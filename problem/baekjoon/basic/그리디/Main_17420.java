import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17420 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    Gifticon[] gifticons = new Gifticon[N];
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      gifticons[i] = new Gifticon(Integer.parseInt(st1.nextToken()),
          Integer.parseInt(st2.nextToken()));
    }

    Arrays.sort(gifticons);

    long timeOfExtension = 0L;

    int maxDeadLine = 0;
    int bfPlanToUseAt = 0;

    for (int i = 0; i < N; i++) {
      int deadLine = gifticons[i].deadLine;
      int planToUseAt = gifticons[i].planToUse;

      if (i > 0) {
        bfPlanToUseAt = gifticons[i - 1].planToUse;
        if (bfPlanToUseAt != planToUseAt) {
          for (int j = i - 1; j >= 0; j--) {
            if (gifticons[j].planToUse < bfPlanToUseAt) {
              break;
            }
            maxDeadLine = Math.max(maxDeadLine, gifticons[j].deadLine);
          }
        }
      }

      while (deadLine < planToUseAt || deadLine < maxDeadLine) {
        deadLine += 30;
        gifticons[i].deadLine += 30;
        timeOfExtension++;
      }
    }

    sb.append(timeOfExtension);
    System.out.println(sb);
  }

  static class Gifticon implements Comparable<Gifticon> {

    private int deadLine;
    private int planToUse;

    private Gifticon(int deadLine, int planToUse) {
      this.deadLine = deadLine;
      this.planToUse = planToUse;
    }

    @Override
    public int compareTo(Gifticon gifticon) {
      return this.planToUse - gifticon.planToUse;
    }
  }
}
