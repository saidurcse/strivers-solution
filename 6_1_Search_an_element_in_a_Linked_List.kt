import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

// Node class represents a node in a linked list
class Node(var data: Int, var next: Node? = null)

// LinkedList class contains utility methods for linked list operations
object LinkedList {

    // Function to check if a given element is present in the linked list
    fun checkifPresent(head: Node?, desiredElement: Int): Int {
        var temp = head

        // Traverse the linked list
        while (temp != null) {
            // Check if the current node's data is equal to the desired element
            if (temp.data == desiredElement)
                return 1  // Return 1 if the element is found

            // Move to the next node
            temp = temp.next
        }

        return 0  // Return 0 if the element is not found in the linked list
    }

    // Main function
    @JvmStatic
    fun main(args: Array<String>) {
        // Create a linked list: 1 -> 2 -> 3
        val arr = intArrayOf(1, 2, 3)
        var head: Node? = Node(arr[0])
        head?.next = Node(arr[1])
        head?.next?.next = Node(arr[2])

        val valueToCheck = 3  // Element to be checked for presence in the linked list

        // Call the checkifPresent function and print the result
        print(checkifPresent(head, valueToCheck))
    }
}


// Time Complexity:  O(n)
// Space Complexity: O(1)



