import java.io.File

fun readFileAsLinesUsingUseLines(fileName: String): List<List<Int>>
        = File(fileName).useLines {
    it.toList().map{
            line -> line
        .split(" ")
        .filter{it.length>0}
        .map{ value -> value.toInt() }
    }
}

fun readTextFile(fileName: String): String
        = File(fileName).readText()
