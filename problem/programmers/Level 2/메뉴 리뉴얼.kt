/*
* 점수: 100.0 / 100.0
*/

class Solution7 {
    fun solution(orders: Array<String>, course: IntArray): List<String> {

        val answer = mutableListOf<String>()

        for (i in course) {
            getCombinationOfCourse(i, orders).forEach { answer.add(it) }
        }

        return answer.sorted()
    }

    private fun getCombinationOfCourse(
        numberOfMenu: Int,
        orders: Array<String>
    ): MutableList<String> {

        val mapOfCombination = mutableMapOf<String, Int>()
        val filteredOrders = orders.filter { it.length >= numberOfMenu }

        for (order in filteredOrders) {
            val sortedOrder = order.toMutableList().sorted()

            getCombinationOfMenu(
                0,
                numberOfMenu,
                sortedOrder.size,
                sortedOrder,
                BooleanArray(sortedOrder.size),
                mapOfCombination
            )
        }

        val maxNumberOfMenu = mapOfCombination.maxByOrNull { it.value }?.value

        return mapOfCombination.filter { it.value == maxNumberOfMenu && it.value > 1 }.keys.toMutableList()
    }

    private fun getCombinationOfMenu(
        start: Int,
        numberOfMenu: Int,
        totalMenu: Int,
        order: List<Char>,
        visited: BooleanArray,
        mapOfCombination: MutableMap<String, Int>
    ) {
        if (numberOfMenu == 0) {
            val sb = StringBuilder()
            for (i in 0 until totalMenu) {
                if (visited[i]) sb.append("${order[i]}")
            }
            val key = sb.toString()
            if (mapOfCombination.containsKey(key)) {
                mapOfCombination[key] = mapOfCombination[key]!!.plus(1)
            } else {
                mapOfCombination[key] = 1
            }
            return
        }

        for (i in start until totalMenu) {
            visited[i] = true
            getCombinationOfMenu(
                i + 1,
                numberOfMenu - 1,
                totalMenu,
                order,
                visited,
                mapOfCombination
            )
            visited[i] = false
        }
    }
}

fun main() {
    val solution = Solution7()
    val orders = arrayOf("XYZ", "XWY", "WXA")
    val course = intArrayOf(2, 3, 4)
    println(solution.solution(orders, course))
}