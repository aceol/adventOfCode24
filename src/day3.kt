
fun day031() {
    val input = readTextFile("src/day3.txt");
    val regex = """mul\((?<left>\d*),(\d*)\)""".toRegex().findAll(input)

    val res = regex.fold(0, { acc, next ->
        val (_, left, right) = next.groupValues;
        acc + (left.toInt() * right.toInt());
    })
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}

fun day032() {
    val input = readTextFile("src/day3.txt");
    val regex = """mul\((?<left>\d*),(\d*)\)""".toRegex().findAll(input)

    val res = regex.fold(0, { acc, next ->
        val (_, left, right) = next.groupValues;
        acc + (left.toInt() * right.toInt());
    })
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}
