val map = readArrayOfStrings("./src/day07.txt", ":").associateBy(
    {it.get(0).toLong()}, {it.get(1).split(" ").filter{it -> it.isNotEmpty()}.map(String::toLong)}
).toMap()

fun day071() {
    val res = map.entries.fold(0.toLong()) {acc, entry ->
        if(compose(entry.value).contains(entry.key))
            acc + entry.key
        else
            acc
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}

fun day072() {
    val res = map.entries.fold(0.toLong()) {acc, entry ->
        if(compose(entry.value, 2).contains(entry.key))
            acc + entry.key
        else
            acc
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}

fun multiply (left:Long, right: Long): Long { return left * right}
fun add (left:Long, right: Long): Long { return left + right}
fun concat (left:Long, right: Long): Long { return (left.toString() + right.toString()).toLong()}
val operations: List<(Long, Long) -> Long> = listOf(::multiply, ::add, :: concat)


fun addOperations(currentResult: Long, values: List<Long>, results: MutableList<Long>, index: Int, maxOp: Int){
    if(values.isEmpty()){
        results.add(currentResult)
    } else {
        val newResult = operations[index](currentResult, values.first())
        for(i in 0..maxOp) {
            addOperations(newResult, values.drop(1), results, i, maxOp)
        }
    }
}

fun compose(values: List<Long>, maxOp: Int = 1): List<Long> {
    val results = mutableListOf<Long>()
    for(i in 0..maxOp) {
        addOperations(values.first(), values.drop(1), results, i, maxOp)
    }
    return results
}
