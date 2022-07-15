import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())

    val array = mutableListOf<Pair<Int, Int>>()

    for (i in 1..N) {
        val st = StringTokenizer(br.readLine())
        array.add(Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
    }

    val sortedArray =
        array.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

    var maxRamen = 0L

    val pq = PriorityQueue<Int>()

    for (i in 0 until N) {
        val pqSize = pq.size
        val (deadLine, numOfRamen) = sortedArray[i]
        if (pqSize < deadLine) {
            pq.add(numOfRamen)
        } else if (pqSize == deadLine) {
            if (pq.peek() < numOfRamen) {
                pq.poll()
                pq.add(numOfRamen)
            }
        }
    }

    while (pq.isNotEmpty()) {
        maxRamen += pq.poll()
    }

    println(maxRamen)
}