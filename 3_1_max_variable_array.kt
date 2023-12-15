import java.util.*
import kotlin.collections.HashMap

fun main() {
     // Find the largest element in an array

    //bruteForceApproach()
    //maxVariableApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(N*log(N)) // Space Complexity: O(n)
    val arr = intArrayOf(2,5,1,3,0)
    print(sort(arr))
}

fun sort(arr: IntArray): Int {
    arr.sort()

    return arr[arr.size-1]
}

fun maxVariableApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(2,5,1,3,0)
    print(maxVariable(arr))
}

fun maxVariable(arr: IntArray): Int {
    var max = arr[0]
    for (i in 0 until arr.size) {
        if(arr[i] > max)
            max = arr[i]
    }

    return max
}
