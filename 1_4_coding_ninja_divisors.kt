import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var list = ArrayList<Int>()

    for (i in 1 .. n) {
        if(n % i == 0) {
            list.add(i)
        }
    }

    print(list)
}


Time Complexity: O(n)
Space Complexity: O(n) as the ArrayList will store all these values.