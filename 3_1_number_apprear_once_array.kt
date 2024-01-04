import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Find the number that appears once, and the other numbers twice
    //bruteForceApproach()
    //betterApproachOne()
    //betterApproachTwo()
}

fun bruteForceApproach() {
    val arr = intArrayOf(4, 1, 2, 1, 2)
    val ans = getSingleElement(arr)
    println("The single element is: $ans")
}

fun getSingleElement(arr: IntArray): Int {
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    for(i in 0 until arr.size) {
        val num = arr[i]
        var count = 0

        for (j in 0 until arr.size) {
            if (arr[j] == num)
                count++
        }

        if(count == 1) return num
    }

    return -1
}

fun betterApproachOne() {
    val arr = intArrayOf(4, 1, 2, 1, 2)
    val ans = getSingleElementHash(arr)
    println("The single element is: $ans")
}

fun getSingleElementHash(arr: IntArray): Int {
    //Time Complexity: O(n)
    //Space Complexity: O(maxi), where maxi represents the maximum element in the array

    // Find the maximum element:
    val maxi = arr.maxOrNull() ?: 0

    // Declare hash array of size maxi+1
    // And hash the given array:
    val hash = IntArray(maxi+1)
    for (element in arr) {
        hash[element]++
    }

    // Find the single element and return the answer:
    for (element in arr) {
        if (hash[element] == 1) {
            return element
        }
    }

    return -1
}

fun betterApproachTwo() {
    val arr = intArrayOf(4, 1, 2, 1, 2)
    val ans = getSingleElementMap(arr)
    println("The single element is: $ans")
}

fun getSingleElementMap(arr: IntArray): Int {
    //Time Complexity: O(n + m), where n is the number of elements in the array and m is the number of unique elements.
    //Space Complexity: O(m), where m is the number of unique elements in the input array.

    // Declare the hashmap and hash the given array:
    val mpp = HashMap<Int, Int>()
    for (i in 0 until arr.size) {
        val value = mpp.getOrDefault(arr[i], 0)
        mpp[arr[i]] = value + 1
    }

    // Find the single element and return the answer:
    for ((key, value) in mpp) {
        if (value == 1) {
            return key
        }
    }

    return -1
}