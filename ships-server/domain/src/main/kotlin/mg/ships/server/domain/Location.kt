package mg.ships.server.domain

data class Location(
    val x: Int,
    val y: Int
) {
    init {
        require(x in 1..GameRules.MAX_X_VALUE)
        require(y in 1..GameRules.MAX_Y_VALUE)
    }


    fun toFormalString(): String = "($x,$y)"

    override fun toString(): String = toFormalString()

    companion object {
        fun fromFormalString(formalString: String): Location {
            val matched = LOCATION_PATTERN.matchEntire(formalString)
                ?: throw IllegalArgumentException("Cannot parse location: $formalString")

            return Location(
                matched.groups["x"]!!.value.toInt(),
                matched.groups["y"]!!.value.toInt()
            )
        }
    }
}

private val LOCATION_PATTERN = """\((?<x>\d{1,2}),(?<y>\d{1,2})\)""".toRegex()