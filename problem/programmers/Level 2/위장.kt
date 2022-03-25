class Solution2 {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = mutableMapOf<String, Int>()
        for (i in clothes) {
            if (map.containsKey(i[1])) {
                map.replace(i[1], map[i[1]]?.plus(1) ?: -100)
            } else {
                map[i[1]] = 1
            }
        }
        return getCombination(map)
    }

    private fun getCombination(map: Map<String, Int>): Int {

        if (map.size < 2) {
            return map.values.toIntArray()[0]
        } else {
            var combination = 1
            for (i in map) {
                combination *= (i.value + 1)
            }
            return combination - 1
        }
    }
}

fun main() {
    val solution = Solution2()
    val clothes = arrayOf(
        arrayOf("동그란 안경", "얼굴"),
        arrayOf("검정 선글라스", "얼굴"),
        arrayOf("파란색 티셔츠", "상의"),
        arrayOf("노란색 셔츠", "상의"),
        arrayOf("긴 코트", "겉옷"),
        arrayOf("청바지", "하의")
    )
    println(solution.solution(clothes))
}