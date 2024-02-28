import java.lang.Integer.min
import java.util.*

var N: Int = 0
var INF = 100000000
lateinit var G: Array<IntArray>
lateinit var V: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {

    N = Integer.parseInt(readLine())
    G = Array(N) {
        val st = StringTokenizer(readLine())
        IntArray(N) { Integer.parseInt(st.nextToken()) }
    }
    V = Array(N) { IntArray(1 shl N) { INF } }

    println("${tsp(0, 1)}")
}

fun tsp(city: Int, visited: Int): Int {

    if (visited == (1 shl N) - 1) {
        return if (G[city][0] != 0) G[city][0] else INF
    }

    if (V[city][visited] != INF) return V[city][visited]

    G[city].forEachIndexed { index, value ->
        if (value != 0 && visited and (1 shl index) == 0) {
            V[city][visited] = min(V[city][visited], tsp(index, visited or (1 shl index)) + value)
        }
    }
    return V[city][visited]
}