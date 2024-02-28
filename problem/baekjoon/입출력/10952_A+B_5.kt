import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    try {
        while (true) {
            val tokenizer = StringTokenizer(br.readLine())

            val a = Integer.parseInt(tokenizer.nextToken())
            val b = Integer.parseInt(tokenizer.nextToken())

            if (a == 0 && b == 0) {
                break
            }

            bw.write("${a + b}\n")
            bw.flush()
        }
    } catch (e: Exception) {
    }

    bw.close()

}