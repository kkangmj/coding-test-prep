import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val numOfCity = Integer.parseInt(br.readLine())
    val distance = LongArray(numOfCity - 1)
    val price = LongArray(numOfCity)

    var st = StringTokenizer(br.readLine())
    for (i in 0 until numOfCity - 1) {
        distance[i] = st.nextToken().toLong()
    }

    st = StringTokenizer(br.readLine())
    var minPriceOfTotal = 1000000001L
    var indexOfMinPriceOfTotal = 0

    for (i in 0 until numOfCity) {
        val priceOfCity = st.nextToken().toLong()
        price[i] = priceOfCity
        if (i != numOfCity - 1 && minPriceOfTotal > priceOfCity) {
            minPriceOfTotal = priceOfCity
            indexOfMinPriceOfTotal = i
        }
    }

    var result = 0L
    var minPrice = 1000000001L

    for (i in distance.indices) {
        if (price[i] == minPriceOfTotal) break
        if (price[i] < minPrice) minPrice = price[i]
        result += minPrice * distance[i]
    }

    for (i in indexOfMinPriceOfTotal until numOfCity - 1) {
        result += minPriceOfTotal * distance[i]
    }

    println(result)
}