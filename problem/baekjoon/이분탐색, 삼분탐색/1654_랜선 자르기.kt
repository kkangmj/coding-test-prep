import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var line: IntArray

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val k = Integer.parseInt(st.nextToken())
    val n = Integer.parseInt(st.nextToken())
    line = IntArray(k)
    for (i in 0 until k) {
        line[i] = Integer.parseInt(br.readLine())
    }

    println(getMaxLengthOfLine(n))
}

fun getMaxLengthOfLine(n: Int): Long {
    var pl: Long = 1
    var pr: Long = (line.maxOrNull()?.toLong()?.plus(1)) ?: return -1

    while (pl < pr) {
        val pc = (pl + pr) / 2
        if (getNumberOfLineBy(pc.toInt()) >= n) pl = pc + 1
        else pr = pc
    }
    return pl - 1
}

fun getNumberOfLineBy(pc: Int): Int {
    var count = 0
    for (i in line) {
        count += i / pc
    }
    return count
}