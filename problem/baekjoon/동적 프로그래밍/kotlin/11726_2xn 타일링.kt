import java.io.BufferedReader
import java.io.InputStreamReader

val memoryArray: IntArray = IntArray(1001)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val number = Integer.parseInt(br.readLine())

    initialize()
    println(getNumberOfCombination(number))

}

fun initialize() {
    memoryArray[1] = 1
    memoryArray[2] = 2
}

fun getNumberOfCombination(number: Int): Int {

    if (memoryArray[number] > 0) return memoryArray[number]

    memoryArray[number] =
        (getNumberOfCombination(number - 1) + getNumberOfCombination(number - 2)) % 10007

    return memoryArray[number]
}

