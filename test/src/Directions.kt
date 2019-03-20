enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END

}

class Game() {
    var path = mutableListOf<Directions>(Directions.START)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    private fun move(where: () -> Boolean) = where()
    fun makeMove(directionString: String): Boolean {
        val direction: () -> Boolean = when (directionString) {
            Directions.NORTH.name -> north
            Directions.SOUTH.name -> south
            Directions.EAST.name -> east
            Directions.WEST.name -> west
            else -> end
        }
        return move(direction)
    }
}


fun main() {
    val game = Game()
    println("Game: ${game.path}")
    while (true) {
        print("Enter a direction: n/s/e/w:")
        val input = readLine()
        if (!game.makeMove(input ?: "end")) break

    }
    println("Game: ${game.path}")
}