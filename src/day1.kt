import kotlin.math.abs

fun day1Step1(){
    val data = readFileAsLinesUsingUseLines("./src/day1_ex.txt");
    val left = mutableListOf<Int>();
    val right= mutableListOf<Int>();
    data.listIterator().forEach { left.add(it.first()); right.add(it.last()); }
    left.sort()
    right.sort()
    val index = left.foldIndexed(0) { index, acc, next ->
        //val x = right.elementAt(index)
        //val distance = abs(next - right.elementAt(index))
        //println("$index, $next - $x $distance => $acc ")
        acc + abs(next - right.elementAt(index))
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $index")
}


fun day1Step2() {
    val data = readFileAsLinesUsingUseLines("./src/day1.txt");
    val left = mutableListOf<Int>();
    val right= mutableListOf<Int>();
    data.listIterator().forEach { left.add(it.first()); right.add(it.last()); }
    left.sort()
    right.sort()
    val  rightM = right.groupBy{it -> it}

    val index = left.fold(0){ acc, value ->
        val rightNumber = rightM.get(value)?.count() ?: 0
        acc + (value * rightNumber)
    }
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $index")
}
