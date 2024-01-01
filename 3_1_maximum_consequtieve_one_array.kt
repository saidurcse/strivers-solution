import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    //Count Maximum Consecutive One’s in the array
    val nums = intArrayOf(1, 1, 0, 1, 1, 1)
    val ans = findMaxConsecutiveOnes(nums)
    println("The maximum consecutive 1's are $ans")
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    var count = 0
    var maxi = 0

    for (i in nums.indices) {
        if (nums[i] == 1) {
            count++
        } else {
            count = 0
        }
        maxi = maxOf(maxi, count)
    }

    return maxi
}

