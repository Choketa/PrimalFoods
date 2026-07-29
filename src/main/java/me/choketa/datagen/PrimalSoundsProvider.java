package me.choketa.datagen;

import me.choketa.PrimalMod;
import me.choketa.PrimalSounds;
import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;

public class PrimalSoundsProvider extends FabricSoundsProvider {

    public PrimalSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        exporter.add(PrimalSounds.FREAK_OUT,
                SoundTypeBuilder.of(PrimalSounds.FREAK_OUT.value())
                        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(
                                Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, "freak_out")).stream(true)));
    }

    @Override
    public String getName() {
        return "";
    }
}
