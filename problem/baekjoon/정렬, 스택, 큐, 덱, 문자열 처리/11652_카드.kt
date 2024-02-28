import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    val map = mutableMapOf<Long, Int>()

    for (i in 1..N) {
        val n = br.readLine().toLong()
        if (map.containsKey(n)) {
            map[n] = map[n]!!.plus(1)
        } else {
            map[n] = 1
        }
    }

    val resultMap = map.toList()
        .sortedWith(compareByDescending<Pair<Long, Int>> { (_, value) -> value }.thenBy { (key, _) -> key })
    println(resultMap.first().first)
}