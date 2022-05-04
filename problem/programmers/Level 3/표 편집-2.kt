/*
* 정확성: 30.0
* 효율성: 0.0
* 점수: 30.0 / 100.0
*/

import java.util.*

class Solution2 {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val deletedRow = Stack<Int>()
        val existingRow: LinkedList<Int> = LinkedList()

        for (i in 0 until n) {
            existingRow.add(i)
        }

        var pointer = k

        for (c in cmd) {
            val st = StringTokenizer(c)
            when (st.nextToken()) {
                "U" -> {
                    val move = Integer.parseInt(st.nextToken())
                    val index = existingRow.indexOf(pointer)
                    pointer = existingRow[index - move]
                }
                "D" -> {
                    val move = Integer.parseInt(st.nextToken())
                    val index = existingRow.indexOf(pointer)
                    pointer = existingRow[index + move]
                }
                "C" -> {
                    deletedRow.push(pointer)

                    val index = existingRow.indexOf(pointer)
                    pointer =
                        if (existingRow.last == pointer) existingRow[index - 1] else existingRow[index + 1]

                    existingRow.removeAt(index)
                }
                else -> {
                    val element = deletedRow.pop()

                    var elementAdded = false

                    // TODO 이 부분을 개선해 보자!
                    // 나랑 가까운 수 하나씩 찾아보는 걸로?
                    for (i in existingRow.indices) {
                        if (element < existingRow[i]) {
                            existingRow.add(i, element)
                            elementAdded = true
                            break
                        }
                    }
                    if (!elementAdded) {
                        existingRow.addLast(element)
                    }
                }
            }
        }

        // TODO 이 부분도 함께 개선해보자!
        val s = "X".repeat(n).toCharArray()

        for (i in existingRow) {
            s[i] = 'O'
        }
        return String(s)
    }
}

fun main() {
    val solution = Solution2()
    val array =
        arrayOf(
            "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
        )
    println(solution.solution(8, 2, array))
}