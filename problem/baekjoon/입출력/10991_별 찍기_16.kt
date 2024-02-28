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
        for (j in 1..(numberOfLine - i)) sb.append(" ")
        for (j in 1..i) sb.append("* ")
        sb.append("\n")
    }
    bw.write(sb.toString())
    bw.flush()
}