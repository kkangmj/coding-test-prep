import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1826 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] gasStation = new int[1000001];
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int dist = Integer.parseInt(st.nextToken());
      int amount = Integer.parseInt(st.nextToken());

      gasStation[dist] = amount;
    }

    st = new StringTokenizer(br.readLine());
    int town = Integer.parseInt(st.nextToken());
    int baseAmount = Integer.parseInt(st.nextToken());

    System.out.println(getInPosition(baseAmount, town, N, gasStation));
  }

  private static int getInPosition(int amount, int town, int N, int[] gasStations) {
    PriorityQueue<GasStation> pq = new PriorityQueue<>();
    pq.add(new GasStation(0, amount));

    int visit = 0;
    int currentLocation = 0;
    int currentGasAmount = 0;

    while (!pq.isEmpty()) {
      GasStation gasStation = pq.poll();

      int gasAmount = gasStation.amount;
      int location = gasStation.location;

      currentGasAmount = location < currentLocation ? currentGasAmount + gasAmount
          : currentGasAmount - (location - currentLocation) + gasAmount;
      currentLocation = Math.max(currentLocation, location);
      int maxLocation = currentLocation + currentGasAmount;

      if (maxLocation >= town) {
        return visit;
      }

      for (int i = currentLocation + 1; i <= maxLocation; i++) {
        if (gasStations[i] != 0) {
          pq.add(new GasStation(i, gasStations[i]));
          gasStations[i] = 0;
        }
      }

      visit++;
    }

    return -1;
  }

  static class GasStation implements Comparable<GasStation> {

    private int location;
    private int amount;


    GasStation(int location, int amount) {
      this.location = location;
      this.amount = amount;
    }

    @Override
    public int compareTo(GasStation gasStation) {
      if (this.amount > gasStation.amount) {
        return -1;
      } else if (this.amount == gasStation.amount) {
        return this.location >= gasStation.location ? -1 : 1;
      } else {
        return 1;
      }
    }
  }
}
