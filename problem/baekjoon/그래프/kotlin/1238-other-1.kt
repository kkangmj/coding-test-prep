/*
 * 개선된 다익스트라 알고리즘
 */


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max


val INF = 1000001

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val numberOfTown = Integer.parseInt(st.nextToken())
    val numberOfEdge = Integer.parseInt(st.nextToken())
    val partyHeldIn = Integer.parseInt(st.nextToken())

    val graph = Array(numberOfTown + 1) { IntArray(numberOfTown + 1) }

    for (i in 1..numberOfEdge) {
        val st = StringTokenizer(br.readLine())
        val start = Integer.parseInt(st.nextToken())
        val end = Integer.parseInt(st.nextToken())
        graph[start][end] = Integer.parseInt(st.nextToken())
    }

    val distanceBtwTown =
        Array(numberOfTown + 1) { IntArray(numberOfTown + 1) { INF } }

    // 각 정점에서 모든 정점으로 가는 최단거리 구하기
    for (i in 1..numberOfTown) {
        dijkstra2(i, numberOfTown, partyHeldIn, graph, distanceBtwTown[i])
    }

    var maxDistance = 0
    for (i in 1..numberOfTown) {
        if (i == partyHeldIn) continue
        maxDistance =
            max(maxDistance, distanceBtwTown[i][partyHeldIn] + distanceBtwTown[partyHeldIn][i])
    }

    println(maxDistance)
}

fun dijkstra2(v: Int, n: Int, partyHeldIn: Int, graph: Array<IntArray>, distance: IntArray) {
    val pq = PriorityQueue<Node>()

    pq.offer(Node(v, 0))
    distance[v] = 0

    while (!pq.isEmpty()) {
        val node = pq.poll()
        val dist = node.distance
        val index = node.index

        if (distance[index] < dist) continue

        for (i in 1..n) {
            // 연결되어 있을 때
            val const = distance[index] + graph[index][i]
            if (graph[index][i] != 0 && const < distance[i]) {
                distance[i] = const
                pq.offer(Node(i, distance[i]))
            }
        }

        if (v != partyHeldIn && index == partyHeldIn) break
    }
}

class Node(val index: Int, val distance: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        if (distance < other.distance) return -1
        return 1
    }
}