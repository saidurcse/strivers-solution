data class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun inorder(root: Node?, arr: MutableList<Int>) {
    if (root == null) return

    inorder(root.left, arr)
    arr.add(root.data)
    inorder(root.right, arr)
}

fun inOrder(root: Node?): List<Int> {
    val arr = mutableListOf<Int>()
    inorder(root, arr)
    return arr
}

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left!!.left = Node(4)
    root.left!!.right = Node(5)

    val result = inOrder(root)

    print("Inorder Traversal: ")
    result.forEach { print("$it ") }
    println()
}

// Time Complexity:  O(n)
// Space Complexity: O(n) due to recursion



