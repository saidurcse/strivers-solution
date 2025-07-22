import java.util.*

data class Tuple(val first: Int, val second: Int, val third: Int)

class Solution {

    fun shortestPath(grid: Array<IntArray>, source: IntArray, destination: IntArray): Int {

        // Edge Case: if the source is only the destination.
        if (source[0] == destination[0] && source[1] == destination[1]) return 0

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        val q: Queue<Tuple> = LinkedList()
        val n = grid.size
        val m = grid[0].size

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        dist[source[0]][source[1]] = 0
        q.add(Tuple(0, source[0], source[1]))

        // The following delta rows and delta columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        val dr = intArrayOf(-1, 0, 1, 0)
        val dc = intArrayOf(0, 1, 0, -1)

        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (q.isNotEmpty()) {
            val it = q.poll()
            val dis = it.first
            val r = it.second
            val c = it.third

            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for (i in 0..3) {
                val newr = r + dr[i]
                val newc = c + dc[i]

                // Checking the validity of the cell and updating if dist is shorter.
                if (newr in 0 until n && newc in 0 until m &&
                    grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]
                ) {
                    dist[newr][newc] = 1 + dis

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if (newr == destination[0] && newc == destination[1]) return dis + 1

                    q.add(Tuple(dis + 1, newr, newc))
                }
            }
        }

        // If no path is found from source to destination.
        return -1
    }
}

fun main() {
    val source = intArrayOf(0, 1)
    val destination = intArrayOf(2, 2)

    val grid = arrayOf(
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 0, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(1, 0, 0, 1)
    )

    val obj = Solution()
    val res = obj.shortestPath(grid, source, destination)

    println(res)
}

// Time Complexity: O(N * M)
   Where N = number of rows, M = number of columns.
   Every cell is visited at most once and all 4 directions are checked.

// Space Complexity: O(N * M)
   For distance matrix dist[n][m] and queue which can grow up to N*M in worst case.