import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = br.readLine()
    val sb = StringBuffer()

    val numberOfLine = line.length / 10

    for (i in 0 until numberOfLine ) {
        sb.append(line.substring(10 * i, 10 * (i+1) ))
        sb.append("\n")
    }

    sb.append(line.substring(10 * numberOfLine ))
    sb.append("\n")

    bw.write("$sb")
    bw.flush()

    br.close()
    bw.close()
}