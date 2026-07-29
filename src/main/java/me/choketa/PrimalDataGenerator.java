package me.choketa;

import me.choketa.datagen.PrimalJukeboxSongs;
import me.choketa.datagen.PrimalModelProvider;
import me.choketa.datagen.PrimalRegistryDataProvider;
import me.choketa.datagen.PrimalSoundsProvider;
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

    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.JUKEBOX_SONG, PrimalJukeboxSongs::bootstrap);
    }
}
