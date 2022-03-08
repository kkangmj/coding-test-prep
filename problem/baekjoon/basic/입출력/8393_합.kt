import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val lastNumber = Integer.parseInt(br.readLine())

    println(lastNumber * (lastNumber + 1) / 2)

    br.close()
}
