import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val numOfJewel = Integer.parseInt(st.nextToken())
    val numOfBag = Integer.parseInt(st.nextToken())

    val jewels = PriorityQueue { a: Jewel, b: Jewel -> a.weight - b.weight }
    for (i in 0 until numOfJewel) {
        st = StringTokenizer(br.readLine())
        jewels.add(Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
    }

    val infoOfBag = IntArray(numOfBag)
    for (i in 0 until numOfBag) {
        infoOfBag[i] = Integer.parseInt(br.readLine())
    }

    infoOfBag.sort()

    var answer = 0L

    val jewelsWeightSmallerThan = PriorityQueue { a: Jewel, b: Jewel ->
        if (a.price < b.price) {
            1
        } else if (a.price == b.price) {
            if (a.weight <= b.weight) {
                -1
            } else {
                1
            }
        } else {
            -1
        }
    }

    for (i in 0 until numOfBag) {
        val weightOfBag = infoOfBag[i]

        while (!jewels.isEmpty()) {
            val weightOfJewel = jewels.peek().weight
            if (weightOfJewel <= weightOfBag) {
                jewelsWeightSmallerThan.add(jewels.poll())
            } else {
                break
            }
        }

        if (!jewelsWeightSmallerThan.isEmpty()) {
            answer += jewelsWeightSmallerThan.poll().price
        }

    }

    println(answer)
}

class Jewel(val weight: Int, val price: Int)