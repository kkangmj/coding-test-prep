import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val brackets = br.readLine().toCharArray();
    var numOfStick = 0;
    var slicedStick = 0;
    var index = 0;

    while (index < brackets.size) {
        if (brackets[index] == '(') {
            if (brackets[index + 1] == ')') {
                slicedStick += numOfStick;
                index++;
            } else {
                numOfStick++;
            }
        } else {
            numOfStick--;
            slicedStick++;
        }
        index++;
    }

    println(slicedStick);
}