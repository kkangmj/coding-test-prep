import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Long.min
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val numOfCity = Integer.parseInt(br.readLine())
    var st = StringTokenizer(br.readLine())
    val distance = LongArray(numOfCity - 1) { st.nextToken().toLong() }

    st = StringTokenizer(br.readLine())
    var minPrice = 1000000001L
    var result = 0L

    for (i in distance.indices) {
        val priceOfCity = st.nextToken().toLong()
        minPrice = min(priceOfCity, minPrice)
        result += minPrice * distance[i]
    }

    println(result)
}