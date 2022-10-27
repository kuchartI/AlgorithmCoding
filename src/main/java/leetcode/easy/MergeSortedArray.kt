package leetcode.easy

//88. Merge Sorted Array

fun main() {
    println(merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(4, 5, 6), 3))
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = 0
    var j = 0
    val result = IntArray(n + m)
    while (i < m || j < n) {
        if (i < m && (j == n || nums1[i] < nums2[j])) {
            result[i + j] = nums1[i]
            i++
        } else {
            result[i + j] = nums2[j]
            j++
        }
    }
    System.arraycopy(result, 0, nums1, 0, m + n)
    println(nums1.contentToString())
}