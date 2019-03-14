import java.util.*

fun main(args: Array<String>) {

    println(if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin")
    dayOfWeak()
}

fun dayOfWeak() {
    val days = listOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val dayOftheWeak = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    println("What day is today?\n the day of the weak is ${days[dayOftheWeak - 1]}")

}