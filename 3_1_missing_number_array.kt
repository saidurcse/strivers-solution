import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Find the missing number in an array
    //bruteForceApproach()
    //betterApproach()
    //optimalApproachOne() // Summation Approach
}

fun bruteForceApproach() {
    //Time Complexity: O(N2)
    //Space Complexity: O(1)
    val N = 5
    val a = intArrayOf(1, 2, 4, 5)

    val ans = missingNumber(a, N)
    println("The missing number is: $ans")
}

fun missingNumber(arr: IntArray, N: Int): Int {

    for (i in 1 .. N) {
        //flag variable to check
        //if an element exists
        var flag = 0

        //Search the element using linear search:
        for (j in 0 until N-1) {
            if(arr[j] == i) {
                //i is present in the array:
                flag = 1
                break
            }
        }

        //check if the element is missing
        //i.e flag == 0:
        if (flag == 0)
            return i
    }

    //The following line will never execute.
    //It is just to avoid warnings.
    return -1
}

fun betterApproach() {
    //Time Complexity: O(N) + O(N) ~ O(2*N)
    //Space Complexity: O(N)
    val N = 5
    val a = intArrayOf(1, 2, 4, 5)

    val ans = missingNumberBetter(a, N)
    println("The missing number is: $ans")
}

fun missingNumberBetter(arr: IntArray, N: Int): Int {
    val hash = IntArray(N+1) // hash array

    //storing the frequencies
    for (i in 0 until N-1) {
        hash[arr[i]]++
    }

    //checking frequencies for numbers 1 to N
    for (i in 1..N) {
        if (hash[i] == 0) {
            return i
        }
    }

    //This line will never execute, just to avoid warnings
    return -1
}

fun optimalApproachOne() {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    val N = 5
    val a = intArrayOf(1, 2, 4, 5)

    val ans = missingNumberOptimal(a, N)
    println("The missing number is: $ans")
}

fun missingNumberOptimal(arr: IntArray, N: Int): Int {
    // Summation of first N numbers:
    val sum = (N * (N + 1)) / 2

    // Summation of all array elements:
    var s2 = 0
    for (i in 0 until N - 1) {
        s2 += arr[i]
    }

    val missingNum = sum - s2
    return missingNum
}


