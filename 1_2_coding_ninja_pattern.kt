import java.util.*

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    //printPattern1(n)
    //printPattern2(n)
    //printPattern3(n)
    //printPattern4(n)
    //printPattern5(n)
    //printPattern6(n)
    //printPattern7(n)
    //printPattern8(n)
    //printPattern9(n)
    //printPattern10(n)
    //printPattern11(n)
    //printPattern12(n)
    //printPattern13(n)
    //printPattern14(n)
    //printPattern15(n)
    //printPattern16(n)
    //printPattern17(n)
    //printPattern18(n)
    //printPattern19(n)
    //printPattern20(n)
    //printPattern21(n)
    //printPattern22(n)

}
/*
Time Complexity: O(n^2)
Space Complexity: O(1)
*/

fun printPattern1(n: Int) {
    for(i in 0 until n) {
        for (j in 0 until n) {
            print("* ")
        }
        println()
    }
}

fun printPattern2(n: Int) {
    for(i in 0 until n) {
        for (j in 0 .. i) {
            print("* ")
        }
        println()
    }
}

fun printPattern3(n: Int) {
    for(i in 1 .. n) {
        for (j in 1 .. i) {
            //print("${(j+1)} ")
            print("$j ")
        }
        println()
    }
}

fun pattern4(n: Int) {
    for (i in 1..n) {
		// Inner loop for columns (print i, i times)
        for (j in 1..i) {
            print("$i ")
        }
        println()
    }
}

fun printPattern5(n: Int) {
    for(i in 0 until n) {
        for (j in n downTo  i) {
            print("* ")
        }
        println()
    }
}

/*
Row 1 (i = 1):
j goes from 4 down to 1 → values of j: 4 3 2 1
n - j + 1: 1 2 3 4
Output: 1 2 3 4
*/
fun printPattern6(n: Int) {
    for(i in 1 .. n) {
        for (j in n downTo   i) {
            print("${n-j+1} ")
        }
        println()
    }
}

fun printPattern6(n: Int) {
    for (i in rows downTo 1) {
        for (j in 1..i) {
            print("$j ")
        }
        println()
    }
}

fun printPattern7(n: Int) {
    for(i in 0 until  n) {
        for (j in 0 until n-i-1) { // For printing the spaces
            print(" ")
        }
        for (j in 0 until   2*i+1) { // For printing the stars
            print("*")
        }
        for (j in 0 until   n-i-1) { // For printing the spaces
            print(" ")
        }
        println()
    }
}

fun printPattern8(n: Int) {
    for(i in 0 until n) {
        for (j in 0 until i) { // For printing the spaces
            print(" ")
        }
        for (j in 0 until   (2*n)-(2*i+1)) { // For printing the stars
            print("*")
        }
        for (j in 0 until i) { // For printing the spaces
            print(" ")
        }
        println()
    }
}

fun printPattern9(n: Int) {
    for(i in 0 until  n) {
        for (j in 0 until n-i-1) { // For printing the spaces
            print(" ")
        }
        for (j in 0 until   2*i+1) { // For printing the stars
            print("*")
        }
        for (j in 0 until   n-i-1) { // For printing the spaces
            print(" ")
        }
        println()
    }

    for(i in 0 until n) {
        for (j in 0 until i) { // For printing the spaces
            print(" ")
        }
        for (j in 0 until   (2*n)-(2*i+1)) { // For printing the stars
            print("*")
        }
        for (j in 0 until i) { // For printing the spaces
            print(" ")
        }
        println()
    }
}

fun printPattern10(n: Int) {

    for (i in 1 .. 2*n-1) {

        var stars = i
        if(i > n) stars = 2*n-i
        for (j in 1 .. stars) {
            print("*")
        }
        print(" ")
        println()
    }
}

fun printPattern11(n: Int) {

    var start = 1
    for (i in 0 until n) {
        //flipping
        if(i%2 == 0)
            start = 1
        else
            start = 0

        for (j in 0 .. i) {
            print(start)
            start = 1 - start //flipping
        }
        println()
    }
}

fun printPattern12(n: Int) {

    var spaces = 2 * (n-1)
    for (i in 1 .. n) {
        for (j in 1 .. i) {
            print(j)
        }
        for (j in 1 .. spaces) {
            print(" ")
        }
        for (j in i downTo  1) {
            print(j)
        }
        println()
        spaces -= 2
    }
}

fun printPattern13(n: Int) {
    var number = 1
    for(i in 1 .. n) {
        for(j in 1 .. i) {
           print("${number++} ")
        }
        println()
    }
}

fun printPattern14(n: Int) {
    /*One way*/
    var num: Int
    for(i in 1 .. n) {
        num = 65
        for(j in 1 .. i) {
            print((num++).toChar())
        }
        println()
    }
    /*Alternative way*/
    for(i in 1 .. n) {
        for(j in 'A' ..'A'+i) {
            print(j + " ")
        }
        println()
    }
}

fun printPattern15(n: Int) {
    for(i in n downTo  0) {
        for(j in 'A' .. 'A'+i) {
            print(j + " ")
        }
        println()
    }
}

fun printPattern16(n: Int) {
    for(i in 0 until n) {
        for(j in 0 ..  i) {
            print(('A'.code + i).toChar() + " ")
        }
        println()
    }
}

fun printPattern17(n: Int) {
    for(i in 0 until  n) {
        for(j in 0 ..  (n-i-1)) {
            print(" ")
        }
        var ch = 'A'
        var breakPoint = (2*i+1)/2
        for(j in 1 ..  2*i+1) {
            print(ch)
            if(j <= breakPoint) ch++
            else ch--
        }
        for(j in 0 until   (n-i-1)) {
            print(" ")
        }
        println()
    }
}

fun printPattern18(n: Int) {
    for(i in 0 until  n) {
        // A + N -1 -i (i is row no.) to A + N -1 ( E in this case).
        for (ch in ('A' + n - 1 - i).code .. ('A' + n - 1).code) {
            print(ch.toChar() + " ")
        }
        println()
    }
}

fun printPattern19(n: Int) {
    // Symmetry
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) due to iniS
    var iniS = 0
    for(i in 0 until  n) {
        for (j in 1 ..n-i) {
            print("*")
        }
        for (j in 0 until iniS) {
            print(" ")
        }
        for (j in 1 .. n-i) {
            print("*")
        }
        iniS += 2
        println()
    }

    iniS = 2*n -2
    for(i in 1 ..  n) {
        for (j in 1 ..i) {
            print("*")
        }
        for (j in 0 until iniS) {
            print(" ")
        }
        for (j in 1 .. i) {
            print("*")
        }
        iniS -= 2
        println()
    }
}

fun printPattern20(n: Int) {
    var spaces = 2*n -2

    for(i in 1 ..  2*n-1) {
        var stars = i
        if(i > n) stars = 2*n - i

        for (j in 1 ..stars) {
            print("*")
        }
        for (j in 1 .. spaces) {
            print(" ")
        }
        for (j in 1 .. stars) {
            print("*")
        }
        println()
        if(i<n) spaces -= 2
        else spaces += 2
    }
}

fun printPattern21(n: Int) {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if(i ==0 || j ==0 || i == n-1 || j == n-1) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}

fun printPattern22(n: Int) {
    for (i in 0 until 2*n-1) {
        for (j in 0 until 2*n-1) {
            var top = i
            var bottom = j
            var right = (2*n - 2) - j
            var left = (2*n - 2) - i

            print("${n - Math.min(Math.min(top, bottom), Math.min(left, right))}" + " ")
        }
        println()
    }
}