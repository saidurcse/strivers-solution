import java.util.*

fun main() {
    val V = 3
    val E = 3
    val S = 2

    val node1 = arrayListOf(arrayListOf(1, 1))
    val node2 = arrayListOf(arrayListOf(2, 6))
    val node3 = arrayListOf(arrayListOf(2, 3))
    val node4 = arrayListOf(arrayListOf(0, 1))
    val node5 = arrayListOf(arrayListOf(1, 3))
    val node6 = arrayListOf(arrayListOf(0, 6))

    val inter1 = arrayListOf(node1, node2)
    val inter2 = arrayListOf(node3, node4)
    val inter3 = arrayListOf(node5, node6)

    val adj = arrayListOf(
        inter1, // for 1st node
        inter2, // for 2nd node
        inter3  // for 3rd node
    )

    //add final values of adj here.
    val obj = Solution()
    val res = obj.dijkstra(V, adj, S)

    for (i in 0 until V) {
        print("${res[i]} ")
    }
    println()
}

class Pair(val distance: Int, val node: Int)

class Solution {
     // Function to find the shortest distance of all the vertices from the source vertex S.
    fun dijkstra(
        V: Int,
        adj: ArrayList<ArrayList<ArrayList<Int>>>,
        S: Int
    ): IntArray {
	
		// Create a priority queue for storing the nodes as a pair {dist, node
        // where dist is the distance from source to the node. 
        val pq = PriorityQueue<Pair>(compareBy { it.distance })
        
		// Initialising distTo list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
		val dist = IntArray(V) { Int.MAX_VALUE }

		// Source initialised with dist=0.
        dist[S] = 0
        pq.add(Pair(0, S))

		// Now, pop the minimum distance node first from the min-heap
        // and traverse for all its adjacent nodes.
        while (pq.isNotEmpty()) {
            val (dis, node) = pq.poll()

			// Check for all adjacent nodes of the popped out
            // element whether the prev dist is larger than current or not.
            for (i in adj[node].indices) {
                val adjNode = adj[node][i][0]
                val edgeWeight = adj[node][i][1]

				// If current distance is smaller,
                // push it into the queue.
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight
                    pq.add(Pair(dist[adjNode], adjNode))
                }
            }
        }
		
		// Return the list containing shortest distances
        // from source to all the nodes.
        return dist
    }
}

Output: 

4 3 0

// Time Complexity: O((V + E) * log V)

Explanation:

    V is the number of vertices.

    E is the number of edges.

    For each node, we may insert it into the priority queue.

    For each edge, we may update the distance and insert its target node into the priority queue.

    The priority queue (min-heap) operations take log V time (for insertion and removal).

Hence, the total time is: O((V + E) * log V)

// Space Complexity: O(V + E)

Explanation:

    dist[] array of size V.

    adj stores all E edges.

    Priority queue may hold up to V nodes in the worst case.

So overall: O(V + E)
