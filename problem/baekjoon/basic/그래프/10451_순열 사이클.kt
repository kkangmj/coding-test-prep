import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var count: Int = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val numberOfTestCase = Integer.parseInt(br.readLine())

    for (i in 1..numberOfTestCase) {
        val sizeOfPermutation = Integer.parseInt(br.readLine())
        val permutation = IntArray(sizeOfPermutation + 1)
        val st = StringTokenizer(br.readLine())

        for (j in 1..sizeOfPermutation) {
            permutation[j] = Integer.parseInt(st.nextToken())
        }

        count = 0
        getNumberOfCycle(permutation, BooleanArray(sizeOfPermutation + 1))
        bw.write("$count\n")
    }
    bw.flush()
}

fun getNumberOfCycle(array: IntArray, visited: BooleanArray) {
    for (i in 1 until array.size) {
        if (!visited[i]) dfs4(i, i, array, visited)
    }
}

fun dfs4(startPoint: Int, index: Int, array: IntArray, visited: BooleanArray) {

    visited[index] = true

    if (array[index] == startPoint) {
        count++
        return
    }
    if (!visited[array[index]]) dfs4(startPoint, array[index], array, visited)
}