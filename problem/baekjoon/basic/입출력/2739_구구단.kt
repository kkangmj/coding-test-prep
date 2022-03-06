import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = Integer.parseInt(br.readLine())

    for (i in 1..9) {
        bw.write("$number * $i = ${number * i}\n")
    }

    bw.flush()
}