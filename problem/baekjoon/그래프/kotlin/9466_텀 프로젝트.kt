/*
 * REF) https://loosie.tistory.com/235
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var numOfStudentNotInTeam: Int = 0

lateinit var graph5: IntArray
lateinit var visited5: BooleanArray
lateinit var cycleChecked: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numOfTestCase = Integer.parseInt(br.readLine())

    for (i in 1..numOfTestCase) {
        val numOfStudent = Integer.parseInt(br.readLine())
        val st = StringTokenizer(br.readLine())

        graph5 = IntArray(numOfStudent + 1)
        visited5 = BooleanArray(numOfStudent + 1)
        cycleChecked = BooleanArray(numOfStudent + 1)
        numOfStudentNotInTeam = 0

        for (j in 1..numOfStudent) {
            graph5[j] = Integer.parseInt(st.nextToken())
        }

        for (j in 1..numOfStudent) {
            if (!visited5[j] || graph5[j] != j) {
                dfs5(j)
            }
        }

        println(numOfStudent - numOfStudentNotInTeam)
    }
}

fun dfs5(v: Int) {
    visited5[v] = true
    var next = graph5[v]

    if (!visited5[next]) {
        dfs5(next)
    } else {
        if (!cycleChecked[next]) {
            numOfStudentNotInTeam++
            while (next != v) {
                numOfStudentNotInTeam++
                next = graph5[next]
            }
        }
    }

    cycleChecked[v] = true
}

