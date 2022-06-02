package mg.ships.server.domain

internal data class PlayerBoard(
    private val ships: Collection<Ship>
) {
    fun hasHealthyShips(): Boolean = ships.any { it.isHealthy() }
}