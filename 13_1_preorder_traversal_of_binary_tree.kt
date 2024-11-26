data class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun preorder(root: Node?, list: MutableList<Int>) {
    if (root == null) return

    list.add(root.data)
    preorder(root.left, list)
    preorder(root.right, list)
}

fun preOrder(root: Node?): List<Int> {
    val list = mutableListOf<Int>()
    preorder(root, list)
    return list
}

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.left = Node(4)
    root.left?.right= Node(5)

    val result = preOrder(root)

    println("Preorder Traversal: ${result.joinToString(" ")}")
}

// Time Complexity:  O(n)
// Space Complexity: O(n) due to recursion



