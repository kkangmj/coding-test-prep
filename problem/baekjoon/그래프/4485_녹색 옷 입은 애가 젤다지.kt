import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var round = 1

    while (true) {
        val N = Integer.parseInt(br.readLine())

        if (N == 0) break

        val graph = Array(N) {
            val st = StringTokenizer(br.readLine())
            IntArray(N) { Integer.parseInt(st.nextToken()) }
        }
        val rupeeGraph = Array(N) { IntArray(N) { 10000000 } }

        val pq = PriorityQueue<Position>()
        val op1 = arrayOf(1, -1, 0, 0)
        val op2 = arrayOf(0, 0, 1, -1)

        pq.add(Position(0, 0, graph[0][0]))
        rupeeGraph[0][0] = graph[0][0]

        while (!pq.isEmpty()) {
            val position = pq.poll()
            val (x, y, rupee) = arrayOf(position.x, position.y, position.rupee)

            if (rupeeGraph[x][y] < rupee) continue

            for (i in 0..3) {
                val newX = x + op1[i]
                val newY = y + op2[i]

                if (newX !in 0 until N || newY !in 0 until N) continue

                val currentRupee = rupeeGraph[x][y] + graph[newX][newY]
                if (currentRupee < rupeeGraph[newX][newY]) {
                    rupeeGraph[newX][newY] = currentRupee
                    pq.add(Position(newX, newY, currentRupee))
                }
            }
        }

        bw.write("Problem $round: ${rupeeGraph[N - 1][N - 1]}\n")

        round++
    }

    bw.flush()
}

class Position(val x: Int, val y: Int, val rupee: Int) : Comparable<Position> {
    override fun compareTo(other: Position): Int {
        return rupee - other.rupee
    }
}