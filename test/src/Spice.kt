/*Practice Time
Let's improve our SimpleSpice class so that we can have various spices with different levels of spiciness.

Create a new class, Spice.
Pass in a mandatory String argument for the name,
 and a String argument for the level of spiciness where the default value is mild for not spicy.
Add a variable, heat, to your class, with a getter that returns a numeric value for each type of spiciness.

Instead of the list of spices as Strings you used earlier, create a list of Spice objects and give each object a name and a spiciness level.
Add an init block that prints out the values for the object after it has been created. Create a spice.
Create a list of spices that are spicy or less than spicy. Hint: Use a filter and the heat property.
Because salt is a very common spice, create a helper function called makeSalt().*/

class smpleSpice(var name: String = "curry", var spiciness: String = "mild") {
    val heat: Int
        get() = if (spiciness.equals("mild")) 5 else 0
}

fun isHot(spiciness: String) = if (spiciness.contains("curry")) "spicy" else "mild"

class Spice(var name: String, val spiciness: String = isHot(name)) {


    val heat: Int
        get() = if (spiciness.equals("mild")) 5 else if (spiciness.equals("spicy")) 9 else 3


    init {
        println("name: \"$name\" spiciness: $spiciness heat: $heat ")
    }
}

fun filterList() {
    val mySpice = smpleSpice()
    println("name is ${mySpice.name} and heat is ${mySpice.heat} ")
    val spicesNames = listOf(
        "curry", "pepper", "cayenne",
        "ginger", "red curry", "green curry", "red pepper"
    )

    fun makeSalt(): Spice = Spice("Salt")

    val spices = mutableListOf<Spice>()
    spicesNames.forEach() { spices.add(Spice(it)) }
    spices.add(makeSalt())
    val filteredCurryList = spicesNames.filter { it.contains("curry") }.sortedBy { it.length }
    val spicesEndsWithCAndE = spicesNames.filter { (it.startsWith('c') && it.endsWith('e')) }
    val spicesEndsWithCAndE2 = spicesNames.filter { it.endsWith('e') }.filter { it.startsWith('c') }
    val spicesEndsWithC = spicesNames.take(3).filter { it.startsWith('c') }

    print("$filteredCurryList \n $spicesEndsWithCAndE \n $spicesEndsWithCAndE2 \n $spicesEndsWithC")
}
