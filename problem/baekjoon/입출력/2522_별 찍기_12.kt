import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val number = Integer.parseInt(br.readLine())

    for (i in 1..number) {
        sb.append(" ".repeat(number-i))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    for (i in (number-1) downTo 1) {
        sb.append(" ".repeat(number-i))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()
}