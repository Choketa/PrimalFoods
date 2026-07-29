package me.choketa;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;

public class PrimalUtils {
    public static void punishPlayer(Player player) {
        player.playSound(PrimalSounds.GOATIS_CORTISOL, 2.0f, 1.0f);
        player.animateHurt(0f);
        player.playSound(SoundEvents.PLAYER_HURT, 1.0f, 1.0f);
        player.setHealth(player.getHealth()-2.0f);
    }
}
