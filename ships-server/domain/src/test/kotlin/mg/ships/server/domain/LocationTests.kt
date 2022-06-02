package mg.ships.server.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LocationTests {

    @Test
    fun `test deserialization of valid location 1,1`() {
        Assertions.assertEquals(
            Location(1, 1),
            Location.fromFormalString("(1,1)")
        )
    }

    @Test
    fun `test deserialization of valid location 10,10`() {
        Assertions.assertEquals(
            Location(10, 10),
            Location.fromFormalString("(10,10)")
        )
    }

    @ValueSource(strings = ["(0,1)", "(-1,1)", "(11,1)", "(1,-1)", "(1,0)", "(1,11)"])
    @ParameterizedTest
    fun `test deserialization of invalid location`(serializedForm: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Location.fromFormalString(serializedForm)
        }
    }

    @Test
    fun `test serialization of valid location 10,10`() {
        Assertions.assertEquals(
            "(10,10)",
            Location(10, 10).toFormalString()
        )
    }

}