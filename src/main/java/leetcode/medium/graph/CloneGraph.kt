package leetcode.medium.graph

//133. Clone Graph

fun main() {
    val graph = Node(1)
    graph.neighbors = arrayListOf(Node(2), Node(4))
    graph.neighbors[0]!!.neighbors = arrayListOf(graph, Node(3))
    graph.neighbors[1]!!.neighbors = arrayListOf(graph, graph.neighbors[0]!!.neighbors[1])
    graph.neighbors[0]!!.neighbors[1]!!.neighbors = arrayListOf(graph.neighbors[0], graph.neighbors[1])

    println(cloneGraph(graph))
}

fun cloneGraph(node: Node?): Node? {
    if (node == null) {
        return null
    }
    if (node.neighbors.isEmpty()) {
        return Node(node.`val`)
    }
    val newNodes = HashMap<Int, Node?>()
    val resultGraph = Node(node.`val`)
    newNodes[node.`val`] = resultGraph
    fun dfs(node: Node?) {
        node!!.neighbors.forEach { i ->
            if (!newNodes.containsKey(i!!.`val`)) {
                newNodes[i.`val`] = Node(i.`val`)
                dfs(i)
            }
            newNodes[node.`val`]!!.neighbors.add(newNodes[i.`val`])
        }
    }
    dfs(node)

    return resultGraph
}