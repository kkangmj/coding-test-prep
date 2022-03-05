import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = Integer.parseInt(br.readLine())
    val numbersForSum = br.readLine()
    var sum = 0

    for (i in 0 until number) {
        sum += Integer.parseInt(numbersForSum[i].toString())
    }

    bw.write("$sum")
    bw.flush()

    bw.close()
    br.close()
}