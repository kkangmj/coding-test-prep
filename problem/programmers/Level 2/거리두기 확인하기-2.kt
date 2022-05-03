/*
* 점수: 100.0 / 100.0
*/

import java.util.*

class Solution6 {
    fun solution(places: Array<Array<String>>): IntArray {
        val answer: IntArray = intArrayOf(0, 0, 0, 0, 0)

        for (i in places.indices) {
            val location = arrayToTable(places[i])
            if (isSafeSpace(location)) answer[i] = 1
        }

        return answer
    }

    private fun arrayToTable(place: Array<String>): MutableList<MutableList<Char>> {

        val table = mutableListOf<MutableList<Char>>()

        for (i in 0 until 5) {
            val list = mutableListOf<Char>()
            for (j in 0 until 5) {
                list.add(place[i][j])
            }
            table.add(list)
        }

        return table
    }

    private fun isSafeSpace(location: MutableList<MutableList<Char>>): Boolean {

        val startPoint = mutableListOf<MutableList<Int>>()

        for (i in 0..4) {
            for (j in 0..4) {
                if (location[i][j] == 'P') startPoint.add(mutableListOf(i, j))
            }
        }

        for (person in startPoint) {
            if (!bfs(person, location)) return false
        }

        return true
    }

    private fun bfs(
        person: MutableList<Int>,
        location: MutableList<MutableList<Char>>
    ): Boolean {

        val queue: Queue<MutableList<Int>> = LinkedList()
        val visited = Array(5) { BooleanArray(5) }
        val distance = Array(5) { IntArray(5) }
        visited[person[0]][person[1]] = true
        queue.add(person)

        while (queue.isNotEmpty()) {
            val point = queue.poll()

            val x = point[0]
            val y = point[1]

            val variableForX = arrayOf(-1, 1, 0, 0)
            val variableForY = arrayOf(0, 0, -1, 1)

            for (i in 0..3) {
                val nx = x + variableForX[i]
                val ny = y + variableForY[i]

                if (nx in 0..4 && ny in 0..4 && !visited[nx][ny]) {

                    if (location[nx][ny] == 'O') {
                        visited[nx][ny] = true
                        distance[nx][ny] = distance[x][y] + 1
                        queue.add(mutableListOf(nx, ny))
                    }

                    if (location[nx][ny] == 'P' && distance[x][y] <= 1) {
                        return false
                    }
                }

            }
        }
        return true
    }

}

fun main() {
    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )
    val solution = Solution6()

    println(solution.solution(places).contentToString())
}