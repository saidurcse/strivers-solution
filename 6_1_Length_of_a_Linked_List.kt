import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Node(var data: Int, var next: Node? = null)

object LinkedList {
    // Function to calculate the length of a linked list
    private fun lengthOfLL(head: Node?): Int {
        var count = 0
        var temp = head
        // Traverse the linked list and count nodes
        while (temp != null) {
            temp = temp.next
            count++ // increment count for every node traversed
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(2, 5, 8, 7)
        var head: Node? = Node(arr[0])
        head?.next = Node(arr[1])
        head?.next?.next = Node(arr[2])
        head?.next?.next?.next = Node(arr[3])
        // Print the length of the linked list
        println(lengthOfLL(head))
    }
}

// Time Complexity:  O(n)
// Space Complexity: O(n)



