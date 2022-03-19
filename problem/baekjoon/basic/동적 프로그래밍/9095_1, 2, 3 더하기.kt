import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val array = IntArray(11)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfTestCase = Integer.parseInt(br.readLine())

    array[1] = 1
    array[2] = 2
    array[3] = 4

    for (i in 1..numberOfTestCase) {
        val case = Integer.parseInt(br.readLine())
        bw.write("${getNumberOfCases(case)}\n")
    }
    bw.flush()
}

fun getNumberOfCases(case: Int): Int {
    if (case < 4) return array[case]
    array[case] =
        getNumberOfCases(case - 1) + getNumberOfCases(case - 2) + getNumberOfCases(case - 3)
    return array[case]
}