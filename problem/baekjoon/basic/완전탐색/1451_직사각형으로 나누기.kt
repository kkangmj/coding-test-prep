import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val height = Integer.parseInt(st.nextToken())
    val width = Integer.parseInt(st.nextToken())
    val rectangle = Array(height) { IntArray(width) }

    for (i in 0 until height) {
        val line = br.readLine()
        for (j in 0 until width) {
            rectangle[i][j] = Integer.parseInt(line[j].toString())
        }
    }

    println(getMaxOfMultiply(height, width, rectangle))
}

fun getMaxOfMultiply(height: Int, width: Int, rectangle: Array<IntArray>): Long {
    var totalSumOfNumber = 0
    rectangle.forEach { it.forEach { n -> totalSumOfNumber += n } }

    var max: Long = 0

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (i == height - 1 && j == width - 1) break
            val aRectangle = getSumOfRectangle(0, 0, i, j, rectangle)
            var bRectangle = 0L
            var cRectangle = 0L
            if (j == width - 1) {
                for (n in (i + 1) until height) {
                    if (n != height - 1) {
                        bRectangle = getSumOfRectangle((i + 1), 0, n, j, rectangle)
                        cRectangle = totalSumOfNumber - aRectangle - bRectangle
                        if (max < aRectangle * bRectangle * cRectangle) max =
                            aRectangle * bRectangle * cRectangle
                    } else {
                        for (m in 0 until width - 1) {
                            bRectangle = getSumOfRectangle((i + 1), 0, n, m, rectangle)
                            cRectangle = totalSumOfNumber - aRectangle - bRectangle
                            if (max < aRectangle * bRectangle * cRectangle) max =
                                aRectangle * bRectangle * cRectangle
                        }
                    }
                }
            } else if (i == height - 1) {
                for (n in (j + 1) until width) {
                    if (n != width - 1) {
                        bRectangle = getSumOfRectangle(0, j + 1, i, n, rectangle)
                        cRectangle = totalSumOfNumber - aRectangle - bRectangle
                        if (max < aRectangle * bRectangle * cRectangle) max =
                            aRectangle * bRectangle * cRectangle
                    } else {
                        for (m in 0 until height - 1) {
                            bRectangle = getSumOfRectangle(0, j + 1, m, n, rectangle)
                            cRectangle = totalSumOfNumber - aRectangle - bRectangle
                            if (max < aRectangle * bRectangle * cRectangle) max =
                                aRectangle * bRectangle * cRectangle
                        }
                    }
                }
            } else {
                bRectangle = getSumOfRectangle(i + 1, 0, height - 1, j, rectangle)
                cRectangle = totalSumOfNumber - aRectangle - bRectangle
                if (max < aRectangle * bRectangle * cRectangle) max =
                    aRectangle * bRectangle * cRectangle

                bRectangle = getSumOfRectangle(i + 1, 0, height - 1, width - 1, rectangle)
                cRectangle = totalSumOfNumber - aRectangle - bRectangle
                if (max < aRectangle * bRectangle * cRectangle) max =
                    aRectangle * bRectangle * cRectangle
            }
        }
    }
    return max
}

fun getSumOfRectangle(
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int,
    rectangle: Array<IntArray>
): Long {
    var sum = 0
    for (i in startX..endX) {
        for (j in startY..endY) {
            sum += rectangle[i][j]
        }
    }
    return sum.toLong()
}