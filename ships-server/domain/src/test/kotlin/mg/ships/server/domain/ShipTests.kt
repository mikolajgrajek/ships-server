package mg.ships.server.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ShipTests {

    @Test
    fun `test serialization`() {
        val ship = Ship(
            bowLocation = Location(1, 1),
            length = 4
        )
        Assertions.assertEquals("(1,1) [4]", ship.toFormalString())
    }

    @Test
    fun `test deserialization`() {
        val ship = Ship(
            bowLocation = Location(1, 1),
            length = 4
        )
        Assertions.assertEquals(ship, Ship.fromFormalString("(1,1) [4]"))
    }

}