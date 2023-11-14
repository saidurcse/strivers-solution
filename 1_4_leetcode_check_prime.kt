import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var ans = isPrime(n)

    if(n != 1 && ans == true) {
        print("true")
    } else {
        print("false")
    }

}

fun isPrime(n: Int) : Boolean {

    for (i in 2 until n) {
        if(n % i == 0) {
            return false
        }
    }

    return true
}


Time Complexity: O(n)
Space Complexity: O(1)

Better Approach:

fun isPrime(n: Int) : Boolean {

    for (i in 2 .. sqrt(n.toDouble()).toInt()) {
        if(n % i == 0) {
            return false
        }
    }

    return true
}

Time Complexity: O(sqrt(n))
Space Complexity: O(1)