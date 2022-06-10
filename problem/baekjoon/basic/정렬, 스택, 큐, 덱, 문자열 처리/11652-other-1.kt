import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    val map = HashMap<Long, Int>()

    for (i in 1..N) {
        val key = br.readLine().toLong()
        // map 자료구조 사용 시 유용한 함수
        // - getOrDefault 함수
        map[key] = map.getOrDefault(key, 0) + 1
    }

    var minKey = Long.MAX_VALUE
    var maxCount = 0

    for ((key, value) in map) {
        if (value > maxCount) {
            maxCount = value
            minKey = key
        }
        if (value == maxCount && key < minKey) minKey = key
    }

    println(minKey.toString())
}