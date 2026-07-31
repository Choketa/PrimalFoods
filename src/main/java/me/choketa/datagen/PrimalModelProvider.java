package me.choketa.datagen;

import me.choketa.item.PrimalItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jetbrains.annotations.NotNull;

public class PrimalModelProvider extends FabricModelProvider {
    public PrimalModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NotNull BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(PrimalItems.FREAK_OUT_MUSIC_DISC, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(PrimalItems.VEGETABLE_JUICE, ModelTemplates.FLAT_ITEM);
    }
}
