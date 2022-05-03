/*
* 점수: 100.0 / 100.0
*/

class Solution5 {
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
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (location[i][j] == 'P' && !isKeepingDistance(i, j, location)) return false
            }
        }

        return true
    }

    private fun isKeepingDistance(
        x: Int,
        y: Int,
        location: MutableList<MutableList<Char>>
    ): Boolean {

        if (isPerson(x - 1, y, location) || isPerson(x, y - 1, location) ||
            isPerson(x + 1, y, location) || isPerson(x, y + 1, location)
        ) return false


        if (isPerson(x - 2, y, location) && isNotPartition(x - 1, y, location)) return false
        if (isPerson(x, y - 2, location) && isNotPartition(x, y - 1, location)) return false
        if (isPerson(x + 2, y, location) && isNotPartition(x + 1, y, location)) return false
        if (isPerson(x, y + 2, location) && isNotPartition(x, y + 1, location)) return false

        if (isPerson(x - 1, y - 1, location) &&
            (isNotPartition(x - 1, y, location) || isNotPartition(x, y - 1, location))
        ) return false
        if (isPerson(x - 1, y + 1, location) &&
            (isNotPartition(x - 1, y, location) || isNotPartition(x, y + 1, location))
        ) return false
        if (isPerson(x + 1, y - 1, location) &&
            (isNotPartition(x + 1, y, location) || isNotPartition(x, y - 1, location))
        ) return false
        if (isPerson(x + 1, y + 1, location) &&
            (isNotPartition(x, y + 1, location) || isNotPartition(x + 1, y, location))
        ) return false

        return true
    }

    private fun isPerson(x: Int, y: Int, location: MutableList<MutableList<Char>>): Boolean {
        if (x !in 0..4 || y !in 0..4) return false

        return when (location[x][y]) {
            'P' -> true
            else -> false
        }
    }

    private fun isNotPartition(x: Int, y: Int, location: MutableList<MutableList<Char>>): Boolean =
        when (location[x][y]) {
            'X' -> false
            else -> true
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
    val solution = Solution5()

    println(solution.solution(places).contentToString())
}