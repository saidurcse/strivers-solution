import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Longest Subarray with given Sum K(Positives)
    //bruteForceApproachOne()
    //bruteForceApproachTwo()//Using Two Loops
    //betterApproach()//Using Hashing
    //OptimalApproach()//(Using 2 pointers)
}

fun bruteForceApproachOne() {
    val a = intArrayOf(2, 3, 5, 1, 9)
    val k: Long = 10
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
    val a = intArrayOf(2, 3, 5, 1, 9)
    val k: Long = 10
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
    val a = intArrayOf(2, 3, 5, 1, 9)
    val k: Long = 10
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

fun OptimalApproach() {
    val a = intArrayOf(2, 3, 5, 1, 9)
    val k: Long = 10
    val len = getLongestSubarrayOptimal(a, k)
    println("The length of the longest subarray is: $len")
}

fun getLongestSubarrayOptimal(arr: IntArray, k: Long): Int {
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    val n = arr.size // size of the array.

    var left = 0
    var right = 0 // 2 pointers
    var sum = arr[0].toLong()
    var maxLen = 0

    while (right < n) {
        // if sum > k, reduce the subarray from left
        // until sum becomes less or equal to k:
        while (left <= right && sum > k) {
            sum -= arr[left]
            left++
        }

        // if sum = k, update the maxLen i.e. answer:
        if(sum == k) {
            maxLen = maxOf(maxLen, right-left+1)
        }

        // Move forward the right pointer:
        right++
        if (right < n) sum += arr[right]
    }

    return maxLen
}