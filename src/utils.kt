import java.io.File

fun readFileAsLinesUsingUseLines(fileName: String, delimiter: String = " "): List<MutableList<Int>>
        = File(fileName).useLines {
    it.toList().map{
            line -> line
        .split(delimiter)
        .filter{ it.isNotEmpty() }
        .map{ value -> value.toInt() }
        .toMutableList()
    }
}

fun readArrayOfStrings(fileName: String, delimiter: String = ""): List<List<String>>
        = File(fileName).useLines {
        it.toList().map{
            it.split(delimiter).filter{ it.isNotEmpty() }
            }
        }

fun readLong(fileName: String): String = File(fileName).useLines { it.first() }



fun readArrayOfChars(fileName: String, delimiter: String = ""): List<MutableList<Char>>
= File(fileName).useLines {
    it.toList().map{
        println(it)
        it.toCharArray().asList().toMutableList()
    }
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

fun addToMap(positionsByChar: HashMap<Char, MutableList<Position>>, char: Char, position: Position) {
    val positions = positionsByChar[char];
    if(positions == null) positionsByChar[char] = mutableListOf(position)
    else positions.add(position)

}

fun readOrders(fileName: String, delimiter: String = ""): List<List<Int>>
        = File(fileName).useLines {
    it.toList().map{
        it.split("|").map { it.toInt() }
    }
}

fun readTextFile(fileName: String): String
        = File(fileName).readText()


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

    fun<T> isOut(map: List<List<T>>): Boolean{
        return x< 0 || y< 0 || y >= map.size || x >= map.first().size
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

fun printMap(map: List<List<Char>>){
    map.forEach { println(it.joinToString ("")) }
}
