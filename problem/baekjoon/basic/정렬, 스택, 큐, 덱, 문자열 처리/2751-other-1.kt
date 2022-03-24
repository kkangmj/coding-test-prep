import java.io.BufferedReader
import java.io.InputStreamReader

val array2 = BooleanArray(2000001)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = Integer.parseInt(br.readLine())

    for (i in 1..n) {
        val value = Integer.parseInt(br.readLine())
        array2[value + 1000000] = true
    }

    for (i in array2.indices) {
        if (array2[i]) sb.append("${i - 1000000}\n")
    }

    println(sb.toString())
}