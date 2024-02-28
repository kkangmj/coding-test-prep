import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = Integer.parseInt(br.readLine())

    for (i in number downTo 1) {
        bw.write("$i\n")
    }

    bw.flush()

    br.close()
    bw.close()
}