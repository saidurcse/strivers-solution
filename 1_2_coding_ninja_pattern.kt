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
}
/*
From 1 to 6
Time Complexity: O(n^2)
Space Complexity: O(1)

For 7
Time Complexity: O(n^2)
Space Complexity: O(n^2)
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

