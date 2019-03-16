package Buildings

open class BaseBuildingMaterial(open val numberNeeded: Int = 1)
class Brick() : BaseBuildingMaterial(numberNeeded = 8) {}
class Wood() : BaseBuildingMaterial(numberNeeded = 4) {}

class Building<out T : BaseBuildingMaterial>
    (val buildingMaterial: T, val baseMaterialsNeeded: Int = 100) {
    fun actualMaterialsNeeded(): Int = baseMaterialsNeeded * buildingMaterial.numberNeeded


    fun build() {
        println(
            "the Building needs ${actualMaterialsNeeded()} of ${buildingMaterial::class.simpleName} to Build"
        )
    }

}

fun <R : BaseBuildingMaterial> isSmallBuilding(building: Building<R>) =
    if (building.actualMaterialsNeeded() < 500) "small building" else "large building"


fun main() {
    fun Building<*>.isSmallBuilding() = if (this.actualMaterialsNeeded() < 500) "small building" else "large building"
    val builder = Building(Wood())
    val builder2 = Building(Brick())
    builder.build()
    println(isSmallBuilding(builder))
    println(builder.isSmallBuilding())
    builder2.build()
    println(isSmallBuilding(builder2))
    println(builder2.isSmallBuilding())
}
