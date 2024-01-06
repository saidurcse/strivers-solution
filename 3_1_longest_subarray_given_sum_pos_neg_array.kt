import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Longest Subarray with sum K | [Postives and Negatives]
    //bruteForceApproachOne()
    //bruteForceApproachTwo()//Using Two Loops
    //betterApproach()//Using Hashing
}

fun bruteForceApproachOne() {
    val a = intArrayOf(-1, 1, 1)
    val k: Long = 1
    val len = getLongestSubarrayOne(a, k)
    println("The length of the longest subarray is: $len")
}

fun getLongestSubarrayOne(arr: IntArray, k: Long): Int {
    //Time Complexity: O(N3)
    //Space Complexity: O(1)
    val n = arr.size // size of the array.

    var len = 0
    for (i in 0 until arr.size) { // starting index
        for (j in i until n) { // ending index
            // add all the elements of subarray = a[i...j]:
            var s: Long = 0

            for (k in i .. j) {
                s += arr[k]
            }

            if (s == k)
                len = maxOf(len, j - i + 1)
        }
    }
    return len
}

fun bruteForceApproachTwo() {
    val a = intArrayOf(-1, 1, 1)
    val k: Long = 1
    val len = getLongestSubarrayTwo(a, k)
    println("The length of the longest subarray is: $len")
}

fun getLongestSubarrayTwo(arr: IntArray, k: Long): Int {
    //Time Complexity: O(N2)
    //Space Complexity: O(1)
    val n = arr.size // size of the array

    var len = 0

    for (i in 0 until n) { // starting index
        var s: Long = 0 // Sum variable
        for (j in i until n) { // ending index
            // add the current element to
            // the subarray a[i...j-1]:
            s += arr[j]

            if(s == k)
                len = maxOf(len, j-i+1)
        }
    }

    return len
}

fun betterApproach() {
    val a = intArrayOf(-1, 1, 1)
    val k: Long = 1
    val len = getLongestSubarrayBetter(a, k)
    println("The length of the longest subarray is: $len")
}

fun getLongestSubarrayBetter(arr: IntArray, k: Long): Int {
    //Time Complexity: O(N)
    //Space Complexity: O(n)
    val n = arr.size // size of the array.

    val preSumMap = HashMap<Long, Int>()
    var sum: Long = 0
    var maxLen = 0
    for (i in 0 until n) {
        // calculate the prefix sum till index i:
        sum += arr[i]

        // if the sum = k, update the maxLen:
        if (sum == k) {
            maxLen = maxOf(maxLen, i + 1)
        }

        // calculate the sum of remaining part i.e. x-k:
        val rem = sum - k

        // Calculate the length and update maxLen:
        if (preSumMap.containsKey(rem)) {
            val len = i - preSumMap[rem]!!
            maxLen = maxOf(maxLen, len)
        }

        // Finally, update the map checking the conditions:
        // Updates the preSumMap by storing the sum as a key with its corresponding index if it's not already present in the map.
        if (!preSumMap.containsKey(sum)) {
            preSumMap[sum] = i
        }
    }

    return maxLen
}