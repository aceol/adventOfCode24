import java.io.File
import kotlin.math.abs

fun main() {
    //day1Step1()
    //day1Step2()
    day021()
}

fun readFileAsLinesUsingUseLines(fileName: String): List<List<Int>>
        = File(fileName).useLines {
    it.toList().map{
            line -> line
        .split(" ")
        .filter{it.length>0}
        .map{ value -> value.toInt() }
    }
}


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

fun isValid(reports: List<Int>): Boolean{
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
