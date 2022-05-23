import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val listOfMeeting = mutableListOf<Pair<Int, Int>>()

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        val startsAt = Integer.parseInt(st.nextToken())
        val endsAt = Integer.parseInt(st.nextToken())
        val meeting = Pair(startsAt, endsAt)

        listOfMeeting.add(meeting)
    }

    listOfMeeting.sortWith(compareBy({ it.second }, { it.first }))

    var maxNumOfMeeting = 0
    var timeOfMeeting = 0

    for ((startsAt, endsAt) in listOfMeeting) {
        if (timeOfMeeting <= startsAt) {
            maxNumOfMeeting++
            timeOfMeeting = endsAt
        }
    }

    println(maxNumOfMeeting)
}