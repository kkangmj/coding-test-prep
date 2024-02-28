import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val tokenizedInput = StringTokenizer(bufferedReader.readLine())
    
    val a = Integer.parseInt(tokenizedInput.nextToken())
    val b = Integer.parseInt(tokenizedInput.nextToken())
    
    println(a+b)
}