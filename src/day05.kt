import java.util.Collections
import java.util.concurrent.atomic.AtomicLongFieldUpdater

fun day051() {
    val pageOrderings = readOrders("./src/day051_order.txt").sortedBy { it.first() }
    val updates = readFileAsLinesUsingUseLines("./src/day051_updates.txt", ",")

    fun checkOrder(currentUpdate: Int, update: List<Int>): Boolean {
        if(update.isEmpty()) return true
        val iterator = update.listIterator()
        while(iterator.hasNext()){
            val nextUpdate = iterator.next()
            if(areOutOfOrder(pageOrderings, nextUpdate, currentUpdate)) {
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

//4230
fun day052() {
    val pageOrderings = readOrders("./src/day051_order.txt").sortedBy { it.first() }
    val updates = readFileAsLinesUsingUseLines("./src/day051_updates.txt", ",")

    fun checkOrder(currentUpdate: Int, update: List<Int>): Pair<Int, Int>? {
        if(update.isEmpty()) return null
        val iterator = update.listIterator()
        while(iterator.hasNext()){
            val nextUpdate = iterator.next()
            if(areOutOfOrder(pageOrderings, nextUpdate, currentUpdate)) {
                return  Pair<Int, Int>(nextUpdate, currentUpdate)
            }
        }
        return checkOrder(update.first(), update.drop(1))
    }

    val middlePages = updates.fold(0) { acc, update ->

        fun swap(): Boolean{
            val toUpdate = checkOrder(update[0], update.drop(1))
            var hasSwaped = false;
                if(toUpdate != null){
                    hasSwaped = true
                    Collections.swap(update, update.indexOf(toUpdate.first), update.indexOf(toUpdate.second))
                    swap()
                }
            return hasSwaped
        }
        if(swap())
            acc + update[(update.size / 2).toInt()]
        else
            acc
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $middlePages")
}

private fun areOutOfOrder(
    pageOrderings: List<List<Int>>,
    nextUpdate: Int,
    currentUpdate: Int
): Boolean = pageOrderings.any { it.first() == nextUpdate && it.last() == currentUpdate }
