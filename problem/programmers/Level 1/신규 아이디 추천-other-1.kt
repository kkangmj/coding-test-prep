/**
 * 첫 번째 코드로 통과한 뒤 참고할 만한 코드가 있어 작성한 other-1 솔루션
 * 그러나 프로그래머스에서 채점해보면 테스트 케이스 중 몇 개가 메모리 초과 뜸.
 * 통과한 다른 사람의 코드를 그대로 복붙해서도 돌려봤는데 여전히 메모리 초과.
 **/

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution2 {
    fun solution(new_id: String): String = new_id.lowercase()
        .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
        .replace("[.]{2,}".toRegex(), ".")
        .removePrefix(".").removeSuffix(".")
        .let { if (it.isEmpty()) "a" else it }
        .let { if (it.length > 15) it.substring(0 until 15) else it }.removeSuffix(".")
        .let {
            if (it.length <= 2) StringBuilder(it).run {
                while (it.length < 3) append(it.last())
                toString()
            } else it
        }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val solution = Solution2()
    println(solution.solution(br.readLine()))
}