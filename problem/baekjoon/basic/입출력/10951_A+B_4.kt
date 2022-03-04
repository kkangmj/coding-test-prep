import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val iterator = bufferedReader.lineSequence().iterator()
    while (iterator.hasNext()) {
        val line = iterator.next()
        val tokenizer = StringTokenizer(line)
        println(Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken()))
    }
}