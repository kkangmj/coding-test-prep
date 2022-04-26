import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

private var n = 0
private lateinit var numberArray: IntArray
private var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = Integer.parseInt(br.readLine())
    numberArray = with(StringTokenizer(br.readLine())) {
        IntArray(n) { Integer.parseInt(nextToken()) }
    }

    perm(0, IntArray(n), BooleanArray(n))

    println(max)
}

fun perm(index: Int, array: IntArray, visited: BooleanArray) {
    if (index == n) {
        var value = 0
        for (i in 0 until n - 1) {
            value += abs(array[i] - array[i + 1])
        }
        if (value > max) max = value
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            array[index] = numberArray[i]
            perm(index + 1, array, visited)
            visited[i] = false
        }
    }
}