package mg.ships.server.domain

sealed class GameRules {

    abstract fun verifyInitialState(playerShips: Collection<Ship>)

    object NoRules : GameRules() {
        override fun verifyInitialState(playerShips: Collection<Ship>) = Unit
    }

    object Default : GameRules() {
        override fun verifyInitialState(playerShips: Collection<Ship>) {
            hasValidShipsCount(length = 4, count = 1, ships = playerShips)
            hasValidShipsCount(length = 3, count = 2, ships = playerShips)
            hasValidShipsCount(length = 2, count = 3, ships = playerShips)
            hasValidShipsCount(length = 1, count = 4, ships = playerShips)
        }
    }

    companion object {
        const val MAX_X_VALUE = 10
        const val MAX_Y_VALUE = 10
    }
}

private fun hasValidShipsCount(length: Int, count: Int, ships: Collection<Ship>) {
    val actualCount = ships.count { it.length == length }
    require(
        actualCount == count
    ) { "Illegal number of ships of length=$length, was $actualCount, was expecting $count" }
}
