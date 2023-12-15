import java.lang.Integer.MIN_VALUE
import java.util.*
import kotlin.collections.HashMap

fun main() {
     // Second smallest and second largest element in an array

    //bruteForceApproach()
    //betterApproach()
    //optimizedApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(N*log(N)) // Space Complexity: O(1)
    // It will work if there are no duplicates
    val arr = intArrayOf(2,5,1,3,0)
    bruteForceApproachArray(arr)
}

fun bruteForceApproachArray(arr: IntArray) {
    arr.sort()

    println(arr[1])
    println(arr[arr.size-2])
}

fun betterApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(2,5,1,3,0)
    betterApproachArray(arr)
}

fun betterApproachArray(arr: IntArray) {
    var lar = MIN_VALUE
    var small = Int.MAX_VALUE
    var secondLar = MIN_VALUE
    var secondSmall = Int.MAX_VALUE
    for (i in 0 until arr.size) {
        if(arr[i] > lar)
            lar = arr[i]
        if(arr[i] < small)
            small = arr[i]
    }
    for (i in 0 until arr.size) {
        if(arr[i] > secondLar && arr[i] != lar)
            secondLar = arr[i]
        if(arr[i] < secondSmall && arr[i] != small)
            secondSmall = arr[i]
    }

    println(secondLar)
    println(secondSmall)
}

fun optimizedApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(2,5,1,3,0)
    println(optimizedApproachArrayLargest(arr))
    println(optimizedApproachArraySmallest(arr))
}

fun optimizedApproachArrayLargest(arr: IntArray): Int {
    var large = Int.MIN_VALUE
    var second_large = Int.MIN_VALUE

    for (i in 0 until arr.size) {
        if(arr[i] > large) {
            second_large = large
            large = arr[i]
        } else if (arr[i] > second_large && arr[i] != large) {
            second_large = arr[i]
        }
    }

    return second_large
}

fun optimizedApproachArraySmallest(arr: IntArray): Int {
    var small = Int.MAX_VALUE
    var second_small = Int.MAX_VALUE

    for (i in 0 until arr.size) {
        if(arr[i] < small) {
            second_small = small
            small = arr[i]
        } else if (arr[i] < second_small && arr[i] != small) {
            second_small = arr[i]
        }
    }

    return second_small
}
