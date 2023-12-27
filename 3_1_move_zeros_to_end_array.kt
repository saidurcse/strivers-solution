import java.util.*

fun main() {
    //Move all Zeros to the end of the array
    //optimalApproach1() // generic brute force approach
    optimalApproach2() // Using 2 pointers
}

fun optimalApproach1() {
    //Time complexity: O(n), where n is the size of the input array.
    //Space complexity: O(1)

    val arr = intArrayOf(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9)
    val n = arr.size

    pushZerosToEnd1(arr, n)

    for (i in 0 until n)
        print(arr[i].toString() + " ")
}

// Function which pushes all zeros to end of an array.
fun pushZerosToEnd1(arr: IntArray, n: Int) {
    var count = 0 // Count of non-zero elements

    // Traverse the array. If element encountered is non-zero, then replace the element at index 'count' with this element
    for (i in 0 until n) {
        if (arr[i] != 0)
            arr[count++] = arr[i]
        // here count is incremented
    }

    // Now all non-zero elements have been shifted to front and 'count' is set as the index of the first 0. Make all elements 0 from count to end.
    while (count < n)
        arr[count++] = 0
}

fun optimalApproach2() {
    //Time complexity: O(n), where n is the size of the input array.
    //Space complexity: O(1)

    val arr = intArrayOf(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9)
    val n = arr.size

    pushZerosToEnd2(arr, n)

    for (i in 0 until n)
        print(arr[i].toString() + " ")
}

// Function which pushes all zeros to end of an array.
fun pushZerosToEnd2(arr: IntArray, n: Int) {
    var j = -1
    // place the pointer j
    for (i in 0 until n) {
        if (arr[i] == 0) {
            j = i
            break
        }
    }
    // no non-zero element
    if (j == -1)
        return

    // Move the pointers i and j, and swap accordingly:
    // If a[i] != 0 i.e. a[i] is a non-zero element: We will swap a[i] and a[j].
    // Now, the current j is pointing to the non-zero element a[i]. So, we will shift the pointer j by 1 so that it can again point to the first zero.
    for (i in j+1 until n) {
        if (arr[i] != 0) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            j++
        }
    }
}