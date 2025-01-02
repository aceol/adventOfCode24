class Position(var x: Int, var y: Int){
    override fun toString(): String {
        return "x: $x, y: $y"
    }

    fun move(move: Moves): Position{
        return Position(x+ move.x, y + move.y)
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
