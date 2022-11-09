package leetcode.medium

//36. Valid Sudoku

fun main() {
    println(isValidSudoku(arrayOf(charArrayOf())))
}

//Shortest
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val set = hashSetOf<String>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] != '.') {
                val ch = board[i][j]
                if (!set.add(ch + "i" + i) || !set.add(ch + "j" + j) || !set.add(ch + "ji" + i / 3 + j / 3)) {
                    return false
                }
            }
        }
    }
    return true
}
//First
//fun isValidSudoku(board: Array<CharArray>): Boolean {
//    val map = hashMapOf<Char, ArrayList<Pair<Int, Int>>>()
//    for (i in board.indices) {
//        for (j in board[0].indices) {
//            if (board[i][j] != '.') {
//                if (map.containsKey(board[i][j])) {
//                    val existsCoordinate = map[board[i][j]]!!
//                    for (k in existsCoordinate.indices) {
//                        if (existsCoordinate[k].first == i || existsCoordinate[k].second == j) {
//                            return false
//                        }
//                        if (existsCoordinate[k].first / 3 == i / 3 && existsCoordinate[k].second / 3 == j / 3) {
//                            return false
//                        }
//                    }
//                    val list = map.getOrDefault(board[i][j], arrayListOf())
//                    list.add(Pair(i, j))
//                    map[board[i][j]] = list
//                } else {
//                    map[board[i][j]] = arrayListOf(Pair(i, j))
//                }
//            }
//        }
//    }
//    return true
//}