import java.util.LinkedList
import java.util.Queue

fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var countFresh = 0

    // Add all rotten oranges to queue and count total oranges
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 2) {
                queue.offer(Pair(i, j))
            }
            if (grid[i][j] != 0) {
                countFresh++
            }
        }
    }

    if (countFresh == 0) return 0

    var countMin = 0
    var cnt = 0
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

	// bfs starting from initially rotten oranges
    while (queue.isNotEmpty()) {
        val size = queue.size
        cnt += size

        repeat(size) {
            val (x, y) = queue.poll()
            for (k in 0 until 4) {
                val newX = x + dx[k]
                val newY = y + dy[k]

                if (newX < 0 || newY < 0 || newX >= rows || newY >= cols ||
                    grid[newX][newY] == 0 || grid[newX][newY] == 2
                ) continue

                grid[newX][newY] = 2
                queue.offer(Pair(newX, newY))
            }
        }

        if (queue.isNotEmpty()) {
            countMin++
        }
    }

    return if (cnt == countFresh) countMin else -1
}

fun main() {
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )
    val result = orangesRotting(grid)
    println("Minimum Number of Minutes Required $result")
}


// Time Complexity: O(N*M)
// Space Complexity: O(N*M)

//Solution Approach (BFS):
1.Add all initial rotten oranges (2) to a queue.
2.Count total non-empty cells (fresh + rotten) to track progress.
3.Do a BFS level-order traversal (minute-by-minute), spreading the rot in all 4 directions.
4.Count how many oranges are processed (fresh + initial rotten).
5.If all oranges are rotted, return minutes; otherwise, return -1.