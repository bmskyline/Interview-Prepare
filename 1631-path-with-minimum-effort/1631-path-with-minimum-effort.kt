class Solution {
    fun minimumEffortPath(h: Array<IntArray>): Int {
        val m = h.size
        val n = h[0].size
        var max = 0
        var min = Int.MAX_VALUE;
        for (i in 0 until m) {
            for (j in 0 until n) {
                min = Math.min(min, h[i][j])
                max = Math.max(max, h[i][j])
            }
        }
        max = max - min
        min = 0
        while (min < max) {
            val m = min + (max - min) / 2
            if (isValid(h, m)) {
                max = m
            } else {
                min = m + 1
            }
        }
        return min
    }
    
    fun isValid(h: Array<IntArray>, diff: Int) : Boolean {
        val vR = arrayOf(1,-1,0,0)
        val vC = arrayOf(0,0,1,-1)
        var rows = ArrayDeque<Int>()
        var cols = ArrayDeque<Int>()
        rows.addLast(0)
        cols.addLast(0)
        var visited = Array(h.size, {BooleanArray(h[0].size)})
        visited[0][0] = true
        while(!rows.isEmpty()) {
            val size = rows.size
            for (i in 0 until size) {
                val r = rows.removeFirst()
                val c = cols.removeFirst()
                if (r == h.size - 1 && c == h[0].size - 1)
                    return true
                for (j in 0..3) {
                    val newRow = r + vR[j]
                    val newCol = c + vC[j]
                    if (newRow < 0 || newRow > h.size - 1 || newCol < 0 || newCol > h[0].size - 1 || Math.abs(h[r][c] - h[newRow][newCol]) > diff || visited[newRow][newCol])
                        continue
                    else {
                        rows.addLast(newRow)
                        cols.addLast(newCol)
                        visited[newRow][newCol] = true
                    }
                }
            }
        }
        return false
    }
}