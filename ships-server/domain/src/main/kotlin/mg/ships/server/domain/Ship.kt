package mg.ships.server.domain

data class Ship(
    val bowLocation: Location,
    val length: Int
) {

    init {
        require(length in 1..4)
    }

    fun toFormalString(): String = "$bowLocation [$length]"

    fun isHealthy(): Boolean = true

    companion object {
        fun fromFormalString(formalString: String): Ship {
            val matchedPattern = SHIP_PATTERN.matchEntire(formalString)
                ?: throw IllegalArgumentException("Malformed ship notation: $formalString")

            val location = matchedPattern.groups["location"]!!.value
                .let { Location.fromFormalString(it) }
            val length = matchedPattern.groups["length"]!!.value.toInt()

            return Ship(
                bowLocation = location,
                length = length
            )
        }
    }
}

private val SHIP_PATTERN = """(?<location>\(\d{1,2},\d{1,2}\))\s+\[(?<length>\d)]""".toRegex()