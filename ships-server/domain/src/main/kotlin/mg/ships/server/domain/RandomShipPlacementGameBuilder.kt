package mg.ships.server.domain

import kotlin.random.Random

class RandomShipPlacementGameBuilder(
    private val gameRules: GameRules = GameRules.Default
) {

    fun create(): ShipsGame {
        return ShipsGameBuilder(gameRules = gameRules)
            .addPlayerAShip(shipWithRandomLocation(shipLength = 4))
            .addPlayerAShip(shipWithRandomLocation(shipLength = 3))
            .build()
    }

    private fun shipWithRandomLocation(shipLength: Int): Ship {
        val orientation = if (Random.nextBoolean()) Ship.Orientation.HORIZONTAL else Ship.Orientation.VERTICAL


        Random.nextInt(1, GameRules.)
        TODO("Not yet implemented")
    }
}

