fun day081() {
    val map = readArrayOfChars("./src/day08_ex.txt")
    //println(map)
    val antennas = find(map)
//    while(!isOut(map, position)) {
//        //move(map, position, Moves.UP)
//        map[position.y][position.x] = 'X'
//        val newPosition = position.move(direction)
//        if (!isOut(map, newPosition) && map[newPosition.y][newPosition.x] == '#') {
//            //println("move ${direction.moveRight()}")
//            direction = direction.moveRight()
//        } else {
//            position = newPosition
//        }
//    }
    //val xs = countX(map)

    println(antennas)
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: 0")
}

fun find(map: List<List<Char>>): HashMap<Char, MutableList<Position>>{
    val mapOfChars = HashMap<Char, MutableList<Position>>()
    map.forEachIndexed{ y: Int, chars: List<Char> ->
        chars.forEachIndexed{ x: Int, char: Char ->
            if(char != '.') {
                addToMap(mapOfChars, char, Position(x, y))
            }
        }
    }

    //val y = map.indexOfFirst { it.any {it === character} }
    //val x =  map[y].indexOfFirst { it === character }
    //return Position(x, y)
    return mapOfChars
}

fun addToMap(map: java.util.HashMap<Char, MutableList<Position>>, char: Char, position: Position) {
    var positions = map.get(char);
    if(positions == null) map.put(char, mutableListOf(position))
    else positions.add(position)

}

