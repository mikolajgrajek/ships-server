package mg.ships.server.domain

data class ShipsGame(
    val state: State,
    val ships: Collection<Ship>
) {
    enum class State {
        IN_PROGRESS, GAME_OVER
    }
}