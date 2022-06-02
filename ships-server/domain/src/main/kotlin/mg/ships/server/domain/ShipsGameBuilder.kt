package mg.ships.server.domain

class ShipsGameBuilder {

    fun build(): ShipsGame {
        return ShipsGame(
            state = ShipsGame.State.GAME_OVER,
            ships = emptyList()
        )
    }
}