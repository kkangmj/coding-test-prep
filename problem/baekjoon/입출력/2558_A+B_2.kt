import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val A = Integer.parseInt(bufferedReader.readLine())
    val B = Integer.parseInt(bufferedReader.readLine())
    
    println(A+B)
}