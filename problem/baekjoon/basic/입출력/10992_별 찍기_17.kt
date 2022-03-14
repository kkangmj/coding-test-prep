import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val numberOfLine = Integer.parseInt(br.readLine())

    for (i in 1 until numberOfLine) {
        for (j in 1..(numberOfLine - i)) sb.append(" ")
        if (i != 1) sb.append("*")
        for (j in 1..(2 * i - 3)) sb.append(" ")
        sb.append("*\n")
    }

    for (i in 1 until 2 * numberOfLine) sb.append("*")

    bw.write(sb.toString())
    bw.flush()
}