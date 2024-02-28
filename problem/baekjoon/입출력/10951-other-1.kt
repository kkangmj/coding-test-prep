import java.io.BufferedReader;
import java.io.BufferedWriter
import java.io.InputStreamReader;
import java.io.OutputStreamWriter
import java.util.*;

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    try {
        while (true) {
            val line = bufferedReader.readLine()
            val tokenizer = StringTokenizer(line)

            val a = Integer.parseInt(tokenizer.nextToken())
            val b = Integer.parseInt(tokenizer.nextToken())

            bufferedWriter.write("${a + b}\n")
            bufferedWriter.flush()
        }

    } catch (e: Exception) {

    }

    bufferedWriter.close()

}