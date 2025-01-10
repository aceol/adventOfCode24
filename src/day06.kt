enum class Moves (val x: Int, val y: Int) {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    fun moveRight(): Moves {
        return when (this) {
            UP -> RIGHT
            RIGHT -> DOWN
            DOWN -> LEFT
            LEFT -> UP
        }
    }
}


fun day061() {
    val map = readArrayOfChars("./src/day061.txt")
    println(map)
    var position = initial(map)
    var direction = Moves.UP
    while(!position.isOut(map)) {
        //move(map, position, Moves.UP)
        map[position.y][position.x] = 'X'
        val newPosition = position.move(direction)
        if (!newPosition.isOut(map) && map[newPosition.y][newPosition.x] == '#') {
            //println("move ${direction.moveRight()}")
            direction = direction.moveRight()
        } else {
            position = newPosition
        }
    }
    val xs = countX(map)

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $xs")
}

fun day062() {
    val map = readArrayOfChars("./src/day061.txt")
    var loop = 0

    map.forEachIndexed { y, line -> line.forEachIndexed lineForEach@ {
        x, column ->
        var position = initial(map)
        var direction = Moves.UP
        var history = HashMap<Position, MutableList<Moves>>()
        val updatedMap = readArrayOfChars("./src/day061.txt")
        if(updatedMap[y][x] == '#' && updatedMap[y][x] == '^'){
            return@lineForEach
        }
        updatedMap[y][x] = '#'

        while(!position.isOut(updatedMap)) {
            if(isLoop(position, direction, history)){
                loop ++
                return@lineForEach
            }
            var directions = history.get(position)
            if(directions == null) history.put(position, mutableListOf(direction))
            else directions.add(direction)

            val newPosition = position.move(direction)
            if (!newPosition.isOut(updatedMap) && updatedMap[newPosition.y][newPosition.x] == '#') {
                direction = direction.moveRight()
            } else {
                position = newPosition
            }
    } }

    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $loop")
}

fun initial(map: List<List<Char>>): Position{
    val character = '^'
    val y = map.indexOfFirst { it.any {it == character} }
    val x =  map[y].indexOfFirst { it == character }
    return Position(x, y)
}


// stackOverflow error, too many recursions
fun move(map: List<MutableList<Char>>, position: Position, direction: Moves): Boolean{
    if(position.isOut(map)) {
        return false
    }
    map[position.y][position.x] = 'X'
    val newPosition = position.move(direction)
    return if(!newPosition.isOut(map) && map[newPosition.y][newPosition.x] == '#'){
        println("move ${direction.moveRight()}")
        move(map, position, direction.moveRight())
    } else {
        move(map, newPosition, direction)
    }
}


fun countX(map: List<List<Char>>): Int{
    return map.foldIndexed(0) { index, acc, next ->
        acc + map[index].count{it == 'X'}
    }
}

fun isLoop(currentPosition: Position, currentMove: Moves, past: Map<Position, List<Moves>>): Boolean {
    return past.get(currentPosition)?.contains(currentMove) == true
}
