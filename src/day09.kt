import java.util.*

private val diskMap = readLong("./src/day09.txt")

//
fun day091() {
    val individualBlocks = getIndividualBLocks(diskMap)
    //println(individualBlocks.joinToString (""))
    val reordered = getReordered(individualBlocks)
    //println(reordered.joinToString (""))
    val checksum = getChecksum(reordered)
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${checksum}")
}

fun getIndividualBLocks(diskMap: String): MutableList<Int> {
    var isEmpty = false
    var count = 0
    return diskMap.split("").filterNot { it.isEmpty() }.fold(mutableListOf()) { individualBLocks, block ->
        val toAdd = if (isEmpty) -1 else count++
        isEmpty = !isEmpty
        individualBLocks.addAll(List(block.toInt()) { toAdd })
        individualBLocks
    }
}

fun getReordered(diskMap: MutableList<Int>): List<Int> {
    while (!areDotsInTheEnd(diskMap)) {
        val right = diskMap.indexOfLast { valid(it) }
        val firstDot = diskMap.indexOfFirst { !valid(it) }
        Collections.swap(diskMap, firstDot, right)
    }
    return diskMap
}

fun areDotsInTheEnd(value: List<Int>): Boolean {
    return value.subList(value.indexOfFirst { !valid(it) }, value.size - 1).all { !valid(it) }
}

fun valid(i: Int): Boolean = i != -1

fun getChecksum(chars: List<Int>): Long =
    chars.filter { valid(it) }.foldIndexed(0.toLong()) { index: Int, acc: Long, value: Int ->
        acc + value * index
    }