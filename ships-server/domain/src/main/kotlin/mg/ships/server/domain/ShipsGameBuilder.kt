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

