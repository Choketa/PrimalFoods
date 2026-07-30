package me.choketa;

import me.choketa.creativemodetab.PrimalCreativeModeTabs;
import me.choketa.item.PrimalItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
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

        ServerPlayerEvents.AFTER_RESPAWN.register((_, newPlayer, _) -> {
            try (ServerLevel level = newPlayer.level()) {
                level.playSound(null,
                        newPlayer.getX(),
                        newPlayer.getY(),
                        newPlayer.getZ(),
                        PrimalSounds.MEEKS_MOTIVATION,
                        SoundSource.PLAYERS,
                        1.0f,
                        1.0f);

            } catch (Exception e) {
                LOGGER.error("Lol wtf", e);
            }
        });

}

public static Identifier id(String path) {
    return Identifier.fromNamespaceAndPath(MOD_ID, path);
}
}
