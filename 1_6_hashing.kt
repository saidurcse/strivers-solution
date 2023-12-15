import java.util.*
import kotlin.collections.HashMap

fun main() {
    //var sc = Scanner(System.`in`)
    //var n = sc.nextInt()

    //Number Hashing
    //bruteForceApproachNumberHashing()
    //optimizeApproachNumberHashing()

    //Character Hashing
    //bruteForceApproachCharacterHashing()
    //optimizeApproachCharacterLowerHashing()
    //optimizeApproachCharacterUpperLowerHashing()
    //hashMapForLargeNumbers()
    //hashMapForLargeCharacters()
    //highestLowestFrequencyBruteForce()
    highestLowestFrequencyOptimzed()
}

fun bruteForceApproachNumberHashing() {
    var arr = intArrayOf(1,2,1,3,2)
    var qur = intArrayOf(1,3,4,2,10)

    // Time complexly: O(q*N) // Space complexity: O(1)
    for (i in 0 until qur.size) {
        println("${qur[i]} : " + hashCountGeneral(arr, qur[i]))
    }
}

fun hashCountGeneral(arr: IntArray, qurNumber: Int): Int {
    var count = 0
    for (i in 0 until arr.size) {
        if (arr[i] == qurNumber)
            count++
    }
    return count
}

fun optimizeApproachNumberHashing() {
    // Time complexly: O(N+q) // Space complexity: O(n)
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    // Precompute
    val hash = IntArray(13)
    for (i in 0 until n) {
        hash[arr[i]] += 1
    }

    var q = sc.nextInt()
    while (q-- != 0) {
        val number = sc.nextInt()
        println(hash[number])
    }
}

fun bruteForceApproachCharacterHashing() {
    var str = "abcdabefc"
    var qur = "acz".toCharArray()

    // Time complexly: O(q*N) // Space complexity: O(1)
    for (i in 0 until qur.size) {
        println("${qur[i]} : " + hashCountGeneralCharacter(str, qur[i]))
    }
}

fun hashCountGeneralCharacter(str: String, qurChar: Char): Int {
    var count = 0
    for (i in 0 until str.length) {
        if (str[i] == qurChar)
            count++
    }
    return count
}

fun optimizeApproachCharacterLowerHashing() {
    // Time complexity: O(length of s + q) // Space complexity: O(length of s)
    val sc = Scanner(System.`in`)
    val s = sc.next()

    // Precompute
    val hash = IntArray(26)
    for (i in s.indices) {
        hash[s[i]-'a']++
    }

    var q = sc.nextInt()
    while (q-- > 0) {
        val c = sc.next()[0]
        //Fetch
        println(hash[c-'a'])
    }
}

fun optimizeApproachCharacterUpperLowerHashing() {
    // Time complexity: O(length of s + q) // Space complexity: O(length of s)
    val sc = Scanner(System.`in`)
    val s = sc.next()

    // Precompute
    val hash = IntArray(256)
    for (i in s.indices) {
        hash[s[i].code]++
    }

    var q = sc.nextInt()
    while (q-- > 0) {
        val c = sc.next()[0]
        //Fetch
        println(hash[c.code])
    }
}

fun hashMapForLargeNumbers() {
    // All the above array hashing can handle 10^7 using globally and 10^6 inside main function but
    // If we need higher number like 10^9 or higher we need HashMap function of Java or Kotlin

    // Time complexity: O(n+q) // Space Complexity: O(n)
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    // Precompute
    val mp = HashMap<Int, Int>()
    for(i in 0 until n) {
        val key = arr[i]
        val freq = mp.getOrDefault(key, 0) + 1
        // It checks if the element exists as a key in the HashMap:
        // If it exists, it retrieves the frequency and increments it by 1.
        // If it doesn't exist, it defaults the frequency to 0 and increments it by 1.
        mp[key] = freq
    }

    var q = sc.nextInt()
    while (q-- > 0) {
        val number = sc.nextInt()
        // Fetch
        println(mp.getOrDefault(number, 0))
    }
}

fun hashMapForLargeCharacters() {
    // All the above array hashing can handle 10^7 using globally and 10^6 inside main function but
    // If we need higher number like 10^9 or higher we need HashMap function of Java or Kotlin

    // Time complexity: O(n) // Space Complexity: O(n)
    val sc = Scanner(System.`in`)
    val str = sc.next()

    //HashMap char as a key and occurrence as a value
    val charCount = HashMap<Char, Int>()

    for (i in 0 until str.length) {
        if (charCount.containsKey(str[i])) {
            // Initially taking count from map
            var count = charCount[str[i]]!!
            charCount[str[i]] = ++count // I should not give double equal
        } else {
            charCount[str[i]] = 1
        }
    }
    for ((key, value) in charCount) {
        print("$key") // e g l o
        print("$value") // 1 2 1 2
    }

    println(charCount)

}

fun highestLowestFrequencyBruteForce() {
    // Time complexly: O(N*N) // Space complexity: O(n)
    val arr = intArrayOf(10, 5, 10, 15, 10, 5)
    val n = arr.size
    countFreq(arr, n)
}

fun countFreq(arr: IntArray, n: Int) {
    val visited = BooleanArray(n)
    var maxFreq = 0
    var minFreq = n
    var maxEle = 0
    var minEle = 0

    for (i in 0 until n) {
        if (visited[i]) continue

        var count = 1
        for (j in i+1 until n) {
            if(arr[i] == arr[j]) {
                visited[j] = true
                count++
            }
        }

        if(count > maxFreq) {
            maxEle = arr[i]
            maxFreq = count
        }
        if(count < minFreq) {
            minEle = arr[i]
            minFreq = count
        }
    }

    println("The highest frequency element is: $maxEle")
    println("The lowest frequency element is: $minEle")
}

fun highestLowestFrequencyOptimzed() {
    // Time complexly: O(n) // Space complexity: O(n)
    val arr = intArrayOf(10, 5, 10, 15, 10, 5)
    val n = arr.size
    frequencyOptimized(arr, n)
}

fun frequencyOptimized(arr: IntArray, n: Int) {
    val map = HashMap<Int, Int>()

    for (i in 0 until n) {
        if (map.containsKey(arr[i])) {
            map[arr[i]] = map[arr[i]]!! + 1
        } else {
            map[arr[i]] = 1
        }
    }

    var maxFreq = 0
    var minFreq = n
    var maxEle = 0
    var minEle = 0
    for ((element, count) in map) {
        if (count > maxFreq) {
            maxEle = element
            maxFreq = count
        }
        if (count < minFreq) {
            minEle = element
            minFreq = count
        }
    }

    println("The highest frequency element is: $maxEle")
    println("The lowest frequency element is: $minEle")
}