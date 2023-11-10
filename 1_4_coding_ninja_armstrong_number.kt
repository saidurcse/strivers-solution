import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    var num1 = n
    var num2 = n
    var sum = 0
    var digit = 0

    while (num1 > 0) {
        digit++
        num1 /= 10
    }

    while (num2 > 0) {
        val rem = num2 % 10
        sum = sum + Math.pow(rem.toDouble(), digit.toDouble()).toInt()
        num2 /= 10
    }

    if (sum == n)
        println("true")
    else
        println("false")
}


Time Complexity: O(log(n))
Space Complexity: O(1)