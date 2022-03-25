import java.io.BufferedReader
import java.io.InputStreamReader

class Solution1 {
    fun solution(s: String): Int {
        var minLength = s.length
        for (i in 1..(s.length / 2 + 1)) {
            val lengthOfCompressed = compress(s, i)
            if (minLength > lengthOfCompressed) minLength = lengthOfCompressed
        }
        return minLength
    }

    private fun compress(s: String, n: Int): Int {
        val chunkedString = s.chunked(n)
        var lengthOfString = 0
        var index = 0

        while (index < chunkedString.size) {

            var pointer = index + 1
            val chunkForCompare = chunkedString[index]
            var numberOfRepeat = 1

            while (pointer < chunkedString.size) {
                if (chunkedString[pointer] == chunkForCompare) {
                    pointer += 1
                    numberOfRepeat += 1
                } else break
            }

            lengthOfString += if (numberOfRepeat == 1) {
                chunkForCompare.length
            } else {
                val number = when {
                    numberOfRepeat < 10 -> 1
                    numberOfRepeat < 100 -> 2
                    numberOfRepeat < 1000 -> 3
                    else -> 4
                }

                chunkForCompare.length + number
            }

            index = pointer
        }
        return lengthOfString
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val solution = Solution1()
    println(solution.solution(br.readLine()))
}