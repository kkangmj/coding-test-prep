import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var dp3: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    dp3 = Array(n + 1) { IntArray(10) }

    for (i in 1..9) {
        dp3[1][i] = 1
    }

    println(getStairNumber(n))

}

fun getStairNumber(number: Int): Long {
    return if (number == 1) getSumOf(dp3[1])
    else {
        for (i in 2..number) {
            for (j in 0..9) {
                dp3[i][j] = getEachValueWith(i, j)
            }
        }
        getSumOf(dp3[number])
    }
}

fun getSumOf(array: IntArray): Long {
    var sum = 0L
    array.forEach { sum += it }
    return sum % 1000000000
}

fun getEachValueWith(i: Int, j: Int) = when (j) {
    0 -> dp3[i - 1][1]
    9 -> dp3[i - 1][8]
    else -> (dp3[i - 1][j - 1] + dp3[i - 1][j + 1]) % 1000000000
}