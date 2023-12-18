import java.util.*
import kotlin.collections.HashSet

fun main() {
    //Remove Duplicates in-place from Sorted Array
    //bruteForceApproach()
    optimalApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1) to O(n)
    val arr = intArrayOf(1,1,2,2,2,3,3)
    removeDuplicatesBrute(arr)
}

fun removeDuplicatesBrute(arr: IntArray) {

    val set = HashSet<Int>()
    for (element in arr) {
        set.add(element)
    }

    print(set)
}

fun optimalApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(1, 1, 2, 2, 2, 3, 3)
    removeDuplicatesOptimal(arr)

}

fun removeDuplicatesOptimal(arr: IntArray) {
    var i = 0
    for (j in 1 until arr.size) {
        if (arr[i] != arr[j]) {
            i++
            arr[i] = arr[j]
        }
    }

    for (k in 0 until i+1) {
        print(arr[k])
    }
}