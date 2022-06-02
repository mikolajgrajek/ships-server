package mg.ships.server.domain

class ShipsGameBuilder {

    private val playerAShips = mutableListOf<Ship>()
    private val playerBShips = mutableListOf<Ship>()

    fun build(): ShipsGame {
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