import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var vertex: Int = 0
var edge: Int = 0
lateinit var graph2: Array<IntArray>
lateinit var visited2: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    vertex = Integer.parseInt(st.nextToken())
    edge = Integer.parseInt(st.nextToken())
    graph2 = Array(vertex + 1) { IntArray(vertex + 1) }
    visited2 = BooleanArray(vertex + 1)

    for (i in 1..edge) {
        st = StringTokenizer(br.readLine())
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())
        graph2[a][b] = 1
        graph2[b][a] = 1
    }

    bw.write(getNumberOfConnectedComponent().toString())
    bw.flush()
}

fun getNumberOfConnectedComponent(): Int {

    var count: Int = 0

    for (i in 1..vertex) {
        if (!visited2[i]) {
            dfs2(i)
            count += 1
        }
    }

    return count
}

fun dfs2(startPoint: Int) {

    visited2[startPoint] = true

    for (i in 1..vertex) {
        if (!visited2[i] && graph2[startPoint][i] == 1) {
            dfs2(i)
        }
    }
}