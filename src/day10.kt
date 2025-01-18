
private val DOT = -1

// xxx
fun day101(inputName: String = "day10"): Int {
    val map = readArrayOfChars("./src/${inputName}.txt").map { it -> it.map{ if(it == '.') DOT else it.digitToInt() }}
    val starters = findStarts(map)

    var score = starters.fold(0){ acc: Int, starter: Position ->
        var history = mutableListOf<Position>()
        acc + move(starter, Moves.UP, map, history) + move(starter, Moves.DOWN, map, history) + move(starter, Moves.LEFT, map, history) + move(starter, Moves.RIGHT, map, history)
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

fun move(from: Position, direction: Moves, map: List<List<Int>>, history: MutableList<Position>, score: Int = 0, idx: Int = 1): Int {
    val newPosition = from.move(direction);
    if(newPosition.isOut(map))
        return score
    val newPositionIndex = map[newPosition.y][newPosition.x]
    if(newPositionIndex == 9 && idx == 9) {
        // Comment out this for day 10 part 2s
        if(history.contains(newPosition)) return score
        history.add(newPosition)
        //println("${from} (${map[from.y][from.x]}) ${newPosition} => ${score +1}")
        return score + 1
    }
    if (newPositionIndex == idx) {
        //println("${idx} goes to ${newPositionIndex} (${direction})")
        return score + (move(newPosition, Moves.UP, map, history, score, newPositionIndex+1)
            + move(newPosition, Moves.DOWN, map, history, score, newPositionIndex+1)
            + move(newPosition, Moves.LEFT, map, history, score, newPositionIndex+1)
            + move(newPosition, Moves.RIGHT, map, history, score, newPositionIndex+1))
    } else return score;
}


fun findStarts(map: List<List<Int>>): List<Position>{
    val character = 0
    return map.foldIndexed(mutableListOf()) { y: Int, acc: MutableList<Position>, line: List<Int> ->
        line.forEachIndexed { x: Int, value: Int ->
            if(value == character)
                acc.add(Position(x, y))
        }
        acc
    }
}