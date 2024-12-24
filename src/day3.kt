
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
    val input = readTextFile("src/day03.txt");
    //xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5)sdsdgdgs?mul(2,3))
    val regex = """mul\((?<left>\d*),(\d*)\)|do\(\)|don't\(\)""".toRegex().findAll(input)
    var accept = true
    val res = regex.fold(0, { acc, next ->
        var returnValue = acc;
        val (catch, left, right) = next.groupValues;
        if(catch == "do()"){
            accept = true
        } else if(catch == "don't()") {
            accept = false
        } else if(accept) {
            returnValue = acc + (left.toInt() * right.toInt());
        }
        returnValue
    })
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $res")
}
