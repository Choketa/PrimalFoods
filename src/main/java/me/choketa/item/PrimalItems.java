package me.choketa.item;

import me.choketa.PrimalMod;
import me.choketa.datagen.PrimalJukeboxSongs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class PrimalItems {
    public static final Item FREAK_OUT_MUSIC_DISC = registerItem("freak_out_music_disc",
            properties ->
                    new Item(properties.jukeboxPlayable(PrimalJukeboxSongs.FREAK_OUT_KEY).stacksTo(1).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PrimalMod.LOGGER.info("Registering Mod Items for {}", PrimalMod.MOD_ID);

        //I guess this is for loading ingredients, uselss for now
//        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
//
//        });
    }
}
