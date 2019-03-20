fun main() {
    var fortune = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortuneCookie(getBirthday())
        println("your fortune is: \"$fortune\"")
    }
}


fun getFortuneCookie(birthday: Int): String = when (birthday) {
    1 -> "You will have a great day!"
    2 -> "Things will go well for you today."
    3 -> "Enjoy a wonderful day of success."
    4 -> "Be humble and all will turn out well."
    5 -> "Today is a good day for exercising restraint."
    6 -> "Treasure your friends because they are your greatest fortune."
    7 -> "Take it easy and enjoy life!"
    else -> "Stay patient the success coming."

}


fun getBirthday(): Int {
    print("Enter your birthday:")
    return (readLine()?.toIntOrNull() ?: 1) % 8
}