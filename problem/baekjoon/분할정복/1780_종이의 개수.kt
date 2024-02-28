import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var typeOfPaper: IntArray
lateinit var st: StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())
    val matrix = IntArray(n * n)
    typeOfPaper = IntArray(3)

    for (i in 0 until n * n) {
        if (i % n == 0) {
            st = StringTokenizer(br.readLine())
        }
        matrix[i] = Integer.parseInt(st.nextToken())
    }

    getNumberOfPaper(matrix, n)
    typeOfPaper.forEach { println(it) }
}

fun getNumberOfPaper(matrix: IntArray, n: Int) {

    if (isSinglePaper(matrix)) {
        addNumberOfPaper(matrix[0])
        return
    }

    val splitTo = n / 3

    if (splitTo == 1) {
        matrix.forEach { addNumberOfPaper(it) }
        return
    }

    var startPoint = 0

    for (i in 0 until 9) {
        val newMatrix = IntArray(splitTo * splitTo)

        if (i % 3 == 0) {
            startPoint = n * splitTo * (i / 3)
        } else {
            startPoint += splitTo
        }

        var point = startPoint
        var newMatrixIndex = 0

        for (j in 0 until splitTo) {
            for (k in 0 until splitTo) {
                newMatrix[newMatrixIndex] = matrix[point + k]
                newMatrixIndex += 1
            }
            point += n
        }
        getNumberOfPaper(newMatrix, splitTo)
    }
}

fun isSinglePaper(matrix: IntArray): Boolean {
    val value = matrix[0]
    for (i in matrix) {
        if (i != value) return false
    }
    return true
}

fun addNumberOfPaper(value: Int) = when (value) {
    -1 -> typeOfPaper[0] += 1
    0 -> typeOfPaper[1] += 1
    else -> typeOfPaper[2] += 1
}