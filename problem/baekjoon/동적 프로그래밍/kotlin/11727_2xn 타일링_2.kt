import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val dp = IntArray(10001)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = Integer.parseInt(br.readLine())
    dp[1] = 1
    dp[2] = 3

    bw.write(numberOfCombination(n).toString())
    bw.flush()
}

fun numberOfCombination(n: Int): Int {
    if (dp[n] > 0) return dp[n]

    dp[n] = (numberOfCombination(n - 1) + numberOfCombination(n - 2) * 2) % 10007
    return dp[n]
}