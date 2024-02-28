import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = Integer.parseInt(br.readLine())
    val stringTokenizer = StringTokenizer(br.readLine())

    var maxNumber: Int = Integer.parseInt(stringTokenizer.nextToken())
    var minNumber: Int = maxNumber

    for (i in 1 until number) {
        val nextNumber = Integer.parseInt(stringTokenizer.nextToken())
        maxNumber = max(maxNumber, nextNumber)
        minNumber = min(minNumber, nextNumber)
    }

    bw.write("$minNumber $maxNumber")
    bw.flush()

    br.close()
    bw.close()
}