import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()
    //var row = sc.nextInt()
    //var col = sc.nextInt()

    printPattern1(n)    
}

fun printPattern1(n: Int) {
    for(i in 0 until n) {
        for (j in 0 until n) {
            print("* ")
        }
        println()
    }
}

Time Complexity: O(n^2)
Space Complexity: O(1)