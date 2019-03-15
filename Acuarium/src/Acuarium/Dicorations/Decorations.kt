package Acuarium.Dicorations

fun main() {
    makeDicorations()
}

fun makeDicorations() {
    val d1 = Decorations("granite")
    println(d1)
    val d2 = Decorations("slate")
    println(d2)
    val d3 = d1.copy()
    println(d3)

    println(d2.equals(d1))
    println(d2.equals(d3))
}

data class Decorations(val rocks: String) {}