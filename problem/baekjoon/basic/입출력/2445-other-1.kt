import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    val number = Integer.parseInt(br.readLine())

    val intArray = IntArray(number * 2 - 1) { i -> if (i < number) i + 1 else 2 * number - i - 1 }

    for (i in intArray) {
        sb.append("*".repeat(i))
        sb.append(" ".repeat(2 * (number - i)))
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    bw.write(sb.toString())
    bw.flush()
}