import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var unionParent: IntArray

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val numberOfComputer = Integer.parseInt(br.readLine())
    val numberOfLine = Integer.parseInt(br.readLine())

    val pq = PriorityQueue<Line>()

    for (i in 1..numberOfLine) {
        val st = StringTokenizer(br.readLine())
        val start = Integer.parseInt(st.nextToken())
        val end = Integer.parseInt(st.nextToken())
        val cost = Integer.parseInt(st.nextToken())

        val line = Line(start, end, cost)
        pq.offer(line)
    }

    unionParent = IntArray(numberOfComputer + 1) { it }

    var numberOfVertexInMST = 0
    var minCost = 0

    // 크루스칼 알고리즘
    while (numberOfVertexInMST < numberOfComputer - 1) {
        val node = pq.poll()
        val x = node.start
        val y = node.end

        // 사이클 없는 것 확인
        if (findParent(x) != findParent(y)) {
            // union
            unionComputer(x, y)

            // 비용 합치기
            minCost += node.cost
            numberOfVertexInMST++
        }
    }

    println(minCost)
}

fun findParent(x: Int): Int {
    if (x == unionParent[x]) return x
    unionParent[x] = findParent(unionParent[x])
    return unionParent[x]
}

fun unionComputer(x: Int, y: Int) {
    val a = findParent(x)
    val b = findParent(y)

    if (a < b) unionParent[b] = a
    else unionParent[a] = b
}

class Line(val start: Int, val end: Int, val cost: Int) : Comparable<Line> {
    override fun compareTo(other: Line): Int {
        if (cost < other.cost) return -1
        return 1
    }
}