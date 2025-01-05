fun day071() {
    val map
     = readArrayOfStrings("./src/day07.txt", ":").associateBy(
        {it.get(0).toLong()}, {it.get(1).split(" ").filter{it -> it.isNotEmpty()}.map(String::toLong)}
     ).toMap()

    val res = map.entries.fold(0.toLong()) {acc, entry ->
        if(compose(entry.value).contains(entry.key))
            acc + entry.key
        else
            acc
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}

fun multiply (left:Long, right: Long): Long { return left * right}
fun add (left:Long, right: Long): Long { return left + right}
val operations: List<(Long, Long) -> Long> = listOf(::multiply, ::add)


fun addOperations(currentResult: Long, values: List<Long>, results: MutableList<Long>, index: Int){
    if(values.isEmpty()){
        results.add(currentResult)
    } else {
        val newResult = operations[index](currentResult, values.first())
        addOperations(newResult, values.drop(1), results, 1)
        addOperations(newResult, values.drop(1), results, 0)
    }
}

fun compose(values: List<Long>): List<Long> {
    val results = mutableListOf<Long>()
    addOperations(values.first(), values.drop(1), results, 0)
    addOperations(values.first(), values.drop(1), results, 1)
    return results
}
