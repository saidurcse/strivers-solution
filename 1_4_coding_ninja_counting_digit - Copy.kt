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