import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var tomatoM = 0
var tomatoN = 0

lateinit var tomatoGraph: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    tomatoM = Integer.parseInt(st.nextToken())
    tomatoN = Integer.parseInt(st.nextToken())
    tomatoGraph = Array(tomatoN) { IntArray(tomatoM) }
    val ripeTomato: Queue<Point> = LinkedList()

    for (i in 0 until tomatoN) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until tomatoM) {
            val statusOfTomato = Integer.parseInt(st.nextToken())
            tomatoGraph[i][j] = statusOfTomato
            if (statusOfTomato == 1) {
                ripeTomato.offer(Point(i, j))
            }
        }
    }

    if (ripeTomato.isEmpty()) {
        println(-1)
        return
    }

    var recentRipeTomato = bfs(ripeTomato)
    var minTime = 0

    while (recentRipeTomato.isNotEmpty()) {
        minTime++
        recentRipeTomato = bfs(recentRipeTomato)
    }

    for (i in 0 until tomatoN) {
        for (j in 0 until tomatoM) {
            if (tomatoGraph[i][j] == 0) {
                println(-1)
                return
            }
        }
    }

    println(minTime)
}

fun bfs(ripeTomato: Queue<Point>): Queue<Point> {
    val op1 = arrayOf(-1, 1, 0, 0)
    val op2 = arrayOf(0, 0, 1, -1)

    val recentRipeTomato: Queue<Point> = LinkedList()

    while (ripeTomato.isNotEmpty()) {
        val point = ripeTomato.poll()

        for (i in 0..3) {
            val newX = point.x + op1[i]
            val newY = point.y + op2[i]

            if (newX in 0 until tomatoN && newY in 0 until tomatoM && tomatoGraph[newX][newY] == 0) {
                recentRipeTomato.offer(Point(newX, newY))
                tomatoGraph[newX][newY] = 1
            }
        }
    }

    return recentRipeTomato
}

class Point(val x: Int, val y: Int)