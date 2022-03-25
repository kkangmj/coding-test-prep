import java.io.BufferedReader
import java.io.InputStreamReader

class Solution1 {
    fun solution(new_id: String): String {
        val lowerCase = new_id.lowercase()
        val specialCharRemoved = removeCharacter(lowerCase)
        val dotRemoved = removeDot(specialCharRemoved)
        val resized = checkSize(dotRemoved)

        return resized
    }

    private fun removeCharacter(id: String): String {
        val regex = """[^a-z0-9_.-]""".toRegex()
        return id.replace(regex, "")
    }

    private fun removeDot(id: String): String {
        val regexForContinuedDots = """(\.){2,}""".toRegex()
        val replacedId = id.replace(regexForContinuedDots, ".")

        val regexForStartEndDots = """^(\.)|(\.)$""".toRegex()
        return replacedId.replace(regexForStartEndDots, "")
    }

    private fun checkSize(id: String): String {
        var replacedId = id
        if (id.isEmpty()) {
            replacedId = "a"
        }
        if (replacedId.length >= 16) {
            replacedId = replacedId.slice(0..14)
            while (replacedId.endsWith(".")) {
                replacedId = replacedId.dropLast(1)
            }
        }
        if (replacedId.length <= 2) {
            while (replacedId.length < 3) {
                replacedId += replacedId.last()
            }
        }
        return replacedId
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val solution = Solution1()
    println(solution.solution(br.readLine()))
}