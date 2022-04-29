class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        /*
        How to solve it
        loop every vertex
        - if not visited
            run dfs to coloring
        - else continue
        0 - not colored
        1 - color 1
        2 - color 2
        */
        val colored = IntArray(graph.size)
        for (i in graph.indices) {
            if (colored[i] > 0)
                continue
            if (!dfs(graph, colored, i, 1))
                return false
        }
        return true
    }
    
    fun dfs(graph: Array<IntArray>, colored: IntArray, pos: Int, color: Int): Boolean {
        colored[pos] = color
        var newColor = if (color == 1) 2 else 1
        for (i in graph[pos]) {
            if (colored[i] == 0) {
                if (!dfs(graph, colored, i, newColor))
                    return false
            } else if (colored[i] != newColor) {
                return false
            }
        }
        return true
    }
}