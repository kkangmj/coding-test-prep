import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val numberOfHouse = Integer.parseInt(st.nextToken())
    val numberOfRouter = Integer.parseInt(st.nextToken())
    val houseLocation = IntArray(numberOfHouse)

    for (i in 0 until numberOfHouse) {
        houseLocation[i] = Integer.parseInt(br.readLine())
    }

    houseLocation.sort()

    println(installRouter(houseLocation, numberOfHouse, numberOfRouter) - 1)
}

fun installRouter(houseLocation: IntArray, numberOfHouse: Int, numberOfRouter: Int): Int {
    var pl = 1
    var pr = houseLocation[numberOfHouse - 1] - houseLocation[0] + 1

    while (pl < pr) {
        var pc = (pl + pr) / 2
        if (getNumberOfRouter(pc, houseLocation) >= numberOfRouter) {
            pl = pc + 1
        } else pr = pc
    }

    return pl
}

fun getNumberOfRouter(pc: Int, houseLocation: IntArray): Int {
    var count = 1
    var baseLocation = 0

    for (i in 1 until houseLocation.size) {
        if (houseLocation[i] - houseLocation[baseLocation] >= pc) {
            baseLocation = i
            count += 1
        }
    }

    return count
}
