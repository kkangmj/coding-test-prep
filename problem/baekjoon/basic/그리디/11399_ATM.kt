import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    val timeToWithdrawal = IntArray(n)
    val st = StringTokenizer(br.readLine())

    for (i in 0 until n) {
        timeToWithdrawal[i] = Integer.parseInt(st.nextToken())
    }

    timeToWithdrawal.sort()

    var min = 0
    for (i in 0 until n) {
        min += timeToWithdrawal[i] * (n - i)
    }

    println(min)
}