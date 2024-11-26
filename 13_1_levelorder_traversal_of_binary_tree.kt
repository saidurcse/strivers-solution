import java.util.*

data class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    if (root == null) return result

    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty())
    {
        val levelSize = queue.size
        val levelList = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val node = queue.poll()!!

            levelList.add(node.`val`)

            if (node.left != null) queue.add(node.left!!)
            if (node.right != null) queue.add(node.right!!)
        }

        result.add(levelList)
    }

    return result

}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    val result = levelOrder(root)

    println("Level Order Traversal of Tree:")
    result.forEach { level ->
        println(level.joinToString(" "))
    }
}

// Time Complexity:  O(n)
// Space Complexity: O(n)



