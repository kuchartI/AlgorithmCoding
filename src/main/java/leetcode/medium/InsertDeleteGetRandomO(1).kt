package leetcode.medium

//380. Insert Delete GetRandom O(1)

fun main() {
    val randomizedSet = RandomizedSet()
    randomizedSet.insert(1)
    randomizedSet.insert(2)
    randomizedSet.insert(3)
    randomizedSet.remove(5)
    println(randomizedSet.getRandom())
}

class RandomizedSet() {

    private val randomizedSet = HashSet<Int>()

    fun insert(`val`: Int): Boolean {
        return randomizedSet.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return randomizedSet.remove(`val`)
    }

    fun getRandom(): Int {
        return randomizedSet.random()
    }

}