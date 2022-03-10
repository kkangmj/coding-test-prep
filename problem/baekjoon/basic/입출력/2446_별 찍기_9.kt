import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val number = Integer.parseInt(br.readLine())

    for (i in 1..number) {
        for (j in 1 until i) sb.append(" ")
        for (j in 1..(2 * (number - i) + 1)) sb.append("*")
        sb.append("\n")
    }

    for (i in 1 until number) {
        for (j in 1 until number - i) sb.append(" ")
        for (j in 1..(2 * i + 1)) sb.append("*")
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()

    br.close()
    bw.close()
}