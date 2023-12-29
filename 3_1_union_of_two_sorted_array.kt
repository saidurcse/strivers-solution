import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Union of Two Sorted Arrays
    //approachOne() // Using Map
    //approachTwo() // Using Set
    //approachThree() // Two pointers
}

fun approachOne() {
    //Time complexity: O( (m+n)log(m+n) ) where N and M are the sizes of the input arrays.
    //Space complexity: O(N + M)

    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr2 = intArrayOf(2, 3, 4, 4, 5, 11, 12)
    val union = findUnion(arr1, arr2)

    println("Union of arr1 and arr2 is ")
    for (value in union) {
        print("$value ")
    }
}

fun findUnion(arr1: IntArray, arr2: IntArray): ArrayList<Int> {

    val freq = HashMap<Int, Int>()
    val union = ArrayList<Int>()

    // Count the frequency of elements in arr1
    // After retrieving the value associated with the element key, the code increments that value by 1.
    // This increment is used to count the occurrence of the element in the array.
    for (element in arr1) {
        freq[element] = freq.getOrDefault(element, 0) + 1
    }

    // Count the frequency of elements in arr2
    for (element in arr2) {
        freq[element] = freq.getOrDefault(element, 0) + 1
    }

    // Extract keys (unique elements) from the HashMap and add them to Union
    for (key in freq.keys) {
        union.add(key)
    }

    return union
}

fun approachTwo() {
    //Time complexity: O(N + M + K), where N and M are the sizes of the input arrays and K is the number of unique elements in both arrays.
    //Space complexity: O(N + M)

    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr2 = intArrayOf(2, 3, 4, 4, 5, 11, 12)
    val union = findUnionTwo(arr1, arr2)

    println("Union of arr1 and arr2 is ")
    for (value in union) {
        print("$value ")
    }
}

fun findUnionTwo(arr1: IntArray, arr2: IntArray): List<Int> {
    val set = HashSet<Int>()
    val union = ArrayList<Int>()

    for (element in arr1) {
        set.add(element)
    }

    for (element in arr2) {
        set.add(element)
    }

    union.addAll(set)

    return union
}

fun approachThree() {
    //Time complexity: O(m+n)
    //Space complexity: O(m + n)

    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr2 = intArrayOf(2, 3, 4, 4, 5, 11, 12)
    val union = findUnionThree(arr1, arr2)

    println("Union of arr1 and arr2 is ")
    for (value in union) {
        print("$value ")
    }
}

fun findUnionThree(arr1: IntArray, arr2: IntArray): List<Int> {
    var i = 0
    var j = 0
    val union = ArrayList<Int>()

    while (i < arr1.size && j < arr2.size) {
        if (arr1[i] <= arr2[j]) {
            if (union.isEmpty() || union.last() != arr1[i]) {
                union.add(arr1[i])
            }
            i++
        } else {
            if (union.isEmpty() || union.last() != arr2[j]) {
                union.add(arr2[j])
            }
            j++
        }
    }

    while (i < arr1.size) {
        if (union.isEmpty() || union.last() != arr1[i]) {
            union.add(arr1[i])
        }
        i++
    }

    while (j < arr2.size) {
        if (union.isEmpty() || union.last() != arr2[j]) {
            union.add(arr2[j])
        }
        j++
    }

    return union
}
