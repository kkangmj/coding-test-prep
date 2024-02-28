import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

lateinit var graph3: Array<MutableList<Int>>
lateinit var color: IntArray


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfCase = Integer.parseInt(br.readLine())

    for (i in 1..numberOfCase) {
        var st = StringTokenizer(br.readLine())
        val vertex = Integer.parseInt(st.nextToken())
        val edge = Integer.parseInt(st.nextToken())
        graph3 = Array(vertex + 1) { mutableListOf() }
        color = IntArray(vertex + 1)

        for (j in 1..edge) {
            st = StringTokenizer(br.readLine())
            val a = Integer.parseInt(st.nextToken())
            val b = Integer.parseInt(st.nextToken())
            graph3[a].add(b)
            graph3[b].add(a)
        }

        for (i in 1 until color.size) {
            if (color[i] == 0) dfs3(i)
        }

        if (isBipartiteGraph()) bw.write("YES\n")
        else bw.write("NO\n")
    }
    bw.flush()
}


fun dfs3(vertex: Int) {

    if (color[vertex] == 0) color[vertex] = 1

    for (i in graph3[vertex].indices) {
        val index = graph3[vertex][i]
        if (color[index] == 0) {
            color[index] = -color[vertex]
            dfs3(index)
        }
    }

}

fun isBipartiteGraph(): Boolean {

    for (i in graph3.indices) {
        if (graph3[i].isNotEmpty()) {
            val colorOfVertex = color[i]
            for (j in graph3[i]) {
                if (color[j] == colorOfVertex) return false
            }
        }
    }
    return true
}

