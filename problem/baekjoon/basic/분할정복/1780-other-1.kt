import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var matrix: Array<IntArray>
lateinit var numberOfPaperWithType: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    matrix = Array(n) { IntArray(n) }
    numberOfPaperWithType = IntArray(3)

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            matrix[i][j] = Integer.parseInt(st.nextToken())
        }
    }

    dividePaper(0, 0, n)

    numberOfPaperWithType.forEach { println(it) }
}

fun dividePaper(x: Int, y: Int, n: Int) {
    if (isSingle(x, y, n)) {
        addNumberOf(matrix[x][y])
        return
    }

    val splitTo = n / 3

    dividePaper(x, y, splitTo)
    dividePaper(x, y + splitTo, splitTo)
    dividePaper(x, y + splitTo * 2, splitTo)
    dividePaper(x + splitTo, y, splitTo)
    dividePaper(x + splitTo, y + splitTo, splitTo)
    dividePaper(x + splitTo, y + splitTo * 2, splitTo)
    dividePaper(x + splitTo * 2, y, splitTo)
    dividePaper(x + splitTo * 2, y + splitTo, splitTo)
    dividePaper(x + splitTo * 2, y + splitTo * 2, splitTo)
}

fun isSingle(x: Int, y: Int, n: Int): Boolean {
    val value = matrix[x][y]

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[x + i][y + j] != value) return false
        }
    }

    return true
}

fun addNumberOf(value: Int) = when (value) {
    -1 -> numberOfPaperWithType[0] += 1
    0 -> numberOfPaperWithType[1] += 1
    else -> numberOfPaperWithType[2] += 1
}

