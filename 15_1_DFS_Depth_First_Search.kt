import java.util.*

class Solution {

    // Recursive function to perform DFS traversal
    fun dfs(node: Int, vis: BooleanArray, adj: ArrayList<ArrayList<Int>>, ls: ArrayList<Int>) {
        // Mark current node as visited
        vis[node] = true
        ls.add(node)

        // Recursively visit all unvisited neighbors
        for (neighbor in adj[node]) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, ls)
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph
    fun dfsOfGraph(V: Int, adj: ArrayList<ArrayList<Int>>): ArrayList<Int> {
        val vis = BooleanArray(V)  // Boolean array to track visited nodes
        val result = ArrayList<Int>() // Stores DFS traversal order
        dfs(0, vis, adj, result) // Start DFS from node 0
        return result
    }
}

fun main() {
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0 until 5) {
        adj.add(ArrayList())
    }

    // Define edges of the graph
    adj[0].add(2)
    adj[2].add(0)
    adj[0].add(1)
    adj[1].add(0)
    adj[0].add(3)
    adj[3].add(0)
    adj[2].add(4)
    adj[4].add(2)

    val solution = Solution()
    val ans = solution.dfsOfGraph(5, adj)

    println(ans.joinToString(" ")) // Print DFS traversal result
}

// Time Complexity: O(V + E) (V = vertices, E = edges)

/*
     0
    /|\
   2 1 3
   |
   4

V = 5
Edges = [[0,2], [0,1], [0,3], [2,4]]

DFS Traversal Output:
0 2 4 1 3
 */

/*Alternative DFS Using Stack (Iterative)*/
class Solution1 {

    fun dfsOfGraph(V: Int, adj: ArrayList<ArrayList<Int>>): ArrayList<Int> {
        val vis = BooleanArray(V) // Boolean array to track visited nodes
        val stack = Stack<Int>() // Stack for DFS traversal
        val result = ArrayList<Int>() // Stores DFS traversal order

        stack.push(0) // Start DFS from node 0
        vis[0] = true

        while (stack.isNotEmpty()) {
            val node = stack.pop() // Get the last inserted node
            result.add(node)

            // Traverse all neighbors in reverse order for correct DFS order
            for (neighbor in adj[node].reversed()) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true
                    stack.push(neighbor)
                }
            }
        }
        return result
    }
}
