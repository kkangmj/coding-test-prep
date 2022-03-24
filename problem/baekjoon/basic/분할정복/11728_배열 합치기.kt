import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    var st = StringTokenizer(br.readLine())
    val sizeOfArrayA = Integer.parseInt(st.nextToken())
    val sizeOfArrayB = Integer.parseInt(st.nextToken())

    val arrayA = IntArray(sizeOfArrayA)
    val arrayB = IntArray(sizeOfArrayB)

    st = StringTokenizer(br.readLine())
    for (i in 0 until sizeOfArrayA) {
        arrayA[i] = Integer.parseInt(st.nextToken())
    }

    st = StringTokenizer(br.readLine())
    for (i in 0 until sizeOfArrayB) {
        arrayB[i] = Integer.parseInt(st.nextToken())
    }

    sortArray(arrayA, arrayB).forEach { sb.append("$it ") }
    bw.write(sb.toString())
    bw.flush()
}

fun sortArray(a: IntArray, b: IntArray): ArrayList<Int> {
    var indexA = 0
    var indexB = 0
    val combinedArray = ArrayList<Int>(a.size + b.size)

    while (indexA < a.size && indexB < b.size) {
        if (a[indexA] > b[indexB]) {
            combinedArray.add(b[indexB])
            indexB++
        } else {
            combinedArray.add(a[indexA])
            indexA++
        }
    }

    while (indexA < a.size) {
        combinedArray.add(a[indexA])
        indexA++
    }

    while (indexB < b.size) {
        combinedArray.add(b[indexB])
        indexB++
    }

    return combinedArray
}