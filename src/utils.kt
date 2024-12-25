import java.io.File

fun readFileAsLinesUsingUseLines(fileName: String): List<List<Int>>
        = File(fileName).useLines {
    it.toList().map{
            line -> line
        .split(" ")
        .filter{ it.isNotEmpty() }
        .map{ value -> value.toInt() }
    }
}

fun readArrayOfStrings(fileName: String, delimiter: String = ""): List<List<String>>
        = File(fileName).useLines {
        it.toList().map{
            it.split(delimiter).filter{ it.isNotEmpty() }
    }
}

fun readArrayOfChars(fileName: String, delimiter: String = ""): List<List<Char>>
= File(fileName).useLines {
    it.toList().map{
        it.toCharArray().asList()
    }
}

fun readTextFile(fileName: String): String
        = File(fileName).readText()
