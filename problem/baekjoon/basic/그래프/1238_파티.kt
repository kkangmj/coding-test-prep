/*
 * 다익스트라 알고리즘
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import java.util.*
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val numberOfTown = Integer.parseInt(st.nextToken())
    val numberOfEdge = Integer.parseInt(st.nextToken())
    val partyHeldIn = Integer.parseInt(st.nextToken())

    // 그래프 생성
    val graph = Array(numberOfTown + 1) { IntArray(numberOfTown + 1) }

    for (i in 1..numberOfEdge) {
        val st = StringTokenizer(br.readLine())
        val start = Integer.parseInt(st.nextToken())
        val end = Integer.parseInt(st.nextToken())
        graph[start][end] = Integer.parseInt(st.nextToken())
    }

    // Town -> Town 가는 최단거리 저장하는 배열 생성
    val distanceBtwTown =
        Array(numberOfTown + 1) { IntArray(numberOfTown + 1) { Integer.MAX_VALUE } }

    // 각 정점에서 모든 정점으로 가는 최단거리 구하기
    for (i in 1..numberOfTown) {
        dijkstra1(i, numberOfTown, graph, distanceBtwTown[i])
    }

    var maxDistance = 0
    for (i in 1..numberOfTown) {
        if (i == partyHeldIn) continue
        maxDistance =
            max(maxDistance, distanceBtwTown[i][partyHeldIn] + distanceBtwTown[partyHeldIn][i])
    }

    println(maxDistance)
}

fun dijkstra1(v: Int, n: Int, graph: Array<IntArray>, distance: IntArray) {
    val visited = BooleanArray(n + 1)

    distance[v] = 0
    visited[v] = true

    // 최단거리 업데이트
    for (i in 1..n) {
        if (!visited[i] && graph[v][i] != 0) {
            distance[i] = graph[v][i]
        }
    }

    // 모든 정점에 대해 반복
    for (i in 1 until n) {
        // distance 중 최단거리 찾기
        var minDistance = Integer.MAX_VALUE
        var minDistanceTown = -1

        for (j in 1..n) {
            if (!visited[j] && minDistance > distance[j]) {
                minDistance = distance[j]
                minDistanceTown = j
            }
        }

        visited[minDistanceTown] = true

        // 최단거리 업데이트하기
        for (j in 1..n) {
            // 연결되어 있는지 확인
            if (!visited[j] && graph[minDistanceTown][j] != 0) {
                distance[j] =
                    min(distance[j], distance[minDistanceTown] + graph[minDistanceTown][j])
            }
        }
    }
}
