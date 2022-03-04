import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testCaseCount = Integer.parseInt(br.readLine())

    for (i in 1..testCaseCount) {
        val stringTokenizer = StringTokenizer(br.readLine())

        val a = Integer.parseInt(stringTokenizer.nextToken())
        val b = Integer.parseInt(stringTokenizer.nextToken())

        bw.write("Case #$i: ${a + b}\n")

    }
    bw.flush()
    bw.close()
}