import java.util.*

class Solution {
    // Function to return Breadth First Traversal of given graph.
    fun bfsOfGraph(V: Int, adj: ArrayList<ArrayList<Int>>): ArrayList<Int> {
        val bfs = ArrayList<Int>()   // Stores BFS traversal order
        val vis = BooleanArray(V)    // Tracks visited nodes, ensures each node is visited only once.
        val q: Queue<Int> = LinkedList() // Queue for BFS traversal

        q.add(0)        // Start BFS from node 0
        vis[0] = true   // Mark node 0 as visited

        while (q.isNotEmpty()) {
            val node = q.poll() // Dequeue front element
            bfs.add(node)       // Store in BFS order list

            for (neighbor in adj[node]) { // Traverse all adjacent nodes
                if (!vis[neighbor]) {      // If not visited
                    vis[neighbor] = true    // Mark as visited
                    q.add(neighbor)         // Enqueue neighbor
                }
            }
        }

        return bfs
    }
}

fun main() {
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0 until 5) {
        adj.add(ArrayList())
    }

    adj[0].add(1)
    adj[1].add(0)
    adj[0].add(4)
    adj[4].add(0)
    adj[1].add(2)
    adj[2].add(1)
    adj[1].add(3)
    adj[3].add(1)

    val solution = Solution()
    val ans = solution.bfsOfGraph(5, adj)

    println(ans.joinToString(" ")) // Output BFS result
}

/* Graph Representation
0
/ \
1   4
/ \
2   3

Input Adjacency List
V = 5
Edges = [[0,1], [0,4], [1,2], [1,3]]

BFS Traversal Output
0 1 4 2 3
*/