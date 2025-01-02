class Position(var x: Int, var y: Int){
    override fun toString(): String {
        return "x: $x, y: $y"
    }

    override fun hashCode(): Int {
        return (x+1)*10000 + (y+1)*100
    }

    fun move(move: Moves): Position{
        return Position(x+ move.x, y + move.y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }
}



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
    while(!isOut(map, position)) {
        //move(map, position, Moves.UP)
        map[position.y][position.x] = 'X'
        val newPosition = position.move(direction)
        if (!isOut(map, newPosition) && map[newPosition.y][newPosition.x] == '#') {
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

        while(!isOut(updatedMap, position)) {
            if(isLoop(position, direction, history)){
                loop ++
                return@lineForEach
            }
            var directions = history.get(position)
            if(directions == null) history.put(position, mutableListOf(direction))
            else directions.add(direction)

            val newPosition = position.move(direction)
            if (!isOut(updatedMap, newPosition) && updatedMap[newPosition.y][newPosition.x] == '#') {
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
    val y = map.indexOfFirst { it.any {it === character} }
    val x =  map[y].indexOfFirst { it === character }
    return Position(x, y)
}


// stackOverflow error, too many recursions
fun move(map: List<MutableList<Char>>, position: Position, direction: Moves): Boolean{
    if(isOut(map, position)) {
        return false
    }
    map[position.y][position.x] = 'X'
    val newPosition = position.move(direction)
    return if(!isOut(map, newPosition) && map[newPosition.y][newPosition.x] == '#'){
        println("move ${direction.moveRight()}")
        move(map, position, direction.moveRight())
    } else {
        move(map, newPosition, direction)
    }
}

fun isOut(map: List<List<Char>>, position: Position): Boolean{
    return position.x< 0 || position.y< 0 || position.y >= map.size || position.x >= map.first().size
}
fun countX(map: List<List<Char>>): Int{
    return map.foldIndexed(0) { index, acc, next ->
        acc + map[index].count{it == 'X'}
    }
}
fun isLoop(currentPosition: Position, currentMove: Moves, past: Map<Position, List<Moves>>): Boolean {
    return past.get(currentPosition)?.contains(currentMove) ?: false
}
