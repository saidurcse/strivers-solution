import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun traverseLevel(nodes: List<TreeNode?>, level: Int, result: MutableList<List<Int>>) {
    if (nodes.isEmpty()) return

    val values = mutableListOf<Int>()
    val nextLevelNodes = mutableListOf<TreeNode?>()

    for (node in nodes) {
        if (node != null) {
            values.add(node.`val`)
            nextLevelNodes.add(node.left)
            nextLevelNodes.add(node.right)
        }
    }

    if (values.isNotEmpty()) result.add(values)
    traverseLevel(nextLevelNodes, level + 1, result)
}

fun levelOrderRecursive(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    traverseLevel(listOf(root), 0, result)
    return result
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)

    val level = levelOrderRecursive(root)
    println("Level of the tree: $level")
}

// Time Complexity:  O(n)
// Space Complexity: O(n)

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


