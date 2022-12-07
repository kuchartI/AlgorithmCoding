package leetcode.easy.binary_tree

//108. Convert Sorted Array to Binary Search Tree

fun main() {
    println(sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun recursion(low: Int, high: Int): TreeNode? {
        if (low > high) {
            return null
        }
        val mid = (low + high) / 2
        val root = TreeNode(nums[mid])

        root.left = recursion(low, mid - 1)
        root.right = recursion(mid + 1, high)

        return root
    }
    return recursion(0, nums.size - 1)
}