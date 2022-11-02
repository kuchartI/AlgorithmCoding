package leetcode.medium

//433. Minimum Genetic Mutation

fun main() {
    println(
        minMutation(
            "AAAAAAAA",
            "AAGTAAAA",
            arrayOf("CAAAAAAA", "CCAAAAAA", "CCATAAAA", "CCGTAAAA", "CAGTAAAA", "AAGTAAAA")
        )
    )
}

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    val gens = setOf(start, end, *bank)
    val allowed = bank.toHashSet()
    val mutatuinGraph = gens.associateWith { mutableSetOf<String>() }
    for (i in gens) {
        for (j in gens) {
            if (findMutation(i, j) && allowed.contains(j)) {
                mutatuinGraph[i]!!.add(j)
            }
        }
    }
    return graphSearch(mutatuinGraph, hashSetOf(), end, listOf(start)) ?: -1
}

fun graphSearch(
    mutatuinGraph: Map<String, Set<String>>,
    visited: HashSet<String>,
    end: String,
    current: List<String>
): Int? {
    if (current.isEmpty()) return null
    visited.addAll(current)
    if (visited.contains(end)) return 0
    return graphSearch(
        mutatuinGraph,
        visited,
        end,
        current.flatMap { mutatuinGraph[it]!! }.filterNot { visited.contains(it) })?.let { it + 1 }
}

fun findMutation(gen1: String, gen2: String): Boolean {
    return gen1.zip(gen2).filterNot { it.first == it.second }.size == 1

}