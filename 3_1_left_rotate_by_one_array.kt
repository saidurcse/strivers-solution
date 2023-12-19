import java.util.*

fun main() {
    //Left Rotate the Array by One
    //bruteForceApproach()
    //optimalApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(n) // Space Complexity: O(n)
    val arr = intArrayOf(1,2,3,4,5,6)
    leftRotateBruteForce(arr)
}

fun leftRotateBruteForce(arr: IntArray) {
    var temp = IntArray(arr.size)

    for (i in 0 until arr.size-1) {
        temp[i] = arr[i+1]
    }
    temp[arr.size-1] = arr[0]

    for (i in 0 until temp.size) {
        print("${temp[i]} ")
    }
}

fun optimalApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(1,2,3,4,5,6)
    leftRotateOptimal(arr)
}

fun leftRotateOptimal(arr: IntArray) {
    var temp = arr[0]

    for (i in 0 until arr.size-1) {
        arr[i] = arr[i+1]
    }
    arr[arr.size-1] = temp

    for (i in 0 until arr.size) {
        print("${arr[i]} ")
    }
}

