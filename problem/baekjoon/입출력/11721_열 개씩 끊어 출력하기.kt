import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val line = br.readLine()
    val chunkedWords = line.chunked(10)

    for (word in chunkedWords) {
        bw.write("$word\n")

    }

    bw.flush()

    br.close()
    bw.close()
}