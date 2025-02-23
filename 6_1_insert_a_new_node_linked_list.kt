import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

// This class represents a node in the singly linked list.
// Each node contains: An integer value (val). A reference (next) to the next node in the list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

object TUF {
	// This function traverses the linked list from the head and prints the values
	// The loop iterates until it reaches null, indicating the end of the list
    fun printList(head: ListNode?) {
        var curr = head
        while (curr != null) {
            print("${curr.`val`}-->")
            curr = curr.next
        }
        println("null")
    }

	// This function inserts a new node at the beginning of the linked list
    fun insertAtFirst(value: Int, head: ListNode?): ListNode {
        // Step1 : creating a new Node with the given val
        val newnode = ListNode(value)
        // Step2 : The next of the new node is set to point to the current head
        newnode.next = head
        // The new node is then returned as the new head of the list
        return newnode
    }
}

fun main() {
	// Initially, the linked list is empty (head = null).
	// Head of the LinkedList
    var head: ListNode? = null 
	// Nodes are inserted at the beginning, so the linked list is built in reverse order.
    head = TUF.insertAtFirst(40, head)
    head = TUF.insertAtFirst(30, head)
    head = TUF.insertAtFirst(20, head)
    head = TUF.insertAtFirst(10, head)
	// After these insertions, the list looks like: 10-->20-->30-->40-->null
    println("LinkedList before inserting 0 at beginning : ")
    TUF.printList(head)
    head = TUF.insertAtFirst(0, head)
    println("LinkedList after inserting 0 at beginning : ")
    TUF.printList(head)
}

// Time Complexity:  O(n) due to the printing calls, O(1) because we are just Manipulating the links, which is a constant operation.
// Space Complexity: O(1) We are not using any extra space.



