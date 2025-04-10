package adv_12_2025

import Position
import getMapOfChars
import readArrayOfChars
import kotlin.math.abs

fun day121(file: String = "adv_12_2025/day12.txt"): Int {
    var chars = readArrayOfChars(file)
    var mapOfPositions = getMapOfChars(chars)
    val howMany = mapOfPositions.entries.fold(0) { price, positions ->
        println(positions.key)
        println(positions.value)
        var charRegions = positions.value.fold(mutableListOf<MutableList<Position>>(), { regions, currentPosition ->
            //println("current: $currentPosition")
            val currentPositionRegions = regions.filter {
                it.any {
                    currentPosition != it
                            && isTouching(currentPosition, it)
                }
            }
            if (currentPositionRegions.isEmpty()) regions.add(mutableListOf(currentPosition))
            else
                if (currentPositionRegions.size == 1)
                    currentPositionRegions.first().add(currentPosition)
                else {
                    regions.add(currentPositionRegions.fold(mutableListOf<Position>()) { mergedPositions, otherRegion ->
                        regions.remove(otherRegion)
                        ArrayList(mergedPositions.plus(currentPosition).union(otherRegion))
                    })
                }

            regions
        })
        //println(regions)
        getRegionsPrice(price, charRegions, positions)
    }

    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: $howMany")
    return howMany;
}

private fun getRegionsPrice(
    price: Int,
    regions: MutableList<MutableList<Position>>,
    positions: MutableMap.MutableEntry<Char, MutableList<Position>>
): Int = price + regions.fold(0) { acc, current ->
    val area = current.size
    val perimeter = getPerimeter(current)
    //println("A region of ${positions.value.size} ${positions.key} plants with price  ${area}*$perimeter = ${area * perimeter}")
    acc + area * perimeter
}

fun getPerimeter(positions: MutableList<Position>): Int {
    return positions.fold(0) { acc, current ->
        acc + 4 - positions.count { it != current && isTouching(current, it) }
    }
}

fun isTouching(currentPosition: Position, groupPosition: Position): kotlin.Boolean {
    return abs(currentPosition.x - groupPosition.x) == 1 && abs(currentPosition.y - groupPosition.y) == 0
            || abs(currentPosition.y - groupPosition.y) == 1 && abs(currentPosition.x - groupPosition.x) == 0
}
