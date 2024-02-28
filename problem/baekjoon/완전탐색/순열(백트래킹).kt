/*
* 완전 탐색 (순열)
 */

// 백트래킹
fun permutation(
    indexOfNewArray: Int,
    n: Int,
    array: IntArray,
    newArray: IntArray,
    visited: BooleanArray
) {
    if (indexOfNewArray == n) {
        val sb = StringBuilder()
        for (i in newArray) {
            sb.append("$i ")
        }
        println(sb.toString())
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            newArray[indexOfNewArray] = array[i]
            permutation(indexOfNewArray + 1, n, array, newArray, visited)
            visited[i] = false
        }
    }
}


fun main() {
    val array = intArrayOf(1, 2, 3)
    val n = array.size

    permutation(0, n, array, IntArray(n), BooleanArray(n))
}