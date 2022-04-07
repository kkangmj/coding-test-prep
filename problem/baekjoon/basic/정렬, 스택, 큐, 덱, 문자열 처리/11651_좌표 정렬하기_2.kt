import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = Integer.parseInt(br.readLine())
    val array = Array(n) { Point2(0, 0) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        array[i] = Point2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
    }

    quickSort2(array, 0, n - 1)
    array.forEach { bw.write("${it.x} ${it.y}\n") }

    bw.flush()
}

fun quickSort2(array: Array<Point2>, left: Int, right: Int) {
    val index = partition2(array, left, right)
    if (left < index - 1) {
        quickSort2(array, left, index - 1)
    }
    if (index < right) {
        quickSort2(array, index, right)
    }
}

fun partition2(array: Array<Point2>, left: Int, right: Int): Int {
    var leftIndex = left
    var rightIndex = right
    val pivot = array[(left + right) / 2]

    while (leftIndex <= rightIndex) {
        while (array[leftIndex].compare(pivot) < 0) {
            leftIndex++
        }
        while (array[rightIndex].compare(pivot) > 0) {
            rightIndex--
        }
        if (leftIndex <= rightIndex) {
            val temp = array[leftIndex]
            array[leftIndex] = array[rightIndex]
            array[rightIndex] = temp
            leftIndex++
            rightIndex--
        }
    }
    return leftIndex
}

class Point2(val x: Int, val y: Int) {
    fun compare(other: Point2): Int {
        return if (y > other.y) {
            1
        } else if (y == other.y) {
            if (x > other.x) 1
            else if (x == other.x) 0
            else -1
        } else {
            -1
        }
    }
}