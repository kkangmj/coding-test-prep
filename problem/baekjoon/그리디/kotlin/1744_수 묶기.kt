/*
 * 실행 시간: 120ms
 * 메모리: 14104KB
*/

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())

    val positiveNumArray = mutableListOf<Int>()
    val negativeNumArray = mutableListOf<Int>()
    var oneNumCount = 0
    var zeroExist = false

    for (i in 0 until N) {
        val num = Integer.parseInt(br.readLine())
        if (num == 0) {
            zeroExist = true
        } else if (num == 1) {
            oneNumCount++
        } else if (num > 1) {
            positiveNumArray.add(num)
        } else {
            negativeNumArray.add(num)
        }
    }

    positiveNumArray.sortDescending()
    negativeNumArray.sort()

    var result = if (oneNumCount > 0) oneNumCount else 0
    var index = 0

    for (i in 1..(positiveNumArray.size / 2)) {
        result += positiveNumArray[index] * positiveNumArray[index + 1]
        index += 2
    }

    if (index == positiveNumArray.size - 1) {
        result += positiveNumArray[index]
    }

    index = 0

    for (i in 1..(negativeNumArray.size / 2)) {
        result += negativeNumArray[index] * negativeNumArray[index + 1]
        index += 2
    }

    if (index == negativeNumArray.size - 1 && !zeroExist) {
        result += negativeNumArray[index]
    }

    println(result)
}