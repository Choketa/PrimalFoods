package me.choketa.mixin.foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Foods.class)
public interface FoodAccessor {
    @Accessor("BEEF")
    @Mutable
    static void setBeef(FoodProperties food) {
        throw new AssertionError();
    }
    @Accessor("COOKED_BEEF")
    @Mutable
    static void setCookedBeef(FoodProperties food) {
        throw new AssertionError();
    }

}
