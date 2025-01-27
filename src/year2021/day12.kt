package year2021

import readArrayOfStrings

private data class Cave(var name: String) {
    fun isStart(): Boolean {
        return name == "start"
    }

    fun isEnd(): Boolean {
        return name == "end"
    }

    fun isBig(): Boolean {
        return name.toUpperCase().equals(name, ignoreCase = false)
    }

    override fun toString(): String {
        return name
    }
}

private data class Connexion(var from: Cave, var to: Cave) {
    override fun toString(): String {
        return "${from.name}->${to.name}"
    }
}

private class Subsystems() {
    val connexions = mutableListOf<Connexion>()
    val paths = mutableListOf<List<Cave>>()

    fun addConnexion(from: String, to: String) =
        connexions.add(Connexion(Cave(from), Cave(to)))

    fun nexts(cave: Cave, previous: List<Cave>): List<Cave> =
        connexions
            .filter {
                it.from == cave
                        && (it.to.isBig() || !previous.contains(it.to))
            }
            .map { it.to }
            .plus(connexions.filter {
                it.to == cave
                        && (it.from.isBig() || !previous.contains(it.from))
            }.map { it.from })

    fun start(): Cave {
        //val connexion = connexions.find { it.from.name == "start" }
        return Cave("start")
    }


    fun addPath(path: List<Cave>) {
        paths.add(path)
    }

    fun printPath() {
        paths.forEach { it -> println(it.joinToString(", ")) }
    }
}

// xxx
fun day121(inputName: String = "./src/day12.txt"): Int {
    val subsystems = readArrayOfStrings(inputName, "-")
        .fold(Subsystems()) { subsystem, it ->
            subsystem.addConnexion(it.first(), it.last())
            subsystem
        }
    update(listOf(subsystems.start()), subsystems)

    subsystems.printPath()
    val score = subsystems.paths.size
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}

private fun update(list: List<Cave>, subsystems: Subsystems) {
    var current = list.last()
    if (current.isEnd()) {
        subsystems.addPath(list)
        return
    }
    subsystems.nexts(current, list).map {
        update(list.plus(it), subsystems)
    }
}

