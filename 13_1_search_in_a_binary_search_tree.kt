data class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    var current = root
    while (current != null) {
        when {
            current.`val` == `val` -> return current
            `val` < current.`val` -> current = current.left
            else -> current = current.right
        }
    }
    return null
}

fun printInOrder(root: TreeNode?) {
    if (root == null) return

    printInOrder(root.left)
    print("${root.`val`} ")
    printInOrder(root.right)
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left!!.left = TreeNode(2)
    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(10)

    println("Binary Search Tree:")
    printInOrder(root)
    println()

    val target = 6
    val result = searchBST(root, target)

    if (result != null) {
        println("Value $target found in the BST!")
    } else {
        println("Value $target not found in the BST.")
    }
}

// Time Complexity:  O(log2n)
// Space Complexity: O(1)



