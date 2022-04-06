import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val earthYear = Integer.parseInt(st.nextToken())
    val sunYear = Integer.parseInt(st.nextToken())
    val moonYear = Integer.parseInt(st.nextToken())
    var year = 1

    while (true) {
        val earthYearCalculated = if (year % 15 == 0) 15 else year % 15
        val sunYearCalculated = if (year % 28 == 0) 28 else year % 28
        val moonYearCalculated = if (year % 19 == 0) 19 else year % 19

        if (earthYear == earthYearCalculated && sunYear == sunYearCalculated && moonYear == moonYearCalculated) {
            break
        }
        year += 1
    }

    println(year)
}