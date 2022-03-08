import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuffer()

    val number = Integer.parseInt(br.readLine())

    for (i in 1..number) {
        sb.append(" ".repeat(number - i))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()

    br.close()
    bw.close()
}