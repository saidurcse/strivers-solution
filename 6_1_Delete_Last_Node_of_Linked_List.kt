import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

// Node class definition
class Node(var data: Int, var next: Node? = null)

// LinkedList class
class LinkedList {
    companion object {
        // Function to delete the tail of the linked list
        fun deleteTail(head: Node?): Node? {
            // Check if the linked list is empty or has only one node
            if (head == null || head.next == null)
                return null
            // Create a temporary pointer for traversal
            var temp: Node? = head
            // Traverse the list until the second-to-last node
            while (temp?.next?.next != null) {
                temp = temp.next
            }
            // Nullify the connection from the second-to-last node to delete the last node
            temp?.next = null
            // Return the updated head of the linked list
            return head
        }

        // Function to print the linked list
        fun printLL(head: Node?) {
            var current = head
            while (current != null) {
                print("${current.data} ")
                current = current.next
            }
        }
    }
}

// Main method
fun main() {
    // Initialize an array with integer values
    val arr = intArrayOf(2, 5, 8, 7)
    // Create the linked list with nodes initialized with array values
    var head: Node? = Node(arr[0])
    head?.next = Node(arr[1])
    head?.next?.next = Node(arr[2])
    head?.next?.next?.next = Node(arr[3])
    // Delete the tail of the linked list
    head = LinkedList.deleteTail(head)
    // Print the modified linked list
    LinkedList.printLL(head)
}

// Time Complexity:  O(n)
// Space Complexity: O(1)



