/*
* 병합 정렬 알고리즘
* 실행 시간: 1892ms
* 메모리: 83896KB
*  */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numberOfMember = Integer.parseInt(br.readLine())

    val members = mutableListOf<Member>()

    for (i in 1..numberOfMember) {
        val st = StringTokenizer(br.readLine())
        val member = Member(Integer.parseInt(st.nextToken()), st.nextToken())

        members.add(member)
    }

    mergeSort(members, 0, numberOfMember - 1)
    members.forEach { println("${it.age} ${it.name}") }
}

fun mergeSort(members: MutableList<Member>, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(members, left, mid)
        mergeSort(members, mid + 1, right)
        merge(members, left, mid, right)
    }
}

fun merge(members: MutableList<Member>, left: Int, mid: Int, right: Int) {
    var leftArrayIndex = left
    var rightArrayIndex = mid + 1
    var newArrayIndex = 0

    val newArray = arrayOfNulls<Member>(right - left + 1)

    while (leftArrayIndex <= mid && rightArrayIndex <= right) {
        if (members[leftArrayIndex].age <= members[rightArrayIndex].age) {
            newArray[newArrayIndex] = members[leftArrayIndex]
            newArrayIndex += 1
            leftArrayIndex += 1
        } else {
            newArray[newArrayIndex] = members[rightArrayIndex]
            newArrayIndex += 1
            rightArrayIndex += 1
        }
    }

    if (leftArrayIndex > mid) {
        for (i in rightArrayIndex..right) {
            newArray[newArrayIndex] = members[i]
            newArrayIndex += 1
        }
    } else {
        for (i in leftArrayIndex..mid) {
            newArray[newArrayIndex] = members[i]
            newArrayIndex += 1
        }
    }

    newArrayIndex = 0
    for (i in left..right) {
        members[i] = newArray[newArrayIndex]!!
        newArrayIndex += 1
    }
}

class Member(val age: Int, val name: String)