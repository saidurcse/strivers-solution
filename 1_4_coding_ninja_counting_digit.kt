import java.io.*

fun main() {
    var num = 1100000
    var orginalNum = num
    
    var count = 0
    
    while (num > 0) {
        
        var rem = num % 10
        //println(rem) // 6, 3, 3
        //println(num%rem) // 0, 0, 0
        
        if(rem!=0 && orginalNum%rem == 0) // overflow condition checking
        	count++
        
        num /= 10
    }
    
    print(count)
}

Time Complexity: O(log(num)), where num is the value of the variable num in the code.
Space Complexity: O(1)

Better Approach:

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var stringConversion = n.toString()

    print(stringConversion.length)
}

Time Complexity: O(1)
Space Complexity: O(1)

Better Approach:

fun main() {
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var digits = Math.floor(Math.log10(n.toDouble()) + 1).toInt()

    print(digits)
}

Time Complexity: O(1)
Space Complexity: O(1)

Explanation:
n = 12345
log10(12345) = 4.091
Integral part of 4.091 is 4 and 4 + 1 =  5 which is also the number of digits in 12345