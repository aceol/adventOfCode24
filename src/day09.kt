import java.util.*
import kotlin.collections.joinToString

private val diskMap = readLong("./src/day09.txt")
private val DOT = -1

// 6341711060162
fun day091() {
    val individualBlocks = getIndividualBLocks(diskMap)
    //println(individualBlocks.joinToString (""))
    val reordered = getReordered(individualBlocks)
    //println(reordered.joinToString (""))
    val checksum = getChecksum(reordered)
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${checksum}")
}

fun day092() {
    val individualBlocks = getIndividualBLocks(diskMap)
    val reordered = getReordered2(individualBlocks)
    println(reordered.map{if(it==DOT) '.' else it }.joinToString (""))
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

fun getReordered2(diskMap: MutableList<Int>): List<Int> {
    var current = diskMap.max()

    while (current > 0) {
        val countCurrentNumbers = countNextNumbers(diskMap, current)
        var switch = false
        var currentDotIndex = diskMap.indexOfFirst { it == DOT }
        val currentNumberIndex = diskMap.indexOfFirst { it == current }
        while(!switch && currentDotIndex < currentNumberIndex){
            val countNextDot = countNextNumbers(diskMap.subList(currentDotIndex, diskMap.size), DOT)
            if(countCurrentNumbers <= countNextDot){
                for(i in 0..countCurrentNumbers-1){
                    diskMap[currentDotIndex + i] = current
                    diskMap[currentNumberIndex + i] = DOT
                }
                switch  = true
           }
            var nextRelativeDotIndex = diskMap.subList(currentDotIndex + countNextDot, diskMap.size)
                .indexOfFirst { it == DOT }
            currentDotIndex = currentDotIndex + countNextDot + nextRelativeDotIndex
        }
        current --
   }
    return diskMap
}

fun areDotsInTheEnd(value: List<Int>): Boolean {
    return value.indexOfFirst { !valid(it) } + countNextNumbers(value, -1) + 1 == value.size
}

fun valid(i: Int): Boolean = i != -1

fun getChecksum(chars: List<Int>): Long =
    chars.foldIndexed(0.toLong()) { index: Int, acc: Long, value: Int ->
        if(valid(value))
            acc + value * index
        else acc
    }

fun countNextNumbers(chars: List<Int>, number: Int): Int {
    val first = chars.indexOfFirst { it == number }
    val tt = chars.subList(first, chars.size).iterator()
    var count = 0
    while(tt.hasNext() && tt.next() == number){
        count ++
    }
    return count
}