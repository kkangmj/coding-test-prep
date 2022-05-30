import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numOfStudent = Integer.parseInt(br.readLine())
    val studentArray = mutableListOf<Student>()

    for (i in 0 until numOfStudent) {
        val st = StringTokenizer(br.readLine())
        studentArray.add(
            Student(
                st.nextToken(),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            )
        )
    }

    studentArray.sort()
    studentArray.forEach { bw.write("${it.name}\n") }

    bw.flush()
}

class Student(val name: String, val lang: Int, val eng: Int, val math: Int) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return if (lang > other.lang) -1
        else if (lang < other.lang) 1
        else
            if (eng < other.eng) -1
            else if (eng > other.eng) 1
            else
                if (math > other.math) -1
                else if (math < other.math) 1;
                else
                    if (name <= other.name) -1
                    else 1
    }
}