import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    for (i in 0..2) {
        val st = StringTokenizer(br.readLine())
        for (j in 0..2) {
            sb.append(st.nextToken())
        }
    }

    val map = HashMap<String, Int>()
    val pq = PriorityQueue<Board>()

    val boardString = sb.toString()
    pq.add(Board(0, boardString))
    map[boardString] = 0

    var answer = -1

    while (pq.isNotEmpty()) {
        val board = pq.poll()
        val boardInString = board.board
        val move = map[boardInString] ?: 0

        if (boardInString == "123456780") {
            answer = move
            break
        }

        val index = boardInString.indexOf("0")
        val currentZeroX = index / 3
        val currentZeroY = index % 3

        val op1 = intArrayOf(-1, 1, 0, 0)
        val op2 = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val newZeroX = currentZeroX + op1[i]
            val newZeroY = currentZeroY + op2[i]

            if (newZeroX !in 0..2 || newZeroY !in 0..2) {
                continue
            }

            val newPositionInString = newZeroX * 3 + newZeroY
            val temp = boardInString[newPositionInString]
            var newString = boardInString.replace(temp, '9')
            newString = newString.replace('0', temp)
            newString = newString.replace('9', '0')

            if (!map.containsKey(newString)) {
                map[newString] = move + 1
                pq.add(Board(move + 1, newString))
            }
        }
    }

    println(answer)
}

class Board(val count: Int, val board: String) : Comparable<Board> {
    override fun compareTo(other: Board): Int = count - other.count
}
