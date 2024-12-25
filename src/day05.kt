
fun day051() {
    val pageOrderings = readOrders("./src/day051_order.txt").sortedBy { it.first() }
    val updates = readFileAsLinesUsingUseLines("./src/day051_updates.txt", ",")

    fun checkOrder(currentUpdate: Int, update: List<Int>): Boolean {
        if(update.isEmpty()) return true
        val iterator = update.listIterator()
        while(iterator.hasNext()){
            val nextUpdate = iterator.next()
            if(pageOrderings.any{ it.first() == nextUpdate && it.last() == currentUpdate }) {
                return false
            }
        }
        return checkOrder(update.first(), update.drop(1))
    }

    val middlePages = updates.fold(0) { acc, update ->
        if(checkOrder(update[0], update.drop(1)))
            acc + update[(update.size/2).toInt()]
        else
            acc
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $middlePages")
}
