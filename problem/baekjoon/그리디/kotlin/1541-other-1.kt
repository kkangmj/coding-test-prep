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
    var minusFlag = false

    while (!operatorQueue.isEmpty() && !operandQueue.isEmpty()) {
        if (operatorQueue.poll() == '-') {
            minusFlag = true
        }

        if (minusFlag) {
            answer -= operandQueue.poll()
        } else {
            answer += operandQueue.poll()
        }
    }

    println(answer)
}