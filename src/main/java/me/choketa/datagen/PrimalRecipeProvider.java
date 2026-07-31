package me.choketa.datagen;

import me.choketa.item.PrimalItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class PrimalRecipeProvider extends FabricRecipeProvider {
    public PrimalRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider registries, @NotNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.FOOD, PrimalItems.VEGETABLE_JUICE)
                        .requires(Items.CARROT)
                        .requires(Ingredient.of(Items.SHORT_GRASS,
                                Items.TALL_GRASS,
                                Items.OAK_LEAVES,
                                Items.DARK_OAK_LEAVES,
                                Items.JUNGLE_LEAVES,
                                Items.BIRCH_LEAVES,
                                Items.SPRUCE_LEAVES,
                                Items.ACACIA_LEAVES,
                                Items.MANGROVE_LEAVES,
                                Items.VINE), 2)
                        .requires(Items.GLASS_BOTTLE)
                        .group("primal")
                        .unlockedBy("has_carrot", has(Items.CARROT))
                        .save(output);
            }
        };
    }

    @Override
    public @NotNull String getName() {
        return "Primal Recipe Provider";
    }
}
