class Solution3 {
    fun solution(s: String): Int {

        val map = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )

        var answer = s
        for (i in map) {
            answer = answer.replace(i.key, i.value.toString())
        }

        return answer.toInt()
    }
}

fun main() {
    val solution = Solution3()
    println(solution.solution("1zerotwozero3"))
}