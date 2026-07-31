package me.choketa;

import me.choketa.creativemodetab.PrimalCreativeModeTabs;
import me.choketa.event.PrimalPlayerEvents;
import me.choketa.item.PrimalItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimalMod implements ModInitializer {
    public static final String MOD_ID = "primalmod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        PrimalSounds.registerSounds();
        PrimalItems.registerModItems();
        PrimalCreativeModeTabs.registerModCreativeModeTabs();
        PrimalPlayerEvents.register();

    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
