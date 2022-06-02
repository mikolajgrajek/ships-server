package mg.ships.server.domain

class ShipsGameBuilder(
    private val gameRules: GameRules = GameRules.Default
) {

    private val playerAShips = mutableListOf<Ship>()
    private val playerBShips = mutableListOf<Ship>()

    fun build(): ShipsGame {
        gameRules.verifyInitialState(playerAShips)
        gameRules.verifyInitialState(playerBShips)

        return ShipsGame(
            playerABoard = PlayerBoard(playerAShips),
            playerBBoard = PlayerBoard(playerBShips)
        )
    }

    fun addPlayerAShip(ship: Ship): ShipsGameBuilder {
        playerAShips += ship
        return this
    }

    fun addPlayerBShip(ship: Ship): ShipsGameBuilder {
        playerBShips += ship
        return this
    }

}

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

}

private fun hasValidShipsCount(length: Int, count: Int, ships: Collection<Ship>) {
    val actualCount = ships.count { it.length == length }
    require(
        actualCount == count
    ) { "Illegal number of ships of length=$length, was $actualCount, was expecting $count" }
}
