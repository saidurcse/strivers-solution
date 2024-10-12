import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class DLinkedList {

    class Node(var data: Int) {
        var next: Node? = null  // Reference to the next node in the list (forward direction)
        var back: Node? = null  // Reference to the previous node in the list (backward direction)

        // Constructor for a Node with both data, a reference to the next node, and a reference to the previous node
        constructor(data: Int, next: Node?, back: Node?) : this(data) {
            this.next = next
            this.back = back
        }
    }

    // Function to convert an array to a doubly linked list
    private fun convertArr2DLL(arr: IntArray): Node? {
        val head = Node(arr[0])  // Create the head node with the first element of the array
        var prev = head          // Initialize 'prev' to the head node

        for (i in 1 until arr.size) {
            // Create a new node with data from the array and set its 'back' pointer to the previous node
            val temp = Node(arr[i], null, prev)
            prev.next = temp      // Update the 'next' pointer of the previous node to point to the new node
            prev = temp           // Move 'prev' to the newly created node for the next iteration
        }
        return head // Return the head of the doubly linked list
    }

    // Function to print the elements of the doubly linked list
    private fun print(head: Node?) {
        var current = head
        while (current != null) {
            print("${current.data} ") // Print the data in the current node
            current = current.next     // Move to the next node
        }
        println()
    }

    // Function to reverse a doubly linked list
    private fun reverseDLL(head: Node?): Node? {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head // No change is needed; return the current head
        }

        var prev: Node? = null
        var current = head

        // Traverse the linked list
        while (current != null) {
            prev = current.back // Store a reference to the previous node
            current.back = current.next // Swap the previous and next pointers
            current.next = prev          // This step reverses the links
            current = current.back       // Move to the next node in the original list
        }

        return prev?.back // The final node in the original list becomes the new head after reversal
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(12, 5, 6, 8, 4)
            val dList = DLinkedList()

            // Convert the array to a doubly linked list
            var head = dList.convertArr2DLL(arr)

            // Print the doubly linked list
            println("Doubly Linked List Initially:")
            dList.print(head)

            println("Doubly Linked List After Reversing:")
            head = dList.reverseDLL(head)
            dList.print(head)
        }
    }
}


// Time Complexity:  O(n)
// Space Complexity: O(1)



