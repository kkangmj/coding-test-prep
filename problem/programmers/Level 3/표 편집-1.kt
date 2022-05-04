/*
* 정확성: 30.0
* 효율성: 42.0
* 점수: 72.0 / 100.0
*/

import java.util.*

class Solution1 {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val isDeleted = BooleanArray(n)
        val deletedRow = Stack<Int>()
        val sb = StringBuilder()

        var pointer = k

        for (c in cmd) {
            val st = StringTokenizer(c)
            when (st.nextToken()) {
                "U" -> {
                    var move = Integer.parseInt(st.nextToken())
                    while (move > 0) {
                        pointer -= 1
                        if (!isDeleted[pointer]) move -= 1
                    }
                }
                "D" -> {
                    var move = Integer.parseInt(st.nextToken())
                    while (move > 0) {
                        pointer += 1
                        if (!isDeleted[pointer]) move -= 1
                    }
                }
                "C" -> {
                    deletedRow.push(pointer)
                    isDeleted[pointer] = true

                    var nextRowExists = false

                    for (i in (pointer + 1) until n) {
                        if (!isDeleted[i]) {
                            nextRowExists = true
                            pointer = i
                            break
                        }
                    }

                    if (!nextRowExists) {
                        while (pointer > 0) {
                            pointer -= 1
                            if (!isDeleted[pointer]) {
                                break
                            }
                        }
                    }
                }
                else -> isDeleted[deletedRow.pop()] = false
            }
        }
        isDeleted.forEach { sb.append(if (it) "X" else "O") }
        return sb.toString()
    }

}

fun main() {
    val solution = Solution1()
    val array =
        arrayOf(
            "D 2",
            "C",
            "U 3",
            "C",
            "D 4",
            "C",
            "U 2",
            "Z",
            "Z",
            "U 1",
            "C",
            "Z",
            "U 1",
            "C"
        )
    println(solution.solution(8, 2, array))
}