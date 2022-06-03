package mg.ships.server.domain.placement

import mg.ships.server.domain.GameRules
import mg.ships.server.domain.Location
import mg.ships.server.domain.Ship

internal class RandomPlacementSelector : ShipPlacementSelector {
    private val freeLocations: Collection<Location> = generateLocationsForWholeBoard()

    fun nextRandomLocation(shipLength: Int, shipOrientation: Ship.Orientation): Location {
        TODO()
    }

}


private fun generateLocationsForWholeBoard(): Collection<Location> {
    val result = mutableListOf<Location>()
    for (x in 1..GameRules.MAX_X_VALUE) {
        for (y in 1..GameRules.MAX_Y_VALUE) {
            result += Location(x, y)
        }
    }
    return result.toList()
}