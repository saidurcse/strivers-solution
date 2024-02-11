import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

object TUF {
    fun printList(head: ListNode?) { // Function to print the LinkedList
        var curr = head
        while (curr != null) {
            print("${curr.`val`}-->")
            curr = curr.next
        }
        println("null")
    }

    fun insertAtFirst(value: Int, head: ListNode?): ListNode {
        // Step1 : creating a new Node with the given val
        val newnode = ListNode(value)
        // Step2 : Making next of newly created Node to point the head of LinkedList
        newnode.next = head
        // Making the newly created Node as head
        return newnode
    }
}

fun main() {
    var head: ListNode? = null // head of the LinkedList
    head = TUF.insertAtFirst(40, head)
    head = TUF.insertAtFirst(30, head)
    head = TUF.insertAtFirst(20, head)
    head = TUF.insertAtFirst(10, head)
    println("LinkedList before inserting 0 at beginning : ")
    TUF.printList(head)
    head = TUF.insertAtFirst(0, head)
    println("LinkedList after inserting 0 at beginning : ")
    TUF.printList(head)
}

// Time Complexity:  O(n) due to the printing calls, O(1) because we are just Manipulating the links, which is a constant operation.
// Space Complexity: O(1) We are not using any extra space.



