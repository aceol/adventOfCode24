fun isValid(reports: List<Int>): Boolean {
        val diff = mutableListOf<Int>()
        var previous = -1;
    for (index in reports.indices) {
        val level = reports[index]
        if (previous != -1)
            diff.add(level - previous)
        previous = level;
    }

    //print("$it ::")
    diff.sort();
    val increase =
            (diff.first() > 0 && diff.last() < 4) || (diff.first() > -4 && diff.last() < 0)
    val isDecreasingOrIncreasing = (diff.first() * diff.last()) >= 0
    //println("diff :: $increase $isDecreasingOrIncreasing")
    return increase && isDecreasingOrIncreasing
}


    //day 2
// 379
fun day021() {
    val data = readFileAsLinesUsingUseLines("./src/day2.txt");

    val safeCount = data.map { isValid(it) }.count {it}

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $safeCount")
}

fun day022() {
    val data = readFileAsLinesUsingUseLines("./src/day2.txt");
    val safeCount = data.map {
        val iterator = it.listIterator()
        var valid = isValid(it)
        while(iterator.hasNext() && !valid) {
            val truncatedList = it.toMutableList()
            truncatedList.removeAt(iterator.nextIndex())
            valid = isValid(truncatedList)
            iterator.next()
        }
        valid
    }.count { it }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $safeCount")
}


