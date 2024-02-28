import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val array = mutableListOf<Int>()

    val A = Integer.parseInt(st.nextToken())
    val P = Integer.parseInt(st.nextToken())
    var startOfRepeat = 0

    array.add(A)

    for (i in 0..10000) {
        var value = 0
        for (element in array[i].toString()) {
            value += element.toString().toDouble().pow(P).toInt()
        }
        if (value in array) {
            startOfRepeat = value
            break
        }
        array.add(value)
    }

    val endPoint = array.indexOf(startOfRepeat)
    println(endPoint)
}