import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    val dp = Array(n + 1) { LongArray(2) }

    dp[1][1] = 1

    for (i in 2..n) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
        dp[i][1] = dp[i - 1][0]
    }

    println(dp[n][0] + dp[n][1])
}