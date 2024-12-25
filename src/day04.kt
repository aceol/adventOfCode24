

fun day041() {
    val xmas = "XMAS";
    val samx = "SAMX";

    val xmasArray = readArrayOfChars("src/day04.txt");


    fun isXmas(x: Int, y: Int, search: String, incrementX: Int = 0, incrementY: Int= 0): Int{
        if(x < 0 || y >= xmasArray.size || x >= xmasArray[y].size || search.length == 0){
            return 0;
        }
        if(xmasArray[y][x] == search[0]) {
            if (search.length == 1)
                return 1;

            val newSearch = search.drop(1);
            // new search
            return if (incrementX == 0 && incrementY == 0)
                (isXmas(x, y + 1, newSearch, 0, 1)
                + isXmas(x + 1, y + 1, newSearch, 1, 1)
                + isXmas(x - 1, y + 1, newSearch,-1, 1)
                + isXmas(x + 1, y, newSearch, 1, 0))
            else isXmas(x + incrementX, y + incrementY, newSearch, incrementX, incrementY)
        }
        return 0;
    }
    var i = 0;
    xmasArray.forEachIndexed({x, row ->
        row.forEachIndexed({y, character ->
            i = i + isXmas(x, y, xmas) + isXmas(x, y, samx)
        });
    });
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $i")
}
