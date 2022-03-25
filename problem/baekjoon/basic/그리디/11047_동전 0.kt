import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val typeOfCoin = Integer.parseInt(st.nextToken())
    val goalOfPrice = Integer.parseInt(st.nextToken())

    val coins = IntArray(typeOfCoin)

    for (i in 0 until typeOfCoin) {
        coins[i] = Integer.parseInt(br.readLine())
    }

    println(greedy(goalOfPrice, coins))
}

fun greedy(price: Int, coins: IntArray): Int {
    var count = 0
    var leftPrice = price
    for (i in coins.reversed()) {
        while (leftPrice >= i) {
            leftPrice -= i
            count++
            if (leftPrice == 0) return count
        }

    }
    return -1
}