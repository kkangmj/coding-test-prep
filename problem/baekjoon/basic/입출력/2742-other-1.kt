import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val number = Integer.parseInt(br.readLine())

    for (i in number downTo 1) {
        sb.append("$i\n")
    }

    println(sb)

    br.close()
}