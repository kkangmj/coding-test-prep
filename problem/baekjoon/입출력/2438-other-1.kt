import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val numberOfLine = Integer.parseInt(br.readLine())

    for (i in 1..numberOfLine) {
        sb.append("*".repeat(i))
        sb.append("\n")
    }
    bw.write(sb.toString())
    bw.flush()
}