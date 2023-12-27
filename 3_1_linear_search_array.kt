import java.util.*
import kotlin.io.path.fileVisitor

fun main() {
    //Linear Search
    linearSearch()
}

fun linearSearch() {
    //Time complexity: O(n), where n is the size of the input array.
    //Space complexity: O(1)

    val arr = intArrayOf(1,2,3,4,5)
    val n = arr.size
    val num = 4

    val result = search(arr, num)
    println(result)
}

fun search(arr: IntArray, num: Int): Int {
    var res = 0

    for (i in 0 until arr.size) {
         if (arr[i] == num)
             res = i
    }


    return res
}



