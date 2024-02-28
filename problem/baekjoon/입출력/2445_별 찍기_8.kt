import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val number = Integer.parseInt(br.readLine())

    val halfOfLine = number - 1

    for (i in 1..halfOfLine) {
        sb.append("*".repeat(i))
        sb.append(" ".repeat(2 * (number - i)))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    sb.append("*".repeat(number * 2))
    sb.append("\n")

    for (i in halfOfLine downTo 1) {
        sb.append("*".repeat(i))
        sb.append(" ".repeat(2 * (number - i)))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()

    bw.close()
}