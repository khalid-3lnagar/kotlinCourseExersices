package Acuarium

import kotlin.math.PI

fun main() {
    val myAcuarium = buildAcuarium()
    println("default Acuarium Values\n $myAcuarium} ")
    val newAcuarium = Acuarium(width = 14, height = 53, length = 32)
    println("default constructor Acuarium Values\n $newAcuarium ")
    val anotherAcuarium = Acuarium(numberOfFish = 9)
    println("custom constructor Acuarium Values\n$anotherAcuarium")
    val fish = Fish(volumeNeeded = 5)
    val fish1 = fish.makeDefultFish()
    val fish2 = Fish()
}

fun buildAcuarium() = Acuarium()

open class Acuarium(val width: Int = 20, var height: Int = 20, val length: Int = 20) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / width * length
        }
    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water = (numberOfFish * 2000)//3cm
        val tank = water + water * 0.1
        height = (tank / (width * length)).toInt()
    }

    class TowerTank() : Acuarium() {
        override var water = volume * 0.8

        override var volume: Int
            get() = (width * height * length / 1000 * PI).toInt()
            set(value) {
                height = (value * 1000) / width * length
            }
    }

    override fun toString() = "width:${width} height: ${height} length: ${length} volume: ${volume} water:${water} "

}


class Fish(val frindley: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        println("first init")
    }

    init {
        size = if (frindley) volumeNeeded; else volumeNeeded * 2
    }

    init {
        println("constructred fish of size$volumeNeeded in size $size")
    }


    constructor() : this(false, 3) {
        println("init second constructor..")
    }


    fun makeDefultFish() = Fish(true, 5)

}
