import java.lang.Integer.MIN_VALUE
import java.util.*
import kotlin.collections.HashMap

fun main() {
     //Array is sorted
    //bruteForceApproach()
    optimalApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(n^2) // Space Complexity: O(1)
    val arr = intArrayOf(1,2,3,4,5)
    println(bruteForceApproachArray(arr))
}

fun bruteForceApproachArray(arr: IntArray): Boolean {

    for (i in 0 until arr.size) {
        for (j in i+1 until arr.size) {
            if(arr[j]< arr[i])
                return false
        }
    }

    return true
}

fun optimalApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(1,2,3,4,5)
    println(optimalApproachArray(arr))
}

fun optimalApproachArray(arr: IntArray) : Boolean {
    for (i in 1 until arr.size) {
        if (arr[i] < arr[i-1])
            return false
    }

    return true
}