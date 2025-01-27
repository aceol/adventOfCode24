private class Cave(var name: String){
    fun isStart(): Boolean {
        return name === "start"
    }

    fun isEnd(): Boolean {
        return name === "end"
    }

    fun isBig(): Boolean {
        return name.toUpperCase().equals(name, ignoreCase = false)
    }

    override fun toString(): String{
        return name
    }
}
private class Connexion(var from: Cave, var to: Cave) {
    override fun toString(): String{
        return "${from.name}->${to.name}"
    }
}

private class Subsystems(){
    val connexions = mutableListOf<Connexion>()
    val paths = mutableListOf<List<Cave>>()

    fun addConnexion(from: String, to: String) {
        connexions.add(Connexion(Cave(from), Cave(to)))
    }

    fun addPath(path: List<Cave>){
        paths.add(path)
    }

    fun printPath() {
        paths.forEach { it -> println(it.joinToString(", ")) }
    }
}

// xxx
fun day121(inputName: String = "day12_ex_01.txt"): Int {
    val subsystems = readArrayOfStrings(inputName, "-")
        .fold(Subsystems()) { subsystem, it ->
            subsystem.addConnexion(it.first(), it.last())
            subsystem
        }
    subsystems.addPath(listOf(subsystems.connexions.first().from,subsystems.connexions.first().to))
    subsystems.printPath()

    val score = 10
    val methodName = object {}.javaClass.enclosingMethod.name
    println("Advent of code $methodName, I found an answer: ${score}")
    return score
}
