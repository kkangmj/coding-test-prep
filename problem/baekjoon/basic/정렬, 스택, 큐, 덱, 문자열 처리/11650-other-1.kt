import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = Integer.parseInt(br.readLine())
    val array = Array(n) { Point(0, 0) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        array[i] = Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
    }

    quickSort(array, 0, array.size - 1)

    for (i in array) {
        sb.append("${i.x} ${i.y}\n")
    }

    println(sb.toString())

}

fun quickSort(array: Array<Point>, startIndex: Int, endIndex: Int) {
    val index = partition(array, startIndex, endIndex)
    if (startIndex < index - 1) quickSort(array, startIndex, index - 1)
    if (index < endIndex) quickSort(array, index, endIndex)

}

fun partition(array: Array<Point>, start: Int, end: Int): Int {
    var left = start
    var right = end
    val pivot = array[(left + right) / 2]

    while (left <= right) {
        while (array[left].compare(pivot) < 0) left++
        while (array[right].compare(pivot) > 0) right--

        if (left <= right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
    return left
}

class Point(val x: Int, val y: Int) {
    fun compare(other: Point): Int {
        return if (this.x > other.x) {
            1
        } else if (this.x == other.x) {
            if (this.y > other.y) {
                1
            } else if (this.y == other.y) {
                0
            } else {
                -1
            }
        } else {
            -1
        }
    }
}
