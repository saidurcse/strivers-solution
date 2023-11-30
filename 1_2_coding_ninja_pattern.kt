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
    printPattern11(n)

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

fun printPattern5(n: Int) {
    for(i in 0 until n) {
        for (j in n downTo  i) {
            print("* ")
        }
        println()
    }
}

fun printPattern6(n: Int) {
    for(i in 1 .. n) {
        for (j in n downTo   i) {
            print("${n-j+1} ")
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

