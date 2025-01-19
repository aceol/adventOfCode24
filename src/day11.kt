// xxx
fun day111(inputName: String = "6 11 33023 4134 564 0 8922422 688775", cycles: Int = 25): Int {
    var stones = inputName.split(" ").map { it.toLong() }
//    If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1.
//    If the stone is engraved with a number that has an even number of digits, it is replaced by two stones. The left half of the digits are engraved on the new left stone, and the right half of the digits are engraved on the new right stone. (The new numbers don't keep extra leading zeroes: 1000 would become stones 10 and 0.)
//    If none of the other rules apply, the stone is replaced by a new stone; the old stone's number multiplied by 2024 is engraved on the new stone.
    for( i in 1..cycles){
        stones = evolve(stones)
        //println("$i::${stones.joinToString(" ")}")
    }


    val score = stones.size
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

fun day112(inputName: String = "6 11 33023 4134 564 0 8922422 688775", cycles: Int = 75): Int {
    var stones = inputName.split(" ").map { it.toLong() }
     for( i in 1..cycles){
        stones = evolve(stones)
    }


    val score = stones.size
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

fun evolve(stones: List<Long>): MutableList<Long> {
    return stones.fold(mutableListOf<Long>()) {
            acc, value ->
        if(value == 0.toLong())
            acc.add(1.toLong())
        else if(value.toString().length % 2 == 0){
            val asString = value.toString()
            acc.add(asString.substring(0, asString.length / 2).toLong())
            acc.add(asString.substring(asString.length / 2, asString.length).toLong())
        } else {
            acc.add(value*2024)
        }
        acc
    }

}
