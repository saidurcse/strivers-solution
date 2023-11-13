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


Better Solution:

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var list = ArrayList<Int>()

    for (i in 1 .. sqrt(n.toDouble()).toInt()) {
        if(n % i == 0) {
            list.add(i)

            if((n/i) != i)
                list.add(n/i)
        }
    }

    list.sort()

    print(list)
}

Time Complexity: O(sqrt(n)), because every time the loop runs only sqrt(n) times.
Space Complexity: O(1), we are not using any extra space.