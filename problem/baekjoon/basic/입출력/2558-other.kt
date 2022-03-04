import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = StringTokenizer(br.readLine()).nextToken().toInt()
    val b = StringTokenizer(br.readLine()).nextToken().toInt()

    println(a + b)
}