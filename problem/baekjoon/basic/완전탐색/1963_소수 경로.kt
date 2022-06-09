import java.io.*
import java.util.*

lateinit var primeArray: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val numOfTestCase = Integer.parseInt(br.readLine())
    primeArray = IntArray(10000)

    // 에라토스테네스의 체
    for (i in 2..9999) {
        if (primeArray[i] == 0) {
            for (j in 2..1000) {
                if (i * j <= 9999) primeArray[i * j] = 1
            }
        }
    }

    for (i in 1..numOfTestCase) {
        val st = StringTokenizer(br.readLine())
        val start = Integer.parseInt(st.nextToken())
        val end = Integer.parseInt(st.nextToken())

        val result = getMinCount(Prime(start, 0), end)

        if (result == -1) {
            bw.write("Impossible\n")
        } else {
            bw.write("$result\n")
        }
    }

    bw.flush()
}

fun getMinCount(startPrime: Prime, end: Int): Int {
    val queue: Queue<Prime> = LinkedList()
    val visited = BooleanArray(10000)

    queue.offer(startPrime)
    visited[startPrime.number] = true

    while (queue.isNotEmpty()) {
        val prime = queue.poll()

        if (prime.number == end) {
            return prime.count
        }

        val numOfPrime = arrayOf(
            prime.get1(),
            prime.get2(),
            prime.get3(),
            prime.get4(),
        )
        val countOfPrime = prime.count
        val numbers = arrayOf(1000, 100, 10, 1)

        for (i in 0..9) {  // 0 ~ 9까지 바꿔보기
            for (j in 0..3) {  // 각 자릿수 순서대로
                var nextNumOfPrime = 0

                if (i != numOfPrime[j]) {
                    for (k in 0..3) {  // nextNumOfPrime 생성하기
                        nextNumOfPrime += if (k == j) numbers[k] * i else numbers[k] * numOfPrime[k]
                    }

                    if (nextNumOfPrime >= 1000 && primeArray[nextNumOfPrime] == 0 && !visited[nextNumOfPrime]
                    ) {
                        queue.offer(Prime(nextNumOfPrime, countOfPrime + 1))
                        visited[nextNumOfPrime] = true
                    }
                }
            }
        }
    }
    return -1
}


class Prime(val number: Int, val count: Int) {
    fun get1(): Int {
        return number / 1000
    }

    fun get2(): Int {
        return (number % 1000) / 100
    }

    fun get3(): Int {
        return (number % 100) / 10
    }

    fun get4(): Int {
        return number % 10
    }
}

