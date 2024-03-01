import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph6: Array<CharArray>
lateinit var visited6: Array<BooleanArray>

var apartNum = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = Integer.parseInt(br.readLine())
    graph6 = Array(n) { CharArray(n) }
    visited6 = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until n) {
            graph6[i][j] = line[j]
        }
    }

    val arrayOfEachApart = mutableListOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph6[i][j] == '1' && !visited6[i][j]) {
                apartNum = 0
                dfs6(i, j, n)
                arrayOfEachApart.add(apartNum)
            }
        }
    }

    arrayOfEachApart.sort()

    bw.write("${arrayOfEachApart.size}\n")
    arrayOfEachApart.forEach { bw.write("${it}\n") }

    bw.flush()
}

fun dfs6(x: Int, y: Int, n: Int) {
    visited6[x][y] = true
    apartNum++

    val op1 = arrayOf(-1, 1, 0, 0)
    val op2 = arrayOf(0, 0, -1, 1)

    for (i in 0..3) {
        val nearX = x + op1[i]
        val nearY = y + op2[i]

        if (nearX in 0 until n && nearY in 0 until n && !visited6[nearX][nearY] && graph6[nearX][nearY] == '1') {
            dfs6(nearX, nearY, n)
        }
    }
}

