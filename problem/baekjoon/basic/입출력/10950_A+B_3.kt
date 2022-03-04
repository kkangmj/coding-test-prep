import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    
    val iterationTime = StringTokenizer(bufferedReader.readLine()).nextToken().toInt()
    for (i in 1..iterationTime) {
        val line = StringTokenizer(bufferedReader.readLine())
        val a = line.nextToken().toInt()
        val b = line.nextToken().toInt()
        
        println(a+b)    
    }
}