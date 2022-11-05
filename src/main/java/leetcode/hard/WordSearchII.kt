package leetcode.hard

//212. Word Search II

fun main() {
    println(
        findWords(
            arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 'a', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v')
            ), arrayOf("aaaane", "aaaaoe", "eat", "rain")
        )
    )
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var w: String? = null
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val root = TrieNode()
    val result = ArrayList<String>()

    fun insert(w: String) {
        var node = root
        for (ch in w.toCharArray()) {
            node = node.children.getOrPut(ch) { TrieNode() }
        }
        node.w = w
    }
    for (w in words) {
        insert(w)
    }
    fun recursive(
        i: Int, j: Int, node: TrieNode, bool: Array<BooleanArray>,
        board: Array<CharArray>
    ) {
        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || bool[i][j]) {
            return
        }
        val next = node.children[board[i][j]]

        next ?: return

        next.w?.let {
            result.add(it)
            next.w = null
        }

        bool[i][j] = true

        recursive(i + 1, j, next, bool, board)
        recursive(i - 1, j, next, bool, board)
        recursive(i, j + 1, next, bool, board)
        recursive(i, j - 1, next, bool, board)

        bool[i][j] = false
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            recursive(i, j, root, Array(board.size) { BooleanArray(board[0].size) }, board)
        }
    }
    return result
}