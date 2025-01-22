// xxx
fun day111(inputName: String = "6 11 33023 4134 564 0 8922422 688775", cycles: Long = 25): Int {
    var stones = inputName.split(" ").map { it.toLong() }
    for( i in 1..cycles) {
        stones = stones.fold(mutableListOf<Long>()) { acc, stone ->
            acc.addAll(algo(stone))
            acc
            //println("$i::${stones.joLongoString(" ")}")
        }
    }


    val score = stones.size
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

fun evolve(stone: Long, cycles: Long): List<Long> {
    var evolvingStones = mutableListOf<Long>(stone)
    for (cycle in 1..cycles) {
        evolvingStones = evolvingStones.fold(mutableListOf<Long>()) { acc, stone ->
            //history.set(value, h + 1)
            acc.addAll(algo(stone))
            return@fold acc
        }
        //  println("$i::${evolvingStones.joLongoString(" ")}")
    }

    return evolvingStones
}

//261936432123724
fun day112(inputName: String = "6 11 33023 4134 564 0 8922422 688775", cycles: Int = 75): Long {
    var stones = inputName.split(" ").map { it.toLong() }
    val stonesByCyclesForStone = computeStonesByCyclesForStone(cycles)

    var score = 0.toLong()
    for(i in 1 .. cycles) {
        stones = stones.fold(mutableListOf<Long>()) { acc, stone ->
            val stoneByCycles = stonesByCyclesForStone.get(stone)
            val stonesForTheRemainingCycles = stoneByCycles?.getOrNull(cycles - i)
            if(stonesForTheRemainingCycles != null){
                //println("use cache for ${stone}, cycle ${i}")
               score += stonesForTheRemainingCycles
            } else {
                acc.addAll(algo(stone))
            }
            acc
        }
        //println("$i\t${stones.size}")
    }

    score += stones.size
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

private fun computeStonesByCyclesForStone(cycles: Int): HashMap<Long, MutableList<Long>> {
    val stonesByCyclesForStone = HashMap<Long, MutableList<Long>>()
    for (exStone in 0..9) {
        var mapStones = mutableListOf<Long>(exStone.toLong())
        for (i in 1..cycles / 2) {
            mapStones = mapStones.fold(mutableListOf<Long>()) { acc, stone ->
                acc.addAll(algo(stone))
                acc
            }
            //println("$i\t${stones.size}")
            val stonesByCycle = stonesByCyclesForStone.getOrDefault(exStone.toLong(), mutableListOf<Long>())
            //println("used cache for ${stone}")
            stonesByCycle.add(mapStones.size.toLong())
            stonesByCyclesForStone.put(exStone.toLong(), stonesByCycle)
        }
    }

    return stonesByCyclesForStone
}

fun algo(stone: Long): List<Long> {
    val acc = mutableListOf<Long>()
    if(stone == 0.toLong())
        acc.add(1.toLong())
    else if(stone.toString().length % 2 == 0){
        val asString = stone.toString()
        try {
            acc.add(asString.substring(0, asString.length / 2).toLong())
        } catch(e: Exception){
            println(asString)
            println(e)
        }

        acc.add(asString.substring(asString.length / 2, asString.length).toLong())
    } else {
        acc.add(stone*2024)
    }
    return acc
}
