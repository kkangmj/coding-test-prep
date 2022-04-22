/*
* 실행 시간: 552ms
* 메모리: 59120KB
*  */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfMember = Integer.parseInt(br.readLine())

    val members = mutableMapOf<Int, MutableList<String>>()

    for (i in 1..numberOfMember) {
        val st = StringTokenizer(br.readLine())
        val age = Integer.parseInt(st.nextToken())
        val name = st.nextToken()
        val listOfName = members.getOrDefault(age, mutableListOf())
        listOfName.add(name)
        members[age] = listOfName
    }

    members.toSortedMap().forEach { map ->
        val age = map.key
        map.value.forEach { bw.write("$age $it\n") }
    }

    bw.flush()
}