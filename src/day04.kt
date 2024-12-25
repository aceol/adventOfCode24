
// 2567
fun day041() {
    val xmas = "XMAS";
    val samx = "SAMX";

    val xmasArray = readArrayOfChars("src/day04.txt");


    fun isXmas(x: Int, y: Int, search: String, incrementX: Int = 0, incrementY: Int= 0): Int{
        var isOutOfBound: Boolean = x < 0 || y >= xmasArray.size || x >= xmasArray[y].size
        if(isOutOfBound || search.length == 0)
            return 0;
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

// 2029
fun day042() {
    val xmas = "MAS";
    val samx = "SAM";

    val xmasArray = readArrayOfChars("src/day04.txt");

    fun isXmas(x: Int, y: Int, search: String, incrementX: Int = 0, incrementY: Int= 0): Int{

        var isOutOfBound: Boolean = y < 0 || x < 0 || y >= xmasArray.size || x >= xmasArray[y].size
        if(isOutOfBound || search.isEmpty()){
            return 0;
        }

        if(xmasArray[y][x] == search[0]) {
            if (search.length == 1)
                return 1

            val newSearch = search.drop(1);
            return isXmas(x + incrementX, y + incrementY, newSearch, incrementX, incrementY)
        }
        return 0;
    }

    var i = 0;
    xmasArray.forEachIndexed({y, row ->
        row.forEachIndexed({x, character ->
            if(xmasArray[y][x] == 'A') {
                i = i + (
                        (isXmas(x - 1, y - 1, xmas, 1, 1) + isXmas(x - 1 , y - 1, samx, 1, 1))
                                * (isXmas(x + 1, y - 1, xmas, -1, 1) + isXmas(x + 1 , y - 1, samx, - 1, 1)))
            }
        });
    });
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $i")
}
