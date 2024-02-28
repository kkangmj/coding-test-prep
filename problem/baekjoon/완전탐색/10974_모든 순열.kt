import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())

    permutation2(0, n, IntArray(n) { it + 1 }, IntArray(n), BooleanArray(n))
}

fun permutation2(
    indexOfNewArray: Int,
    n: Int,
    array: IntArray,
    newArray: IntArray,
    visited: BooleanArray
) {
    if (indexOfNewArray == n) {
        val sb = StringBuilder()
        newArray.forEach { sb.append("$it ") }
        println(sb.toString())
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            newArray[indexOfNewArray] = array[i]
            permutation2(indexOfNewArray + 1, n, array, newArray, visited)
            visited[i] = false
        }
    }
}