/**
 * 실행 시간: 2844ms
 * 메모리: 304364KB
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = Integer.parseInt(br.readLine())
    val map = HashMap<Int, Int>()

    for (i in 0 until N) {
        val key = Integer.parseInt(br.readLine())
        map[key] = map.getOrDefault(key, 0) + 1
    }

    val sortedmap = map.toSortedMap()
    for ((key, value) in sortedmap) {
        repeat(value) {
            bw.write("$key\n")
        }
    }

    bw.flush()
}