package mg.ships.server.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class CreateShipsGameTests {

    @Test
    fun `WHEN empty game created THEN game over`() {
        val game = ShipsGameBuilder()
            .build()

        Assertions.assertFalse(game.isGameInProgress())
    }

    @Test
    fun `WHEN one ship game created THEN game in progress`() {
        val game = ShipsGameBuilder()
            .addPlayerAShip(Ship.fromFormalString("(1,1) [4]"))
            .addPlayerBShip(Ship.fromFormalString("(1,1) [4]"))
            .build()

        Assertions.assertTrue(game.isGameInProgress())
    }

}