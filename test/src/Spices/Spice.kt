package Spices

/*Practice Time
Let's improve our SimpleSpice class so that we can have various spices with different levels of spiciness.

Create a new class, Spices.Spice.
Pass in a mandatory String argument for the name,
 and a String argument for the level of spiciness where the default value is mild for not spicy.
Add a variable, heat, to your class, with a getter that returns a numeric value for each type of spiciness.

Instead of the list of spices as Strings you used earlier, create a list of Spices.Spice objects and give each object a name and a spiciness level.
Add an init block that prints out the values for the object after it has been created. Create a spice.
Create a list of spices that are spicy or less than spicy. Hint: Use a filter and the heat property.
Because salt is a very common spice, create a helper function called makeSalt().*/
fun main() {
    //filterList()
    val myContainer = SpiceContainer(Curry("spicy"))
    val myContainer2 = SpiceContainer(Curry("mild"))
    println(
        "1 $myContainer\n 2 $myContainer2 \n" +
                "is the Same?${myContainer.equals(myContainer2)} "
    )
}

sealed class Spice(var name: String, val spiciness: String = isHot(name)) :
    SpiceColor by YellowSpiceColor {


    val heat: Int
        get() = if (spiciness.equals("mild")) 5 else if (spiciness.equals("spicy")) 9 else 3

    init {
        println("name: \"$name\" spiciness: $spiciness heat: $heat  color: $color")
    }


}

//delegation
class Curry(spiciness: String) : Spice("curry", spiciness),
    Grinder {
    override fun grind() {

    }

}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    var color: Color
}

//Create a singleton subclass
object YellowSpiceColor : SpiceColor {
    override var color = Color.YELLOW

}

data class SpiceContainer(val spice: Spice, val lable: String = spice.name) {}
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

fun isHot(spiciness: String) = if (spiciness.contains("curry")) "spicy" else "mild"
fun filterList() {
    val spicesNames = listOf(
        "curry", "pepper", "cayenne",
        "ginger", "red curry", "green curry", "red pepper"
    )


    val spices = mutableListOf<Spice>()
    spicesNames.forEach() { spices.add(Curry(it)) }

    spices.add(Curry("spicy"))
    val filteredCurryList = spicesNames
        .filter { it.contains("curry") }.sortedBy { it.length }
    val spicesEndsWithCAndE = spicesNames
        .filter { (it.startsWith('c') && it.endsWith('e')) }
    val spicesEndsWithCAndE2 = spicesNames
        .filter { it.endsWith('e') }.filter { it.startsWith('c') }
    val spicesEndsWithC = spicesNames
        .take(3).filter { it.startsWith('c') }

    print("${filteredCurryList} \n $spicesEndsWithCAndE \n $spicesEndsWithCAndE2 \n $spicesEndsWithC")
}

