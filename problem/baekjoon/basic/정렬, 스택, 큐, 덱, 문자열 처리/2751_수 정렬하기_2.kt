import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var array: ArrayList<Int>
lateinit var bw: BufferedWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = Integer.parseInt(br.readLine())
    array = ArrayList(n)
    bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 1..n) {
        array.add(Integer.parseInt(br.readLine()))
    }

    heapSort()
    array.forEach { sb.append("$it\n") }
    println(sb.toString())
}

fun heapSort() {
    // (1) 최대힙으로 만들기
    for (i in (array.size / 2 - 1) downTo 0) {
        makeMaxHeap(array.size, i)
    }

    // (2) 최대힙 정렬하기
    for (i in (array.size - 1) downTo 0) {
        swap(i, 0)
        makeMaxHeap(i, 0)
    }
}

fun makeMaxHeap(size: Int, parentNode: Int) {
    var parent = parentNode    // child 노드 중 최대값을 갖는 노드의 인덱스 저장
    val leftChild = parent * 2 + 1
    val rightChild = parent * 2 + 2

    if (leftChild < size && array[leftChild] > array[parent]) {
        parent = leftChild
    }
    if (rightChild < size && array[rightChild] > array[parent]) {
        parent = rightChild
    }

    if (parent != parentNode) {
        swap(parent, parentNode)
        makeMaxHeap(size, parent)
    }
}

fun swap(a: Int, b: Int) {
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}

