import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val array = mutableListOf<Int>()

    val st = StringTokenizer(br.readLine())
    for (i in 1..n) {
        array.add(Integer.parseInt(st.nextToken()))
    }

    val permutedLists = permutation(array)
    var max = 0
    for (i in permutedLists) {
        if (max < getValueOf(i)) max = getValueOf(i)
    }

    println(max)
}

fun permutation(
    array: List<Int>,
    temp: List<Int> = listOf(),
    sub: List<Int> = array
): List<List<Int>> =
    when (sub.size) {
        1 -> listOf(temp + sub)
        else -> sub.flatMap { permutation(array, temp + it, sub - it) }
    }

fun getValueOf(list: List<Int>): Int {
    var value = 0
    for (i in 0 until list.size - 1) {
        value += abs(list[i] - list[i + 1])
    }
    return value
}