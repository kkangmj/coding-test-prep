import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var N: Int = 0
var M: Int = 0
var V: Int = 0

var graph: Array<IntArray> = arrayOf()
var visited: BooleanArray = booleanArrayOf()

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = Integer.parseInt(st.nextToken())
    M = Integer.parseInt(st.nextToken())
    V = Integer.parseInt(st.nextToken())

    graph = Array(N + 1) { IntArray(N + 1) }
    visited = BooleanArray(N + 1)

    for (i in 1..M) {
        st = StringTokenizer(br.readLine())
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())
        graph[a][b] = 1
        graph[b][a] = 1
    }

    dfs(V)
    bw.write("\n")

    for (i in visited.indices) visited[i] = false

    bfs(V)
    bw.flush()

}

fun dfs(V: Int) {
    visited[V] = true
    bw.write("$V ")

    for (i in 1..N) {
        if (!visited[i] && graph[V][i] == 1) {
            dfs(i)
        }
    }
}

fun bfs(V: Int) {
    val queue: Queue<Int> = LinkedList()
    visited[V] = true
    queue.add(V)

    while (queue.isNotEmpty()) {
        val startPoint = queue.poll()
        bw.write("$startPoint ")

        for (i in 1..N) {
            if (!visited[i] && graph[startPoint][i] == 1) {
                visited[i] = true
                queue.add(i)
            }
        }
    }
}