package Acuarium

//Higher-Order-Functions
data class FishData(var name: String)

fun main() {
    fishExample()

}

fun fishExample() {
    val fish = FishData("shark").apply { name = "splashy" }
    myWith(fish.name) { println(capitalize()) }

    println(fish.run {
        name.run(::println)
        name
    })
    fish.apply(::println).apply { fish.name = "shark" }.apply(::println).name.run(::println)
}


fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

