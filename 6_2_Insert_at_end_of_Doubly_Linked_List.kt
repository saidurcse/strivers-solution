import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class DLinkedList {
    class Node(var data: Int, var next: Node? = null, var back: Node? = null)

    private fun convertArr2DLL(arr: IntArray): Node? {
        // Create the head node with the first element of the array
        var head: Node? = Node(arr[0])
        // Initialize 'prev' to the head node
        var prev = head

        for (i in 1 until arr.size) {
            // Create a new node with data from the array and set its 'back' pointer to the previous node
            val temp = Node(arr[i], null, prev)
            // Update the 'next' pointer of the previous node to point to the new node
            prev?.next = temp
            // Move 'prev' to the newly created node for the next iteration
            prev = temp
        }
        // Return the head of the doubly linked list
        return head
    }

    private fun print(head: Node?) {
        var current = head
        while (current != null) {
            // Print the data in the current node
            print("${current.data} ")
            // Move to the next node
            current = current.next
        }
        println()
    }

    // Function to insert a new node with value 'k' at the end of the doubly linked list
    private fun insertAtTail(head: Node?, k: Int): Node? {
        // Create a new node with data 'k'
        val newNode = Node(k)

        // If the doubly linked list is empty, set 'head' to the new node
        if (head == null) {
            return newNode
        }

        // Traverse to the end of the doubly linked list
        var current = head
        while (current?.next != null) {
            current = current.next
        }

        // Connect the new node to the last node in the list
        current?.next = newNode
        newNode.back = current

        return head
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(12, 5, 6, 8, 4)
            // Convert the array to a doubly linked list
            val head = DLinkedList().convertArr2DLL(arr)

            // Print the doubly linked list
            println("Doubly Linked List Initially: ")
            DLinkedList().print(head)

            println("Doubly Linked List After Inserting before the node with value 8:")

            // Insert a node with value 10 at the end
            val updatedHead = DLinkedList().insertAtTail(head, 10)
            DLinkedList().print(updatedHead)
        }
    }
}

// Time Complexity:  O(n)
// Space Complexity: O(1)



