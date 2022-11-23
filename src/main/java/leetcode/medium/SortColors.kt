package leetcode.medium

//75. Sort Colors

fun main() {
    println(sortColors(intArrayOf(2, 0, 2, 1, 1, 0)))
    println(sortColors2(intArrayOf(2, 0, 2, 1, 1, 0)))
}

fun sortColors(nums: IntArray) {
    var zeros = 0
    var ones = 0
    var twos = 0
    for (i in nums) {
        when (i) {
            0 -> { zeros++ }
            1 -> { ones++ }
            else -> { twos++ }
        }
    }
    var counter = 0
    while (counter < nums.size){
        while (zeros > 0) {
            nums[counter] = 0
            zeros--
            counter++
        }
        while (ones > 0) {
            nums[counter] = 1
            ones--
            counter++
        }
        while (twos > 0) {
            nums[counter] = 2
            twos--
            counter++
        }
    }

    println(nums.contentToString())
}

//QuickSort
fun sortColors2(nums: IntArray) {
    fun quickSort(left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val mid = (left + right) / 2
        val pivot = nums[mid]
        var i = left
        var j = right
        while (i <= j) {
            while (nums[i] < pivot && i <= j) {
                i++
            }
            while (nums[j] > pivot && i <= j) {
                j--
            }
            if (i <= j) {
                val temp = nums[j]
                nums[j] = nums[i]
                nums[i] = temp
                j--
                i++
            }
        }
        quickSort(i, right)
        quickSort(left, j)
    }

    quickSort(0, nums.size - 1)

    println(nums.contentToString())
}