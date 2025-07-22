class Solution {

    private fun dfs(node: Int, col: Int, color: IntArray, adj: ArrayList<ArrayList<Int>>): Boolean {
        color[node] = col

		// traverse adjacent nodes
        for (neighbor in adj[node]) {
			// if uncoloured
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, color, adj)) return false
            } 
			// if previously coloured and have the same colour
			else if (color[neighbor] == col) {
                return false
            }
        }

        return true
    }

    fun isBipartite(V: Int, adj: ArrayList<ArrayList<Int>>): Boolean {
        val color = IntArray(V) { -1 }

		// for connected components
        for (i in 0 until V) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) return false
            }
        }

        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
			// V = 4, E = 4
            val adj = ArrayList<ArrayList<Int>>()
            for (i in 0 until 4) {
                adj.add(ArrayList())
            }

            adj[0].add(2)
            adj[2].add(0)
            adj[0].add(3)
            adj[3].add(0)
            adj[1].add(3)
            adj[3].add(1)
            adj[2].add(3)
            adj[3].add(2)

            val obj = Solution()
            val ans = obj.isBipartite(4, adj)
            println(if (ans) "1" else "0")
        }
    }
}

//  Time Complexity: O(V + E)

    Every node is visited once.

    Each edge is checked once during DFS traversal.

    So total time is proportional to the sum of vertices and edges.

//  Space Complexity: O(V)

    color[] array stores color for each node → O(V)

    Recursive DFS call stack can also go up to O(V) in the worst case.