package Acuarium

abstract class AcuariumFish {
    abstract val color: String
}

class Shark : AcuariumFish(), FishAction {
    override fun eat() {
        println("hunt and eat fish")
    }

    override val color: String = "gray"
}

class Plecostomus() : AcuariumFish(), FishAction {
    override fun eat() {
        println("munch on algea")

    }

    override val color: String = "gold"
}

interface FishAction {
    fun eat()
}