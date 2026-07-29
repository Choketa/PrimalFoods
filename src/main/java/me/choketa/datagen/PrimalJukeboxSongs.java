package me.choketa.datagen;

import me.choketa.PrimalMod;
import me.choketa.PrimalSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public class PrimalJukeboxSongs {
    public static final ResourceKey<JukeboxSong> FREAK_OUT_KEY =
            ResourceKey.create(Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, "freak_out"));
    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, FREAK_OUT_KEY, PrimalSounds.FREAK_OUT, 137, 15);
    }
    private static void register(BootstrapContext<JukeboxSong> context,
                                 ResourceKey<JukeboxSong> key,
                                 Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds,
                                 int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent,
                Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())),
                        lengthInSeconds, comparatorOutput));


    }
}
