import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = Integer.parseInt(br.readLine())
    val map = mutableMapOf<Int, MutableList<Int>>()

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        val x = Integer.parseInt(st.nextToken())
        val y = Integer.parseInt(st.nextToken())

        if (map.containsKey(x)) {
            map[x]?.add(y)
        } else {
            map[x] = mutableListOf(y)
        }
    }

    for (i in map.keys.sorted()) {
        map[i]?.sorted()?.forEach { sb.append("$i $it\n") }
    }

    println(sb.toString())
}