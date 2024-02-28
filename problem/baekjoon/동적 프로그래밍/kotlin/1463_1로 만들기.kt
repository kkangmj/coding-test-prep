import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())

    val result = getMinimumOfCalculation(n)
    println(result)
}

fun getMinimumOfCalculation(n: Int): Int {

    if (n < 2) return 0

    val memoryTable = IntArray(n + 1)

    for (i in 2..n) {
        val candidate = ArrayList<Int>()

        candidate.add(memoryTable[i - 1] + 1)
        if (i % 3 == 0) candidate.add(memoryTable[i / 3] + 1)
        if (i % 2 == 0) candidate.add(memoryTable[i / 2] + 1)

        memoryTable[i] = candidate.minOrNull()!!

        when (i%3==0 && i%2==0) {

        }
    }

    return memoryTable[n]
}