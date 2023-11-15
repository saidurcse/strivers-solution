import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var num1 = sc.nextInt()
    var num2 = sc.nextInt()

    var ans = 1

    for (i in 1 .. Math.min(num1, num2)) {
        if (num1 % i == 0 && num2 % i == 0) {
            ans = i
        }
    }

    print(ans)
}


Time Complexity: O(n)
Space Complexity: O(1)


Better Solution:

import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var num1 = sc.nextInt()
    var num2 = sc.nextInt()

    var ans = gcd(num1, num2)

    print(ans)
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0)
        return a

    return gcd(b, a % b)
}

Time Complexity: O(logɸmin(a,b)), where ɸ is 1.61.
Space Complexity: O(1)

// Recursively call gcd(b,a%b) function till the base condition is hit.
// b==0 is the base condition.When base condition is hit return a,as gcd(a,0) is equal to a.