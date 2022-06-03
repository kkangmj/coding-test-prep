import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine()
    val st = StringTokenizer(line, "+-")

    var index = 0
    val operatorQueue: Queue<Char> = LinkedList()
    val operandQueue: Queue<Int> = LinkedList()

    while (st.hasMoreTokens()) {
        val operand = st.nextToken()
        operandQueue.add(Integer.parseInt(operand))
        index += operand.length
        if (index < line.length) {
            operatorQueue.add(line[index])
            index++
        }
    }

    var answer = operandQueue.poll()

    while (!operatorQueue.isEmpty() && !operandQueue.isEmpty()) {
        val operator = operatorQueue.poll()
        var operand = operandQueue.poll()

        while (!operatorQueue.isEmpty() && !operandQueue.isEmpty()) {
            val nextOperator = operatorQueue.peek()
            if (nextOperator == '+') {
                operand += operandQueue.poll()
                operatorQueue.poll()
            } else
                break
        }

        if (operator == '+') {
            answer += operand
        } else {
            answer -= operand
        }
    }

    println(answer)
}