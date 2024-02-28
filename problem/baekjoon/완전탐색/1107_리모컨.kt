import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val channel = Integer.parseInt(br.readLine())

    when (val numberOfBroken = Integer.parseInt(br.readLine())) {
        0 -> println(getNumberOfPressedWithAllButton(channel))
        10 -> println(abs(100 - channel))
        else -> {
            val st = StringTokenizer(br.readLine())
            var numberList = """^[0123456789]*$"""
            for (i in 1..numberOfBroken) {
                numberList = numberList.replace("${Integer.parseInt(st.nextToken())}", "")
            }
            println(getNumberOfPressedWithSomeButton(channel, numberList))
        }
    }
}

fun getNumberOfPressedWithAllButton(channel: Int): Int {
    return min(getDigitOf(channel), abs(100 - channel))
}

fun getNumberOfPressedWithSomeButton2(channel: Int, numberList: String): Int {
    val regex = numberList.toRegex()
    var min = 1000000

    if (channel == 100) return 0

    for (i in 0 until 1000000) {
        if (i.toString().matches(regex)) {
            val buttonPressed = getNumberOfPressedWithNumberKey(channel, i)
            if (min > buttonPressed) min = buttonPressed
        }
    }

    return min(min, abs(100 - channel))
}

fun getNumberOfPressedWithNumberKey(channel: Int, target: Int): Int {
    var count = 0

    count += getDigitOf(target)
    count += abs(channel - target)

    return count
}

fun getDigitOf1(number: Int): Int {
    var digit = 0
    var target = number

    if (target == 0) {
        digit += 1
    }

    while (target != 0) {
        target /= 10
        digit += 1
    }

    return digit
}