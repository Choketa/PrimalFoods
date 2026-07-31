package me.choketa;

import me.choketa.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class PrimalDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(PrimalRegistryDataProvider::new);
        pack.addProvider(PrimalModelProvider::new);
        pack.addProvider(PrimalSoundsProvider::new);
        pack.addProvider(PrimalRecipeProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.JUKEBOX_SONG, PrimalJukeboxSongs::bootstrap);
    }
}
