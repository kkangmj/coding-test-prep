import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())

    val result = getMinimumOfCalculation2(n)
    println(result)
}

fun getMinimumOfCalculation2(n: Int): Int {

    val memoryTable = IntArray(n + 1)

    for (i in 2..n) {
        memoryTable[i] = memoryTable[i - 1] + 1
        if (i % 3 == 0) memoryTable[i] = min(memoryTable[i], memoryTable[i / 3] + 1)
        if (i % 2 == 0) memoryTable[i] = min(memoryTable[i], memoryTable[i / 2] + 1)
    }

    return memoryTable[n]
}