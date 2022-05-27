import java.io.*
import java.util.*

val op1 = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
val op2 = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

var w = 0
var h = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        var st = StringTokenizer(br.readLine())

        w = Integer.parseInt(st.nextToken())
        h = Integer.parseInt(st.nextToken())

        if (w == 0 && h == 0) break

        val graph = Array(h) { IntArray(w) }

        for (i in 0 until h) {
            st = StringTokenizer(br.readLine())
            for (j in 0 until w) {
                graph[i][j] = Integer.parseInt(st.nextToken())
            }
        }

        val visited = Array(h) { BooleanArray(w) }
        var numOfIsland = 0

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs7(i, j, graph, visited)
                    numOfIsland++
                }
            }
        }

        bw.write("$numOfIsland\n")
    }

    bw.flush()
}

fun dfs7(x: Int, y: Int, graph: Array<IntArray>, visited: Array<BooleanArray>) {
    visited[x][y] = true

    for (i in 0..7) {
        val newX = x + op1[i]
        val newY = y + op2[i]

        if (newX in 0 until h && newY in 0 until w &&
            !visited[newX][newY] && graph[newX][newY] == 1
        ) {
            dfs7(newX, newY, graph, visited)
        }
    }
}