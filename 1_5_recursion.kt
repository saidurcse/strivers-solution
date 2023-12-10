import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    //funName(1, n)
    //funIncrementCountForward(1, n)
    //funIncrementCountBacktracking(n, n)
    //funDecrementCountForward(n, n)
    //funDecrementCountBacktracking(1, n)
    //funSumOfIntegersParameterized(n, 0)
    //print(funSumOfIntegersFunctional(n))
    //print(funFactorial(n))
    //funReverseArray(n)
    //funReverseArrayRecursive(n)
    //palindrome()
    //palindromeRecursive()
    //fibonacci()
    //fibonacciRecursive()
}

fun funName(i: Int, n: Int) {

    if(i > n) return

    println("Hello")

    funName(i+1, n)
}
//Time Complexity: O(N), Since the function is being called n times, and for each function,
//we have only one printable line that takes O(1) time, so the cumulative time complexity would be O(N)
//Space Complexity: O(N),  In the worst case, the recursion stack space would be full with all
//the function calls waiting to get completed and that would make it an O(N) recursion stack space.

// Forward recursion // 1 to n
fun funIncrementCountForward(i: Int, n: Int) {

    if(i > n) return

    println(i)

    funIncrementCountForward(i+1, n)
}

//  Using Backtracking // 1 to n
fun funIncrementCountBacktracking(i: Int, n: Int) {

    if(i < 1) return

    funIncrementCountBacktracking(i-1, n)

    println(i)
}

// Forward recursion // n to 1
fun funDecrementCountForward(i: Int, n: Int) {

    if(i < 1) return

    println(i)

    funDecrementCountForward(i-1, n)
}

// Using Backtracking // n to 1
fun funDecrementCountBacktracking(i: Int, n: Int) {

    if(i > n) return

    funDecrementCountBacktracking(i+1, n)

    println(i)
}

fun funSumOfIntegersParameterized(i:Int, sum: Int) {
    // Normal way
    // loop, sum += i // Time Complexity: O(N) // Space Complexity: O(1)
    // another way, sum = n * (n+1)/2 // Time Complexity: O(1) // Space Complexity: O(1)

    // Parameterized way //Time Complexity: O(N) //Space Complexity: O(N)
    if(i<1) {
        println(sum)
        return
    }
    funSumOfIntegersParameterized(i-1, sum+i)
}

fun funSumOfIntegersFunctional(n: Int): Int {
    // Functional way
    if(n == 0) return 0
    else return n + funSumOfIntegersFunctional(n-1)
}

fun funFactorial(n: Int): Int {
    // Normal way // Time Complexity: O(N) // Space Complexity: O(1)
    /*
       var fact = 1
       val number = 5
       for(i in 1..number) {
           fact = fact * i
       }
       println("Factorial of $number is: $fact")
    */
    if (n == 0) return 1 // we return 1 because the factorial of 0 is 1 only.
    else return n * funFactorial(n - 1)
}

fun funReverseArray(n: Int) {
    // Normal way // Time Complexity: O(N) // Space Complexity: O(n)
    val arr = intArrayOf(5,4,3,2,1)
    val ans = IntArray(arr.size)
    val len = arr.size

    for (i in 0 until len) {
        ans[len-i-1] = arr[i]
    }

    for (i in 0 until len) {
        print("${ans[i]} ")
    }
    println()

    // Alternative way // Time Complexity: O(N) // Space Complexity: O(1)
    val newArr = intArrayOf(5,4,3,2,1)
    var p1 = 0
    var p2 = newArr.size-1
    while (p1 < p2) {
        val temp = newArr[p1]
        newArr[p1] = newArr[p2]
        newArr[p2] = temp
        p1++
        p2--
    }

    for (i in 0 until newArr.size) {
        print("${newArr[i]} ")
    }
    println()

    // Alternative way // Time Complexity: O(N) // Space Complexity: O(1)
    val arrLibrary = intArrayOf(5,4,3,2,1)
    arrLibrary.reverse()
    for (i in 0 until arrLibrary.size) {
        print("${arrLibrary[i]} ")
    }

}

fun funReverseArrayRecursive(n: Int) {
    // Recursive way // Time Complexity: O(N) // Space Complexity: O(1)
    var arr = intArrayOf(5,4,3,2,1)
    reverseArrayRecursive(arr, 0, n-1)
    printRecursiveArray(arr, n)
}

fun printRecursiveArray(arr: IntArray, n: Int) {
    for (i in 0 until arr.size)
        print("${arr[i]} ")
}

fun reverseArrayRecursive(arr: IntArray, start: Int, end: Int) {
    if(start < end) {
        var temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        reverseArrayRecursive(arr, start+1, end-1)
    }
}

fun palindrome() {
    // Time Complexity:  O(N) // Space Complexity: O(1)
    val str = "ABCDCBA"
    val ans = isPalindrome(str)

    if (ans) {
        println("Palindrome")
    } else {
        println("Not Palindrome")
    }
}

fun isPalindrome(str: String): Boolean {
    var left = 0
    var right = str.length - 1
    while (left < right) {
        val l = str[left]
        val r = str[right]
        if (!l.isLetterOrDigit())
            left++
        else if (!l.isLetterOrDigit())
            right--
        else if (l.lowercaseChar() != r.lowercaseChar())
            return false
        else {
            left++
            right--
        }
    }

    return true
}

fun palindromeRecursive() {
    //Time Complexity: O(N) { Precisely, O(N/2) as we compare the elements N/2 times and swap them}.
    //Space Complexity: O(1) { The elements of the given array are swapped in place so no extra space is required}.
    val s = "madam"
    println(isPalindromeRecursion(0, s))
}

fun isPalindromeRecursion(i: Int, s: String): Boolean {

    if(i >= s.length/2) return true
    if(s[i] != s[s.length-i-1]) return false
    return isPalindromeRecursion(i+1, s)
}

fun fibonacci() {
    generateFibonacci(20)
}

fun generateFibonacci(limit: Int) {
    //Time complexity: O(n) //Space complexity: O(1), as it uses a constant amount of additional memory regardless of the value of limit.
    var first = 0
    var second = 1
    print("$first, $second")


    for (i in 1 until limit) {
        val next = first + second
        print(", $next")
        first = second
        second = next
    }
    println()
}
//Output: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,

fun fibonacciRecursive() {
    val limit = 20
    for (i in 1..limit) {
        print(fibonacci(i).toString() + ", ")
    }
}

fun fibonacci(n: Int): Int {
    //Time complexity: O(2^n) //Space complexity: O(n), due to the call stack.
    if(n <= 2) return n - 1
    else return fibonacci(n - 1) + fibonacci(n - 2)
}

