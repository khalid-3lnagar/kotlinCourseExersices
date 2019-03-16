package Buildings

open class BaseBuildingMaterial(open val numberNeeded: Int = 1)
class Brick() : BaseBuildingMaterial(numberNeeded = 8) {}
class Wood() : BaseBuildingMaterial(numberNeeded = 4) {}

class Building<T : BaseBuildingMaterial>
    (var buildingMaterial: T, val baseMaterialsNeeded: Int = 100) {
    fun actualMaterialsNeeded(): Int = baseMaterialsNeeded * buildingMaterial.numberNeeded


    fun build() {
        println(
            "the Building needs ${actualMaterialsNeeded()} of ${buildingMaterial::class.simpleName} to Build"
        )
    }

}

fun main() {
    val builder = Building(Wood())
    val builder2 = Building(Brick())
    builder.build()
    builder2.build()
}