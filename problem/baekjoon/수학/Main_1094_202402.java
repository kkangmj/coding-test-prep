import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1094_202402 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int total = 64;
        int count = 0;

        while (total != 0) {
            if (x >= total) {
                x -= total;
                count++;
            }
            total /= 2;
        }

        System.out.println(count);
    }
}