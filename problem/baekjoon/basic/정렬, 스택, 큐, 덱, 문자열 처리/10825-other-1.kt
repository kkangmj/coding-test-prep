import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numOfStudent = Integer.parseInt(br.readLine())
    val students = PriorityQueue<Student2>()

    for (i in 0 until numOfStudent) {
        val st = StringTokenizer(br.readLine())
        students.add(
            Student2(
                st.nextToken(),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            )
        )
    }

    while (!students.isEmpty()) {
        bw.write(students.poll().name)
        bw.write("\n")
    }

    bw.flush()
}

class Student2(val name: String, val lang: Int, val eng: Int, val math: Int) : Comparable<Student2> {
    override fun compareTo(other: Student2): Int {
        return if (lang != other.lang) {
            other.lang - lang
        } else {
            if (eng != other.eng) {
                eng - other.eng
            } else {
                if (math != other.math) {
                    other.math - math
                } else {
                    name.compareTo(other.name)
                }
            }
        }
    }
}