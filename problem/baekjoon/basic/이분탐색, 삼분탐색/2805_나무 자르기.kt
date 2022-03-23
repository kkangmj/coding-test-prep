import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var trees: ArrayList<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val numberOfTree = Integer.parseInt(st.nextToken())
    val totalLengthOfTree = Integer.parseInt(st.nextToken())
    trees = ArrayList<Int>(numberOfTree)

    st = StringTokenizer(br.readLine())
    for (i in 1..numberOfTree) {
        trees.add(Integer.parseInt(st.nextToken()))
    }

    println(getMaxLengthOfTree(totalLengthOfTree))

}

fun getMaxLengthOfTree(totalLengthOfTree: Int): Int {
    var pl = 1
    var pr = trees.maxOrNull()?.plus(1) ?: return -1

    while (pl < pr) {
        val pc = (pl + pr) / 2
        if (getTotalLengthOfTreeBy(pc) >= totalLengthOfTree) pl = pc + 1
        else pr = pc
    }
    return pl - 1
}

fun getTotalLengthOfTreeBy(height: Int): Long {
    var totalLength: Long = 0
    for (i in trees) {
        totalLength += if (i < height) 0 else i - height
    }
    return totalLength
}
