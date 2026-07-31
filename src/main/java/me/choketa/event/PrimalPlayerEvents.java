package me.choketa.event;

import me.choketa.PrimalSounds;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.sounds.SoundSource;

public class PrimalPlayerEvents {
    public static void register() {
        ServerPlayerEvents.AFTER_RESPAWN.register(PrimalPlayerEvents::onRespawn);
    }

    private static void onRespawn(net.minecraft.server.level.ServerPlayer oldPlayer,
                                  net.minecraft.server.level.ServerPlayer newPlayer,
                                  boolean alive) {
        newPlayer.level().playSound(null,
                newPlayer.getX(),
                newPlayer.getY(),
                newPlayer.getZ(),
                PrimalSounds.MEEKS_MOTIVATION,
                SoundSource.PLAYERS,
                1.0f,
                1.0f);
    }
}
