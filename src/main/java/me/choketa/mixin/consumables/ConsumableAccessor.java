package me.choketa.mixin.consumables;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Consumables.class)
public interface ConsumableAccessor {
    @Accessor("ROTTEN_FLESH")
    @Mutable
    static void setRottenFlesh(Consumable consumable) { throw new AssertionError(); }
    @Accessor("CHICKEN")
    @Mutable
    static void setChicken(Consumable consumable) { throw new AssertionError(); }
}
