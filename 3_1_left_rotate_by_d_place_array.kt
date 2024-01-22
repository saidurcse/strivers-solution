import java.util.*

fun main() {
    //Left Rotate the Array by K elements
    //bruteForceApproach()
    optimalApproach()
}

fun bruteForceApproach() {
    // Time Complexity: O(n) // Space Complexity: O(n)
    val arr = intArrayOf(1,2,3,4,5,6)
    val k = 2
    //For Rotating the Elements to right
    rotateBruteForceRight(arr, k)
    val arr1 = intArrayOf(1,2,3,4,5,6)
    //For Rotating the Elements to left
    rotateBruteForceLeft(arr1, k)
}

fun rotateBruteForceRight(arr: IntArray, k: Int) {
    val n = arr.size
    val temp = IntArray(n)

    //Copy the last k elements into the temp array.
    for (i in n-k until n) { // i = n-k = 4..5
        temp[i-n+k] = arr[i] // i-n+k = 4-6+2 = 0..1
    }

    //Shift n-k elements from the beginning by k position to the right
    for (i in n-k-1 downTo 0) { // i = n-k-1 = 3..0
        arr[i+k] = arr[i] // i+k = 3+2 = 5..2
    }

    //Copy the elements into the main array from the temp array.
    for (i in 0 until k) {
        arr[i] = temp[i]
    }

    for (i in 0 until arr.size) {
        print("${arr[i]} ")
    }
}

fun rotateBruteForceLeft(arr: IntArray, k: Int) {
    val n = arr.size
    val temp = IntArray(n)

    //Copy the last k elements into the temp array.
    for (i in 0 until k) {
        temp[i] = arr[i]
    }

    //Shift n-k elements from last by k position to the left
    for (i in 0 until  n-k) {
        arr[i] = arr[i+k]
    }

    //Copy the elements into the main array from the temp array.
    for (i in n-k until n) {
        arr[i] = temp[i - n + k]
    }

    for (i in 0 until arr.size) {
        print("${arr[i]} ")
    }
}

fun optimalApproach() {
    // Time Complexity: O(n) // Space Complexity: O(1)
    val arr = intArrayOf(1,2,3,4,5,6)
    val n = arr.size
    val k = 2
    //For Rotating the Elements to right
    rotateElementsToRight(arr, n, k)
    for (i in 0 until n) {
        print("${arr[i]} ")
    }
    println()
}

fun rotateElementsToRight(arr: IntArray, n: Int, k: Int) {
    reverse(arr, 0, n - k - 1) // n-k+1 = 3
    reverse(arr, n - k, n - 1) // n-k = 4
    reverse(arr, 0, n - 1) // n-1 = 5
}

fun reverse(arr: IntArray, start: Int, end: Int) {
    var s = start
    var e = end
    while (s <= e) {
        val temp = arr[s]
        arr[s] = arr[e]
        arr[e] = temp
        s++
        e--
    }
}

