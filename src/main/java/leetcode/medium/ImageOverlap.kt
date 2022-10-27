package leetcode.medium

//835. Image Overlap

fun main() {
    println(
        largestOverlap(
            arrayOf(intArrayOf(1, 1, 0), intArrayOf(0, 1, 0), intArrayOf(0, 1, 0)),
            arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 1), intArrayOf(0, 0, 1))
        )
    )
}

fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
    var result = 0
    val list1 = arrayListOf<Pair<Int, Int>>()
    val list2 = arrayListOf<Pair<Int, Int>>()
    //Write only 1 in both matrix, 0 skip
    for (i in img1.indices) {
        for (j in img1.indices) {
            if (img1[i][j] == 1) {
                list1.add(Pair(i, j))
            }
            if (img2[i][j] == 1) {
                list2.add(Pair(i, j))
            }
        }
    }
    //Now we have all indices of 1 in both matrix
    //create a hashMap that will contain the difference of 1 indices
    val counterIndicesMap = hashMapOf<Pair<Int, Int>, Int>()
    for (img1Pair in list1) {
        for (img2Pair in list2) {
            //calculate difference of indices
            val pair = Pair(img1Pair.first - img2Pair.first, img1Pair.second - img2Pair.second)
            //if you have already met the same index difference, increment it
            if (counterIndicesMap.containsKey(pair)) {
                counterIndicesMap[pair] = counterIndicesMap[pair]!! + 1
            } else {
                counterIndicesMap[pair] = 1
            }
            //calculate max
            result = Math.max(result, counterIndicesMap[pair]!!)
        }
    }
    return result
}
