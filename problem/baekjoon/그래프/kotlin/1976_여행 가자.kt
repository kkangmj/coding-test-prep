import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var parentCity: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val numOfCity = Integer.parseInt(br.readLine())
    val numOfCityInTravelPlan = Integer.parseInt(br.readLine())

    val connection = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until numOfCity) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until numOfCity) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                connection.add(Pair(i, j))
            }
        }
    }

    val placeToVisit = mutableSetOf<Int>()
    val st = StringTokenizer(br.readLine())
    for (i in 0 until numOfCityInTravelPlan) {
        placeToVisit.add(Integer.parseInt(st.nextToken()) - 1)
    }

    parentCity = IntArray(numOfCity) { i -> i }

    for ((aCity, bCity) in connection) {
        unionCity(aCity, bCity)
    }

    var answer = true
    val parentOfFirstVisitCity = parentCity[placeToVisit.first()]
    placeToVisit.forEach {
        if (parentCity[it] != parentOfFirstVisitCity) {
            answer = false
            return@forEach
        }
    }

    if (answer) {
        println("YES")
    } else {
        println("NO")
    }
}

fun unionCity(aCity: Int, bCity: Int) {
    val parentA = findParentOfCity(aCity)
    val parentB = findParentOfCity(bCity)

    if (parentA < parentB) {
        parentCity[parentB] = parentA
    } else {
        parentCity[parentA] = parentB
    }
}

fun findParentOfCity(city: Int): Int {
    if (city == parentCity[city]) return parentCity[city]
    parentCity[city] = findParentOfCity(parentCity[city])
    return parentCity[city]
}