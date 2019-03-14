/**
 *Create a function that takes these arguments:

tankSize (in gallons)
currentFish (a list of Ints representing the length of each fish currently in the tank)
fishSize (the length of the new fish we want to add to the tank)
hasDecorations (true if the the tank has decorations, false if not)
You can assume that typically a tank has decorations, and that a typical fish is 2 inches long.
That means you can set those values as default parameters.
 * */
fun main() {
    println(canAddFish(10.0, listOf(3, 3, 3)))//---> false
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))//---> true
    println(canAddFish(9.0, listOf(1, 1, 3), 3))//---> false
    println(canAddFish(10.0, listOf(), 7, true))//---> true
}

fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    val totalLength: Double = if (hasDecorations) tankSize.times(0.8) else tankSize
    val currentFishesSize: Double = currentFish.stream().mapToInt { x -> x }.sum() + fishSize.toDouble()
    return currentFishesSize <= totalLength
}