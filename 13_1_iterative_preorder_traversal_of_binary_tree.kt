import java.util.*

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun preorderTraversal(root: TreeNode?): List<Int> {

    val preorder: MutableList<Int> = ArrayList() // val preorder = mutableListOf<Int>()
    if (root == null) {
        return preorder
    }

    val stack = Stack<TreeNode?>() // val stack = mutableListOf<TreeNode>()
    stack.push(root)

    while (!stack.empty()) {
        val node = stack.pop()
        preorder.add(node!!.`val`)

        if (node.right != null) {
            stack.push(node.right)
        }

        if (node.left != null) {
            stack.push(node.left)
        }
    }

    return preorder
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)

    val result = preorderTraversal(root)

    print("Preorder Traversal: ")
    for (`val` in result) {
        print("$`val` ")
    }
    println()
}


// Time Complexity:  O(n)
// Space Complexity: O(n)



