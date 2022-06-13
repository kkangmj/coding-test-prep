/**
 * 실행 시간: 1552ms
 * 메모리: 299548KB
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = Integer.parseInt(br.readLine())
    val array = IntArray(10001)

    for (i in 1..N) {
        val index = Integer.parseInt(br.readLine())
        array[index] += 1
    }

    array.forEachIndexed { index, i ->
        bw.write("$index\n".repeat(i))
    }

    bw.flush()
}