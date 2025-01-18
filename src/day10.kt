private val map = readArrayOfChars("./src/day08.txt")

// 303
fun day081() {
    val antennas = getMapOfChars(map)
    val antinodes = applyDistance(antennas)
//    antinodes
//        .forEach{
//            if( map[it.y][it.x] == '.')
//                map[it.y][it.x] = '#'
//            else
//                map[it.y][it.x] = '$'
//    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${antinodes.size}")
}

// > 1037
fun day082() {
    val antennas = getMapOfChars(map)
    val antinodes = applyDistance(antennas, true)
    antinodes
        .forEach{
            if( map[it.y][it.x] == '.')
                map[it.y][it.x] = '#'
            else
                map[it.y][it.x] = '$'
    }
    printMap(map)
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${antinodes.size}")
}

fun getMapOfChars(positionsByChar: List<List<Char>>): HashMap<Char, MutableList<Position>>{
    val mapOfChars = HashMap<Char, MutableList<Position>>()
    positionsByChar.forEachIndexed{ y: Int, chars: List<Char> ->
        chars.forEachIndexed{ x: Int, char: Char ->
            if(char != '.') {
                addToMap(mapOfChars, char, Position(x, y))
            }
        }
    }
    return mapOfChars
}

fun applyDistance(map: HashMap<Char, MutableList<Position>>, extended: Boolean = false): MutableSet<Position>{
    return map.entries.fold(mutableSetOf()){ acc, it ->
        if(it.value.size>1)
            acc.addAll(it.value)
        acc.addAll(applyDistanceRec(it.value.first(), it.value.drop(1), extended))
        acc
    }
}

fun applyDistanceRec(position: Position, list: List<Position>, extended: Boolean = false, extendedUp: Boolean? = null): MutableSet<Position> {
    val antinodes = mutableSetOf<Position>()
    //println("check for $position ($list)")
    if(list.isNotEmpty()){
        list.forEach {
            //println("$position ::: $it")
            val distance = Position(it.x - position.x, it.y - position.y)
            val up = Position(position.x - distance.x, position.y - distance.y)
            val down = Position(it.x + distance.x, it.y + distance.y)
            //println("$it : $position => ${up}, ${down}")
            if(!up.isOut(map)) {
                antinodes.add(up)
                if(extendedUp == null || isGoingUp(extended, extendedUp))
                    antinodes.addAll(applyDistanceRec(up, listOf(position), extended, true))
            }
            if(!down.isOut(map)){
                antinodes.add(down)
                if(extendedUp == null || isGoingDown(extended, extendedUp))
                    antinodes.addAll(applyDistanceRec(it, listOf(down), extended, false))
            }
        }
        antinodes.addAll(applyDistanceRec(list.first(), list.drop(1), extended))
    }

    return antinodes
}

fun isGoingUp(extended: Boolean, extendedUp: Boolean): Boolean{
    return extended && extendedUp
}

fun isGoingDown(extended: Boolean, extendedUp: Boolean): Boolean{
    return extended && !extendedUp
}



fun addToMap(positionsByChar: HashMap<Char, MutableList<Position>>, char: Char, position: Position) {
    val positions = positionsByChar[char];
    if(positions == null) positionsByChar[char] = mutableListOf(position)
    else positions.add(position)

}

