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

fun readArrayOfChars(fileName: String, delimiter: String = ""): List<MutableList<Char>>
= File(fileName).useLines {
    it.toList().map{
        it.toCharArray().asList().toMutableList()
    }
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

    fun isOut(map: List<List<Char>>): Boolean{
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
