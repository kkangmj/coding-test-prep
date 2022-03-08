import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuffer()

    val numberOfLine = Integer.parseInt(br.readLine())

    for (i in 1..numberOfLine) {
        sb.append(" ".repeat(numberOfLine - i))
        sb.append("*".repeat(i * 2 - 1))
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()
}