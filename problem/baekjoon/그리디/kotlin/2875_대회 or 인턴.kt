import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val women = Integer.parseInt(st.nextToken())
    val men = Integer.parseInt(st.nextToken())
    val headCountForIntern = Integer.parseInt(st.nextToken())

    println(getMaxOfTeam(women, men, headCountForIntern))
}

fun getMaxOfTeam(women: Int, men: Int, headCountForIntern: Int): Int {

    var w = women
    var m = men

    var numberOfTeam = 0

    while (w >= 2 && m >= 1) {
        if ((w - 2) + (m - 1) < headCountForIntern) break
        w -= 2
        m -= 1
        numberOfTeam += 1
    }

    return numberOfTeam
}