package arven.core.plugin

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameInitializationEvent
import org.spongepowered.api.plugin.Plugin

@Plugin(
    id = "arven-core", name = "Arven Core", version = "0.3.0",
    authors = ["doot"], url = "https://github.com/Arvenwood/arven-core",
    description = "A Core plugin mainly used for holding dependencies of other Arven plugins."
)
class ArvenCore @Inject constructor(logger: Logger) {

    companion object {
        lateinit var LOGGER: Logger
    }

    init {
        LOGGER = logger
    }

    @Listener
    fun onInit(event: GameInitializationEvent) {
        LOGGER.info("Initializing...")
    }
}