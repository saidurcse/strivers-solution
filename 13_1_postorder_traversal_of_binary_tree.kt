data class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun postorder(root: Node?, result: MutableList<Int>) {
    if (root == null) return

    postorder(root.left, result)
    postorder(root.right, result)
    result.add(root.data)
}

fun postOrder(root: Node?): List<Int> {
    val result = mutableListOf<Int>()
    postorder(root, result)
    return result.toList()
}

fun printList(list: List<Int>) {
    list.forEach { print("$it ") }
    println()
}

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.left = Node(4)
    root.left?.right = Node(5)

    val postorderList = postOrder(root)
    println("Postorder traversal: ")
    printList(postorderList)
}

// Time Complexity:  O(n)
// Space Complexity: O(n) due to recursion



