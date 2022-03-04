import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfTestCase = Integer.parseInt(br.readLine())

    for (i in 1..numberOfTestCase) {
        val line = br.readLine()
        val stringTokenizer = StringTokenizer(line, ",")

        val a = Integer.parseInt(stringTokenizer.nextToken())
        val b = Integer.parseInt(stringTokenizer.nextToken())

        bw.write("${a + b}\n")
        bw.flush()
    }

    bw.close()
}