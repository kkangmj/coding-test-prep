import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val targetChannel = Integer.parseInt(br.readLine())

    if (targetChannel == 100) {
        println(0)
        return
    }

    when (val numberOfBrokenButton = Integer.parseInt(br.readLine())) {
        0 -> println(min(abs(100 - targetChannel), getDigitOf(targetChannel)))
        10 -> println(abs(100 - targetChannel))
        else -> {
            val st = StringTokenizer(br.readLine())
            var numberList = """^[0123456789]*$"""
            for (i in 1..numberOfBrokenButton) {
                numberList = numberList.replace("${Integer.parseInt(st.nextToken())}", "")
            }
            println(getNumberOfPressedWithSomeButton(targetChannel, numberList))
        }
    }
}

fun getNumberOfPressedWithSomeButton(targetChannel: Int, numberList: String): Int {

    val regex = numberList.toRegex()
    var min = abs(100 - targetChannel)

    var number = targetChannel

    while (number < 1000000) {
        if (number.toString().matches(regex)) {
            val buttonPressed = calculateNumberOfPressed(targetChannel, number)
            if (min > buttonPressed) min = buttonPressed
            break
        }
        number += 1
    }

    number = targetChannel

    while (number >= 0) {
        number -= 1
        if (number.toString().matches(regex)) {
            val buttonPressed = calculateNumberOfPressed(targetChannel, number)
            if (min > buttonPressed) min = buttonPressed
            break
        }
    }

    return min
}

fun calculateNumberOfPressed(targetChannel: Int, number: Int): Int {
    return getDigitOf(number) + abs(targetChannel - number)
}

fun getDigitOf(number: Int): Int {

    if (number == 0) {
        return 1
    }

    var digit = 0
    var target = number

    while (target != 0) {
        target /= 10
        digit += 1
    }

    return digit
}
