import java.util.*

fun main() {
    val s = "{{})){}[]"
    var count: Int = 0

    for (i in s.indices) {
        val case = s.substring(i) + s.substring(0, i)
        if (validateCase(case)) count += 1
    }

    println(count)
}

fun validateCase(s: String): Boolean {

    val stack = Stack<Char>()

    for (i in s.indices) {
        if (isStart(s[i])) {
            stack.push(s[i])
        } else {
            if (stack.isEmpty() || !checkIfPair(stack.pop(), s[i])) return false
        }
    }

    return stack.isEmpty()
}

fun isStart(c: Char): Boolean = when (c) {
    '(', '{', '[' -> true
    ')', '}', ']' -> false
    else -> false
}

fun checkIfPair(c1: Char, c2: Char): Boolean =
    when {
        (c1 == '(') && (c2 == ')') -> true
        (c1 == '[') && (c2 == ']') -> true
        (c1 == '{') && (c2 == '}') -> true
        else -> false
    }
