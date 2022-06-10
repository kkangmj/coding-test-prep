/*
 * 우선순위 큐를 이용해 구현
 * 실행 시간: 92ms
 * 메모리: 12212KB
*/

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())

    val positiveNumQueue = PriorityQueue<Int>(Collections.reverseOrder())
    val negativeNumQueue = PriorityQueue<Int>()
    var oneNumCount = 0
    var zeroExist = false

    for (i in 0 until N) {
        val num = Integer.parseInt(br.readLine())
        if (num == 0) {
            zeroExist = true
        } else if (num == 1) {
            oneNumCount++
        } else if (num > 1) {
            positiveNumQueue.offer(num)
        } else {
            negativeNumQueue.offer(num)
        }
    }

    var result = if (oneNumCount > 0) oneNumCount else 0

    // positiveQueue
    while (!positiveNumQueue.isEmpty()) {
        val current = positiveNumQueue.poll()

        result += if (!positiveNumQueue.isEmpty()) {
            val next = positiveNumQueue.poll()
            current * next
        } else {
            current
        }
    }

    // negativeQueue
    while (!negativeNumQueue.isEmpty()) {
        val current = negativeNumQueue.poll()

        if (!negativeNumQueue.isEmpty()) {
            val next = negativeNumQueue.poll()
            result += current * next
        } else {
            if (!zeroExist) result += current
        }
    }

    println(result)
}