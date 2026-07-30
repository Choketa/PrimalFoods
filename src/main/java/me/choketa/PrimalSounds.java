package me.choketa;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class PrimalSounds {
    private PrimalSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    public static final SoundEvent GOATIS_CORTISOL = registerSound("goatis_cortisol");
    public static final SoundEvent DIRTY_DOG = registerSound("dirty_dog");
    public static final Holder.Reference<SoundEvent> FREAK_OUT = registerJukeboxSong("freak_out");

    private static Holder.Reference<SoundEvent> registerJukeboxSong(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, id);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    // This static method starts class initialization, which then initializes
    // the static class variables.
    public static void registerSounds() {
        PrimalMod.LOGGER.info("Registering {} Sounds", PrimalMod.MOD_ID);
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }
}