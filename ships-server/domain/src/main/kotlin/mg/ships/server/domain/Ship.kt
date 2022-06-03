package mg.ships.server.domain

data class Ship(
    val bowLocation: Location,
    val orientation: Orientation,
    val length: Int
) {

    init {
        require(length in 1..4)
    }

    enum class Orientation(internal val symbol: String) {
        HORIZONTAL("H"), VERTICAL("V");

        companion object {
            fun fromString(text: String): Orientation {
                return when (text) {
                    "H" -> HORIZONTAL
                    "V" -> VERTICAL
                    else -> throw IllegalArgumentException("Unknown orientation constant: $text")
                }
            }
        }
    }

    fun toFormalString(): String = "$bowLocation $length${orientation.symbol}"

    fun isHealthy(): Boolean = true

    companion object {
        fun fromFormalString(formalString: String): Ship {
            val matchedPattern = SHIP_PATTERN.matchEntire(formalString)
                ?: throw IllegalArgumentException("Malformed ship notation: $formalString")

            val location = matchedPattern.groups["location"]!!.value
                .let { Location.fromFormalString(it) }

            val length = matchedPattern.groups["length"]!!.value.toInt()

            val orientation = matchedPattern.groups["orientation"]!!.value.let { Orientation.fromString(it) }

            return Ship(
                bowLocation = location,
                orientation = orientation,
                length = length,
            )
        }
    }
}

private val SHIP_PATTERN = """(?<location>\(\d{1,2},\d{1,2}\))\s+(?<length>\d)(?<orientation>[HV])""".toRegex()