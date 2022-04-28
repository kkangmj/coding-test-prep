/*
* 완전 탐색 (조합)
 */

// 백트래킹
fun backTracking(start: Int, r: Int, n: Int, array: IntArray, visited: BooleanArray) {
    if (r == 0) {
        printCombination(array, visited)
        return
    }

    for (i in start until n) {
        visited[i] = true
        backTracking(i + 1, r - 1, n, array, visited)
        visited[i] = false
    }
}

// 재귀
fun recursive(depth: Int, r: Int, n: Int, array: IntArray, visited: BooleanArray) {
    if (r == 0) {
        printCombination(array, visited)
        return
    }
    if (depth == n) return

    visited[depth] = true
    recursive(depth + 1, r - 1, n, array, visited)
    visited[depth] = false
    recursive(depth + 1, r, n, array, visited)
}

fun printCombination(array: IntArray, visited: BooleanArray) {
    val sb = StringBuilder()
    for (i in array.indices) {
        if (visited[i]) sb.append("${array[i]} ")
    }
    println(sb.toString())
}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val r = 3
    val n = array.size

    println("== Backtracking ==")
    backTracking(0, r, n, array, BooleanArray(n))

    println("== Recursive ==")
    recursive(0, r, n, array, BooleanArray(n))
}