import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var dp4: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    dp4 = Array(n + 1) { IntArray(10) }
    for (i in 0..9) {
        dp4[1][i] = 1
    }

    println(getAscendingNumber(n))
}

fun getAscendingNumber(n: Int): Long {
    for (i in 2..n) {
        for (j in 0..9) {
            dp4[i][j] = getValueWith(i, j)
        }
    }
    return getSumOfElement(dp4[n])
}

fun getSumOfElement(array: IntArray): Long {
    var sum = 0L
    array.forEach { sum += it }
    return sum % 10007
}

fun getValueWith(i: Int, j: Int): Int = when (j) {
    0 -> 1
    else -> (dp4[i][j - 1] + dp4[i - 1][j]) % 10007
}