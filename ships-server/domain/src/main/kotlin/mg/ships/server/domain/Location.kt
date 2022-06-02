package mg.ships.server.domain

data class Location(
    val x: Int,
    val y: Int
) {
    init {
        check(x in 1..10)
        check(y in 1..10)
    }
}

