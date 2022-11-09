package leetcode.medium

//901. Online Stock Span

fun main() {
    val stock = StockSpanner()
    println(stock.next(31))
    println(stock.next(41))
    println(stock.next(48))
    println(stock.next(49))
    println(stock.next(59))
    println(stock.next(79))
    println(stock.next(85))


}

class StockSpanner {

    val list = ArrayList<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var counter = 1
        while (counter <= list.size ) {
            if (list[list.size - counter].first > price) {
                list.add(Pair(price, counter))
                return counter
            } else {
                counter += list[list.size - counter].second

            }
        }
        list.add(Pair(price, counter))
        return counter
    }
}