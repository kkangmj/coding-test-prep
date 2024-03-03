import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = Integer.parseInt(br.readLine())
    val array = Array(n) { Point3(0, 0) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        array[i] = Point3(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
    }

    quickSort3(array, 0, n - 1)
    array.forEach { bw.write("${it.x} ${it.y}\n") }

    bw.flush()
}

fun quickSort3(array: Array<Point3>, left: Int, right: Int) {
    val index = partition3(array, left, right)
    if (left < index - 1) {
        quickSort3(array, left, index - 1)
    }
    if (index < right) {
        quickSort3(array, index, right)
    }
}

fun partition3(array: Array<Point3>, left: Int, right: Int): Int {
    var leftIndex = left
    var rightIndex = right
    val pivot = array[(left + right) / 2]

    while (leftIndex <= rightIndex) {
        while (array[leftIndex] < pivot) {
            leftIndex++
        }
        while (array[rightIndex] > pivot) {
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

class Point3(val x: Int, val y: Int) : Comparable<Point3> {
    override fun compareTo(other: Point3): Int {
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