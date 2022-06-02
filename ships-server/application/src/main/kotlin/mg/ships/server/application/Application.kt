package mg

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import mg.plugins.*
import mg.ships.server.application.plugins.configureAdministration
import mg.ships.server.application.plugins.configureMonitoring
import mg.ships.server.application.plugins.configureRouting
import mg.ships.server.application.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureAdministration()
        configureMonitoring()
    }.start(wait = true)
}
