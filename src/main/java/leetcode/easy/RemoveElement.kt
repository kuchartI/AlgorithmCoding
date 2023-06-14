package leetcode.easy

//27. Remove Element
fun main() {
    println(removeElement(intArrayOf(4,5), 4))
    println(removeElement2(intArrayOf(0,1,2,2,3,0,4,2), 2))
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        while(right > 0 && nums[right] == `val`) {
            right--
        }
        if (`val` == nums[left]) {
            if (left >= right) {
                break
            }
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }
        left++
    }
    return left
}
fun removeElement2(nums: IntArray, `val`: Int): Int {
    var counter = 0
    for (i in nums.indices){
        if(`val` != nums[i]){
            nums[counter] = nums[i]
            counter++
        }
    }
    return counter
}