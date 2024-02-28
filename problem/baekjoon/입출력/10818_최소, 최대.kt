import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = Integer.parseInt(br.readLine())
    val stringTokenizer = StringTokenizer(br.readLine())

    val intArray = IntArray(number) { _ -> Integer.parseInt(stringTokenizer.nextToken()) }

    bw.write("${intArray.minOrNull()} ${intArray.maxOrNull()}")
    bw.flush()

    br.close()
    bw.close()
}