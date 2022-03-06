import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = StringTokenizer(br.readLine())
    val month = Integer.parseInt(input.nextToken())
    val day = Integer.parseInt(input.nextToken())

    var daysUntil: Int = day

    for (i in 1 until month) {
        daysUntil += getDayOfMonth(i)
    }

    val dayOfWeek = getDayOfWeek(daysUntil)
    bw.write(dayOfWeek)
    bw.flush()

    br.close()
    bw.close()
}

fun getDayOfMonth(month: Int): Int = when (month) {
    1, 3, 5, 7, 8, 10, 12 -> 31
    4, 6, 9, 11 -> 30
    2 -> 28
    else -> -1
}

fun getDayOfWeek(daysUntil: Int): String = when ((daysUntil - 1) % 7) {
    0 -> "MON"
    1 -> "TUE"
    2 -> "WED"
    3 -> "THU"
    4 -> "FRI"
    5 -> "SAT"
    6 -> "SUN"
    else -> "No matched day of week:("
}