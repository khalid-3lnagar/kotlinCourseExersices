fun main() {//play with filter
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    val filteredCurryList = spices.filter { it.contains("curry") }.sortedBy { it.length }
    val spicesEndsWithCAndE = spices.filter { (it.startsWith('c') && it.endsWith('e')) }
    val spicesEndsWithCAndE2 = spices.filter { it.endsWith('e') }.filter { it.startsWith('c') }
    val spicesEndsWithC = spices.take(3).filter { it.startsWith('c') }

    print("$filteredCurryList \n $spicesEndsWithCAndE \n $spicesEndsWithCAndE2 \n $spicesEndsWithC")
}