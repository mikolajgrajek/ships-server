package mg.ships.server.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class CreateShipsGameTests {

    @Test
    fun `WHEN empty game created THEN game over`() {
        val game = ShipsGameBuilder()
            .build()

        Assertions.assertEquals(ShipsGame.State.GAME_OVER, game.state)
    }
}