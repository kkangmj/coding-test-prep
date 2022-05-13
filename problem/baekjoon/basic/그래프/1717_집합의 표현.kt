import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())

    val n = Integer.parseInt(st.nextToken())
    val m = Integer.parseInt(st.nextToken())

    parent = IntArray(n + 1) { it }

    for (i in 1..m) {
        val st = StringTokenizer(br.readLine())

        val operation = st.nextToken()
        val x = Integer.parseInt(st.nextToken())
        val y = Integer.parseInt(st.nextToken())

        if (operation == "0") {
            union(x, y)
        } else {
            if (isSameParent(x, y)) bw.write("YES\n")
            else bw.write("NO\n")
        }
    }

    bw.flush()
}

fun union(x: Int, y: Int) {
    val a = find(x)
    val b = find(y)

    if (a < b)
        parent[b] = a
    else
        parent[a] = b
}

fun find(x: Int): Int {
    if (x == parent[x]) return parent[x]
    else {
        parent[x] = find(parent[x])
        return parent[x]
    }
}

fun isSameParent(x: Int, y: Int): Boolean {
    val a = find(x)
    val b = find(y)

    return a == b
}