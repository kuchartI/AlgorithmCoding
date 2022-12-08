package leetcode.easy.binary_tree

//872. Leaf-Similar Trees

fun main(){
    val root1 = TreeNode(5)
    root1.left = TreeNode(2)
    root1.left!!.left = TreeNode(5)
    root1.left!!.right = TreeNode(4)
    root1.right = TreeNode(11)
    root1.right!!.right = TreeNode(7)
    val root2 = TreeNode(5)
    root2.left = TreeNode(2)
    root2.left!!.left = TreeNode(5)
    root2.left!!.right = TreeNode(4)
    root2.right = TreeNode(11)
    root2.right!!.right = TreeNode(7)
    println(leafSimilar(root1,root2))
}
fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leaves1 = ArrayList<Int>()
    val leaves2 = ArrayList<Int>()

    fun dfs(root: TreeNode?, leaves: ArrayList<Int>) {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.`val`)
            return
        }
        dfs(root.left, leaves)
        dfs(root.right, leaves)
    }

    dfs(root1, leaves1)
    dfs(root2, leaves2)
    return leaves1 == leaves2
}