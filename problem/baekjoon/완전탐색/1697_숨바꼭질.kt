import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.max
import java.lang.Math.min
import java.util.*

lateinit var points: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val current = Integer.parseInt(st.nextToken())
    val target = Integer.parseInt(st.nextToken())
    points = IntArray(max(current, target) + 1) { Integer.MAX_VALUE }

    println(rec(current, target))
}


fun rec(current: Int, target: Int): Int {

    if (current >= target) {
        return current - target
    }

    if (points[current] != Integer.MAX_VALUE) {
        return points[current]
    }

    points[current] = min(points[current], rec(current + 1, target) + 1)
    points[current] = min(points[current], rec(current * 2, target) + 1)

    if (current >= 1) {
        points[current] = min(points[current], rec(current - 1, target) + 1)
    }

    return points[current]
}