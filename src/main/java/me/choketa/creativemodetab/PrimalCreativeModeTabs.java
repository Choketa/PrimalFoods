package me.choketa.creativemodetab;

import me.choketa.PrimalMod;
import me.choketa.item.PrimalItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class PrimalCreativeModeTabs {
    public static final CreativeModeTab PRIMAL_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(PrimalMod.MOD_ID, "primal_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(Items.BEEF))
                    .title(Component.translatable("creativemodetab.primalmod.primal_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(PrimalItems.FREAK_OUT_MUSIC_DISC);
                        output.accept(PrimalItems.VEGETABLE_JUICE);
                    }).build());
    public static void registerModCreativeModeTabs() {
        PrimalMod.LOGGER.info("Registering Creative Mode Tabs for {}", PrimalMod.MOD_ID);
    }
}
