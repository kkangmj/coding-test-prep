import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var line = br.readLine()

    while (true) {
        bw.write("${if (line[0] == '0' && line[1] == '0') break else line[0].code + line[1].code}")
        bw.flush()

        line = br.readLine()
    }

    bw.close()

}