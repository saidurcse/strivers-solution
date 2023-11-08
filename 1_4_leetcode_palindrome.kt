import java.io.*

class Solution {
    fun isPalindrome(x: Int): Boolean {
        
        if(x < 0)
            return false

        var temp = x
        var rev = 0

        while(temp > 0) {
            var rem = temp % 10
            rev = rev * 10 + rem
            temp /= 10
        }

        if(x == rev)
            return true
        else
            return false
    }
}