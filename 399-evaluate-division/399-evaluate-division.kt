class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        /*
        1. build a graph so that :
        - start - destination = value
        - destination to start = 1/value
        2. to query
        - check two vertices exits
        if not return -1 
        else dfs to calculate
        */
        val graph: HashMap<String, MutableList<Pair<String, Double>>>
        graph = buildGraph(equations, values)
        
        var res = DoubleArray(queries.size)
        for (i in queries.indices) {
            if (!graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1))) {
                res[i] = -1.0
            } else {
                res[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), HashSet())
            }  
        }
        return res
    }
    
    fun dfs(g : HashMap<String, MutableList<Pair<String, Double>>>, st: String, des: String, visited: HashSet<String>): Double {
        var res: Double = -1.0
        if (visited.contains(st))
            return -1.0
        visited.add(st)
        for (child in g.getOrDefault(st, mutableListOf())) {
            if (child.first == des) {
                res = child.second
            } else {
                val t = dfs(g, child.first, des, visited)
                if (t != -1.0)
                    return t * child.second
            }
        }
        return res
    }
    
    fun buildGraph(equations: List<List<String>>, values: DoubleArray): HashMap<String, MutableList<Pair<String, Double>>>{
        val g = HashMap<String, MutableList<Pair<String, Double>>>()
        for (i in equations.indices) {
            var list = g.getOrDefault(equations.get(i).get(0), mutableListOf<Pair<String, Double>>())
            list.add(Pair(equations.get(i).get(1), values[i]))
            g.put(equations.get(i).get(0), list)
            var list2 = g.getOrDefault(equations.get(i).get(1), mutableListOf<Pair<String, Double>>())
            list2.add(Pair(equations.get(i).get(0), 1/values[i]))
            g.put(equations.get(i).get(1), list2)
        }
        return g
    }
}