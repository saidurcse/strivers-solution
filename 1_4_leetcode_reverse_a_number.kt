import java.io.*

class Solution {
    fun reverse(x: Int): Int {
        var num = x
        var rev: Long = 0

        if(num < 0)
            num = (-1)*x // Math.abs(x)

        while(num > 0) {            
            var rem = num % 10        
            rev = rev * 10 + rem
            num /= 10                     
        }

        if(rev > Int.MAX_VALUE || -rev < Int.MIN_VALUE)
            return 0

        if(x > 0)
            return rev.toInt()
        else
            return (-1)*rev.toInt()
    }
}