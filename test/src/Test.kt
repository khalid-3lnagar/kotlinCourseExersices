import java.util.*

/**
 * Why would you want to use the function type notation instead of just the lambda?
 * >>Function type notation is more readable, which reduces errors,
 * clearly showing the what type is passed in and what type is returned.
 *
 * Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
 * Pass your rollDice2 function as an argument to gamePlay()
 * to generate a dice roll every time gamePlay() is called.
 * */
fun main() {

    //play with filter
    filterList()
    //lambda and Named Function in different ways
    gamePlay(rollDice0(3))
    gamePlay(rollDice1())
    gamePlay(rollDice2)
    gamePlay(rollDice3)
    gamePlay {
        when (it) {
            0 -> 0
            else -> Random().nextInt(it) + 1
        }
    }

}


//lambda and named functions different ways to declare same logic
fun rollDice0(sides: Int): Int {
    return when (sides) {
        0 -> 0
        else -> Random().nextInt(sides) + 1
    }
}

fun rollDice1(): (Int) -> Int = {
    when (it) {
        0 -> 0
        else -> Random().nextInt(it) + 1
    }
}

val rollDice2 = { diceSide: Int ->
    when (diceSide) {
        0 -> 0
        else -> Random().nextInt(diceSide) + 1
    }
}
val rollDice3: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

fun gamePlay(roll: (Int) -> Int) {
    println("${roll(3)}")
}

fun gamePlay(roll: Int) {
    println(roll)
}