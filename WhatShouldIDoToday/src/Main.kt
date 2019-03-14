fun main() {
    println(whatShouldIDoToday())
}

fun isHot(temperature: Int) = temperature > 35
fun getMood(): String {
    print("What Is Your Mood?:")
    val mood = readLine()
    return mood ?: "happy"
}


fun whatShouldIDoToday(mood: String = getMood(), weather: String = "sunny", temperature: Int = 24): String {
    val isHappy = mood == "happy" && weather == "sunny"
    fun isSad() = mood == "sad" && weather == "rainy" && temperature == 0

    return when {
        isHappy -> "go for a walk"
        isSad() -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "stay home and read"
    }
}