package mg.ships.server.domain

data class ShipsGame internal constructor(
    private val playerABoard: PlayerBoard,
    private val playerBBoard: PlayerBoard
) {

    fun isGameInProgress() = playerABoard.hasHealthyShips() || playerBBoard.hasHealthyShips()

}