/*
* 실행 시간: 2264ms
* 메모리: 76992KB
*  */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numberOfMember = Integer.parseInt(br.readLine())

    val ageOfMember = mutableSetOf<Int>()
    val nameOfMember = mutableMapOf<Int, MutableList<String>>()

    for (i in 1..numberOfMember) {
        val st = StringTokenizer(br.readLine())
        val age = Integer.parseInt(st.nextToken())
        val name = st.nextToken()

        ageOfMember.add(age)

        if (nameOfMember.containsKey(age)) nameOfMember[age]?.add(name)
        else nameOfMember[age] = mutableListOf(name)
    }

    ageOfMember.sorted().forEach { age -> nameOfMember[age]?.forEach { println("$age $it") } }
}
